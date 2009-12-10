package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.entity.FunctionMst;
import com.gameif.backoffice.entity.InquiryKindMst;
import com.gameif.backoffice.entity.InquirySendmailTemplate;
import com.gameif.backoffice.entity.TitleMst;

public interface IMasterInfoBusinessLogic {

	public List<FunctionMst> getAllFunctionList();
	public List<InquiryKindMst> getAllInquiryKindList();
	public List<InquirySendmailTemplate> getAllInquirySendmailTemplate();
	public List<TitleMst> getValidTitleList();

}
