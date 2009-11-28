package com.gameif.backoffice.bean;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class UserSearchCondition extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -929161335885542110L;

	private String userId;
	private String nickName;
	private String authorityCode;
	private String authorityName;
	private Date createFrom;
	private Date createTo;
	private String lastUpdateDate;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the authorityCode
	 */
	public String getAuthorityCode() {
		return authorityCode;
	}

	/**
	 * @param authorityCode
	 *            the authorityCode to set
	 */
	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}

	/**
	 * @return the authorityName
	 */
	public String getAuthorityName() {
		return authorityName;
	}

	/**
	 * @param authorityName
	 *            the authorityName to set
	 */
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	/**
	 * @return the createFrom
	 */
	public Date getCreateFrom() {
		return createFrom;
	}

	/**
	 * @param createFrom
	 *            the createFrom to set
	 */
	public void setCreateFrom(Date createFrom) {
		this.createFrom = createFrom;
	}

	/**
	 * @return the createTo
	 */
	public Date getCreateTo() {
		return createTo;
	}

	/**
	 * @param createTo
	 *            the createTo to set
	 */
	public void setCreateTo(Date createTo) {
		this.createTo = createTo;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate
	 *            the lastUpdateDate to set
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
