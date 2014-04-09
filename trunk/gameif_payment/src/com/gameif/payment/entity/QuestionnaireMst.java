package com.gameif.payment.entity;

import com.gameif.common.entity.BaseEntity;

public class QuestionnaireMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5635384338939509327L;
	
	private Integer questionNo;
	private String questionName;
	private String htmlContents;
	/**
	 * @return the questionNo
	 */
	public Integer getQuestionNo() {
		return questionNo;
	}
	/**
	 * @param questionNo the questionNo to set
	 */
	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
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
	 * @return the htmlContents
	 */
	public String getHtmlContents() {
		return htmlContents;
	}
	/**
	 * @param htmlContents the htmlContents to set
	 */
	public void setHtmlContents(String htmlContents) {
		this.htmlContents = htmlContents;
	}

}
