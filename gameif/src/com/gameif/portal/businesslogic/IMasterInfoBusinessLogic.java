package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.portal.entity.DivisionMst;
import com.gameif.portal.entity.InquiryKindMst;
import com.gameif.portal.entity.InviteTemplateMst;
import com.gameif.portal.entity.OccupationMst;
import com.gameif.portal.entity.QuestionMst;
import com.gameif.portal.entity.TitleMst;

public interface IMasterInfoBusinessLogic {

	public List<DivisionMst> getAllDivisionList();
	public List<OccupationMst> getAllOccupationList();
	public List<QuestionMst> getAllQuestionList();
	public List<TitleMst> getValidTitleList();
	public List<InquiryKindMst> getAllInquiryKindList();
	public List<InviteTemplateMst> getInviteTemplateByTitleId(Integer titleId);

}
