package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class InquireKindMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3883627199763070005L;

	private Integer inquireKindCode;
	private String inquireKindName;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the inquireKindCode
	 */
	public Integer getInquireKindCode() {
		return inquireKindCode;
	}

	/**
	 * @param inquireKindCode
	 *            the inquireKindCode to set
	 */
	public void setInquireKindCode(Integer inquireKindCode) {
		this.inquireKindCode = inquireKindCode;
	}

	/**
	 * @return the inquireKindName
	 */
	public String getInquireKindName() {
		return inquireKindName;
	}

	/**
	 * @param inquireKindName
	 *            the inquireKindName to set
	 */
	public void setInquireKindName(String inquireKindName) {
		this.inquireKindName = inquireKindName;
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
