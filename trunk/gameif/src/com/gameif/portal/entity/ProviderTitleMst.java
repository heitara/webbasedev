package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class ProviderTitleMst extends BaseEntity {

	private static final long serialVersionUID = 3271453331772185180L;

	private String providerId;
	private Integer titleId;
	private String titleName;
	private String securityCode;
	private String agentLogin;
	private String siteUrl;
	private String selectServerUrl;
	private String maintenanceUrl;
	private String errorUrl;
	private String chargeSuccessUrl;
	private String chargeCancelUrl;
	private String chargeErrorUrl;
	private String chargeMaintenanceUrl;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;
	
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getAgentLogin() {
		return agentLogin;
	}
	public void setAgentLogin(String agentLogin) {
		this.agentLogin = agentLogin;
	}
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	public String getSelectServerUrl() {
		return selectServerUrl;
	}
	public void setSelectServerUrl(String selectServerUrl) {
		this.selectServerUrl = selectServerUrl;
	}
	public String getMaintenanceUrl() {
		return maintenanceUrl;
	}
	public void setMaintenanceUrl(String maintenanceUrl) {
		this.maintenanceUrl = maintenanceUrl;
	}
	public String getErrorUrl() {
		return errorUrl;
	}
	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}
	public String getChargeSuccessUrl() {
		return chargeSuccessUrl;
	}
	public void setChargeSuccessUrl(String chargeSuccessUrl) {
		this.chargeSuccessUrl = chargeSuccessUrl;
	}
	public String getChargeCancelUrl() {
		return chargeCancelUrl;
	}
	public void setChargeCancelUrl(String chargeCancelUrl) {
		this.chargeCancelUrl = chargeCancelUrl;
	}
	public String getChargeErrorUrl() {
		return chargeErrorUrl;
	}
	public void setChargeErrorUrl(String chargeErrorUrl) {
		this.chargeErrorUrl = chargeErrorUrl;
	}
	public String getChargeMaintenanceUrl() {
		return chargeMaintenanceUrl;
	}
	public void setChargeMaintenanceUrl(String chargeMaintenanceUrl) {
		this.chargeMaintenanceUrl = chargeMaintenanceUrl;
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