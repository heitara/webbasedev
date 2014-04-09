package com.gameif.payment.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class InviteLink extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4102792352529292400L;

	private Long memNum;
	private String linkKey;
	private Date createdDate;
	private String cookie;

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

	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * @param cookie
	 *            the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

}
