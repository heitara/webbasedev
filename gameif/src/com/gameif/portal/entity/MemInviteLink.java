package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemInviteLink extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2478619036096688971L;

	private Long memNum;
	private String linkKey;
	private Date createdDate;

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
	 * @return the linkKey
	 */
	public String getLinkKey() {
		return linkKey;
	}

	/**
	 * @param linkKey
	 *            the linkKey to set
	 */
	public void setLinkKey(String linkKey) {
		this.linkKey = linkKey;
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

}
