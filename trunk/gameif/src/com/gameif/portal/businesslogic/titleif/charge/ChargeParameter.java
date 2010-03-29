package com.gameif.portal.businesslogic.titleif.charge;

import java.util.Date;

public class ChargeParameter {

	private Long memNum;
	private String memId;
	private Long orderNo;
	private Integer titleId;
	private Integer serverId;
	private Integer chargePoint;
	private Date chargeDate;
	private String chargeUrl;
	private String chargeFullUrl;
	private String spType;
	
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
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
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
	public Integer getChargePoint() {
		return chargePoint;
	}
	public void setChargePoint(Integer chargePoint) {
		this.chargePoint = chargePoint;
	}
	public Date getChargeDate() {
		return chargeDate;
	}
	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}
	public String getChargeUrl() {
		return chargeUrl;
	}
	public void setChargeUrl(String chargeUrl) {
		this.chargeUrl = chargeUrl;
	}
	public String getChargeFullUrl() {
		return chargeFullUrl;
	}
	public void setChargeFullUrl(String chargeFullUrl) {
		this.chargeFullUrl = chargeFullUrl;
	}
	public String getSpType() {
		return spType;
	}
	public void setSpType(String spType) {
		this.spType = spType;
	}
}
