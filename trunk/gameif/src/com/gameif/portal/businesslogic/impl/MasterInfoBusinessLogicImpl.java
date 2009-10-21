package com.gameif.portal.businesslogic.impl;

import java.util.List;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.dao.IDivisionMstDao;
import com.gameif.portal.dao.IInquiryKindMstDao;
import com.gameif.portal.dao.IInviteTemplateDao;
import com.gameif.portal.dao.IOccupationMstDao;
import com.gameif.portal.dao.IPointMstDao;
import com.gameif.portal.dao.IQuestionMstDao;
import com.gameif.portal.dao.IServerMstDao;
import com.gameif.portal.dao.ISettlementMstDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.DivisionMst;
import com.gameif.portal.entity.InquiryKindMst;
import com.gameif.portal.entity.InviteTemplateMst;
import com.gameif.portal.entity.OccupationMst;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.QuestionMst;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.entity.SettlementMst;
import com.gameif.portal.entity.TitleMst;

public class MasterInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IMasterInfoBusinessLogic {

	private static final long serialVersionUID = -105096134811999134L;

	private IDivisionMstDao divisionMstDao;
	private IOccupationMstDao occupationMstDao;
	private IQuestionMstDao questionMstDao;
	private ITitleMstDao titleMstDao;
	private IServerMstDao serverMstDao;
	private IInquiryKindMstDao inquiryKindMstDao;
	private IInviteTemplateDao inviteTemplateDao;
	private IPointMstDao pointMstDao;
	private ISettlementMstDao settlementMstDao;

	/**
	 * 都道府県を取得する
	 */
	@Override
	public List<DivisionMst>getAllDivisionList() {
		return divisionMstDao.selectAll(null);
	}

	/**
	 * 職業を取得する
	 */
	@Override
	public List<OccupationMst> getAllOccupationList() {
		return occupationMstDao.selectAll(null);
	}

	/**
	 * 秘密質問を取得する
	 */
	@Override
	public List<QuestionMst> getAllQuestionList() {
		return questionMstDao.selectAll(null);
	}

	/**
	 * 現時点で有効なタイトルを取得する
	 */
	@Override
	public List<TitleMst> getValidTitleList() {
		return titleMstDao.selectValidTitleList();
	}

	/**
	 * 問合せ種類を取得する
	 */
	@Override
	public List<InquiryKindMst> getAllInquiryKindList() {
		return inquiryKindMstDao.selectAll(null);
	}

	/**
	 * 紹介テンプレートを取得する
	 */
	@Override
	public List<InviteTemplateMst> getInviteTemplateByTitleId(Integer titleId) {
		return inviteTemplateDao.selectInviteTemplateByTitleId(titleId);
	}
	
	/**
	 * すべて紹介テンプレートを取得する
	 */
	@Override
	public List<InviteTemplateMst> getInviteTemplateList() {
		return inviteTemplateDao.selectAll(null);
	}
	
	/**
	 * サーバキーより、サーバ情報を取得する
	 */
	@Override
	public ServerMst getServer(ServerMst serverMst) {
		
		return serverMstDao.selectByKey(serverMst);
	}

	/**
	 * ドメインより、サーバ情報を取得する
	 */
	@Override
	public ServerMst getServerByDomain(String domain) {
		
		return serverMstDao.selectServerByDomain(domain);
	}

	/**
	 * 有効なサーバ情報を取得する
	 */
	@Override
	public List<ServerMst> getAllValidServerList() {
		
		return serverMstDao.selectValidServerList();
	}
	
	/**
	 * すべて紹介テンプレートを取得する
	 */
	@Override
	public List<ServerMst> getAllValidServerListByTitle(Integer titleId) {
		
		return serverMstDao.selectValidServerListByTitle(titleId);
	}
	
	/**
	 * キーより、紹介テンプレートを取得する
	 */
	@Override
	public InviteTemplateMst getInviteTemplateByKey(Integer key) {
		
		InviteTemplateMst mst = new InviteTemplateMst();
		mst.setInviteTemplateId(key);
		
		return inviteTemplateDao.selectByKey(mst);
	}
	
	/**
	 * サーバキーより、ポイント情報を取得する
	 */
	@Override
	public List<PointMst> getAllValidPointListByServer(Integer serverId) {
		return pointMstDao.selectValidPointListByServer(serverId);
	}
	
	/**
	 * すべて決済情報を取得する
	 */
	@Override
	public List<SettlementMst> getAllSettlementList() {
		return settlementMstDao.selectAll(null);
	}

	@Override
	public PointMst getPointMstByKey(Integer pointId) {
		PointMst pointMst = new PointMst();
		pointMst.setPointId(pointId);
		return pointMstDao.selectByKey(pointMst);
	}

	/**
	 * @param divisionMstDao
	 *            the divisionMstDao to set
	 */
	public void setDivisionMstDao(IDivisionMstDao divisionMstDao) {
		this.divisionMstDao = divisionMstDao;
	}

	/**
	 * @param occupationMstDao
	 *            the occupationMstDao to set
	 */
	public void setOccupationMstDao(IOccupationMstDao occupationMstDao) {
		this.occupationMstDao = occupationMstDao;
	}

	/**
	 * @param questionMstDao
	 *            the questionMstDao to set
	 */
	public void setQuestionMstDao(IQuestionMstDao questionMstDao) {
		this.questionMstDao = questionMstDao;
	}

	/**
	 * @param titleMstDao
	 *            the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

	public void setServerMstDao(IServerMstDao serverMstDao) {
		this.serverMstDao = serverMstDao;
	}

	/**
	 * @param inquiryKindMstDao the inquiryKindMstDao to set
	 */
	public void setInquiryKindMstDao(IInquiryKindMstDao inquiryKindMstDao) {
		this.inquiryKindMstDao = inquiryKindMstDao;
	}

	public void setInviteTemplateDao(IInviteTemplateDao inviteTemplateDao) {
		this.inviteTemplateDao = inviteTemplateDao;
	}

	/**
	 * @param pointMstDao the pointMstDao to set
	 */
	public void setPointMstDao(IPointMstDao pointMstDao) {
		this.pointMstDao = pointMstDao;
	}

	/**
	 * @param settlementMstDao the settlementMstDao to set
	 */
	public void setSettlementMstDao(ISettlementMstDao settlementMstDao) {
		this.settlementMstDao = settlementMstDao;
	}
	
}
