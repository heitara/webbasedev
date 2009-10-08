package com.gameif.portal.action.menu;

public class LoginStatusProxyAction {

	private String target;
	
	public String execute() {
		
		if (target == null || target.trim().isEmpty()) {
			
			target = "/index.html";
		}
		
		return "success";
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}