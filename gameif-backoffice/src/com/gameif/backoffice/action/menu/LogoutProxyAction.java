package com.gameif.backoffice.action.menu;

import org.apache.struts2.ServletActionContext;

public class LogoutProxyAction {
	
	public String execute() {
		
		try {

			ServletActionContext.getRequest().getSession().invalidate();
			
		} catch (Exception ex) {
			
		}
		
		return "success";
	}
}