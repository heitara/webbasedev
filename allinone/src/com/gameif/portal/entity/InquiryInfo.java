package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class InquiryInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6447552112880293012L;

	private Long inquiryNum;
	private Date inquiryDate;
	private Long memNum;
	private String companyName;
	private String companyMediaName;
	private String companyUserName;
	private String userName;
	private String userMailadd;
	private String telNum;
	private Integer titleId;
	private Integer inquiryType;
	private String inquiryIp;
	private Integer inquiryKindCode;
	private String inquiryObject;
	private String inquiryContents;
	private Date responseDate;
	private String responseSubject;
	private String responseContents;
	private String fromSubject;
	private String fromMailadd;
	private String replyTo;
	private Integer correspondStatus;
	private String correspondUserId;
	private String correspondUserName;
	private Date createdDate;
	private String createdUser;
	private Date lastUpdateDate;
	private String lastUpdateUser;

	/**
	 * @return the inquiryNum
	 */
	public Long getInquiryNum() {
		return inquiryNum;
	}

	/**
	 * @param inquiryNum
	 *            the inquiryNum to set
	 */
	public void setInquiryNum(Long inquiryNum) {
		this.inquiryNum = inquiryNum;
	}

	/**
	 * @return the memNum
	 */
	public Long getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum the memNum to set
	 */
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyMediaName
	 */
	public String getCompanyMediaName() {
		return companyMediaName;
	}

	/**
	 * @param companyMediaName
	 *            the companyMediaName to set
	 */
	public void setCompanyMediaName(String companyMediaName) {
		this.companyMediaName = companyMediaName;
	}

	/**
	 * @return the companyUserName
	 */
	public String getCompanyUserName() {
		return companyUserName;
	}

	/**
	 * @param companyUserName
	 *            the companyUserName to set
	 */
	public void setCompanyUserName(String companyUserName) {
		this.companyUserName = companyUserName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userMailadd
	 */
	public String getUserMailadd() {
		return userMailadd;
	}

	/**
	 * @param userMailadd
	 *            the userMailadd to set
	 */
	public void setUserMailadd(String userMailadd) {
		this.userMailadd = userMailadd;
	}

	/**
	 * @return the telNum
	 */
	public String getTelNum() {
		return telNum;
	}

	/**
	 * @param telNum
	 *            the telNum to set
	 */
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	/**
	 * @return the titleId
	 */
	public Integer getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId
	 *            the titleId to set
	 */
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the inquiryIp
	 */
	public String getInquiryIp() {
		return inquiryIp;
	}

	/**
	 * @param inquiryIp the inquiryIp to set
	 */
	public void setInquiryIp(String inquiryIp) {
		this.inquiryIp = inquiryIp;
	}

	/**
	 * @return the inquiryType
	 */
	public Integer getInquiryType() {
		return inquiryType;
	}

	/**
	 * @param inquiryType
	 *            the inquiryType to set
	 */
	public void setInquiryType(Integer inquiryType) {
		this.inquiryType = inquiryType;
	}

	/**
	 * @return the inquiryKindCode
	 */
	public Integer getInquiryKindCode() {
		return inquiryKindCode;
	}

	/**
	 * @param inquiryKindCode
	 *            the inquiryKindCode to set
	 */
	public void setInquiryKindCode(Integer inquiryKindCode) {
		this.inquiryKindCode = inquiryKindCode;
	}

	/**
	 * @return the inquiryObject
	 */
	public String getInquiryObject() {
		return inquiryObject;
	}

	/**
	 * @param inquiryObject
	 *            the inquiryObject to set
	 */
	public void setInquiryObject(String inquiryObject) {
		this.inquiryObject = inquiryObject;
	}

	/**
	 * @return the inquiryContents
	 */
	public String getInquiryContents() {
		return inquiryContents;
	}

	/**
	 * @param inquiryContents
	 *            the inquiryContents to set
	 */
	public void setInquiryContents(String inquiryContents) {
		this.inquiryContents = inquiryContents;
	}

	/**
	 * @return the inquiryDate
	 */
	public Date getInquiryDate() {
		return inquiryDate;
	}

	/**
	 * @param inquiryDate
	 *            the inquiryDate to set
	 */
	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	/**
	 * @return the responseDate
	 */
	public Date getResponseDate() {
		return responseDate;
	}

	/**
	 * @param responseDate
	 *            the responseDate to set
	 */
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	/**
	 * @return the responseSubject
	 */
	public String getResponseSubject() {
		return responseSubject;
	}

	/**
	 * @param responseSubject
	 *            the responseSubject to set
	 */
	public void setResponseSubject(String responseSubject) {
		this.responseSubject = responseSubject;
	}

	/**
	 * @return the responseContents
	 */
	public String getResponseContents() {
		return responseContents;
	}

	/**
	 * @param responseContents
	 *            the responseContents to set
	 */
	public void setResponseContents(String responseContents) {
		this.responseContents = responseContents;
	}

	/**
	 * @return the fromSubject
	 */
	public String getFromSubject() {
		return fromSubject;
	}

	/**
	 * @param fromSubject
	 *            the fromSubject to set
	 */
	public void setFromSubject(String fromSubject) {
		this.fromSubject = fromSubject;
	}

	/**
	 * @return the fromMailadd
	 */
	public String getFromMailadd() {
		return fromMailadd;
	}

	/**
	 * @param fromMailadd
	 *            the fromMailadd to set
	 */
	public void setFromMailadd(String fromMailadd) {
		this.fromMailadd = fromMailadd;
	}

	/**
	 * @return the replyTo
	 */
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * @param replyTo
	 *            the replyTo to set
	 */
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	/**
	 * @return the correspondStatus
	 */
	public Integer getCorrespondStatus() {
		return correspondStatus;
	}

	/**
	 * @param correspondStatus
	 *            the correspondStatus to set
	 */
	public void setCorrespondStatus(Integer correspondStatus) {
		this.correspondStatus = correspondStatus;
	}

	/**
	 * @return the correspondUserId
	 */
	public String getCorrespondUserId() {
		return correspondUserId;
	}

	/**
	 * @param correspondUserId
	 *            the correspondUserId to set
	 */
	public void setCorrespondUserId(String correspondUserId) {
		this.correspondUserId = correspondUserId;
	}

	/**
	 * @return the correspondUserName
	 */
	public String getCorrespondUserName() {
		return correspondUserName;
	}

	/**
	 * @param correspondUserName
	 *            the correspondUserName to set
	 */
	public void setCorrespondUserName(String correspondUserName) {
		this.correspondUserName = correspondUserName;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdUser
	 */
	public String getCreatedUser() {
		return createdUser;
	}

	/**
	 * @param createdUser
	 *            the createdUser to set
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate
	 *            the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the lastUpdateUser
	 */
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	/**
	 * @param lastUpdateUser
	 *            the lastUpdateUser to set
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

}
