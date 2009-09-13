package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.portal.dao.IInquiryInfoDao;
import com.gameif.portal.entity.InquiryInfo;
import com.opensymphony.xwork2.ActionContext;

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

		if (ActionContext.getContext().getSession().get("memId") == null
				|| ActionContext.getContext().getSession().get("memId")
						.toString().length() == 0) {
			inquiryInfo.setMemId(null);
			inquiryInfo.setCreatedUser(null);
			inquiryInfo.setCreatedDate(inquiryDate);
			inquiryInfo.setLastUpdateUser(null);
			inquiryInfo.setLastUpdateDate(inquiryDate);
		} else {
			String memId = ActionContext.getContext().getSession().get("memId")
					.toString().toString();
			inquiryInfo.setMemId(memId);
			inquiryInfo.setCreatedUser(memId);
			inquiryInfo.setCreatedDate(inquiryDate);
			inquiryInfo.setLastUpdateUser(memId);
			inquiryInfo.setLastUpdateDate(inquiryDate);
		}

		inquiryInfoDao.save(inquiryInfo);
	}
}
