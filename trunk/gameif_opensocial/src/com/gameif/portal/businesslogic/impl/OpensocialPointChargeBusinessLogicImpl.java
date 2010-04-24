package com.gameif.portal.businesslogic.impl;

import java.math.BigDecimal;

import com.gameif.common.exception.SystemException;
import com.gameif.portal.businesslogic.IOpensocialPointChargeBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IOpensocialMemberDao;
import com.gameif.portal.dao.IOpensocialPlayHistDao;
import com.gameif.portal.dao.IOpensocialSettlementHistDao;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MemSettlementTrns;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.OpensocialMember;
import com.gameif.portal.entity.OpensocialSettlementHist;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.util.ContextUtil;

public class OpensocialPointChargeBusinessLogicImpl extends PointChargeBusinessLogicImpl implements IOpensocialPointChargeBusinessLogic {

	private static final long serialVersionUID = 5064320624553235706L;
		
	private IOpensocialMemberDao opensocialMemberDao;
	private IOpensocialSettlementHistDao opensocialSettlementHistDao;
	private IOpensocialPlayHistDao opensocialPlayHistDao;
	
	@Override
	protected MemberInfo getMemberInfoForUpdate(Long memNum) {

		MemberInfo memberInfo = opensocialMemberDao.selectForUpdate(memNum);
		
		if (memberInfo == null) {

			// データが存在しない
			throw new SystemException("Data not exists.");
		}
		
		return memberInfo;
	}

	@Override
	protected MemberInfo getMemberInfo(Long memNum) {
		
		OpensocialMember member = new OpensocialMember();
		member.setMemNum(memNum);
		return opensocialMemberDao.selectByKey(member);
	}

	@Override
	protected void updateMemberInfo(MemberInfo member) {
				
		opensocialMemberDao.update((OpensocialMember)member);
	}

	@Override
	protected void setSettlementTrnsToHist(MemSettlementHist settlementHist, MemSettlementTrns settleTrns, MemberInfo member) {

		super.setSettlementTrnsToHist(settlementHist, settleTrns, member);
		((OpensocialSettlementHist)settlementHist).setProviderId(settleTrns.getProviderId());
	}
	
	protected BigDecimal getTheMonthAmountByCreditCard(Long memNum) {

		// 最近一ヶ月間チャージするポイントを計算する
		return opensocialSettlementHistDao.selectAmountByMonth(PortalConstants.SettlementCode.CREDIT, memNum);
	}

	@Override
	protected void saveSettlementHist(MemSettlementHist settlementHist) {
		
		opensocialSettlementHistDao.save((OpensocialSettlementHist)settlementHist);
	}

	@Override
	protected void presentServicePoint(MemSettlementHist settlementHist, MemberInfo member) {
		
	}

	@Override
	protected void sendChargeMail(MemSettlementHist settlementHist, MemberInfo member, ServerMst server) {
		
	}
	
	/**
	 * 会員番号とタイトルIDより、ゲームのプレイ回数を取得する
	 * @param memNum 会員番号
	 * @param titleId タイトルID
	 * @return プレイ回数
	 */
	@Override
	public Integer countPlayHist(Long memNum, Integer titleId, Integer serverId) {
		
		return opensocialPlayHistDao.selectPlayHistCount(memNum, titleId, serverId);
	}

	public void setOpensocialMemberDao(IOpensocialMemberDao opensocialMemberDao) {
		
		this.opensocialMemberDao = opensocialMemberDao;
	}

	public void setOpensocialSettlementHistDao(IOpensocialSettlementHistDao opensocialSettlementHistDao) {
		
		this.opensocialSettlementHistDao = opensocialSettlementHistDao;
	}

	public void setOpensocialPlayHistDao(IOpensocialPlayHistDao opensocialPlayHistDao) {
		
		this.opensocialPlayHistDao = opensocialPlayHistDao;
	}
}
