package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MySettlementHist {

	private String settlementCode;
	private String settlementName;
	private Integer titleId;
	private String titleName;
	private Integer serverId;
	private String serverName;
	private Date settlementDate;
	private BigDecimal pointAmountAct;

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
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * @param serverName
	 *            the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
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
	 * @return the pointAmountAct
	 */
	public BigDecimal getPointAmountAct() {
		return pointAmountAct;
	}

	/**
	 * @param pointAmountAct
	 *            the pointAmountAct to set
	 */
	public void setPointAmountAct(BigDecimal pointAmountAct) {
		this.pointAmountAct = pointAmountAct;
	}

}
