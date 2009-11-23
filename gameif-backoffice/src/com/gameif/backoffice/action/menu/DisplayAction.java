package com.gameif.backoffice.action.menu;

public class DisplayAction {


	private String action = null;
	private String actionTitle = null;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionTitle() {
		return actionTitle;
	}

	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}

	public String finished() {
		
		if (action != null) {
			
			if (actionTitle != null) {
				
				return "finish";
			}
		}
			
		return "index";
	}

	public String warning() {
		
		if (action != null) {
			
			return "warning";
		}
			
		return "index";
	}
	
	public String index() {
		return "index";
	}
}