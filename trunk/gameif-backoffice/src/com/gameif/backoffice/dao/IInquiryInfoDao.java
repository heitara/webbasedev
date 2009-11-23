package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.backoffice.bean.InquirySearchCondition;
import com.gameif.backoffice.entity.InquiryInfo;

public interface IInquiryInfoDao extends IBaseDao<InquiryInfo, InquiryInfo> {
	
	public List<InquiryInfo> selectInquiryList(InquirySearchCondition searchCondition);
	public InquiryInfo selectForUpdate(Long inquiryNum);
	public void deleteInquiryList(List<Long> inquiryList);

}
