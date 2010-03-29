package com.gameif.portal.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.util.ByteUtil;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.MemberInfo;
import com.opensymphony.xwork2.ActionContext;

import edu.yale.its.tp.cas.client.filter.CASFilter;

public class ContextUtil {
	
	private final static String EXT_SESS_K_MEM_NUM = "extsess.key.memNum";
	private final static String EXT_SESS_K_MEM_ID = "extsess.key.memId";
	private final static String EXT_SESS_K_PROVIDER_ID = "extsess.key.providerId";

	/**
	 * セッションから会員情報（会員番号、アカウントＩＤ、ニックネーム包含）を取得する。
	 * @return　会員情報
	 */
	public final static MemberInfo getMemberInfo() {
		
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setMemNum(ContextUtil.getMemberNo());
		memberInfo.setMemId(ContextUtil.getAccountId());
		memberInfo.setNickName(ContextUtil.getNickName());
		
		return memberInfo;
	}
	
	/**
	 * セッションから会員番号を取得する。
	 * @return　アカウントＩＤ
	 */
	public final static Long getMemberNo() {
		
		Long memberNo = null;
		String memberNoStr = getLoginSessionInfo()[0];
		
		if (memberNoStr != null && !"".equals(memberNoStr.trim())) {
			
			memberNo = new Long(memberNoStr.trim());
		}
		
		return memberNo;
	}
	
	/**
	 * セッションからアカウントＩＤを取得する。
	 * @return　アカウントＩＤ
	 */
	public final static String getAccountId() {
		
		return getLoginSessionInfo()[1];
	}

	/**
	 * セッションからニックネームを取得する。
	 * @return　ニックネーム
	 */
	public final static String getNickName() {
		
		return getLoginSessionInfo()[2];
	}

	/**
	 * セッションからアカウント関連情報（会員番号、アカウントＩＤ、ニックネーム）を取得する。
	 * @return　セッションからアカウント関連情報（会員番号、アカウントＩＤ、ニックネーム）
	 */
	private final static String[] getLoginSessionInfo() {
		
		String[] loginSessionInfo = null;
		String sessionInfo = (String)ActionContext.getContext().getSession().get(CASFilter.CAS_FILTER_USER);
		
		if (sessionInfo != null) {
			
			loginSessionInfo = sessionInfo.split(",");
			loginSessionInfo[2] = ByteUtil.stringFromHexString(loginSessionInfo[2]);
			
		} else {
			
			loginSessionInfo = new String[] {null, null, null};
		}

		return loginSessionInfo;
	}

	/**
	 * セッションに設定されているＣＡＳのユーザ情報文字列から会員番号を抽出する。
	 * @return　会員番号
	 */
	public final static Long getMemberNo(String mergedInfo) {
		
		Long memberNo = null;
		
		if (mergedInfo != null) {
			
			String memberNoStr = mergedInfo.split(",")[0];
			
			if (memberNoStr != null && !"".equals(memberNoStr.trim())) {

				memberNo = Long.valueOf(mergedInfo.split(",")[0].trim());
				
				if (memberNo < 1) {
					
					memberNo = null;
				}
			}
		}

		return memberNo;
	}

	/**
	 * セッションに設定されているＣＡＳのユーザ情報文字列からユーザのログイン状態を判断する。
	 * @return　true:ログイン; false:未ログイン
	 */
	public final static boolean userIsLogin(String mergedInfo) {
		
		return getMemberNo(mergedInfo) != null;
	}
	
	/**
	 * ログイン状態を判断する。
	 * @return　true:ログイン; false:未ログイン
	 */
	public final static boolean userIsLogin() {
		
		return getAccountId() != null;
	}

	/**
	 * クライアントＩＰを取得する。
	 * @return　クライアントＩＰ
	 */
	public final static String getClientIP() {
		
		String clientIp = ServletActionContext.getRequest().getHeader("X-Real-IP");
		
		if (clientIp == null) {
			
			clientIp = ServletActionContext.getRequest().getRemoteAddr();
		}
		
		return clientIp;
	}

	/**
	 * リクエストしたＵＲＩ（ＧＥＴパラメータつき）を取得する。
	 * @return ＵＲＩ
	 */
	public final static String getRequestedURIQuery() {

		StringBuffer uriq = new StringBuffer();
		
		uriq.append(ServletActionContext.getRequest().getRequestURI());
		
		if (ServletActionContext.getRequest().getQueryString() != null) {
			uriq.append("?");
			uriq.append(ServletActionContext.getRequest().getQueryString());
		}
		
		return uriq.toString();
	}
	
	/**
	 * クライアントＩＰとアカウントＩＤ、ＵＲＩを含むリクエスト情報を取得する。
	 * <br/>主にログ出力に使う。
	 * @return　リクエスト情報
	 */
	public final static String getRequestBaseInfo() {
		
		StringBuffer info = new StringBuffer();
		
		String account = getAccountIdWithExt();
		
		info.append(getClientIP());
		info.append(" | ");
		info.append(account == null ? "-" : account);
		info.append(" | ");
		info.append(getRequestedURIQuery());
		
		return info.toString();
	}
	
	/**
	 * 
	 * @param cookieValue
	 */
	public final static void setInviteCookie(String cookieValue) {

	    Cookie cookie = new Cookie(PortalConstants.Key.INVITE_COOKIE_KEY, cookieValue);
	    cookie.setPath("/");
	    cookie.setMaxAge(365*24*60*60);
	    ServletActionContext.getResponse().addCookie(cookie);
	}
	
	/**
	 * 
	 * @return
	 */
	public final static String getInviteCookie() {
		
		String value = null;
	    Cookie cookies[] = ServletActionContext.getRequest().getCookies();
	    
	    if (cookies != null) {
	    	
	        for (Cookie cookie : cookies) {
	        	
	        	if (cookie.getName().equals(PortalConstants.Key.INVITE_COOKIE_KEY)) {
	        	
	        		value = cookie.getValue();
	        	}
	        }
	    }
		
		return value;
	}
	

	public static String getRequestUrl() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		return new StringBuffer()
			.append(request.getSession().getServletContext().getInitParameter("portalTopUrl"))
			.append(request.getRequestURI())
			.toString();
	}
	
	
	public static void setExternalLoginSessionInfo(Long memNum, String memId, String providerId) {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute(EXT_SESS_K_MEM_NUM, memNum);
		request.getSession().setAttribute(EXT_SESS_K_MEM_ID, memId);
		request.getSession().setAttribute(EXT_SESS_K_PROVIDER_ID, providerId);
	}
	
	public static Long getExternalMemberNo() {

		HttpServletRequest request = ServletActionContext.getRequest();
		return (Long)request.getSession().getAttribute(EXT_SESS_K_MEM_NUM);
	}
	
	public static String getExternalAccountId() {

		HttpServletRequest request = ServletActionContext.getRequest();
		return (String)request.getSession().getAttribute(EXT_SESS_K_MEM_ID);
	}
	
	public static String getProviderId() {

		HttpServletRequest request = ServletActionContext.getRequest();
		return (String)request.getSession().getAttribute(EXT_SESS_K_PROVIDER_ID);
	}
	
	public static Long getMemberNoWithExt() {
		
		Long memNum = getMemberNo();
		
		if (memNum == null) {
			
			memNum = getExternalMemberNo();
		}
	
		return memNum;
	}
	
	public static String getAccountIdWithExt() {
		
		String memId = getAccountId();
		
		if (memId == null) {
			
			memId = getExternalAccountId();
		}
	
		return memId;
	}
}