package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IPointChargeBusinessLogic;
import com.gameif.portal.businesslogic.titleif.charge.ChargeParameter;
import com.gameif.portal.businesslogic.titleif.charge.TitleCharge;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IMemSettlementHistDao;
import com.gameif.portal.dao.IMemSettlementTrnsDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.dao.IPointMstDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MemSettlementTrns;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.TitleMst;

public class PointChargeBusinessLogicImpl extends BaseBusinessLogic implements
		IPointChargeBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5064320624553235706L;

	private IMemSettlementTrnsDao memSettlementTrnsDao;
	private IMemSettlementHistDao memSettlementHistDao;
	private IMemberInfoDao memberInfoDao;
	private IPointMstDao pointMstDao;
	private ITitleMstDao titleMstDao;

	/**
	 * 仮決済を登録する
	 */
	@Transactional
	@Override
	public void saveSettlementTrns(MemSettlementTrns settlementTrns) throws LogicException {
		
		// 会員情報を取得する
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMemNum(ContextUtil.getMemberNo());
		memberInfo = memberInfoDao.selectByKey(memberInfo);
		if (memberInfo == null) {
				
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		// チャージポイント情報を取得する
		PointMst pointMst = new PointMst();
		pointMst.setPointId(settlementTrns.getPointId());
		pointMst = pointMstDao.selectByKey(pointMst);
		if (pointMst == null) {
			
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		Date settleDate = new Date();
		settlementTrns.setMemNum(memberInfo.getMemNum());
		settlementTrns.setMemAtbtCd(memberInfo.getMemAtbtCd());
		settlementTrns.setSettlementDate(settleDate);
		settlementTrns.setPointAmount(pointMst.getPointAmount());
		settlementTrns.setPointAmountAct(pointMst.getPointAmountAct());
		settlementTrns.setCreatedDate(settleDate);
		settlementTrns.setCreatedUser(memberInfo.getMemNum().toString());
		//仮決済を登録する
		memSettlementTrnsDao.save(settlementTrns);
	}
	
	/**
	 * 仮決済番号より、仮決済情報を取得する
	 */
	@Override
	public MemSettlementTrns getSettlementTrnsByKey(Long settleTrnsNum) {
		
		MemSettlementTrns settleTrns = new MemSettlementTrns();
		settleTrns.setSettlementTrnsNum(settleTrnsNum);
		
		return memSettlementTrnsDao.selectByKey(settleTrns);
	}

	@Override
	public void createSettlementHist(MemSettlementHist settlementHist)
			throws LogicException {	
			
		// 仮決済情報を取得する
		MemSettlementTrns settleTrns = new MemSettlementTrns();
		settleTrns.setSettlementTrnsNum(settlementHist.getSettlementTrnsNum());
		settleTrns = memSettlementTrnsDao.selectByKey(settleTrns);
//		settleTrns = memSettlementTrnsDao.selectForUpdate(ContextUtil.getSettleTrnsNum());		
		if (settleTrns == null) {
			
			// データが存在しない
			throw new DataNotExistsException("MemSettlementTrns Data not exists.");
		}
		
		// 本決済を登録する
		settlementHist.setSettlementTrnsNum(settleTrns.getSettlementTrnsNum());
		settlementHist.setSettlementCode(settleTrns.getSettlementCode());
		settlementHist.setMemNum(settleTrns.getMemNum());
		settlementHist.setMemAtbtCd(settleTrns.getMemAtbtCd());
		settlementHist.setTitleId(settleTrns.getTitleId());
		settlementHist.setServerId(settleTrns.getServerId());
		settlementHist.setPointId(settleTrns.getPointId());
		settlementHist.setSettlementDate(settleTrns.getSettlementDate());
		settlementHist.setPointAmount(settleTrns.getPointAmount());
		settlementHist.setPointAmountAct(settleTrns.getPointAmountAct());
		// ログ
		settlementHist.setSettlementLog(makeSettlementLog(settlementHist));
		settlementHist.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		settlementHist.setLastUpdateDate(new Date());
		
		memSettlementHistDao.save(settlementHist);
		
		// 会員属性を更新する
		MemberInfo member = memberInfoDao.selectForUpdate(settleTrns.getMemNum());	
		if (member == null) {
			
			// データが存在しない
			throw new DataNotExistsException("MemberInfo Data not exists.");
		}

		// 会員属性：通常会員
		member.setMemAtbtCd(PortalConstants.MemberAtbtCd.CHARGE);
		member.setLastUpdateDate(new Date());
		member.setLastUpdateIp(ContextUtil.getClientIP());
		member.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		
		memberInfoDao.update(member);
		
		// ポイントチャージ
		ChargeParameter params = new ChargeParameter();
		params.setMemNum(member.getMemNum());
		params.setMemId(member.getMemId());
		params.setTitleId(settleTrns.getTitleId());
		params.setChargePoint(Integer.parseInt(settleTrns.getPointAmountAct().toString()));
		params.setChargeDate(settleTrns.getSettlementDate());
		
		TitleMst title = new TitleMst();
		title.setTitleId(settleTrns.getTitleId());
		title =	titleMstDao.selectByKey(title);
		
		params.setChargeUrl(title.getPaymentUrl());
		
		TitleCharge titleCharge = new TitleCharge();
		// チャージを行う
		int chargeRes = titleCharge.chargePoint(params);
		if (chargeRes != 0) {
			throw new LogicException("Failed to charge.");
		}
		
		// 仮決済情報を削除する
		memSettlementTrnsDao.deleteByKey(settleTrns.getSettlementTrnsNum());
		
	}
	
	/**
	 * 決済ログを生成する
	 * @param settlementHist
	 * @return
	 */
	private String makeSettlementLog(MemSettlementHist settlementHist) {
		
		StringBuilder settlementLog = new StringBuilder();
		settlementLog.append(settlementHist.getResResult()).append(",")
		.append(settlementHist.getResTrackingId()).append(",")
		.append(settlementHist.getResSpsCustNo()).append(",")
		.append(settlementHist.getResSpsPaymentNo()).append(",")
		.append(settlementHist.getResPayinfoKey()).append(",")
		.append(settlementHist.getResPaymentDate()).append(",")
		.append(settlementHist.getResErrCode()).append(",")
		.append(settlementHist.getResDate()).append(",")
		.append(settlementHist.getLimitSecond()).append(",")
		.append(settlementHist.getSpsHashcode());
		
		return settlementLog.toString();
		
	}
	

	/**
	 * @return the memSettlementTrnsDao
	 */
	public IMemSettlementTrnsDao getMemSettlementTrnsDao() {
		return memSettlementTrnsDao;
	}

	/**
	 * @param memSettlementTrnsDao
	 *            the memSettlementTrnsDao to set
	 */
	public void setMemSettlementTrnsDao(
			IMemSettlementTrnsDao memSettlementTrnsDao) {
		this.memSettlementTrnsDao = memSettlementTrnsDao;
	}

	/**
	 * @return the memSettlementHistDao
	 */
	public IMemSettlementHistDao getMemSettlementHistDao() {
		return memSettlementHistDao;
	}

	/**
	 * @param memSettlementHistDao the memSettlementHistDao to set
	 */
	public void setMemSettlementHistDao(IMemSettlementHistDao memSettlementHistDao) {
		this.memSettlementHistDao = memSettlementHistDao;
	}

	/**
	 * @return the memberInfoDao
	 */
	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	/**
	 * @param memberInfoDao the memberInfoDao to set
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	/**
	 * @return the pointMstDao
	 */
	public IPointMstDao getPointMstDao() {
		return pointMstDao;
	}

	/**
	 * @param pointMstDao the pointMstDao to set
	 */
	public void setPointMstDao(IPointMstDao pointMstDao) {
		this.pointMstDao = pointMstDao;
	}

	/**
	 * @return the titleMstDao
	 */
	public ITitleMstDao getTitleMstDao() {
		return titleMstDao;
	}

	/**
	 * @param titleMstDao the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

}
