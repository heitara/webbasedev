package com.gameif.portal.interceptor;

import com.gameif.portal.action.pointCharge.JointPointChargeControlAction;
import com.gameif.portal.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;

public class JointPointChargeInterceptor extends JointTitlePlayInterceptor {
	
	private static final long serialVersionUID = -9119576446431831491L;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {

		String result = "warning";
		
		if (ContextUtil.getExternalAccountId() != null && ContextUtil.getProviderId() != null) {

			JointPointChargeControlAction action = (JointPointChargeControlAction)ai.getAction();
			
			if (action.getModel().getTitleId() == null || action.getModel().getServerId() == null || action.getDecorator() == null) {

				String titleId = ContextUtil.getCookieValue("titleId");
				String serverId = ContextUtil.getCookieValue("serverId");
				String decorator = ContextUtil.getCookieValue("decorator");
				
				action.getModel().setTitleId(Integer.valueOf(titleId));
				action.getModel().setServerId(Integer.valueOf(serverId));
				action.setDecorator(decorator);
			}

			result = ai.invoke();
		}
		
		return result;
	}
}