package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.bean.InquirySearchCondition;
import com.gameif.backoffice.entity.InquiryInfo;
import com.gameif.common.exception.LogicException;

public interface IInquiryInfoBusinessLogic {
	
	public List<InquiryInfo> searchInquiryList(InquirySearchCondition searchCondition);
	public InquiryInfo getInquiryInfo(InquiryInfo inquiryInfo);
	public void replyInquiryInfo(InquiryInfo inquiryInfo, String nickName) throws LogicException ;
	public void deleteInquiryInfo(List<Long> inquiryList);
	public String getTitleNameById(Integer titleId);
	public String getInquiryKindNameByCd(Integer inquiryKindCd);

}
