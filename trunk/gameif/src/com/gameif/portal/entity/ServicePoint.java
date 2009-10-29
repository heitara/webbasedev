package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class ServicePoint extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5539265171608816654L;

	private Long servicePointNo;
	private Long memNum;
	private Date giveDate;
	private Date pointStartDate;
	private Date pointEndDate;
	private Integer titleId;
	private BigDecimal pointAmount;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the servicePointNo
	 */
	public Long getServicePointNo() {
		return servicePointNo;
	}

	/**
	 * @param servicePointNo
	 *            the servicePointNo to set
	 */
	public void setServicePointNo(Long servicePointNo) {
		this.servicePointNo = servicePointNo;
	}

	/**
	 * @return the memNum
	 */
	public Long getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum the memNum to set
	 */
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	/**
	 * @return the giveDate
	 */
	public Date getGiveDate() {
		return giveDate;
	}

	/**
	 * @param giveDate
	 *            the giveDate to set
	 */
	public void setGiveDate(Date giveDate) {
		this.giveDate = giveDate;
	}

	/**
	 * @return the pointStartDate
	 */
	public Date getPointStartDate() {
		return pointStartDate;
	}

	/**
	 * @param pointStartDate
	 *            the pointStartDate to set
	 */
	public void setPointStartDate(Date pointStartDate) {
		this.pointStartDate = pointStartDate;
	}

	/**
	 * @return the pointEndDate
	 */
	public Date getPointEndDate() {
		return pointEndDate;
	}

	/**
	 * @param pointEndDate
	 *            the pointEndDate to set
	 */
	public void setPointEndDate(Date pointEndDate) {
		this.pointEndDate = pointEndDate;
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
