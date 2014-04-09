package com.gameif.payment.entity;

import com.gameif.common.entity.BaseEntity;

public class PlayGuaranty extends BaseEntity {

	private static final long serialVersionUID = 5967536948072328483L;

	private Long memNum;
	private Integer titleId;
	private Integer serverId;
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
	public String getPlayIp() {
		return playIp;
	}
	public void setPlayIp(String playIp) {
		this.playIp = playIp;
	}
	
}
