package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.portal.entity.DivisionMst;
import com.gameif.portal.entity.InquiryKindMst;
import com.gameif.portal.entity.InviteTemplateMst;
import com.gameif.portal.entity.OccupationMst;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.QuestionMst;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.entity.SettlementMst;
import com.gameif.portal.entity.TitleMst;

public interface IMasterInfoBusinessLogic {

	public List<DivisionMst> getAllDivisionList();
	public List<OccupationMst> getAllOccupationList();
	public List<QuestionMst> getAllQuestionList();
	public List<TitleMst> getValidTitleList();
	public TitleMst getValidTitle(Integer titleId);
	public List<InquiryKindMst> getAllInquiryKindList();
	public List<InviteTemplateMst> getInviteTemplateByTitleId(Integer titleId);
	public List<InviteTemplateMst> getInviteTemplateList();
	public InviteTemplateMst getInviteTemplateByKey(Integer key);
	
	public ServerMst getServer(ServerMst serverMst);
	public ServerMst getServerByDomain(String domain);
	public List<ServerMst> getAllValidServerList();
	public List<ServerMst> getAllValidServerListByTitle(Integer titleId);
	
	public List<PointMst> getAllValidPointListByTitle(Integer titleId);
	public List<SettlementMst> getAllSettlementList();
	public List<SettlementMst> getValidSettlementList();
	public List<SettlementMst> getSettlementListForCharge();
	public PointMst getPointMstByKey(Integer pointId);
	
}
