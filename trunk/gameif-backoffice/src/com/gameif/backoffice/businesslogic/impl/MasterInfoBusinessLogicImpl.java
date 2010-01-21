package com.gameif.backoffice.businesslogic.impl;

import java.util.List;

import com.gameif.backoffice.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.backoffice.dao.IFunctionMstDao;
import com.gameif.backoffice.dao.IInquiryKindMstDao;
import com.gameif.backoffice.dao.IInquirySendmailTemplateDao;
import com.gameif.backoffice.dao.ITitleMstDao;
import com.gameif.backoffice.entity.FunctionMst;
import com.gameif.backoffice.entity.InquiryKindMst;
import com.gameif.backoffice.entity.InquirySendmailTemplate;
import com.gameif.backoffice.entity.TitleMst;
import com.gameif.common.businesslogic.BaseBusinessLogic;

public class MasterInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IMasterInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3389126393403993641L;

	private IFunctionMstDao functionMstDao;
	private IInquiryKindMstDao inquiryKindMstDao;
	private IInquirySendmailTemplateDao inquirySendmailTemplateDao;
	private ITitleMstDao titleMstDao;

	@Override
	public List<FunctionMst> getAllFunctionList() {
		return functionMstDao.selectAll(null);
	}

	/**
	 * 問合せ種類を取得する
	 */
	@Override
	public List<InquiryKindMst> getAllInquiryKindList() {
		return inquiryKindMstDao.selectAll(null);
	}
	
	/**
	 * 問合せ返信テンプレートを取得する
	 * @return
	 */
	@Override
	public List<InquirySendmailTemplate> getAllInquirySendmailTemplate() {
		return inquirySendmailTemplateDao.selectAll(null);
	}

	/**
	 * 現時点で有効なタイトルを取得する
	 */
	@Override
	public List<TitleMst> getValidTitleList() {
		return titleMstDao.selectValidTitleList();
	}


	/**
	 * すべてタイトル情報を取得する
	 */
	@Override
	public List<TitleMst> getAllTitleList() {
		return titleMstDao.selectAll(null);
	}

	/**
	 * @return the functionMstDao
	 */
	public IFunctionMstDao getFunctionMstDao() {
		return functionMstDao;
	}

	/**
	 * @param functionMstDao
	 *            the functionMstDao to set
	 */
	public void setFunctionMstDao(IFunctionMstDao functionMstDao) {
		this.functionMstDao = functionMstDao;
	}

	/**
	 * @return the inquiryKindMstDao
	 */
	public IInquiryKindMstDao getInquiryKindMstDao() {
		return inquiryKindMstDao;
	}

	/**
	 * @param inquiryKindMstDao
	 *            the inquiryKindMstDao to set
	 */
	public void setInquiryKindMstDao(IInquiryKindMstDao inquiryKindMstDao) {
		this.inquiryKindMstDao = inquiryKindMstDao;
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

	/**
	 * @param titleMstDao the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

}
