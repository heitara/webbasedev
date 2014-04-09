package com.gameif.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MySPInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6397037864808835963L;

	private Integer titleId;
	private String titleName;
	private Date pointEndDate;
	private BigDecimal pointAmount;

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
