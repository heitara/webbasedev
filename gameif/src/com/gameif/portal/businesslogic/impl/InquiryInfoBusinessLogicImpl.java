package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.portal.dao.IInquiryInfoDao;
import com.gameif.portal.entity.InquiryInfo;

public class InquiryInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IInquiryInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1651956051303763371L;


	private IInquiryInfoDao inquiryInfoDao;

	/**
	 * @param inquiryInfoDao
	 *            the inquiryInfoDao to set
	 */
	public void setInquiryInfoDao(IInquiryInfoDao inquiryInfoDao) {
		this.inquiryInfoDao = inquiryInfoDao;
	}

	/**
	 *  @param inquiryInfo
	 */
	public void saveInquiryInfo(InquiryInfo inquiryInfo) {
		inquiryInfoDao.save(inquiryInfo);
	}
}
