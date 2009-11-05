package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MediaKindMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -519266482764610431L;

	private Integer mediaKindNum;
	private String mediaKindName;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

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
	 * @return the mediaKindName
	 */
	public String getMediaKindName() {
		return mediaKindName;
	}

	/**
	 * @param mediaKindName
	 *            the mediaKindName to set
	 */
	public void setMediaKindName(String mediaKindName) {
		this.mediaKindName = mediaKindName;
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
