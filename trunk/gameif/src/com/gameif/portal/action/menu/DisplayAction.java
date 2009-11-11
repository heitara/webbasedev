package com.gameif.portal.action.menu;

import com.gameif.portal.helper.PortalProperties;

public class DisplayAction {

	private PortalProperties portalProperties;

	private String action = null;
	private String actionTitle = null;
	
	public void setPortalProperties(PortalProperties portalProperties) {
		this.portalProperties = portalProperties;
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
			
			actionTitle = portalProperties.getActionTitles().get(action);
			
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
	
	/**
	 * 期限きれ画面へ案内する
	 * @return　期限きれ画面
	 */
	public String outOfDate() {
		return "outOfDate";
	}
	
	/**
	 * メンテナンス画面へ案内する
	 * @return メンテナンス画面
	 */
	public String maintenance() {
		return "maintenance";
	}
}