package org.jasig.cas.web.flow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.util.AuthConsts;
import org.jasig.cas.web.support.ArgumentExtractor;
import org.jasig.cas.web.support.CookieRetrievingCookieGenerator;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.util.StringUtils;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class OpenIDLoginAction extends AbstractAction {

	private CookieRetrievingCookieGenerator warnCookieGenerator;
	private CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator;
	private List<ArgumentExtractor> argumentExtractors;
	private boolean pathPopulated = false;

	/**
	 * OpenIDプロバイダーからの認証結果通知、ポータルサイトからのOpenID有効化結果通知を受け取って、結果を検証する。
	 * <ul>
	 * <li>OpenIDのプロバイダーのサイトにてキャンセルした場合、ログイン画面へ戻る。</li>
	 * <li>ポータルサイトから、OpenID有効化の結果通知を受けた場合、結果検証の次のフローへ。</li>
	 * <li>OpenIDのプロバイダーのサイトから認証完了で戻ってきた場合、認証結果検証の次のフローへ。</li>
	 * </ul>
	 * @param context RequestContext
	 * @return Event
	 * @throws Exception
	 */
	protected Event doExecute(RequestContext context) throws Exception {
		
		HttpServletRequest request = WebUtils.getHttpServletRequest(context);
		
		if (!this.pathPopulated) {
			
			String contextPath = context.getExternalContext().getContextPath();
			String cookiePath = StringUtils.hasText(contextPath) ? contextPath : "/";
			
			this.warnCookieGenerator.setCookiePath(cookiePath);
			this.ticketGrantingTicketCookieGenerator.setCookiePath(cookiePath);
			this.pathPopulated = true;
		}
		
		context.getFlowScope().put("ticketGrantingTicketId", this.ticketGrantingTicketCookieGenerator.retrieveCookieValue(request));
		context.getFlowScope().put("warnCookieValue", Boolean.valueOf(this.warnCookieGenerator.retrieveCookieValue(request)));

		Service service = WebUtils.getService(this.argumentExtractors, context);
		
		if (service == null) {
			
			service = (Service)request.getSession().getAttribute(AuthConsts.Key.SERVICE);
		}
		
		// OpenIDプロバイダーの認証サイトへ行く前に設定したアクセス要望ＵＲＬを取得して、セッションからは削除する。
		context.getFlowScope().put(AuthConsts.Key.SERVICE, service);
		request.getSession().removeAttribute(AuthConsts.Key.SERVICE);
		
		if ("cancel".equalsIgnoreCase(request.getParameter(AuthConsts.Key.OpenID.MODE))) {
			
			// OpenIDのプロバイダーのサイトにてキャンセルした場合、ログイン画面へ戻る。
			return result("gotoOpenIDSelect");
			
		} else if ("portal".equalsIgnoreCase(request.getParameter(AuthConsts.Key.FROM))) {

			// ポータルサイトから、OpenID有効化の結果通知を受けた場合、結果検証の次のフローへ。
			return result("doAuthenticateOpenIDFromPortal");
			
		} else {

			// OpenIDのプロバイダーのサイトから認証完了で戻ってきた場合、認証結果検証の次のフローへ。
			// context.getFlowScope().put("op", request.getSession().getAttribute("op"));			
			// request.getSession().removeAttribute("op");
			
			return result("doAuthenticateOpenID");
		}
	}

	public void setTicketGrantingTicketCookieGenerator(final CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator) {
		
		this.ticketGrantingTicketCookieGenerator = ticketGrantingTicketCookieGenerator;
	}

	public void setWarnCookieGenerator(final CookieRetrievingCookieGenerator warnCookieGenerator) {
		
		this.warnCookieGenerator = warnCookieGenerator;
	}

	public void setArgumentExtractors(final List<ArgumentExtractor> argumentExtractors) {
		
		this.argumentExtractors = argumentExtractors;
	}
}