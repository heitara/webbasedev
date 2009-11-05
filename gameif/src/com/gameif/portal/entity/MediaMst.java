package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MediaMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8049579810833589778L;

	private Integer mediaNum;
	private String mediaName;
	private Integer mediaKindNum;
	private String managerType;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the mediaNum
	 */
	public Integer getMediaNum() {
		return mediaNum;
	}

	/**
	 * @param mediaNum
	 *            the mediaNum to set
	 */
	public void setMediaNum(Integer mediaNum) {
		this.mediaNum = mediaNum;
	}

	/**
	 * @return the mediaName
	 */
	public String getMediaName() {
		return mediaName;
	}

	/**
	 * @param mediaName
	 *            the mediaName to set
	 */
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	/**
	 * @return the mediaKindNum
	 */
	public Integer getMediaKindNum() {
		return mediaKindNum;
	}

	/**
	 * @param mediaKindNum
	 *            the mediaKindNum to set
	 */
	public void setMediaKindNum(Integer mediaKindNum) {
		this.mediaKindNum = mediaKindNum;
	}

	/**
	 * @return the managerType
	 */
	public String getManagerType() {
		return managerType;
	}

	/**
	 * @param managerType
	 *            the managerType to set
	 */
	public void setManagerType(String managerType) {
		this.managerType = managerType;
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
