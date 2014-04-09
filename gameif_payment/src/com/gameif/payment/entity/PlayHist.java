package com.gameif.payment.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class PlayHist extends BaseEntity {

	private static final long serialVersionUID = 3218206708130197209L;

	private Long memNum;
	private Integer titleId;
	private Integer serverId;
	private Date playDate;
	private String playIp;

	public Long getMemNum() {
		return memNum;
	}

	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public Date getPlayDate() {
		return playDate;
	}

	public void setPlayDate(Date startDate) {
		this.playDate = startDate;
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
