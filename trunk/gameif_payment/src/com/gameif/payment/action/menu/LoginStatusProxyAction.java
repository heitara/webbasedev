package com.gameif.payment.action.menu;

public class LoginStatusProxyAction {

	private String target;
	
	public String execute() {
		
		if (target == null || target.trim().isEmpty()) {
			
			target = "/index.html";
		}
		
		if (target.indexOf('?') >= 0) {
			
			target += "&login";
			
		} else {
			
			target += "?login";
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