package com.gameif.portal.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gameif.common.util.SecurityUtil;
import com.gameif.portal.action.titleif.JointTitlePlayControlAction;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.ProviderMst;
import com.gameif.portal.entity.ProviderTitleMst;
import com.gameif.portal.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class JointTitlePlayInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -4908757732007241733L;
	
    private final static Log logger = LogFactory.getLog(JointTitlePlayInterceptor.class);
	
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	
	private Integer timeOutMinutes;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {

		String result = "warning";
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String memId = request.getParameter("memId");
		String titleId = request.getParameter("titleId");
		String serverId = request.getParameter("serverId");
		String providerId = request.getParameter("providerId");
		
		if (memId != null && titleId != null && serverId != null && providerId != null && checkTime()) {

			ProviderMst provider = masterInfoBusinessLogic.getProviderMstByKey(providerId);
			
			if (checkProviderKind(provider)) {
				
				ProviderTitleMst providerTitle = new ProviderTitleMst();			
				providerTitle.setProviderId(providerId);
				providerTitle.setTitleId(Integer.valueOf(titleId));			
				providerTitle = masterInfoBusinessLogic.getProviderTitleMstByKey(providerTitle);
				
				if (checkSign(providerTitle)) {
					
					JointTitlePlayControlAction action = (JointTitlePlayControlAction)ai.getAction();
					
					action.setMaintenanceUrl(providerTitle.getMaintenanceUrl());
					action.setErrorUrl(providerTitle.getErrorUrl());
					
					result = ai.invoke();
				}
			}
		}
		
		return result;
	}
	
	protected boolean checkTime() {
		
		boolean checkOk = false;
		
		String timeStr = ServletActionContext.getRequest().getParameter("time");
		
		if (timeStr != null) { 
			
			Long reqTime = Long.valueOf(timeStr);
			
			if (System.currentTimeMillis() / 1000 < reqTime + timeOutMinutes * 60) {
				
				checkOk = true;
				
			} else {

				logger.warn(ContextUtil.getRequestBaseInfo() + " | The request is time out.");
			}
			
		} else {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | No time parameter.");
		}
		
		return checkOk;
	}
		
	protected boolean checkProviderKind(ProviderMst provider) {
		
		boolean checkOk = false;
		
		if (provider != null && PortalConstants.ProviderKind.JOINT.equals(provider.getProviderKindCd())) {
				
			checkOk = true;
			
		} else {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | The provider is not exists.");
		}
		
		return checkOk;
	}
	
	protected boolean checkSign(ProviderTitleMst providerTitle) {
		
		boolean checkOk = false;

		if (createSign(providerTitle.getSecurityCode()).equals(ServletActionContext.getRequest().getParameter("sign"))) {
			
			checkOk = true;
			
		} else {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | The check of parameter sign is failed.");
		}
		
		return checkOk;
	}
	
	private String createSign(String securityCode) {
		
		return SecurityUtil.getMD5String(new StringBuffer()
			.append(ServletActionContext.getRequest().getParameter("memId"))
			.append(ServletActionContext.getRequest().getParameter("providerId"))
			.append(ServletActionContext.getRequest().getParameter("titleId"))
			.append(ServletActionContext.getRequest().getParameter("serverId"))
			.append(ServletActionContext.getRequest().getParameter("time"))
			.append(securityCode)
			.toString());
	}

	public void setMasterInfoBusinessLogic(IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	public void setTimeOutMinutes(Integer timeOutMinutes) {
		
		this.timeOutMinutes = timeOutMinutes;
	}

	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}
}
