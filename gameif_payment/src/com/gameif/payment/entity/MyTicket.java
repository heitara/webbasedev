package com.gameif.payment.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MyTicket extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2676736259525066536L;

	private Long memNum;
	private Integer ticketId;
	private Date ticketStartDate;
	private Date ticketEndDate;
	private Integer ticketCount;
	private String ticketName;
	private String ticketTypeCd;
	private Integer titleId;
	private String iconUrl;
	private String titleName;

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
	public String getTicketTypeCd() {
		return ticketTypeCd;
	}

	/**
	 * @param ticketTypeCd the ticketTypeCd to set
	 */
	public void setTicketTypeCd(String ticketTypeCd) {
		this.ticketTypeCd = ticketTypeCd;
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

}
