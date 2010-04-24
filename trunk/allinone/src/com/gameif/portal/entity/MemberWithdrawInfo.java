package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemberWithdrawInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7777340785716330475L;

	private Long memNum;
	private Date withdrawDate;
	private Integer withdrawReasonDb;
	private Integer[] withdrawReason;
	private String remarks;

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
	 * @return the withdrawDate
	 */
	public Date getWithdrawDate() {
		return withdrawDate;
	}

	/**
	 * @param withdrawDate
	 *            the withdrawDate to set
	 */
	public void setWithdrawDate(Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

	/**
	 * @return the withdrawReasonDb
	 */
	public Integer getWithdrawReasonDb() {
		return withdrawReasonDb;
	}

	/**
	 * @param withdrawReasonDb
	 *            the withdrawReasonDb to set
	 */
	public void setWithdrawReasonDb(Integer withdrawReasonDb) {
		this.withdrawReasonDb = withdrawReasonDb;
	}

	/**
	 * @return the withdrawReason
	 */
	public Integer[] getWithdrawReason() {
		return withdrawReason;
	}

	/**
	 * @param withdrawReason
	 *            the withdrawReason to set
	 */
	public void setWithdrawReason(Integer[] withdrawReason) {
		this.withdrawReason = withdrawReason;
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

}
