package com.gameif.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class ServicePointGiveHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2721743081474781512L;

	private Long servicePointGiveNo;
	private Long memNum;
	private Integer servicePointTypeId;
	private Integer servicePointTypeCd;
	private Integer titleId;
	private Date giveDate;
	private Date pointEndDate;
	private BigDecimal pointAmount;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the servicePointGiveNo
	 */
	public Long getServicePointGiveNo() {
		return servicePointGiveNo;
	}

	/**
	 * @param servicePointGiveNo
	 *            the servicePointGiveNo to set
	 */
	public void setServicePointGiveNo(Long servicePointGiveNo) {
		this.servicePointGiveNo = servicePointGiveNo;
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
	 * @return the servicePointTypeCd
	 */
	public Integer getServicePointTypeCd() {
		return servicePointTypeCd;
	}

	/**
	 * @param servicePointTypeCd
	 *            the servicePointTypeCd to set
	 */
	public void setServicePointTypeCd(Integer servicePointTypeCd) {
		this.servicePointTypeCd = servicePointTypeCd;
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
