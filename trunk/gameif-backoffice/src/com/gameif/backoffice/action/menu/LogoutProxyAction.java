package com.gameif.backoffice.action.menu;

import org.apache.struts2.ServletActionContext;

public class LogoutProxyAction {
	
	private String logoutUrl;
	
	public String execute() {
		
		try {

			ServletActionContext.getRequest().getSession().invalidate();
			logoutUrl = ServletActionContext.getServletContext().getInitParameter("backOfficeTopUrl") + "/inputUserLogin.html";
			
		} catch (Exception ex) {
			
		}
		
		return "success";
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
}