package com.gameif.portal.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gameif.common.exception.BetaTestException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.MaintenanceException;
import com.gameif.portal.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.portal.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PointChargeTitleMaintenanceInterceptor extends MethodFilterInterceptor {

    private final static Log logger = LogFactory.getLog(PointChargeTitleMaintenanceInterceptor.class);
    
	private static final long serialVersionUID = -4908757732007241733L;
	
	private IMaintenanceBusinessLogic maintenanceBusinessLogic;

    @Override
    protected String doIntercept(ActionInvocation ai) throws Exception {

        String result = null;        
        Integer titleId = null;
        
        ActionSupport action = (ActionSupport)ai.getAction();
        String titleIdStr = ServletActionContext.getRequest().getParameter("titleId");
        
        if (titleIdStr != null) {
        	
        	titleId = Integer.valueOf(titleIdStr);
        	
        	if (titleId != 0) {
        		
        		try {
        			// メンテナンスとCBTチェック
        			maintenanceBusinessLogic.maintenanceCheckByTitleId(titleId);
        			
        		} catch (MaintenanceException mtEx) {
        			
        			// メンテナンス
        			action.addFieldError("errMessage", action.getText("title.maintenance"));
        			result = "pointSelect";
        			
        		} catch (BetaTestException testEx) {
        			
        			// テスト中
        			action.addFieldError("errMessage", action.getText("title.test"));
        			result = "pointSelect";
        			
        		} catch (LogicException lgex) {
    			
	    			logger.warn(ContextUtil.getRequestBaseInfo() + " | " + lgex.getMessage());
	    			return "warning";
	    		}
        	}
        }
        
        if (result == null) {
        	
        	result = ai.invoke();
        }
		
		return result;
    }

	public void setMaintenanceBusinessLogic(IMaintenanceBusinessLogic maintenanceBusinessLogic) {
		
		this.maintenanceBusinessLogic = maintenanceBusinessLogic;
	}
}
