package com.gameif.payment.helper;

import java.util.Map;

public class PaymentProperties {
		
	/** アクションタイトルマップ */
	private Map<String, String> actionTitles;

	/** 性別マップ */
	private Map<String, String> sexListMap;

	/** 月マップ */
	private Map<String, String> monthListMap;

	/** 日マップ */
	private Map<String, String> dayListMap;
	
	/** 友達登録ステータス */
	private Map<String, String> inviteStatusList;
	
	/** ドメイン */
	private Map<String, String> domainListMap;
	
	/** ＷＥＢメールログインＵＲＬ */
	private Map<String, String> mailUrlMap;
	
	/** 時間帯（臨時会員情報を削除するために、時間を指定する） */
	private Map<String, String> timeZoneList;
	
	/** 退会原因 */
	private Map<String, String> withdrawReason;
	
	/** 友達紹介の承認ステータス */
	private Map<String, String> approveStatus;
	
	public String getMailLoginUrl(String mail) {
		
		String mailLoginUrl = null;
		
		if (mail != null) {
			
			mailLoginUrl = mailUrlMap.get(mail.substring(mail.indexOf('@')));
		}
		
		return mailLoginUrl;
	}
	

	public Map<String, String> getActionTitles() {
		return actionTitles;
	}

	public void setActionTitles(Map<String, String> actionTitles) {
		this.actionTitles = actionTitles;
	}

	public Map<String, String> getSexListMap() {
		return sexListMap;
	}

	public void setSexListMap(Map<String, String> sexMap) {
		this.sexListMap = sexMap;
	}

	public Map<String, String> getMonthListMap() {
		return monthListMap;
	}

	public void setMonthListMap(Map<String, String> monthListMap) {
		this.monthListMap = monthListMap;
	}

	public Map<String, String> getDayListMap() {
		return dayListMap;
	}

	public void setDayListMap(Map<String, String> dayListMap) {
		this.dayListMap = dayListMap;
	}
	
	public void setInviteStatusList(Map<String, String> inviteStatusList) {
		this.inviteStatusList = inviteStatusList;
	}

	public Map<String, String> getInviteStatusList() {
		return inviteStatusList;
	}

	/**
	 * @return the domainListMap
	 */
	public Map<String, String> getDomainListMap() {
		return domainListMap;
	}

	/**
	 * @param domainListMap the domainListMap to set
	 */
	public void setDomainListMap(Map<String, String> domainListMap) {
		this.domainListMap = domainListMap;
	}

	/**
	 * @return the timeZoneList
	 */
	public Map<String, String> getTimeZoneList() {
		return timeZoneList;
	}

	/**
	 * @param timeZoneList the timeZoneList to set
	 */
	public void setTimeZoneList(Map<String, String> timeZoneList) {
		this.timeZoneList = timeZoneList;
	}

	public Map<String, String> getMailUrlMap() {
		return mailUrlMap;
	}

	public void setMailUrlMap(Map<String, String> mailUrlMap) {
		this.mailUrlMap = mailUrlMap;
	}


	/**
	 * @return the withdrawReason
	 */
	public Map<String, String> getWithdrawReason() {
		return withdrawReason;
	}


	/**
	 * @param withdrawReason the withdrawReason to set
	 */
	public void setWithdrawReason(Map<String, String> withdrawReason) {
		this.withdrawReason = withdrawReason;
	}


	/**
	 * @return the approveStatus
	 */
	public Map<String, String> getApproveStatus() {
		return approveStatus;
	}


	/**
	 * @param approveStatus the approveStatus to set
	 */
	public void setApproveStatus(Map<String, String> approveStatus) {
		this.approveStatus = approveStatus;
	}
	
}
