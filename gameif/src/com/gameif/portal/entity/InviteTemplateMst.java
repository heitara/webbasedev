package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class InviteTemplateMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8159483727426737623L;

	private Integer inviteTemplateId;
	private Integer titleId;
	private String inviteTemplateSubject;
	private String inviteTemplateMsg;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the inviteTemplateId
	 */
	public Integer getInviteTemplateId() {
		return inviteTemplateId;
	}

	/**
	 * @param inviteTemplateId
	 *            the inviteTemplateId to set
	 */
	public void setInviteTemplateId(Integer inviteTemplateId) {
		this.inviteTemplateId = inviteTemplateId;
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
	 * @return the inviteTemplateSubject
	 */
	public String getInviteTemplateSubject() {
		return inviteTemplateSubject;
	}

	/**
	 * @param inviteTemplateSubject
	 *            the inviteTemplateSubject to set
	 */
	public void setInviteTemplateSubject(String inviteTemplateSubject) {
		this.inviteTemplateSubject = inviteTemplateSubject;
	}

	/**
	 * @return the inviteTemplateMsg
	 */
	public String getInviteTemplateMsg() {
		return inviteTemplateMsg;
	}

	/**
	 * @param inviteTemplateMsg
	 *            the inviteTemplateMsg to set
	 */
	public void setInviteTemplateMsg(String inviteTemplateMsg) {
		this.inviteTemplateMsg = inviteTemplateMsg;
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
