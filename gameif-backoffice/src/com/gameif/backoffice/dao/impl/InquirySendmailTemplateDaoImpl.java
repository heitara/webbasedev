package com.gameif.backoffice.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.gameif.backoffice.dao.IInquirySendmailTemplateDao;
import com.gameif.backoffice.entity.InquirySendmailTemplate;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class InquirySendmailTemplateDaoImpl extends AbstractBaseDao<InquirySendmailTemplate, InquirySendmailTemplate> implements IInquirySendmailTemplateDao {

	/**
	 * 検索条件によって、問合せ返信テンプレートを取得する
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<InquirySendmailTemplate> selectInquiryTemplateList(
			InquirySendmailTemplate inquirySendmailTemplate) {
		return (List<InquirySendmailTemplate>)this.getSqlMapClientTemplate().queryForList(namespace + ".selectInquiryTemplateList", inquirySendmailTemplate);
	}

	/**
	 * 問合せ返信テンプレートを削除する
	 */
	@Override
	public Integer deleteInquiryTemplateList(List<Integer> selectedTemplateList) {
		return getSqlMapClientTemplate().delete(namespace + ".deleteInquiryTemplateList", selectedTemplateList);
	}

	@Override
	public InquirySendmailTemplate selectForUpdate(InquirySendmailTemplate inquirySendmailTemplate) {
		// TODO Auto-generated method stub
		return (InquirySendmailTemplate)this.getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", inquirySendmailTemplate);
	}

	@Override
	public Integer selectCountByName(String mailTemplateName) {
		// TODO Auto-generated method stub
		return (Integer)(getSqlMapClientTemplate().queryForObject(namespace + ".selectCountByName", mailTemplateName));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer selectCountByNameWithId(String mailTemplateName, Integer mailTemplateId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", mailTemplateName);
		params.put("titleId", mailTemplateId);
		
		return (Integer)(getSqlMapClientTemplate().queryForObject(namespace + ".selectCountByNameWithId", params));
	}

	@Override
	public String selectContentsByTemplateId(Integer templateId) {
		// TODO Auto-generated method stub
		return (String)this.getSqlMapClientTemplate().queryForObject(namespace + ".selectContentsByTemplateId", templateId);
	}

}
