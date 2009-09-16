package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class ServerMst extends BaseEntity {

	private static final long serialVersionUID = -9080119895764774848L;

	private Integer serverId;
	private Integer titleId;
	private String serverName;
	private Date ServiceStartDate;
	private Date ServiceEndDate;
	private String ServiceStatus;
	private String serverDomain;
	private String playUrl;
	private String chargeUrl;
	private Integer orderNum;
	private Integer playersNum;
	private String popularity;
	private String recommend;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;
	
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public Date getServiceStartDate() {
		return ServiceStartDate;
	}
	public void setServiceStartDate(Date serviceStartDate) {
		ServiceStartDate = serviceStartDate;
	}
	public Date getServiceEndDate() {
		return ServiceEndDate;
	}
	public void setServiceEndDate(Date serviceEndDate) {
		ServiceEndDate = serviceEndDate;
	}
	public String getServiceStatus() {
		return ServiceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		ServiceStatus = serviceStatus;
	}
	public String getServerDomain() {
		return serverDomain;
	}
	public void setServerDomain(String serverDomain) {
		this.serverDomain = serverDomain;
	}
	public String getPlayUrl() {
		return playUrl;
	}
	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}
	public String getChargeUrl() {
		return chargeUrl;
	}
	public void setChargeUrl(String chargeUrl) {
		this.chargeUrl = chargeUrl;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getPlayersNum() {
		return playersNum;
	}
	public void setPlayersNum(Integer playersNum) {
		this.playersNum = playersNum;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	
}
