package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemSettlementHist extends BaseEntity {

	private static final long serialVersionUID = 4187902858833042314L;

	private Long settlementNum;
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
	private String settlementRemarks;
	private String resResult;
	private String resTrackingId;
	private String resSpsCustNo;
	private String resSpsPaymentNo;
	private String resPayinfoKey;
	private String resPaymentDate;
	private String resErrCode;
	private String resDate;
	private String limitSecond;
	private String spsHashcode;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;
	
	public Long getSettlementNum() {
		return settlementNum;
	}
	public void setSettlementNum(Long settlementNum) {
		this.settlementNum = settlementNum;
	}
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
	public String getSettlementRemarks() {
		return settlementRemarks;
	}
	public void setSettlementRemarks(String settlementRemarks) {
		this.settlementRemarks = settlementRemarks;
	}
	public String getResResult() {
		return resResult;
	}
	public void setResResult(String resResult) {
		this.resResult = resResult;
	}
	public String getResTrackingId() {
		return resTrackingId;
	}
	public void setResTrackingId(String resTrackingId) {
		this.resTrackingId = resTrackingId;
	}
	public String getResSpsCustNo() {
		return resSpsCustNo;
	}
	public void setResSpsCustNo(String resSpsCustNo) {
		this.resSpsCustNo = resSpsCustNo;
	}
	public String getResSpsPaymentNo() {
		return resSpsPaymentNo;
	}
	public void setResSpsPaymentNo(String resSpsPaymentNo) {
		this.resSpsPaymentNo = resSpsPaymentNo;
	}
	public String getResPayinfoKey() {
		return resPayinfoKey;
	}
	public void setResPayinfoKey(String resPayinfoKey) {
		this.resPayinfoKey = resPayinfoKey;
	}
	public String getResPaymentDate() {
		return resPaymentDate;
	}
	public void setResPaymentDate(String resPaymentDate) {
		this.resPaymentDate = resPaymentDate;
	}
	public String getResErrCode() {
		return resErrCode;
	}
	public void setResErrCode(String resErrCode) {
		this.resErrCode = resErrCode;
	}
	public String getResDate() {
		return resDate;
	}
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	public String getLimitSecond() {
		return limitSecond;
	}
	public void setLimitSecond(String limitSecond) {
		this.limitSecond = limitSecond;
	}
	public String getSpsHashcode() {
		return spsHashcode;
	}
	public void setSpsHashcode(String spsHashcode) {
		this.spsHashcode = spsHashcode;
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
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
}
