package com.gameif.portal.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gameif.portal.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PointChargeMaintenanceInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -4908757732007241733L;
	protected final static Log logger = LogFactory.getLog(PointChargeMaintenanceInterceptor.class);
	
	private IMaintenanceBusinessLogic maintenanceBusinessLogic;

    @Override
    protected String doIntercept(ActionInvocation ai) throws Exception {

        String result = null;
        
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.CHARGE)) {
			
			result = "maintenance";
			
		} else {
			
			result = ai.invoke();
		}
		
		logger.warn("PointChargeMaintenanceInterceptor result: " + result);
		
		return result;
    }

	public void setMaintenanceBusinessLogic(IMaintenanceBusinessLogic maintenanceBusinessLogic) {
		
		this.maintenanceBusinessLogic = maintenanceBusinessLogic;
	}
}
