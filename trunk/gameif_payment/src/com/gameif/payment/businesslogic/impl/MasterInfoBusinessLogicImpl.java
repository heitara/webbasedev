package com.gameif.payment.businesslogic.impl;

import java.util.List;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.payment.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.payment.dao.IDivisionMstDao;
import com.gameif.payment.dao.IInquiryKindMstDao;
import com.gameif.payment.dao.IInviteTemplateDao;
import com.gameif.payment.dao.IOccupationMstDao;
import com.gameif.payment.dao.IPointMstDao;
import com.gameif.payment.dao.IProviderMstDao;
import com.gameif.payment.dao.IProviderTitleMstDao;
import com.gameif.payment.dao.IQuestionMstDao;
import com.gameif.payment.dao.IServerMstDao;
import com.gameif.payment.dao.ITitleMstDao;
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

public class MasterInfoBusinessLogicImpl extends BaseBusinessLogic implements IMasterInfoBusinessLogic {

	private static final long serialVersionUID = -105096134811999134L;

	private IDivisionMstDao divisionMstDao;
	private IOccupationMstDao occupationMstDao;
	private IQuestionMstDao questionMstDao;
	private ITitleMstDao titleMstDao;
	private IServerMstDao serverMstDao;
	private IInquiryKindMstDao inquiryKindMstDao;
	private IInviteTemplateDao inviteTemplateDao;
	private IPointMstDao pointMstDao;
	private IProviderMstDao providerMstDao;
	private IProviderTitleMstDao providerTitleMstDao;

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
	 * 現時点で有効なタイトルを取得する
	 */
	@Override
	public TitleMst getValidTitle(Integer titleId) {
		return titleMstDao.selectValidTitleByKey(titleId);
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
	 * 有効なサーバ情報を取得する
	 */
	@Override
	public List<ServerMst> getAllValidServerList() {
		
		return serverMstDao.selectValidServerList();
	}
	
	/**
	 * タイトルIDより、有効なサーバ情報を取得する
	 */
	@Override
	public List<ServerMst> getAllValidServerListByTitle(Integer titleId) {
		
		return serverMstDao.selectValidServerListByTitle(titleId);
	}
	
	/**
	 * タイトルIDより、有効なサーバ情報を取得する(For Mixi)
	 */
	@Override
	public List<ServerMst> getAllValidServerListTitleAndProvider(ServerMst serverMst) {
				
		return serverMstDao.selectServerListByTitleAndProvider(serverMst);
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
	public List<PointMst> getAllValidPointListByTitle(Integer titleId) {
		
		return pointMstDao.selectValidPointListByTitle(titleId);
	}

	@Override
	public PointMst getPointMstByKey(Integer pointId) {
		
		PointMst pointMst = new PointMst();
		pointMst.setPointId(pointId);
		
		return pointMstDao.selectByKey(pointMst);
	}

	@Override
	public ProviderMst getProviderMstByKey(String providerId) {
		
		ProviderMst providerMst = new ProviderMst();
		providerMst.setProviderId(providerId);
		
		return providerMstDao.selectByKey(providerMst);
	}

	@Override
	public ProviderTitleMst getProviderTitleMstByKey(ProviderTitleMst providerTitle) {
		
		
		return providerTitleMstDao.selectByKey(providerTitle);
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

	public void setProviderMstDao(IProviderMstDao providerMstDao) {
		this.providerMstDao = providerMstDao;
	}

	public void setProviderTitleMstDao(IProviderTitleMstDao providerTitleMstDao) {
		this.providerTitleMstDao = providerTitleMstDao;
	}
}
