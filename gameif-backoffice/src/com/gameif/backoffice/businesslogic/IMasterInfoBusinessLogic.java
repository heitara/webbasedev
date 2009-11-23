package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.entity.FunctionMst;
import com.gameif.backoffice.entity.InquiryKindMst;

public interface IMasterInfoBusinessLogic {

	public List<FunctionMst> getAllFunctionList();

	public List<InquiryKindMst> getAllInquiryKindList();

}
