package com.gameif.payment.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class SettlementMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6863133783594219290L;

	private String settlementCode;
	private String settlementName;
	private String iconUrl;
	private String settlementStatus;
	private Integer orderBy;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the settlementCode
	 */
	public String getSettlementCode() {
		return settlementCode;
	}

	/**
	 * @param settlementCode
	 *            the settlementCode to set
	 */
	public void setSettlementCode(String settlementCode) {
		this.settlementCode = settlementCode;
	}

	/**
	 * @return the settlementName
	 */
	public String getSettlementName() {
		return settlementName;
	}

	/**
	 * @param settlementName
	 *            the settlementName to set
	 */
	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
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
	 * @return the settlementStatus
	 */
	public String getSettlementStatus() {
		return settlementStatus;
	}

	/**
	 * @param settlementStatus
	 *            the settlementStatus to set
	 */
	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	/**
	 * @return the orderBy
	 */
	public Integer getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
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
