package com.gameif.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class AdvertMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6426689519309883322L;

	private Integer advertNum;
	private String advertName;
	private Integer advertAgencyNum;
	private Integer mediaNum;
	private Integer payKind;
	private BigDecimal advertBudget;
	private BigDecimal advertActual;
	private Date startDate;
	private Date endDate;
	private Integer titleId;
	private String remarks;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the advertNum
	 */
	public Integer getAdvertNum() {
		return advertNum;
	}

	/**
	 * @param advertNum
	 *            the advertNum to set
	 */
	public void setAdvertNum(Integer advertNum) {
		this.advertNum = advertNum;
	}

	/**
	 * @return the advertName
	 */
	public String getAdvertName() {
		return advertName;
	}

	/**
	 * @param advertName
	 *            the advertName to set
	 */
	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}

	/**
	 * @return the advertAgencyNum
	 */
	public Integer getAdvertAgencyNum() {
		return advertAgencyNum;
	}

	/**
	 * @param advertAgencyNum
	 *            the advertAgencyNum to set
	 */
	public void setAdvertAgencyNum(Integer advertAgencyNum) {
		this.advertAgencyNum = advertAgencyNum;
	}

	/**
	 * @return the mediaNum
	 */
	public Integer getMediaNum() {
		return mediaNum;
	}

	/**
	 * @param mediaNum
	 *            the mediaNum to set
	 */
	public void setMediaNum(Integer mediaNum) {
		this.mediaNum = mediaNum;
	}

	/**
	 * @return the payKind
	 */
	public Integer getPayKind() {
		return payKind;
	}

	/**
	 * @param payKind
	 *            the payKind to set
	 */
	public void setPayKind(Integer payKind) {
		this.payKind = payKind;
	}

	/**
	 * @return the advertBudget
	 */
	public BigDecimal getAdvertBudget() {
		return advertBudget;
	}

	/**
	 * @param advertBudget
	 *            the advertBudget to set
	 */
	public void setAdvertBudget(BigDecimal advertBudget) {
		this.advertBudget = advertBudget;
	}

	/**
	 * @return the advertActual
	 */
	public BigDecimal getAdvertActual() {
		return advertActual;
	}

	/**
	 * @param advertActual
	 *            the advertActual to set
	 */
	public void setAdvertActual(BigDecimal advertActual) {
		this.advertActual = advertActual;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
