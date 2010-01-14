package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class InviteInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011474227495569585L;

	private Long inviteId;
	private Long memNum;
	private String inviteMailFrom;
	private String inviteMailTo;
	private Date inviteDate;
	private String inviteMsg;
	private Integer titleId;
	private String inviteStatus;
	private Date friendCreateDate;
	private String friendName;
	private Long childMemNum;
	private String approveStatus;
	private String parentCookie;
	private String parentApproveCookie;
	private String childCookie;
	private String deleteFlag;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the inviteId
	 */
	public Long getInviteId() {
		return inviteId;
	}

	/**
	 * @param inviteId
	 *            the inviteId to set
	 */
	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
	}

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
	 * @return the inviteMailFrom
	 */
	public String getInviteMailFrom() {
		return inviteMailFrom;
	}

	/**
	 * @param inviteMailFrom
	 *            the inviteMailFrom to set
	 */
	public void setInviteMailFrom(String inviteMailFrom) {
		this.inviteMailFrom = inviteMailFrom;
	}

	/**
	 * @return the inviteMailTo
	 */
	public String getInviteMailTo() {
		return inviteMailTo;
	}

	/**
	 * @param inviteMailTo
	 *            the inviteMailTo to set
	 */
	public void setInviteMailTo(String inviteMailTo) {
		this.inviteMailTo = inviteMailTo;
	}

	/**
	 * @return the inviteDate
	 */
	public Date getInviteDate() {
		return inviteDate;
	}

	/**
	 * @param inviteDate
	 *            the inviteDate to set
	 */
	public void setInviteDate(Date inviteDate) {
		this.inviteDate = inviteDate;
	}

	/**
	 * @return the inviteStatus
	 */
	public String getInviteStatus() {
		return inviteStatus;
	}

	/**
	 * @param inviteStatus
	 *            the inviteStatus to set
	 */
	public void setInviteStatus(String inviteStatus) {
		this.inviteStatus = inviteStatus;
	}

	/**
	 * @return the friendCreateDate
	 */
	public Date getFriendCreateDate() {
		return friendCreateDate;
	}

	/**
	 * @param friendCreateDate
	 *            the friendCreateDate to set
	 */
	public void setFriendCreateDate(Date friendCreateDate) {
		this.friendCreateDate = friendCreateDate;
	}

	/**
	 * @return the friendName
	 */
	public String getFriendName() {
		return friendName;
	}

	/**
	 * @param friendName
	 *            the friendName to set
	 */
	public void setFriendName(String friendName) {
		this.friendName = friendName;
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
	 * @return the inviteMsg
	 */
	public String getInviteMsg() {
		return inviteMsg;
	}

	/**
	 * @param inviteMsg
	 *            the inviteMsg to set
	 */
	public void setInviteMsg(String inviteMsg) {
		this.inviteMsg = inviteMsg;
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
	 * @return the parentCookie
	 */
	public String getParentCookie() {
		return parentCookie;
	}

	/**
	 * @param parentCookie
	 *            the parentCookie to set
	 */
	public void setParentCookie(String parentCookie) {
		this.parentCookie = parentCookie;
	}

	/**
	 * @return the parentApproveCookie
	 */
	public String getParentApproveCookie() {
		return parentApproveCookie;
	}

	/**
	 * @param parentApproveCookie
	 *            the parentApproveCookie to set
	 */
	public void setParentApproveCookie(String parentApproveCookie) {
		this.parentApproveCookie = parentApproveCookie;
	}

	/**
	 * @return the childCookie
	 */
	public String getChildCookie() {
		return childCookie;
	}

	/**
	 * @param childCookie
	 *            the childCookie to set
	 */
	public void setChildCookie(String childCookie) {
		this.childCookie = childCookie;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdUser
	 */
	public String getCreatedUser() {
		return createdUser;
	}

	/**
	 * @param createdUser
	 *            the createdUser to set
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate
	 *            the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the lastUpdateUser
	 */
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	/**
	 * @param lastUpdateUser
	 *            the lastUpdateUser to set
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

}
