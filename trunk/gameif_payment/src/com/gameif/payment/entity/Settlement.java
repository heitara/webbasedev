package com.gameif.payment.entity;

import java.util.Date;

public class Settlement extends Order {

	private static final long serialVersionUID = 4187902858833042314L;

	private Date settlementDate;
	private String sbpsTrackingId;
	
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getSbpsTrackingId() {
		return sbpsTrackingId;
	}
	public void setSbpsTrackingId(String sbpsTrackingId) {
		this.sbpsTrackingId = sbpsTrackingId;
	}
}