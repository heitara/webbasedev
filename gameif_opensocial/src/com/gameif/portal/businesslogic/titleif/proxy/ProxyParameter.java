package com.gameif.portal.businesslogic.titleif.proxy;

import java.util.Date;

public class ProxyParameter {
	
	private Long memNum;
	private Integer titleId;
	private Integer serverId;
	private Date accessDate;
	
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
	public Date getAccessDate() {
		return accessDate;
	}
	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}
}
