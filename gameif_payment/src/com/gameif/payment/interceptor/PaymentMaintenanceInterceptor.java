package com.gameif.payment.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gameif.payment.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.payment.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.payment.constants.PortalConstants;
import com.gameif.payment.entity.MemberInfo;
import com.gameif.payment.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PaymentMaintenanceInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -4908757732007241733L;
	protected final static Log logger = LogFactory.getLog(PaymentMaintenanceInterceptor.class);
	
	private IMaintenanceBusinessLogic maintenanceBusinessLogic;
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;

    @Override
    protected String doIntercept(ActionInvocation ai) throws Exception {

        String result = null;
        
		if (!isTestUser() && maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.CHARGE)) {
			
			result = "maintenance";
			
		} else {
			
			result = ai.invoke();
		}
		
		logger.warn("PaymentMaintenanceInterceptor result: " + result);
		
		return result;
    }
    
    protected boolean isTestUser() {
        
    	boolean isTestUser = false;
    	
    	if (ContextUtil.getMemberNo() != null) {
        	
    		MemberInfo member = new MemberInfo();
    		member.setMemNum(ContextUtil.getMemberNo());
    		member = memberInfoBusinessLogic.getMemberInfo(member);
    		
    		if (member != null && member.getMemAtbtCd().equals(PortalConstants.MemberAtbtCd.TEST)) {
    			
    			isTestUser = true;
    		}
    	}
		
		return isTestUser;
    }

	public void setMaintenanceBusinessLogic(IMaintenanceBusinessLogic maintenanceBusinessLogic) {
		
		this.maintenanceBusinessLogic = maintenanceBusinessLogic;
	}

	public void setMemberInfoBusinessLogic(IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}
}