package com.gameif.portal.interceptor;

import java.util.Map;

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

public class JointPointChargeEntryInterceptor extends JointTitlePlayInterceptor {
	
	private static final long serialVersionUID = -9119576446431831491L;

	private final static Log logger = LogFactory.getLog(JointPointChargeEntryInterceptor.class);
	
	private IJointMemberBusinessLogic jointMemberBusinessLogic;
	private Map<String, String> decorators;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {

		String result = "warning";
		
		String titleId = ServletActionContext.getRequest().getParameter("titleId");
		String serverId = ServletActionContext.getRequest().getParameter("serverId");
		String memId = ServletActionContext.getRequest().getParameter("memId");
		String providerId = ServletActionContext.getRequest().getParameter("providerId");
		
		if (memId != null && providerId != null && titleId != null && serverId != null && checkTime()) {
			
			boolean accessable = false;
			JointMember member = null;

			ProviderMst provider = getMasterInfoBusinessLogic().getProviderMstByKey(providerId);			
			
			if (checkProviderKind(provider)) {
				
				ProviderTitleMst providerTitle = getProviderTitle(providerId, Integer.valueOf(titleId));

				if (checkSign(providerTitle)) {
					
					member = jointMemberBusinessLogic.getMemberByMemIdAndProviderId(memId, providerId);
					
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
				}
			}
			
			if (accessable) {

				ContextUtil.setExternalLoginSessionInfo(member.getMemNum(), memId, providerId);
				
				ContextUtil.setCookieValue("titleId", titleId, "/");
				ContextUtil.setCookieValue("serverId", serverId, "/");
				ContextUtil.setCookieValue("decorator", decorators.get(providerId), "/");
				
				JointPointChargeControlAction action = (JointPointChargeControlAction)ai.getAction();
				
				action.getModel().setTitleId(Integer.valueOf(titleId));
				action.getModel().setServerId(Integer.valueOf(serverId));
				action.setDecorator(decorators.get(providerId));

				result = ai.invoke();
			}
			
		} else if (ContextUtil.getExternalAccountId() != null && ContextUtil.getProviderId() != null) {

			return ai.invoke();
		}
		
		return result;
	}
	
	private ProviderTitleMst getProviderTitle(String providerId, Integer titleId) {
		
		ProviderTitleMst providerTitle = new ProviderTitleMst();			
		providerTitle.setProviderId(providerId);
		providerTitle.setTitleId(Integer.valueOf(titleId));			
		providerTitle = getMasterInfoBusinessLogic().getProviderTitleMstByKey(providerTitle);
		
		return providerTitle;
	}

	public void setJointMemberBusinessLogic(IJointMemberBusinessLogic jointMemberBusinessLogic) {
		
		this.jointMemberBusinessLogic = jointMemberBusinessLogic;
	}

	public void setDecorators(Map<String, String> decorators) {
		this.decorators = decorators;
	}
}