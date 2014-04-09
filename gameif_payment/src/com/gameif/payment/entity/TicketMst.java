package com.gameif.payment.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class TicketMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2576137587369983214L;

	private Integer ticketId;
	private String ticketName;
	private Integer ticketTypeCd;
	private Integer ticketModelId;
	private Integer titleId;
	private Integer delayDays;
	private Integer validDays;
	private String iconUrl;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the ticketId
	 */
	public Integer getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId
	 *            the ticketId to set
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the ticketName
	 */
	public String getTicketName() {
		return ticketName;
	}

	/**
	 * @param ticketName
	 *            the ticketName to set
	 */
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	/**
	 * @return the ticketTypeCd
	 */
	public Integer getTicketTypeCd() {
		return ticketTypeCd;
	}

	/**
	 * @param ticketTypeCd the ticketTypeCd to set
	 */
	public void setTicketTypeCd(Integer ticketTypeCd) {
		this.ticketTypeCd = ticketTypeCd;
	}

	/**
	 * @return the ticketModelId
	 */
	public Integer getTicketModelId() {
		return ticketModelId;
	}

	/**
	 * @param ticketModelId
	 *            the ticketModelId to set
	 */
	public void setTicketModelId(Integer ticketModelId) {
		this.ticketModelId = ticketModelId;
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
	 * @return the delayDays
	 */
	public Integer getDelayDays() {
		return delayDays;
	}

	/**
	 * @param delayDays
	 *            the delayDays to set
	 */
	public void setDelayDays(Integer delayDays) {
		this.delayDays = delayDays;
	}

	/**
	 * @return the validDays
	 */
	public Integer getValidDays() {
		return validDays;
	}

	/**
	 * @param validDays
	 *            the validDays to set
	 */
	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}

	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * @param iconUrl
	 *            the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
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
