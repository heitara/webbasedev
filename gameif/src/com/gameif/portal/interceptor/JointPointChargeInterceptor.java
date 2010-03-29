package com.gameif.portal.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gameif.portal.action.pointCharge.JointPointChargeControlAction;
import com.gameif.portal.businesslogic.IJointMemberBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.JointMember;
import com.gameif.portal.entity.ProviderMst;
import com.gameif.portal.entity.ProviderTitleMst;
import com.gameif.portal.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;

public class JointPointChargeInterceptor extends JointTitlePlayInterceptor {
	
	private static final long serialVersionUID = -9119576446431831491L;

	private final static Log logger = LogFactory.getLog(JointPointChargeInterceptor.class);
	
	private IJointMemberBusinessLogic jointMemberBusinessLogic;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {

		String result = "warning";
		
		boolean accessable = false;
		
		if (ContextUtil.getExternalAccountId() != null && ContextUtil.getProviderId() != null) {
			
			accessable = true;
			
		} else {
			
			HttpServletRequest request = ServletActionContext.getRequest();
			
			String memId = request.getParameter("memId");
			String providerId = request.getParameter("providerId");
			String titleId = request.getParameter("titleId");
			String serverId = request.getParameter("serverId");
			
			if (memId != null && providerId != null && titleId != null && serverId != null && checkTime()) {

				ProviderMst provider = getMasterInfoBusinessLogic().getProviderMstByKey(providerId);			
				
				if (checkProviderKind(provider)) {
					
					ProviderTitleMst providerTitle = new ProviderTitleMst();			
					providerTitle.setProviderId(providerId);
					providerTitle.setTitleId(Integer.valueOf(titleId));			
					providerTitle = getMasterInfoBusinessLogic().getProviderTitleMstByKey(providerTitle);

					if (checkSign(providerTitle)) {
						
						JointMember member = jointMemberBusinessLogic.getMemberByMemIdAndProviderId(memId, providerId);
						
						if (member != null) {
							
							accessable = true;
							
						} else if (!PortalConstants.YES.equals(providerTitle.getAgentLogin())) {
							
							member = new JointMember();
							member.setMemId(memId);
							member.setProviderId(providerId);
							
							member = jointMemberBusinessLogic.createMemberInfo(member);
							
							accessable = true;
							
						} else {
							
							logger.warn(ContextUtil.getRequestBaseInfo() + " | Must play the game befor point charge.");
						}
						
						if (accessable) {
							
							JointPointChargeControlAction action = (JointPointChargeControlAction)ai.getAction();
							action.setChargeSuccessUrl(providerTitle.getChargeSuccessUrl());
							action.setChargeCancelUrl(providerTitle.getChargeCancelUrl());
							action.setChargeErrorUrl(providerTitle.getChargeErrorUrl());
							action.setChargeMaintenanceUrl(providerTitle.getChargeMaintenanceUrl());

							ContextUtil.setExternalLoginSessionInfo(member.getMemNum(), memId, providerId);
						}
					}
				}
			}
		}
		
		if (accessable) {

			result = ai.invoke();
		}
		
		return result;
	}

	public void setJointMemberBusinessLogic(IJointMemberBusinessLogic jointMemberBusinessLogic) {
		
		this.jointMemberBusinessLogic = jointMemberBusinessLogic;
	}
}
