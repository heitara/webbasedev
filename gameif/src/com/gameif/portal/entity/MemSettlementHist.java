package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemSettlementHist extends BaseEntity {

	/**
	 * 
	 */
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

	/**
	 * @return the settlementNum
	 */
	public Long getSettlementNum() {
		return settlementNum;
	}

	/**
	 * @param settlementNum
	 *            the settlementNum to set
	 */
	public void setSettlementNum(Long settlementNum) {
		this.settlementNum = settlementNum;
	}

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
	 * @return the settlementRemarks
	 */
	public String getSettlementRemarks() {
		return settlementRemarks;
	}

	/**
	 * @param settlementRemarks
	 *            the settlementRemarks to set
	 */
	public void setSettlementRemarks(String settlementRemarks) {
		this.settlementRemarks = settlementRemarks;
	}

	/**
	 * @return the resResult
	 */
	public String getResResult() {
		return resResult;
	}

	/**
	 * @param resResult
	 *            the resResult to set
	 */
	public void setResResult(String resResult) {
		this.resResult = resResult;
	}

	/**
	 * @return the resTrackingId
	 */
	public String getResTrackingId() {
		return resTrackingId;
	}

	/**
	 * @param resTrackingId
	 *            the resTrackingId to set
	 */
	public void setResTrackingId(String resTrackingId) {
		this.resTrackingId = resTrackingId;
	}

	/**
	 * @return the resSpsCustNo
	 */
	public String getResSpsCustNo() {
		return resSpsCustNo;
	}

	/**
	 * @param resSpsCustNo
	 *            the resSpsCustNo to set
	 */
	public void setResSpsCustNo(String resSpsCustNo) {
		this.resSpsCustNo = resSpsCustNo;
	}

	/**
	 * @return the resSpsPaymentNo
	 */
	public String getResSpsPaymentNo() {
		return resSpsPaymentNo;
	}

	/**
	 * @param resSpsPaymentNo
	 *            the resSpsPaymentNo to set
	 */
	public void setResSpsPaymentNo(String resSpsPaymentNo) {
		this.resSpsPaymentNo = resSpsPaymentNo;
	}

	/**
	 * @return the resPayinfoKey
	 */
	public String getResPayinfoKey() {
		return resPayinfoKey;
	}

	/**
	 * @param resPayinfoKey
	 *            the resPayinfoKey to set
	 */
	public void setResPayinfoKey(String resPayinfoKey) {
		this.resPayinfoKey = resPayinfoKey;
	}

	/**
	 * @return the resPaymentDate
	 */
	public String getResPaymentDate() {
		return resPaymentDate;
	}

	/**
	 * @param resPaymentDate
	 *            the resPaymentDate to set
	 */
	public void setResPaymentDate(String resPaymentDate) {
		this.resPaymentDate = resPaymentDate;
	}

	/**
	 * @return the resErrCode
	 */
	public String getResErrCode() {
		return resErrCode;
	}

	/**
	 * @param resErrCode
	 *            the resErrCode to set
	 */
	public void setResErrCode(String resErrCode) {
		this.resErrCode = resErrCode;
	}

	/**
	 * @return the resDate
	 */
	public String getResDate() {
		return resDate;
	}

	/**
	 * @param resDate
	 *            the resDate to set
	 */
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}

	/**
	 * @return the limitSecond
	 */
	public String getLimitSecond() {
		return limitSecond;
	}

	/**
	 * @param limitSecond
	 *            the limitSecond to set
	 */
	public void setLimitSecond(String limitSecond) {
		this.limitSecond = limitSecond;
	}

	/**
	 * @return the spsHashcode
	 */
	public String getSpsHashcode() {
		return spsHashcode;
	}

	/**
	 * @param spsHashcode
	 *            the spsHashcode to set
	 */
	public void setSpsHashcode(String spsHashcode) {
		this.spsHashcode = spsHashcode;
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
