package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class TicketUseHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5643535377548899480L;

	private Long ticketUseNo;
	private Long memNum;
	private Integer ticketId;
	private Date ticketUseDate;
	private Date ticketStartDate;
	private Date ticketEndDate;
	private Integer ticketCount;
	private BigDecimal pointAmount;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the ticketUseNo
	 */
	public Long getTicketUseNo() {
		return ticketUseNo;
	}

	/**
	 * @param ticketUseNo
	 *            the ticketUseNo to set
	 */
	public void setTicketUseNo(Long ticketUseNo) {
		this.ticketUseNo = ticketUseNo;
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
	 * @return the pointAmount
	 */
	public BigDecimal getPointAmount() {
		return pointAmount;
	}

	/**
	 * @param pointAmount the pointAmount to set
	 */
	public void setPointAmount(BigDecimal pointAmount) {
		this.pointAmount = pointAmount;
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
