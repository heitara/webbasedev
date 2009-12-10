package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class TicketModelMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5574840844084760417L;

	private Integer modelId;
	private BigDecimal limitPointLower;
	private BigDecimal limitPointUpper;
	private String modelName;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the modelId
	 */
	public Integer getModelId() {
		return modelId;
	}

	/**
	 * @param modelId
	 *            the modelId to set
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * @param modelName
	 *            the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * @return the limitPointUpper
	 */
	public BigDecimal getLimitPointUpper() {
		return limitPointUpper;
	}

	/**
	 * @param limitPointUpper
	 *            the limitPointUpper to set
	 */
	public void setLimitPointUpper(BigDecimal limitPointUpper) {
		this.limitPointUpper = limitPointUpper;
	}

	/**
	 * @return the limitPointLower
	 */
	public BigDecimal getLimitPointLower() {
		return limitPointLower;
	}

	/**
	 * @param limitPointLower
	 *            the limitPointLower to set
	 */
	public void setLimitPointLower(BigDecimal limitPointLower) {
		this.limitPointLower = limitPointLower;
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
