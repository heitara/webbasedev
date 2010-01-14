package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class FunctionControlInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1476197840216571806L;

	private String functionCode;
	private String serviceStatus;
	private Date serviceStartDate;
	private Date serviceEndDate;

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
	 * @return the serviceStatus
	 */
	public String getServiceStatus() {
		return serviceStatus;
	}

	/**
	 * @param serviceStatus
	 *            the serviceStatus to set
	 */
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	/**
	 * @return the serviceStartDate
	 */
	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	/**
	 * @param serviceStartDate
	 *            the serviceStartDate to set
	 */
	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	/**
	 * @return the serviceEndDate
	 */
	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	/**
	 * @param serviceEndDate
	 *            the serviceEndDate to set
	 */
	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

}
