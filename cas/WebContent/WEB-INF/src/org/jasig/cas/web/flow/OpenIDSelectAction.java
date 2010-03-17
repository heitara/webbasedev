package org.jasig.cas.web.flow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.expressme.openid.Association;
import org.expressme.openid.Endpoint;
import org.expressme.openid.OpenIdManager;
import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.util.AuthConsts;
import org.jasig.cas.web.support.ArgumentExtractor;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class OpenIDSelectAction extends AbstractAction {
	
	private List<ArgumentExtractor> argumentExtractors;
	private OpenIdManager openIDManager;    

	/**
	 * 連携用初期設定を行って、OpenIDプロバイダーサイトへ認証に行く。
	 * @param context RequestContext
	 * @return Event
	 * @throws Exception
	 */
	protected Event doExecute(final RequestContext context) throws Exception {
		
		HttpServletRequest request = WebUtils.getHttpServletRequest(context);
		
		String op = request.getParameter(AuthConsts.Key.OP);
		
        Endpoint endpoint = openIDManager.lookupEndpoint(op);
        Association association = openIDManager.lookupAssociation(endpoint);
        String url = openIDManager.getAuthenticationUrl(endpoint, association);
		
		Service service = WebUtils.getService(this.argumentExtractors, context);

        request.getSession().setAttribute(AuthConsts.Key.OpenID.ATTR_MAC, association.getRawMacKey());
        request.getSession().setAttribute(AuthConsts.Key.OpenID.ATTR_ALIAS, endpoint.getAlias());
        
        // ユーザのアクセス要望ＵＲＬ（ログインが必要）をセッションに設定する。
		request.getSession().setAttribute(AuthConsts.Key.SERVICE, service);
        // OpenIDプロバイダーをセッションに設定する。
		request.getSession().setAttribute(AuthConsts.Key.OP, op);
		
		context.getFlowScope().put(AuthConsts.Key.OPENID_PROVIDER_PAGE, url);

		return result(AuthConsts.Key.Result.SUCCESS);
	}

	public void setArgumentExtractors(final List<ArgumentExtractor> argumentExtractors) {
		
		this.argumentExtractors = argumentExtractors;
	}

	public void setOpenIDManager(OpenIdManager openIDManager) {
		
		this.openIDManager = openIDManager;
	}
}