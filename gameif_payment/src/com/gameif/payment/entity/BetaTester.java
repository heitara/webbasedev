package com.gameif.payment.entity;

import com.gameif.common.entity.BaseEntity;

public class BetaTester extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8809337873397482379L;

	private Long memNum;
	private Integer titleId;
	private String electStatus;

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
	 * @return the electStatus
	 */
	public String getElectStatus() {
		return electStatus;
	}

	/**
	 * @param electStatus the electStatus to set
	 */
	public void setElectStatus(String electStatus) {
		this.electStatus = electStatus;
	}

}
