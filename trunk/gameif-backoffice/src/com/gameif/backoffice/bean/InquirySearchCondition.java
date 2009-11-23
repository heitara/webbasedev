package com.gameif.backoffice.bean;

import java.io.Serializable;
import java.util.Date;

public class InquirySearchCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1537202603578700247L;
	
	private Long inquiryNum;
	private Date inquiryStartDate;
	private Date inquiryEndDate;
	private Integer[] inquiryType;
	private Integer[] inquiryKindCode;
	private Integer correspondStatus;
	private String userMailadd;
	private String inquiryObject;
	
	/**
	 * @return the inquiryNum
	 */
	public Long getInquiryNum() {
		return inquiryNum;
	}
	/**
	 * @param inquiryNum the inquiryNum to set
	 */
	public void setInquiryNum(Long inquiryNum) {
		this.inquiryNum = inquiryNum;
	}
	/**
	 * @return the inquiryStartDate
	 */
	public Date getInquiryStartDate() {
		return inquiryStartDate;
	}
	/**
	 * @param inquiryStartDate the inquiryStartDate to set
	 */
	public void setInquiryStartDate(Date inquiryStartDate) {
		this.inquiryStartDate = inquiryStartDate;
	}
	/**
	 * @return the inquiryEndDate
	 */
	public Date getInquiryEndDate() {
		return inquiryEndDate;
	}
	/**
	 * @param inquiryEndDate the inquiryEndDate to set
	 */
	public void setInquiryEndDate(Date inquiryEndDate) {
		this.inquiryEndDate = inquiryEndDate;
	}
	/**
	 * @return the inquiryType
	 */
	public Integer[] getInquiryType() {
		return inquiryType;
	}
	/**
	 * @param inquiryType the inquiryType to set
	 */
	public void setInquiryType(Integer[] inquiryType) {
		this.inquiryType = inquiryType;
	}
	/**
	 * @return the inquiryKindCode
	 */
	public Integer[] getInquiryKindCode() {
		return inquiryKindCode;
	}
	/**
	 * @param inquiryKindCode the inquiryKindCode to set
	 */
	public void setInquiryKindCode(Integer[] inquiryKindCode) {
		this.inquiryKindCode = inquiryKindCode;
	}
	/**
	 * @return the correspondStatus
	 */
	public Integer getCorrespondStatus() {
		return correspondStatus;
	}
	/**
	 * @param correspondStatus the correspondStatus to set
	 */
	public void setCorrespondStatus(Integer correspondStatus) {
		this.correspondStatus = correspondStatus;
	}
	/**
	 * @return the userMailadd
	 */
	public String getUserMailadd() {
		return userMailadd;
	}
	/**
	 * @param userMailadd the userMailadd to set
	 */
	public void setUserMailadd(String userMailadd) {
		this.userMailadd = userMailadd;
	}
	/**
	 * @return the inquiryObject
	 */
	public String getInquiryObject() {
		return inquiryObject;
	}
	/**
	 * @param inquiryObject the inquiryObject to set
	 */
	public void setInquiryObject(String inquiryObject) {
		this.inquiryObject = inquiryObject;
	}

}
