package com.gameif.portal.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gameif.portal.action.pointCharge.PointChargeBindMasterAction;
import com.gameif.portal.businesslogic.IOpensocialMemberBusinessLogic;
import com.gameif.portal.entity.OpensocialMember;
import com.gameif.portal.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class OpensocialPointChargeInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -4908757732007241733L;
	
	private IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {

        String result = null;
        boolean accessable = false;
        
        if (ContextUtil.getExternalAccountId() != null && ContextUtil.getOpensocialProviderId() != null) {
        	
        	accessable = true;
        	
        } else {
        	
        	HttpServletRequest request = ServletActionContext.getRequest();
        	
        	String memId = request.getParameter("account");
        	String providerId = request.getParameter("provider");
        	
        	if (memId != null && providerId != null) {

            	OpensocialMember member = opensocialMemberBusinessLogic.getMemberByMemIdAndProviderId(memId, providerId);
            	
            	if (member != null) {

                	ContextUtil.setExternalLoginSessionInfo(member.getMemNum(), memId, providerId);
                	
                	accessable = true;
            	}
        	}
        }
        
        if (accessable) {
        	
        	result = ai.invoke();
        	
        } else {
        	
        	result = "warning";
        }
		
		return result;
	}

	public void setOpensocialMemberBusinessLogic(IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic) {
		
		this.opensocialMemberBusinessLogic = opensocialMemberBusinessLogic;
	}
}
