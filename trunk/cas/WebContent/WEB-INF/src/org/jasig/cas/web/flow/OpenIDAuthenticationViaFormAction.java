package org.jasig.cas.web.flow;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.expressme.openid.Authentication;
import org.expressme.openid.OpenIdException;
import org.expressme.openid.OpenIdManager;
import org.jasig.cas.adaptors.jdbc.ByteUtil;
import org.jasig.cas.adaptors.jdbc.GameifPasswordEncoder;
import org.jasig.cas.adaptors.jdbc.OpenIDEntryHandler;
import org.jasig.cas.authentication.principal.OpenIDCredentials;
import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.util.AuthConsts;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class OpenIDAuthenticationViaFormAction extends AuthenticationViaFormAction {
	
	private OpenIdManager openIDManager;
	private OpenIDEntryHandler openIDEntryHandler;
	
	/** 認証サーバとポータルサーバ間の通信で使う改竄防止用セキュリティキー */
	private String entryTransKey;
	
	/**
	 * OpenIDプロバイダーからの認証結果情報を受け取って、結果を検証する。
	 * <ul>
	 * <li>認証失敗の場合、エラー（ログイン画面に戻る）</li>
	 * <li>認証成功且つ既存会員の場合、次のフローへ（SSOログイン処理）</li>
	 * <li>認証成功、初めてのログイン場合、OpenID有効化処理へ（ポータルサイトのOpenID有効化画面へ）</li>
	 * </ul>
	 * @param context RequestContext
	 * @return Event
	 * @throws Exception
	 */
	public Event doAuthenticateOpenID(RequestContext context) throws Exception {

		HttpServletRequest request = WebUtils.getHttpServletRequest(context);		
		OpenIDCredentials credentials = (OpenIDCredentials) getFormObject(context);
 		
		checkNonce(request.getParameter(AuthConsts.Key.OpenID.RESPONSE_NONCE));
 
		byte[] mac_key = (byte[]) request.getSession().getAttribute(AuthConsts.Key.OpenID.ATTR_MAC); 
		String alias = (String) request.getSession().getAttribute(AuthConsts.Key.OpenID.ATTR_ALIAS);
		
		Authentication authentication = openIDManager.getAuthentication(request, mac_key, alias);		
		
		if (authentication == null || authentication.getIdentity() == null) {

			// 認証失敗の場合、エラー（ログイン画面に戻る）
			return result(AuthConsts.Key.Result.ERROR);
		}		
		
		credentials.setAuthentication(authentication);
		openIDEntryHandler.setMemberInfoForCredentials(credentials);
		
		if (credentials.getMemNo() != null) {

			// 認証成功且つ既存会員の場合、次のフローへ（SSOログイン処理）
			return result(AuthConsts.Key.Result.SUCCESS);
			
		} else {

			// 認証成功、初めてのログイン場合、OpenID有効化処理へ（ポータルサイトのOpenID有効化画面へ）
			request.getSession().setAttribute(AuthConsts.Key.OPENID_ID, authentication.getIdentity());
			request.getSession().setAttribute(AuthConsts.Key.SERVICE, context.getFlowScope().get(AuthConsts.Key.SERVICE));
			
			context.getFlowScope().put(AuthConsts.Key.OPENID_ENTRY_PAGE, getOpenIDEntryPageUrl(authentication, context));
			
			return result(AuthConsts.Key.Result.FALSE);
		}
	}
	
	/**
	 * ポータルサイトからのOpenIDアカウント有効化結果情報を受け取って、結果を検証する。
	 * <ul>
	 * <li>検証成功の場合、会員番号とニックネームを取得して次のフローへ（SSOログイン処理）</li>
	 * <li>認証失敗の場合、エラー（ログイン画面に戻る）</li>
	 * </ul>
	 * @param context RequestContext
	 * @return Event
	 * @throws Exception
	 */
	public Event doAuthenticateOpenIDFromPortal(RequestContext context) throws Exception {

		HttpServletRequest request = WebUtils.getHttpServletRequest(context);
		
		//　ポータルサイトに遷移する前にセッションに設定したOpenIDのIDを取得し、セッションからは削除する。
		String openIDIdentity = (String)request.getSession().getAttribute(AuthConsts.Key.OPENID_ID);
		request.getSession().removeAttribute(AuthConsts.Key.OPENID_ID);

		// ポータルサイトからOpenIDアカウント有効化結果情報を取得する。
		String memNum = request.getParameter(AuthConsts.Key.Member.MEM_NUM);
		String memId = request.getParameter(AuthConsts.Key.Member.MEM_ID);
		String nickname = request.getParameter(AuthConsts.Key.Member.NICK_NAME);
		String time = request.getParameter(AuthConsts.Key.TIME);
		String sign = request.getParameter(AuthConsts.Key.OPENID_SIGN);
		
		// 情報改竄防止用の比較用サイン文字列を作成する。
		String signCrm = new GameifPasswordEncoder().encode(
							new StringBuffer()
								.append(memNum)
								.append(memId)
								.append(nickname)
								.append(time)
								.append(entryTransKey)
								.toString()
							);
		
		// OpenIDのIDが一致して、情報の改竄がない場合、会員番号とニックネームを取得して次のフローへ（SSOログイン処理）
		if (openIDIdentity != null && openIDIdentity.equals(memId) && signCrm.equals(sign)) {
			
			OpenIDCredentials credentials = (OpenIDCredentials) getFormObject(context);
			
			Authentication authentication = new Authentication();
			authentication.setIdentity(memId);
			
			credentials.setAuthentication(authentication);
			credentials.setMemNo(Long.valueOf(memNum));
			credentials.setNickname(ByteUtil.stringToHexString(nickname));
			
			return result(AuthConsts.Key.Result.SUCCESS);
		}
		
		return result(AuthConsts.Key.Result.ERROR);
	}
	
	/**
	 * ログイン画面への遷移用URLを作成してFlowスコープに設定する。
	 * @param context RequestContext
	 * @return Event
	 * @throws Exception
	 */
	public Event prepareGotoOpenIDSelect(RequestContext context) throws Exception {

		HttpServletRequest request = WebUtils.getHttpServletRequest(context);
		
		StringBuffer urlBuff = new StringBuffer();
		
		urlBuff.append(request.getSession().getServletContext().getInitParameter("portalAuthTopUrl"));
		urlBuff.append("/login");
		
		Service service = (Service)context.getFlowScope().get(AuthConsts.Key.SERVICE);
		
		if (service != null) {
			
			urlBuff.append("?");
			urlBuff.append(AuthConsts.Key.SERVICE);
			urlBuff.append("=");
			urlBuff.append(URLEncoder.encode(service.getId(), AuthConsts.Encode.UTF8));
		}
		
		context.getFlowScope().put(AuthConsts.Key.OPENID_SELECT_PAGE, urlBuff.toString());
		return result("redirectToOpenIDSelectPage");
	}
	
	/**
	 * ポータルサイトのOpenID有効化画面のURLを取得する。
	 * @param authentication 認証情報
	 * @param context RequestContext
	 * @return ポータルサイトのOpenID有効化URL
	 * @throws UnsupportedEncodingException
	 */
	private String getOpenIDEntryPageUrl(Authentication authentication, RequestContext context) throws UnsupportedEncodingException {
		
		return new StringBuffer()
				.append(WebUtils.getHttpServletRequest(context).getSession().getServletContext().getInitParameter("portalTopUrl"))
				.append("/registryOpenID.html?")
				.append(getEntryTransParam(authentication, context))
				.toString();
	}
	
	/**
	 * ポータルサイトのOpenID有効化画面へ遷移する時に渡すパラメータ（OpenIDのID、メールアドレス、改竄防止用サイン文字列）を生成する。
	 * @param authentication 認証情報
	 * @param context RequestContext
	 * @return ポータルサイトのOpenID有効化URL
	 * @throws UnsupportedEncodingException
	 */
	private String getEntryTransParam(Authentication authentication, RequestContext context) throws UnsupportedEncodingException {

		String identity = authentication.getIdentity();
		String email = authentication.getEmail() == null ? "" : authentication.getEmail();
		
		StringBuffer entBuff = new StringBuffer()
			.append(AuthConsts.Key.Member.MEM_ID)
			.append("=")
			.append(URLEncoder.encode(identity, AuthConsts.Encode.UTF8))
			.append("&")
			.append(AuthConsts.Key.Member.MAIL)
			.append("=")
			.append(URLEncoder.encode(email, AuthConsts.Encode.UTF8))
			.append("&")
			.append(AuthConsts.Key.OPENID_SIGN)
			.append("=")
			.append(new GameifPasswordEncoder().encode(new StringBuffer()
					.append(identity)
					.append(entryTransKey)
					.toString())
				);
		
		return entBuff.toString();
	}
	
	/**
	 * 会員IDより会員情報テーブルから会員番号とニックネームを抽出して、OpenID認証情報に設定する。
	 * @param context RequestContext
	 * @return Event
	 * @throws UnsupportedEncodingException
	 */
	public final Event setMemberInfoForOpenID(final RequestContext context) throws Exception {
		
		OpenIDCredentials credentials = (OpenIDCredentials) getFormObject(context);
		
		openIDEntryHandler.setMemberInfoForCredentials(credentials);
			
		return result(AuthConsts.Key.Result.SUCCESS);
	}
	
	private void checkNonce(String nonce) {
		
		if (nonce == null || nonce.length() < 20) {

			throw new OpenIdException("Verify failed."); 
		}
		
		long nonceTime = getNonceTime(nonce); 
		long diff = System.currentTimeMillis() - nonceTime; 
		
		if (diff < 0) {
			
			diff = (-diff);
		}
		
		if (diff > AuthConsts.Time.ONE_HOUR) {

			throw new OpenIdException("Bad nonce time."); 
		}
		
		if (isNonceExist(nonce)) {

			throw new OpenIdException("Verify nonce failed.");
		}
		
		storeNonce(nonce, nonceTime + AuthConsts.Time.TWO_HOUR); 
	}
	
	private boolean isNonceExist(String nonce) {
		
		return false; 
	} 
 
	private void storeNonce(String nonce, long expires) {} 
 
	private long getNonceTime(String nonce) {
		
		try {
			
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
					.parse(nonce.substring(0, 19) + "+0000") 
					.getTime();
			
		} catch(ParseException e) {
			
			throw new OpenIdException("Bad nonce time."); 
		} 
	} 


	public void setOpenIDManager(OpenIdManager openIDManager) {
		
		this.openIDManager = openIDManager;
	}

	public void setOpenIDEntryHandler(OpenIDEntryHandler openIDEntryHandler) {
		
		this.openIDEntryHandler = openIDEntryHandler;
	}

	public String getEntryTransKey() {
		
		return entryTransKey;
	}

	public void setEntryTransKey(String entryTransKey) {
		
		this.entryTransKey = entryTransKey;
	}
}