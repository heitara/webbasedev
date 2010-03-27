package com.gameif.portal.entity;

public class OpensocialMember extends MemberInfo {

	private static final long serialVersionUID = -3014512636439941123L;
	
	private String providerId;
	private String address;
	
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
