package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class GameLoginCount extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6528400296113669760L;

	private Long memNum;
	private Integer titleId;
	private Integer gameLoginCount;
	private Date lastLoginYmd;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

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
	 * @return the gameLoginCount
	 */
	public Integer getGameLoginCount() {
		return gameLoginCount;
	}

	/**
	 * @param gameLoginCount
	 *            the gameLoginCount to set
	 */
	public void setGameLoginCount(Integer gameLoginCount) {
		this.gameLoginCount = gameLoginCount;
	}

	/**
	 * @return the lastLoginYmd
	 */
	public Date getLastLoginYmd() {
		return lastLoginYmd;
	}

	/**
	 * @param lastLoginYmd
	 *            the lastLoginYmd to set
	 */
	public void setLastLoginYmd(Date lastLoginYmd) {
		this.lastLoginYmd = lastLoginYmd;
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
