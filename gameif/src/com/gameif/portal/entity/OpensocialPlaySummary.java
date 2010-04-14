package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class OpensocialPlaySummary extends BaseEntity {

	private static final long serialVersionUID = 3218206708130197209L;
	
	private Long memNum;
	private Integer titleId;
	private Integer serverId;
	private Date firstPlayDate;
	private String firstPlayIp;
	private Date lastPlayDate;
	private String lastPlayIp;
	private Integer playCount;
	
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
	public Date getFirstPlayDate() {
		return firstPlayDate;
	}
	public void setFirstPlayDate(Date firstPlayDate) {
		this.firstPlayDate = firstPlayDate;
	}
	public String getFirstPlayIp() {
		return firstPlayIp;
	}
	public void setFirstPlayIp(String firstPlayIp) {
		this.firstPlayIp = firstPlayIp;
	}
	public Date getLastPlayDate() {
		return lastPlayDate;
	}
	public void setLastPlayDate(Date lastPlayDate) {
		this.lastPlayDate = lastPlayDate;
	}
	public String getLastPlayIp() {
		return lastPlayIp;
	}
	public void setLastPlayIp(String lastPlayIp) {
		this.lastPlayIp = lastPlayIp;
	}
	public Integer getPlayCount() {
		return playCount;
	}
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}
}