package com.gameif.payment.entity;

import com.gameif.common.entity.BaseEntity;

public class MaintenanceInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 360588991685719247L;

	private String functionCode;
	private String maintenStatus;

	/**
	 * @return the functionCode
	 */
	public String getFunctionCode() {
		return functionCode;
	}

	/**
	 * @param functionCode
	 *            the functionCode to set
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	/**
	 * @return the maintenStatus
	 */
	public String getMaintenStatus() {
		return maintenStatus;
	}

	/**
	 * @param maintenStatus
	 *            the maintenStatus to set
	 */
	public void setMaintenStatus(String maintenStatus) {
		this.maintenStatus = maintenStatus;
	}

}
