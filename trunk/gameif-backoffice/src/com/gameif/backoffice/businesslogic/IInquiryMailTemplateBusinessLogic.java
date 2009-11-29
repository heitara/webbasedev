package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.entity.InquirySendmailTemplate;

public interface IInquiryMailTemplateBusinessLogic {
	
	public List<InquirySendmailTemplate> searchInquiryTemplateList(InquirySendmailTemplate inquirymailTemplate);
	public void deleteInquiryTemplateList(List<Integer> selectedTemplateList);
	public void createInquiryMailTemplate(InquirySendmailTemplate inquirySendmailTemplate);
	public void updateInquiryMailTemplate(InquirySendmailTemplate inquirySendmailTemplate);
	public InquirySendmailTemplate getInquiryMailTemplate(InquirySendmailTemplate inquirySendmailTemplate);
	public Integer countInquiryMailTemplateByName(String mailTemplateName);
	public Integer countInquiryMailTemplateByName(String mailTemplateName, Integer mailTemplateId);
	public String getContentsByTemplateId(Integer templateId);

}
