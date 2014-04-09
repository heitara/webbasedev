package com.gameif.payment.entity;

import java.util.Date;

public class MyInviteLink {
	
	private String nickName;
	private Date entryDate;
	private String titleName;
	private Long memNum;
	private Long childMemNum;
	private String approveStatus;
	
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * @return the entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
	}
	
	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	/**
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}
	
	/**
	 * @param titleName the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	/**
	 * @return the memNum
	 */
	public Long getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum the memNum to set
	 */
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	/**
	 * @return the childMemNum
	 */
	public Long getChildMemNum() {
		return childMemNum;
	}

	/**
	 * @param childMemNum the childMemNum to set
	 */
	public void setChildMemNum(Long childMemNum) {
		this.childMemNum = childMemNum;
	}

	/**
	 * @return the approveStatus
	 */
	public String getApproveStatus() {
		return approveStatus;
	}

	/**
	 * @param approveStatus the approveStatus to set
	 */
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
}
