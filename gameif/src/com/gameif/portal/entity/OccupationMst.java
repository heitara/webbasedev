package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class OccupationMst extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5479175243162307761L;
	
	private Integer occupCode;
	private String occupName;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastuUpdateUser;
	/**
	 * @return the occupCode
	 */
	public Integer getOccupCode() {
		return occupCode;
	}
	/**
	 * @param occupCode the occupCode to set
	 */
	public void setOccupCode(Integer occupCode) {
		this.occupCode = occupCode;
	}
	/**
	 * @return the occupName
	 */
	public String getOccupName() {
		return occupName;
	}
	/**
	 * @param occupName the occupName to set
	 */
	public void setOccupName(String occupName) {
		this.occupName = occupName;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
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
	 * @param createdUser the createdUser to set
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
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	/**
	 * @return the lastuUpdateUser
	 */
	public String getLastuUpdateUser() {
		return lastuUpdateUser;
	}
	/**
	 * @param lastuUpdateUser the lastuUpdateUser to set
	 */
	public void setLastuUpdateUser(String lastuUpdateUser) {
		this.lastuUpdateUser = lastuUpdateUser;
	}

}
