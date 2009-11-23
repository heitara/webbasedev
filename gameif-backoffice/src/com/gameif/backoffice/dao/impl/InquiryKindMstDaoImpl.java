package com.gameif.backoffice.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.backoffice.dao.IInquiryKindMstDao;
import com.gameif.backoffice.entity.InquiryKindMst;

public class InquiryKindMstDaoImpl extends
		AbstractBaseDao<InquiryKindMst, InquiryKindMst> implements
		IInquiryKindMstDao {

	@Override
	public String selectNameByCode(Integer inquiryKindCode) {
		return (String)this.getSqlMapClientTemplate().queryForObject(namespace + ".selectNameByCode", inquiryKindCode);
	}

}
