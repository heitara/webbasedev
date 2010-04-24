package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class AdvertAgencyMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6617988048068933265L;

	private Integer advertAgencyNum;
	private String advertAgencyName;
	private String advertAgencyType;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the advertAgencyNum
	 */
	public Integer getAdvertAgencyNum() {
		return advertAgencyNum;
	}

	/**
	 * @param advertAgencyNum
	 *            the advertAgencyNum to set
	 */
	public void setAdvertAgencyNum(Integer advertAgencyNum) {
		this.advertAgencyNum = advertAgencyNum;
	}

	/**
	 * @return the advertAgencyName
	 */
	public String getAdvertAgencyName() {
		return advertAgencyName;
	}

	/**
	 * @param advertAgencyName
	 *            the advertAgencyName to set
	 */
	public void setAdvertAgencyName(String advertAgencyName) {
		this.advertAgencyName = advertAgencyName;
	}

	/**
	 * @return the advertAgencyType
	 */
	public String getAdvertAgencyType() {
		return advertAgencyType;
	}

	/**
	 * @param advertAgencyType
	 *            the advertAgencyType to set
	 */
	public void setAdvertAgencyType(String advertAgencyType) {
		this.advertAgencyType = advertAgencyType;
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
