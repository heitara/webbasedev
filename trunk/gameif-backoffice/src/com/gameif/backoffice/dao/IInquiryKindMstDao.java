package com.gameif.backoffice.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.backoffice.entity.InquiryKindMst;

public interface IInquiryKindMstDao  extends IBaseDao<InquiryKindMst, InquiryKindMst> {

	public String selectNameByCode(Integer inquiryKindCode);
}
