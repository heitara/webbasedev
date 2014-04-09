package com.gameif.payment.action.menu;

import com.gameif.payment.helper.PaymentProperties;

public class DisplayAction {

	private PaymentProperties paymentProperties;

	private String action = null;
	private String actionTitle = null;
	
	public void setPaymentProperties(PaymentProperties paymentProperties) {
		this.paymentProperties = paymentProperties;
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
			
			actionTitle = paymentProperties.getActionTitles().get(action);
			
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