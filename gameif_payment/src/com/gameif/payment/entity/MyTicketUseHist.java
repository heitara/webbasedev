package com.gameif.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MyTicketUseHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4495364906443298500L;
	private Integer ticketId;
	private String ticketName;
	private String iconUrl;
	private Date ticketUseDate;
	private Integer ticketCount;
	private BigDecimal pointAmount;

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
	 * @return the ticketUseDate
	 */
	public Date getTicketUseDate() {
		return ticketUseDate;
	}

	/**
	 * @param ticketUseDate
	 *            the ticketUseDate to set
	 */
	public void setTicketUseDate(Date ticketUseDate) {
		this.ticketUseDate = ticketUseDate;
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
	 * @return the pointAmount
	 */
	public BigDecimal getPointAmount() {
		return pointAmount;
	}

	/**
	 * @param pointAmount
	 *            the pointAmount to set
	 */
	public void setPointAmount(BigDecimal pointAmount) {
		this.pointAmount = pointAmount;
	}

}
