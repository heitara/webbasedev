package com.gameif.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemSettlementTrns extends BaseEntity {

	private static final long serialVersionUID = 600912850745459826L;

	private Long settlementTrnsNum;
	private String settlementCode;
	private String providerId;
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
	
	public Long getSettlementTrnsNum() {
		return settlementTrnsNum;
	}
	public void setSettlementTrnsNum(Long settlementTrnsNum) {
		this.settlementTrnsNum = settlementTrnsNum;
	}
	public String getSettlementCode() {
		return settlementCode;
	}
	public void setSettlementCode(String settlementCode) {
		this.settlementCode = settlementCode;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public Long getMemNum() {
		return memNum;
	}
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}
	public String getMemAtbtCd() {
		return memAtbtCd;
	}
	public void setMemAtbtCd(String memAtbtCd) {
		this.memAtbtCd = memAtbtCd;
	}
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public Integer getPointId() {
		return pointId;
	}
	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public BigDecimal getPointAmount() {
		return pointAmount;
	}
	public void setPointAmount(BigDecimal pointAmount) {
		this.pointAmount = pointAmount;
	}
	public BigDecimal getPointAmountAct() {
		return pointAmountAct;
	}
	public void setPointAmountAct(BigDecimal pointAmountAct) {
		this.pointAmountAct = pointAmountAct;
	}
	public String getSettlementLog() {
		return settlementLog;
	}
	public void setSettlementLog(String settlementLog) {
		this.settlementLog = settlementLog;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

}