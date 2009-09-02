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
	private Date inviteYmd;
	private String inviteMsg;
	private Integer titleId;
	private Date friendCreateYmd;
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
	 * @return the inviteYmd
	 */
	public Date getInviteYmd() {
		return inviteYmd;
	}

	/**
	 * @param inviteYmd
	 *            the inviteYmd to set
	 */
	public void setInviteYmd(Date inviteYmd) {
		this.inviteYmd = inviteYmd;
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
	 * @return the friendCreateYmd
	 */
	public Date getFriendCreateYmd() {
		return friendCreateYmd;
	}

	/**
	 * @param friendCreateYmd
	 *            the friendCreateYmd to set
	 */
	public void setFriendCreateYmd(Date friendCreateYmd) {
		this.friendCreateYmd = friendCreateYmd;
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
