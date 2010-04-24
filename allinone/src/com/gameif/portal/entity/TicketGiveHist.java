package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class TicketGiveHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8982892964925387094L;

	private Long ticketGiveNo;
	private Long memNum;
	private Integer ticketId;
	private Integer ticketTypeCd;
	private Date ticketGiveDate;
	private Date ticketStartDate;
	private Date ticketEndDate;
	private Integer ticketCount;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the ticketGiveNo
	 */
	public Long getTicketGiveNo() {
		return ticketGiveNo;
	}

	/**
	 * @param ticketGiveNo
	 *            the ticketGiveNo to set
	 */
	public void setTicketGiveNo(Long ticketGiveNo) {
		this.ticketGiveNo = ticketGiveNo;
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
