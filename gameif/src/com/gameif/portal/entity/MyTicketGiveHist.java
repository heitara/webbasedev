package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MyTicketGiveHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2950566736483136776L;

	private Integer ticketId;
	private String ticketName;
	private String iconUrl;
	private Date ticketGiveDate;
	private Date ticketStartDate;
	private Date ticketEndDate;
	private Integer ticketCount;

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
	 * @return the ticketGiveDate
	 */
	public Date getTicketGiveDate() {
		return ticketGiveDate;
	}

	/**
	 * @param ticketGiveDate
	 *            the ticketGiveDate to set
	 */
	public void setTicketGiveDate(Date ticketGiveDate) {
		this.ticketGiveDate = ticketGiveDate;
	}

	/**
	 * @return the ticketStartDate
	 */
	public Date getTicketStartDate() {
		return ticketStartDate;
	}

	/**
	 * @param ticketStartDate
	 *            the ticketStartDate to set
	 */
	public void setTicketStartDate(Date ticketStartDate) {
		this.ticketStartDate = ticketStartDate;
	}

	/**
	 * @return the ticketEndDate
	 */
	public Date getTicketEndDate() {
		return ticketEndDate;
	}

	/**
	 * @param ticketEndDate
	 *            the ticketEndDate to set
	 */
	public void setTicketEndDate(Date ticketEndDate) {
		this.ticketEndDate = ticketEndDate;
	}

	/**
	 * @return the ticketCount
	 */
	public Integer getTicketCount() {
		return ticketCount;
	}

	/**
	 * @param ticketCount
	 *            the ticketCount to set
	 */
	public void setTicketCount(Integer ticketCount) {
		this.ticketCount = ticketCount;
	}

}
