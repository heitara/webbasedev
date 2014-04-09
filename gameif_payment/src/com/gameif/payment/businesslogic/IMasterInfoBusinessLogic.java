package com.gameif.payment.businesslogic;

import java.util.List;

import com.gameif.payment.entity.DivisionMst;
import com.gameif.payment.entity.InquiryKindMst;
import com.gameif.payment.entity.InviteTemplateMst;
import com.gameif.payment.entity.OccupationMst;
import com.gameif.payment.entity.PointMst;
import com.gameif.payment.entity.ProviderMst;
import com.gameif.payment.entity.ProviderTitleMst;
import com.gameif.payment.entity.QuestionMst;
import com.gameif.payment.entity.ServerMst;
import com.gameif.payment.entity.TitleMst;

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
	public List<ServerMst> getAllValidServerList();
	public List<ServerMst> getAllValidServerListByTitle(Integer titleId);
	public List<ServerMst> getAllValidServerListTitleAndProvider(ServerMst serverMst);
	
	public List<PointMst> getAllValidPointListByTitle(Integer titleId);
	public PointMst getPointMstByKey(Integer pointId);
	public ProviderMst getProviderMstByKey(String providerId);
	public ProviderTitleMst getProviderTitleMstByKey(ProviderTitleMst providerTitle);
	
}
