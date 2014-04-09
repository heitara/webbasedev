package com.gameif.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MySPUseHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4745577619783226240L;

	private Long memNum;
	private Integer titleId;
	private String titleName;
	private Integer serverId;
	private String serverName;
	private Date useDate;
	private BigDecimal pointAmount;

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
	 * @param serverName the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * @return the useDate
	 */
	public Date getUseDate() {
		return useDate;
	}

	/**
	 * @param useDate
	 *            the useDate to set
	 */
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
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
