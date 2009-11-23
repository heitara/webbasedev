package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.backoffice.bean.InquirySearchCondition;
import com.gameif.backoffice.dao.IInquiryInfoDao;
import com.gameif.backoffice.entity.InquiryInfo;

public class InquiryInfoDaoImpl extends
		AbstractBaseDao<InquiryInfo, InquiryInfo> implements IInquiryInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<InquiryInfo> selectInquiryList(InquirySearchCondition searchCondition) {

		return (List<InquiryInfo>) (getSqlMapClientTemplate().queryForList(namespace + ".selectInquiryList", searchCondition));
	}

	@Override
	public InquiryInfo selectForUpdate(Long inquiryNum) {

		return (InquiryInfo) (getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", inquiryNum));
	}

	@Override
	public void deleteInquiryList(List<Long> inquiryList) {

		getSqlMapClientTemplate().delete(namespace + ".deleteInquiryList", inquiryList);
		
	}

}
