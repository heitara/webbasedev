package com.gameif.portal.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gameif.portal.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PointChargeMaintenanceInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -4908757732007241733L;
	protected final static Log logger = LogFactory.getLog(PointChargeMaintenanceInterceptor.class);
	
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
		
		logger.warn("PointChargeMaintenanceInterceptor result: " + result);
		
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