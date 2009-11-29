package com.gameif.backoffice.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class InquirySendmailTemplate extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3304654074445784016L;

	private Integer inquirySendmailId;
	private String inquirySendmailName;
	private String inquirySendmailContents;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the inquirySendmailId
	 */
	public Integer getInquirySendmailId() {
		return inquirySendmailId;
	}

	/**
	 * @param inquirySendmailId
	 *            the inquirySendmailId to set
	 */
	public void setInquirySendmailId(Integer inquirySendmailId) {
		this.inquirySendmailId = inquirySendmailId;
	}

	/**
	 * @return the inquirySendmailName
	 */
	public String getInquirySendmailName() {
		return inquirySendmailName;
	}

	/**
	 * @param inquirySendmailName
	 *            the inquirySendmailName to set
	 */
	public void setInquirySendmailName(String inquirySendmailName) {
		this.inquirySendmailName = inquirySendmailName;
	}

	/**
	 * @return the inquirySendmailContents
	 */
	public String getInquirySendmailContents() {
		return inquirySendmailContents;
	}

	/**
	 * @param inquirySendmailContents
	 *            the inquirySendmailContents to set
	 */
	public void setInquirySendmailContents(String inquirySendmailContents) {
		this.inquirySendmailContents = inquirySendmailContents;
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
