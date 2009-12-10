package com.gameif.backoffice.action.menu;

import com.gameif.backoffice.helper.BackOfficeProperties;

public class DisplayAction {

	private BackOfficeProperties backOfficeProperties;
	private String action = null;
	private String actionTitle = null;

	/**
	 * @param backOfficeProperties the backOfficeProperties to set
	 */
	public void setBackOfficeProperties(BackOfficeProperties backOfficeProperties) {
		this.backOfficeProperties = backOfficeProperties;
	}

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
			
			actionTitle = backOfficeProperties.getActionTitles().get(action);
			
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