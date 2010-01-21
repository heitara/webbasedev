package com.gameif.backoffice.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class CampaignMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8298916700260534490L;

	private Integer campaignId;
	private String campaignSubject;
	private String campaignContents;
	private Integer titleId;
	private Date campaignStartDate;
	private Date campaignEndDate;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the campaignId
	 */
	public Integer getCampaignId() {
		return campaignId;
	}

	/**
	 * @param campaignId
	 *            the campaignId to set
	 */
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
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
	 * @return the campaignStartDate
	 */
	public Date getCampaignStartDate() {
		return campaignStartDate;
	}

	/**
	 * @param campaignStartDate
	 *            the campaignStartDate to set
	 */
	public void setCampaignStartDate(Date campaignStartDate) {
		this.campaignStartDate = campaignStartDate;
	}

	/**
	 * @return the campaignEndDate
	 */
	public Date getCampaignEndDate() {
		return campaignEndDate;
	}

	/**
	 * @param campaignEndDate
	 *            the campaignEndDate to set
	 */
	public void setCampaignEndDate(Date campaignEndDate) {
		this.campaignEndDate = campaignEndDate;
	}

	/**
	 * @return the campaignSubject
	 */
	public String getCampaignSubject() {
		return campaignSubject;
	}

	/**
	 * @param campaignSubject
	 *            the campaignSubject to set
	 */
	public void setCampaignSubject(String campaignSubject) {
		this.campaignSubject = campaignSubject;
	}

	/**
	 * @return the campaignContents
	 */
	public String getCampaignContents() {
		return campaignContents;
	}

	/**
	 * @param campaignContents
	 *            the campaignContents to set
	 */
	public void setCampaignContents(String campaignContents) {
		this.campaignContents = campaignContents;
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
