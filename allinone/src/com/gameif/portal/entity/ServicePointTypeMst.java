package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class ServicePointTypeMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4204486086827256396L;

	private Integer servicePointTypeId;
	private String servicePointTypeCode;
	private BigDecimal pointAmount;
	private Integer standardLevel;
	private String remarks;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the servicePointTypeId
	 */
	public Integer getServicePointTypeId() {
		return servicePointTypeId;
	}

	/**
	 * @param servicePointTypeId
	 *            the servicePointTypeId to set
	 */
	public void setServicePointTypeId(Integer servicePointTypeId) {
		this.servicePointTypeId = servicePointTypeId;
	}

	/**
	 * @return the servicePointTypeCode
	 */
	public String getServicePointTypeCode() {
		return servicePointTypeCode;
	}

	/**
	 * @param servicePointTypeCode
	 *            the servicePointTypeCode to set
	 */
	public void setServicePointTypeCode(String servicePointTypeCode) {
		this.servicePointTypeCode = servicePointTypeCode;
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
	 * @return the standardLevel
	 */
	public Integer getStandardLevel() {
		return standardLevel;
	}

	/**
	 * @param standardLevel
	 *            the standardLevel to set
	 */
	public void setStandardLevel(Integer standardLevel) {
		this.standardLevel = standardLevel;
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
