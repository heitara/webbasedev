package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class TicketModelDetail extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7260999165741878762L;

	private Integer moduleDetailId;
	private Integer moduleId;
	private BigDecimal limitPointUpper;
	private BigDecimal limitPointLower;
	private Integer personCount;
	private Integer personCountLower;
	private Integer personCountUpper;
	private BigDecimal prizePoint;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the moduleDetailId
	 */
	public Integer getModuleDetailId() {
		return moduleDetailId;
	}

	/**
	 * @param moduleDetailId
	 *            the moduleDetailId to set
	 */
	public void setModuleDetailId(Integer moduleDetailId) {
		this.moduleDetailId = moduleDetailId;
	}

	/**
	 * @return the moduleId
	 */
	public Integer getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId
	 *            the moduleId to set
	 */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
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
	 * @return the personCount
	 */
	public Integer getPersonCount() {
		return personCount;
	}

	/**
	 * @param personCount
	 *            the personCount to set
	 */
	public void setPersonCount(Integer personCount) {
		this.personCount = personCount;
	}

	/**
	 * @return the personCountLower
	 */
	public Integer getPersonCountLower() {
		return personCountLower;
	}

	/**
	 * @param personCountLower
	 *            the personCountLower to set
	 */
	public void setPersonCountLower(Integer personCountLower) {
		this.personCountLower = personCountLower;
	}

	/**
	 * @return the personCountUpper
	 */
	public Integer getPersonCountUpper() {
		return personCountUpper;
	}

	/**
	 * @param personCountUpper
	 *            the personCountUpper to set
	 */
	public void setPersonCountUpper(Integer personCountUpper) {
		this.personCountUpper = personCountUpper;
	}

	/**
	 * @return the prizePoint
	 */
	public BigDecimal getPrizePoint() {
		return prizePoint;
	}

	/**
	 * @param prizePoint
	 *            the prizePoint to set
	 */
	public void setPrizePoint(BigDecimal prizePoint) {
		this.prizePoint = prizePoint;
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
