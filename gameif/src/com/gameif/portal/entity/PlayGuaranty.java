package com.gameif.portal.entity;

import com.gameif.common.entity.BaseEntity;

public class PlayGuaranty extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5967536948072328483L;

	private Long memNum;
	private String playIp;

	/**
	 * @return the memNum
	 */
	public Long getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum the memNum to set
	 */
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	/**
	 * @return the playIp
	 */
	public String getPlayIp() {
		return playIp;
	}

	/**
	 * @param playIp
	 *            the playIp to set
	 */
	public void setPlayIp(String playIp) {
		this.playIp = playIp;
	}

}
