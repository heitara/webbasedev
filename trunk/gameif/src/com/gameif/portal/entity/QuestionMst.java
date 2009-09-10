package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class QuestionMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1814650150059027907L;

	private Integer questionCode;
	private String questionName;
	private Date createdDate;
	private String createdUser;
	private Date lastModifiedDate;
	private String lastUpdateUser;
	/**
	 * @return the questionCode
	 */
	public Integer getQuestionCode() {
		return questionCode;
	}
	/**
	 * @param questionCode the questionCode to set
	 */
	public void setQuestionCode(Integer questionCode) {
		this.questionCode = questionCode;
	}
	/**
	 * @return the questionName
	 */
	public String getQuestionName() {
		return questionName;
	}
	/**
	 * @param questionName the questionName to set
	 */
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
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
	 * @param createdUser the createdUser to set
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/**
	 * @return the lastUpdateUser
	 */
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	/**
	 * @param lastUpdateUser the lastUpdateUser to set
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

}
