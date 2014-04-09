package com.gameif.payment.businesslogic.titleif.entry;

import java.util.Date;

public class EntryParameter {
	
	private Long memNum;
	private String memId;
	private Integer titleId;
	private Integer serverId;
	private Date playDate;
	private String from;
	private Long parentMemNum;
	
	public Long getMemNum() {
		return memNum;
	}
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
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
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the parentMemNum
	 */
	public Long getParentMemNum() {
		return parentMemNum;
	}
	/**
	 * @param parentMemNum the parentMemNum to set
	 */
	public void setParentMemNum(Long parentMemNum) {
		this.parentMemNum = parentMemNum;
	}
}
