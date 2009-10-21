package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemSettlementTrns extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 600912850745459826L;

	private Long settlementTrnsNum;
	private String settlementCode;
	private Long memNum;
	private String memAtbtCd;
	private Integer titleId;
	private Integer serverId;
	private Integer pointId;
	private Date settlementDate;
	private BigDecimal pointAmount;
	private BigDecimal pointAmountAct;
	private String settlementLog;
	private Date createdDate;
	private String createdUser;

	/**
	 * @return the settlementTrnsNum
	 */
	public Long getSettlementTrnsNum() {
		return settlementTrnsNum;
	}

	/**
	 * @param settlementTrnsNum
	 *            the settlementTrnsNum to set
	 */
	public void setSettlementTrnsNum(Long settlementTrnsNum) {
		this.settlementTrnsNum = settlementTrnsNum;
	}

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
	 * @return the memAtbtCd
	 */
	public String getMemAtbtCd() {
		return memAtbtCd;
	}

	/**
	 * @param memAtbtCd
	 *            the memAtbtCd to set
	 */
	public void setMemAtbtCd(String memAtbtCd) {
		this.memAtbtCd = memAtbtCd;
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
	 * @return the serverId
	 */
	public Integer getServerId() {
		return serverId;
	}

	/**
	 * @param serverId
	 *            the serverId to set
	 */
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	/**
	 * @return the pointId
	 */
	public Integer getPointId() {
		return pointId;
	}

	/**
	 * @param pointId
	 *            the pointId to set
	 */
	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	/**
	 * @return the settlementDate
	 */
	public Date getSettlementDate() {
		return settlementDate;
	}

	/**
	 * @param settlementDate
	 *            the settlementDate to set
	 */
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
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
	 * @return the pointAmountAct
	 */
	public BigDecimal getPointAmountAct() {
		return pointAmountAct;
	}

	/**
	 * @param pointAmountAct the pointAmountAct to set
	 */
	public void setPointAmountAct(BigDecimal pointAmountAct) {
		this.pointAmountAct = pointAmountAct;
	}

	/**
	 * @return the settlementLog
	 */
	public String getSettlementLog() {
		return settlementLog;
	}

	/**
	 * @param settlementLog
	 *            the settlementLog to set
	 */
	public void setSettlementLog(String settlementLog) {
		this.settlementLog = settlementLog;
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

}
