package com.gameif.payment.action.menu;

import org.apache.struts2.ServletActionContext;

public class LogoutProxyAction {
	
	private String logoutUrl;
	
	public String execute() {
		
		try {

			ServletActionContext.getRequest().getSession().invalidate();
			logoutUrl = ServletActionContext.getServletContext().getInitParameter("portalAuthTopUrl") + "/logout";
			
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