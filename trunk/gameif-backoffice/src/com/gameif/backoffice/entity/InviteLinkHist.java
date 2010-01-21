package com.gameif.backoffice.entity;

import com.gameif.common.entity.BaseEntity;

public class InviteLinkHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9033074805447562747L;

	private Long memNum;
	private Long childMemNum;
	private Integer titleId;
	private String approveStatus;
	private String cookie;
	private String approveCookie;
	private String rejectReason;

	/**
	 * @return the memNum
	 */
	public Long getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum
	 *            the memNum to set
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
	 * @param childMemNum
	 *            the childMemNum to set
	 */
	public void setChildMemNum(Long childMemNum) {
		this.childMemNum = childMemNum;
	}

	/**
	 * @return the titleId
	 */
	public Integer getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId
	 *            the titleId to set
	 */
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the approveStatus
	 */
	public String getApproveStatus() {
		return approveStatus;
	}

	/**
	 * @param approveStatus
	 *            the approveStatus to set
	 */
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	/**
	 * @return the approveCookie
	 */
	public String getApproveCookie() {
		return approveCookie;
	}

	/**
	 * @param approveCookie
	 *            the approveCookie to set
	 */
	public void setApproveCookie(String approveCookie) {
		this.approveCookie = approveCookie;
	}

	/**
	 * @return the rejectReason
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	/**
	 * @param rejectReason
	 *            the rejectReason to set
	 *            
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

}
