package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.entity.InquirySendmailTemplate;
import com.gameif.common.dao.IBaseDao;

public interface IInquirySendmailTemplateDao extends IBaseDao<InquirySendmailTemplate, InquirySendmailTemplate> {
	
	public List<InquirySendmailTemplate> selectInquiryTemplateList(InquirySendmailTemplate inquirySendmailTemplate);
	public Integer deleteInquiryTemplateList(List<Integer> selectedTemplateList);
	public InquirySendmailTemplate selectForUpdate(InquirySendmailTemplate inquirySendmailTemplate);
	public Integer selectCountByName(String mailTemplateName);
	public Integer selectCountByNameWithId(String mailTemplateName, Integer mailTemplateId);
	public String selectContentsByTemplateId(Integer templateId);

}
