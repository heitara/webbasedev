package com.gameif.backoffice.action.inquiryMailTemplate;

import com.gameif.backoffice.businesslogic.IInquiryMailTemplateBusinessLogic;

public class InquiryBindMailTemplateAction {
	private Integer inquirySendmailId;
	private String inquirySendmailContents;
	private IInquiryMailTemplateBusinessLogic inquiryMailTemplateBusinessLogic;

	/**
	 * 問合せ返信テンプレートIDにより、返信内容を取得する
	 * @return
	 */
	public String importMailContents() {
		inquirySendmailContents = inquiryMailTemplateBusinessLogic.getContentsByTemplateId(inquirySendmailId);
		return "success";
	}

	/**
	 * @return the inquirySendmailId
	 */
	public Integer getInquirySendmailId() {
		return inquirySendmailId;
	}

	/**
	 * @param inquirySendmailId the inquirySendmailId to set
	 */
	public void setInquirySendmailId(Integer inquirySendmailId) {
		this.inquirySendmailId = inquirySendmailId;
	}

	/**
	 * @return the inquirySendmailContents
	 */
	public String getInquirySendmailContents() {
		return inquirySendmailContents;
	}

	/**
	 * @param inquirySendmailContents the inquirySendmailContents to set
	 */
	public void setInquirySendmailContents(String inquirySendmailContents) {
		this.inquirySendmailContents = inquirySendmailContents;
	}

	/**
	 * @param inquiryMailTemplateBusinessLogic the inquiryMailTemplateBusinessLogic to set
	 */
	public void setInquiryMailTemplateBusinessLogic(
			IInquiryMailTemplateBusinessLogic inquiryMailTemplateBusinessLogic) {
		this.inquiryMailTemplateBusinessLogic = inquiryMailTemplateBusinessLogic;
	}

}
