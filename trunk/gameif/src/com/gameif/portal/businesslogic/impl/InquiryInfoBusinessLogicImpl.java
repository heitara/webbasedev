package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IInquiryInfoDao;
import com.gameif.portal.entity.InquiryInfo;
import com.gameif.portal.util.ContextUtil;

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
	 * 問合せ情報を登録する
	 * 
	 * @param inquiryInfo
	 */
	@Transactional
	public void saveInquiryInfo(InquiryInfo inquiryInfo) {

		Date inquiryDate = new Date();

		// 会員の問合せの場合、会員情報を設定する
		if (inquiryInfo.getInquiryType().equals(PortalConstants.InquiryType.MEMBER)) {
			inquiryInfo.setMemNum(ContextUtil.getMemberNo());
			inquiryInfo.setCreatedUser(ContextUtil.getMemberNo().toString());
			inquiryInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		}
		// 登録IP
		inquiryInfo.setInquiryIp(ContextUtil.getClientIP());
		// 問合せ日時
		inquiryInfo.setInquiryDate(inquiryDate);
		// 対応状況
		inquiryInfo.setCorrespondStatus(PortalConstants.CorrespondStatus.NO_CORRESPOND);
		inquiryInfo.setCreatedDate(inquiryDate);
		inquiryInfo.setLastUpdateDate(inquiryDate);

		inquiryInfoDao.save(inquiryInfo);
	}
}
