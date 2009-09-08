package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class titleMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6875925984050486185L;

	private Integer titleId;
	private String titleName;
	private Date validStartDate;
	private Date validEndDate;
	private String siteUrl;
	private String smallIconUrl;
	private String bigIconUrl;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastuUpdateUser;

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
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * @param titleName
	 *            the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	/**
	 * @return the validStartDate
	 */
	public Date getValidStartDate() {
		return validStartDate;
	}

	/**
	 * @param validStartDate
	 *            the validStartDate to set
	 */
	public void setValidStartDate(Date validStartDate) {
		this.validStartDate = validStartDate;
	}

	/**
	 * @return the validEndDate
	 */
	public Date getValidEndDate() {
		return validEndDate;
	}

	/**
	 * @param validEndDate
	 *            the validEndDate to set
	 */
	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}

	/**
	 * @return the siteUrl
	 */
	public String getSiteUrl() {
		return siteUrl;
	}

	/**
	 * @param siteUrl
	 *            the siteUrl to set
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	/**
	 * @return the smallIconUrl
	 */
	public String getSmallIconUrl() {
		return smallIconUrl;
	}

	/**
	 * @param smallIconUrl
	 *            the smallIconUrl to set
	 */
	public void setSmallIconUrl(String smallIconUrl) {
		this.smallIconUrl = smallIconUrl;
	}

	/**
	 * @return the bigIconUrl
	 */
	public String getBigIconUrl() {
		return bigIconUrl;
	}

	/**
	 * @param bigIconUrl
	 *            the bigIconUrl to set
	 */
	public void setBigIconUrl(String bigIconUrl) {
		this.bigIconUrl = bigIconUrl;
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
	 * @return the lastuUpdateUser
	 */
	public String getLastuUpdateUser() {
		return lastuUpdateUser;
	}

	/**
	 * @param lastuUpdateUser
	 *            the lastuUpdateUser to set
	 */
	public void setLastuUpdateUser(String lastuUpdateUser) {
		this.lastuUpdateUser = lastuUpdateUser;
	}

}
