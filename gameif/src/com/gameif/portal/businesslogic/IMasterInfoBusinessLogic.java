package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.portal.entity.DivisionMst;
import com.gameif.portal.entity.InquiryKindMst;
import com.gameif.portal.entity.OccupationMst;
import com.gameif.portal.entity.QuestionMst;
import com.gameif.portal.entity.TitleMst;

public interface IMasterInfoBusinessLogic {

	public List<DivisionMst> selectAllDivisionList();
	public List<OccupationMst> selectAllOccupationList();
	public List<QuestionMst> selectAllQuestionList();
	public List<TitleMst> selectValidTitleList();
	public List<InquiryKindMst> selectAllInquiryKindList();

}
