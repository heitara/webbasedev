package com.gameif.portal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MySPGiveHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8802209390896483864L;

	private Long memNum;
	private Integer servicePointTypeCd;
	private Integer titleId;
	private String titleName;
	private Date giveDate;
	private Date pointEndDate;
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

}
