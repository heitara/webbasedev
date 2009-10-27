package com.gameif.portal.entity;

import com.gameif.common.entity.BaseEntity;

public class CbtTester extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8809337873397482379L;

	private Long memNum;
	private Integer titleId;

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

}
