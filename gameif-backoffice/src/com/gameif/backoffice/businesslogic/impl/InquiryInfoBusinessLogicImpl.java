package com.gameif.backoffice.businesslogic.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.backoffice.bean.InquirySearchCondition;
import com.gameif.backoffice.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.backoffice.constants.BackofficeConstants;
import com.gameif.backoffice.dao.IInquiryInfoDao;
import com.gameif.backoffice.entity.InquiryInfo;
import com.gameif.backoffice.util.ContextUtil;

public class InquiryInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IInquiryInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1651956051303763371L;

	private IInquiryInfoDao inquiryInfoDao;
	private TemplateMailer templateMailer;

	/**
	 * 問合せ情報リストを取得する
	 * @param searchCondition 検索条件
	 */
	@Override
	public List<InquiryInfo> searchInquiryList(InquirySearchCondition searchCondition) {
		return inquiryInfoDao.selectInquiryList(searchCondition);
	}

	/**
	 * 問合せ情報を取得する
	 * @param inquiryInfo 問合せ情報（キーを含める）
	 */
	@Override
	public InquiryInfo getInquiryInfo(InquiryInfo inquiryInfo) {
		return inquiryInfoDao.selectByKey(inquiryInfo);
	}

	/**
	 * 問合せ情報を更新して、返信する。
	 * @param inquiryInfo 問合せ情報（変更した項目を含める）
	 */
	@Transactional
	@Override
	public void replyInquiryInfo(InquiryInfo inquiryInfo) throws LogicException {
		InquiryInfo newInquiryInfo = inquiryInfoDao.selectForUpdate(inquiryInfo.getInquiryNum());
		if (newInquiryInfo == null) {
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		Date now = new Date();
		// 回答日時
		newInquiryInfo.setResponseDate(now);
		// 回答件名
		newInquiryInfo.setResponseSubject(inquiryInfo.getResponseSubject());
		// 回答内容
		newInquiryInfo.setResponseContents(inquiryInfo.getResponseContents());
		// 対応状況：「対応済」
		newInquiryInfo.setCorrespondStatus(BackofficeConstants.CorrespondStatus.CORRESPONDED);
		newInquiryInfo.setCorrespondUserId(ContextUtil.getUserId());
		newInquiryInfo.setCorrespondUserName(ContextUtil.getNickName());
		newInquiryInfo.setLastUpdateDate(now);
		newInquiryInfo.setLastUpdateUser(ContextUtil.getUserId());
		
		inquiryInfoDao.update(newInquiryInfo);
		
		// 問合せを返信する。
		HashMap<String, String> props = new HashMap<String, String>();
		// 名前
		if (newInquiryInfo.getInquiryType().equals(BackofficeConstants.InquiryType.MEDIA)) {
			props.put("name", newInquiryInfo.getCompanyUserName());
		} else {
			props.put("name", newInquiryInfo.getUserName());
		}
		// 問合せ内容
		props.put("originalMsg", newInquiryInfo.getInquiryContents());
		// 回答内容
		props.put("responseMsg", newInquiryInfo.getResponseContents());
		// 送信
		templateMailer.sendAsyncMail(newInquiryInfo.getUserMailadd(), "replyInquiry", props);
	}

	/**
	 * 問合せ情報を削除する
	 */
	@Override
	public void deleteInquiryInfo(List<Long> inquiryList) {
		inquiryInfoDao.deleteInquiryList(inquiryList);
	}

	/**
	 * @param inquiryInfoDao
	 *            the inquiryInfoDao to set
	 */
	public void setInquiryInfoDao(IInquiryInfoDao inquiryInfoDao) {
		this.inquiryInfoDao = inquiryInfoDao;
	}

	/**
	 * @return the inquiryInfoDao
	 */
	public IInquiryInfoDao getInquiryInfoDao() {
		return inquiryInfoDao;
	}

	/**
	 * @return the templateMailer
	 */
	public TemplateMailer getTemplateMailer() {
		return templateMailer;
	}

	/**
	 * @param templateMailer the templateMailer to set
	 */
	public void setTemplateMailer(TemplateMailer templateMailer) {
		this.templateMailer = templateMailer;
	}
	
}
