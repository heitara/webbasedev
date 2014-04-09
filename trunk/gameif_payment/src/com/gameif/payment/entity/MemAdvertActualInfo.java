package com.gameif.payment.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemAdvertActualInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8878532092797273166L;

	private Long memNum;
	private Integer advertNum;
	private Date memLoginDate;
	private String memLoginIp;

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
	 * @return the advertNum
	 */
	public Integer getAdvertNum() {
		return advertNum;
	}

	/**
	 * @param advertNum
	 *            the advertNum to set
	 */
	public void setAdvertNum(Integer advertNum) {
		this.advertNum = advertNum;
	}

	/**
	 * @return the memLoginDate
	 */
	public Date getMemLoginDate() {
		return memLoginDate;
	}

	/**
	 * @param memLoginDate
	 *            the memLoginDate to set
	 */
	public void setMemLoginDate(Date memLoginDate) {
		this.memLoginDate = memLoginDate;
	}

	/**
	 * @return the memLoginIp
	 */
	public String getMemLoginIp() {
		return memLoginIp;
	}

	/**
	 * @param memLoginIp
	 *            the memLoginIp to set
	 */
	public void setMemLoginIp(String memLoginIp) {
		this.memLoginIp = memLoginIp;
	}

}
