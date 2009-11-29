package com.gameif.backoffice.businesslogic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.backoffice.businesslogic.IInquiryMailTemplateBusinessLogic;
import com.gameif.backoffice.dao.IInquirySendmailTemplateDao;
import com.gameif.backoffice.entity.InquirySendmailTemplate;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.businesslogic.BaseBusinessLogic;

public class InquiryMailTemplateBusinessLogicImpl extends BaseBusinessLogic implements
IInquiryMailTemplateBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4913409736944291744L;
	
	private IInquirySendmailTemplateDao inquirySendmailTemplateDao;

	/**
	 * 検索条件によって、問合せ返信テンプレートを取得する
	 */
	@Override
	public List<InquirySendmailTemplate> searchInquiryTemplateList(
			InquirySendmailTemplate inquirymailTemplate) {
		return inquirySendmailTemplateDao.selectInquiryTemplateList(inquirymailTemplate);
	}

	/**
	 * 問合せ返信テンプレートを削除する
	 */
	@Transactional
	@Override
	public void deleteInquiryTemplateList(List<Integer> selectedTemplateList) {
		inquirySendmailTemplateDao.deleteInquiryTemplateList(selectedTemplateList);
	}

	/**
	 * 問合せ返信テンプレートを保存する
	 */
	@Transactional
	@Override
	public void createInquiryMailTemplate(InquirySendmailTemplate inquirySendmailTemplate) {
		
		Date now = new Date();
		inquirySendmailTemplate.setCreatedDate(now);
		inquirySendmailTemplate.setCreatedUser(ContextUtil.getUserId());
		inquirySendmailTemplate.setLastUpdateDate(now);
		inquirySendmailTemplate.setLastUpdateUser(ContextUtil.getUserId());
		
		inquirySendmailTemplateDao.save(inquirySendmailTemplate);
		
	}

	/**
	 * 問合せ返信テンプレートを更新する
	 */
	@Transactional
	@Override
	public void updateInquiryMailTemplate(InquirySendmailTemplate inquirySendmailTemplate) {
		InquirySendmailTemplate oldMailTemplate = inquirySendmailTemplateDao.selectForUpdate(inquirySendmailTemplate);
	
		oldMailTemplate.setInquirySendmailName(inquirySendmailTemplate.getInquirySendmailName());
		oldMailTemplate.setInquirySendmailContents(inquirySendmailTemplate.getInquirySendmailContents());
		oldMailTemplate.setLastUpdateDate(new Date());
		oldMailTemplate.setLastUpdateUser(ContextUtil.getUserId());
		
		inquirySendmailTemplateDao.update(oldMailTemplate);
		
	}

	@Override
	public InquirySendmailTemplate getInquiryMailTemplate(InquirySendmailTemplate inquirySendmailTemplate) {
		return inquirySendmailTemplateDao.selectByKey(inquirySendmailTemplate);
	}

	@Override
	public Integer countInquiryMailTemplateByName(String mailTemplateName) {
		return inquirySendmailTemplateDao.selectCountByName(mailTemplateName);
	}

	@Override
	public Integer countInquiryMailTemplateByName(String mailTemplateName, Integer mailTemplateId) {
		return inquirySendmailTemplateDao.selectCountByNameWithId(mailTemplateName, mailTemplateId);
	}

	/**
	 * テンプレートIDより、返信内容を検索する
	 */
	@Override
	public String getContentsByTemplateId(Integer templateId) {
		return inquirySendmailTemplateDao.selectContentsByTemplateId(templateId);
	}

	/**
	 * @return the inquirySendmailTemplateDao
	 */
	public IInquirySendmailTemplateDao getInquirySendmailTemplateDao() {
		return inquirySendmailTemplateDao;
	}

	/**
	 * @param inquirySendmailTemplateDao the inquirySendmailTemplateDao to set
	 */
	public void setInquirySendmailTemplateDao(
			IInquirySendmailTemplateDao inquirySendmailTemplateDao) {
		this.inquirySendmailTemplateDao = inquirySendmailTemplateDao;
	}
}
