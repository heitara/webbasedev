package com.gameif.portal.businesslogic.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.portal.businesslogic.IPointChargeBusinessLogic;
import com.gameif.portal.businesslogic.titleif.charge.ChargeParameter;
import com.gameif.portal.businesslogic.titleif.charge.TitleCharge;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.dao.IMemSettlementHistDao;
import com.gameif.portal.dao.IMemSettlementTrnsDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.dao.IPointMstDao;
import com.gameif.portal.dao.IServicePointDao;
import com.gameif.portal.dao.IServicePointGiveHistDao;
import com.gameif.portal.dao.IServicePointTypeMstDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MemSettlementTrns;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.ServicePoint;
import com.gameif.portal.entity.ServicePointGiveHist;
import com.gameif.portal.entity.ServicePointTypeMst;
import com.gameif.portal.entity.TitleMst;
import com.gameif.portal.util.ContextUtil;

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
	private IServicePointTypeMstDao servicePointTypeMstDao;
	private IServicePointDao servicePointDao;
	private IServicePointGiveHistDao servicePointGiveHistDao;
	private IInviteInfoDao inviteInfoDao;
	
	// 有効期間
	private Integer validDays;

	/**
	 * 仮決済を登録する
	 */
	@Transactional
	@Override
	public void saveSettlementTrns(MemSettlementTrns settlementTrns)
			throws LogicException {

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
		// 仮決済を登録する
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
		// settleTrns =
		// memSettlementTrnsDao.selectForUpdate(ContextUtil.getSettleTrnsNum());
		if (settleTrns == null) {

			// データが存在しない
			throw new DataNotExistsException(
					"MemSettlementTrns Data not exists.");
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
		MemberInfo member = memberInfoDao.selectForUpdate(settleTrns
				.getMemNum());
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
		params.setChargePoint(Integer.parseInt(settleTrns.getPointAmountAct()
				.toString()));
		params.setChargeDate(settleTrns.getSettlementDate());

		TitleMst title = new TitleMst();
		title.setTitleId(settleTrns.getTitleId());
		title = titleMstDao.selectByKey(title);

		params.setChargeUrl(title.getPaymentUrl());
		params.setSpType(PortalConstants.ChargeSpType.ACCOUNT_POINT);
		params.setParentNum(getParentNum());

		TitleCharge titleCharge = new TitleCharge();
		// チャージを行う
		int chargeRes = titleCharge.chargePoint(params);
		if (chargeRes != 0) {
			throw new LogicException("Failed to charge.");
		}

		// 仮決済情報を削除する
		memSettlementTrnsDao.deleteByKey(settleTrns.getSettlementTrnsNum());
		
		// サービスポイントを贈与する
		checkSettlementAmount(settlementHist);

	}

	/**
	 * 決済ログを生成する
	 * 
	 * @param settlementHist
	 * @return
	 */
	private String makeSettlementLog(MemSettlementHist settlementHist) {

		StringBuilder settlementLog = new StringBuilder();
		settlementLog.append(settlementHist.getResResult()).append(",").append(
				settlementHist.getResTrackingId()).append(",").append(
				settlementHist.getResSpsCustNo()).append(",").append(
				settlementHist.getResSpsPaymentNo()).append(",").append(
				settlementHist.getResPayinfoKey()).append(",").append(
				settlementHist.getResPaymentDate()).append(",").append(
				settlementHist.getResErrCode()).append(",").append(
				settlementHist.getResDate()).append(",").append(
				settlementHist.getLimitSecond()).append(",").append(
				settlementHist.getSpsHashcode());

		return settlementLog.toString();

	}

	/**
	 * サービスポイントを贈与する
	 * @param settlementHist
	 */
	private void checkSettlementAmount(MemSettlementHist settlementHist) {

		// 有効なサービスポイントを取得する(最近一ヶ月の累計課金金額が一定金額を超えた場合)
		ServicePointTypeMst servicePointTypeMst = servicePointTypeMstDao.selectChargePointRate(
						PortalConstants.ServicePointTypeCd.CHARGE,
						settlementHist.getTitleId(), ContextUtil.getMemberNo());
		if (servicePointTypeMst == null || servicePointTypeMst.getServicePointTypeId() == null) {
			return;
		}
		
		// 贈与日時
		Date giveDate = new Date();
		
		Date endDate = new Date();
		// 失効期間を計算する
		Calendar c = Calendar.getInstance();
		c.setTime(giveDate);
		c.add(Calendar.DATE, validDays);
		endDate = c.getTime();
		
		ServicePoint servicePoint = new ServicePoint();
		servicePoint.setMemNum(ContextUtil.getMemberNo());
		servicePoint.setTitleId(settlementHist.getTitleId());
		servicePoint.setGiveDate(giveDate);
		// 有効なデータが存在かどうか
		servicePoint = servicePointDao.selectBalanceByTitleAndMemnum(servicePoint);
		BigDecimal amount = settlementHist.getPointAmountAct().multiply(servicePointTypeMst.getPointAmount()).divide(new BigDecimal(100));
		if (servicePoint == null) {
			
			servicePoint = new ServicePoint();

			servicePoint.setMemNum(ContextUtil.getMemberNo());
			servicePoint.setGiveDate(giveDate);
			servicePoint.setPointStartDate(giveDate);
			servicePoint.setPointEndDate(endDate);
			servicePoint.setTitleId(settlementHist.getTitleId());
			// サービスポイント = 決済ポイント数 * 基準パーセント数
			servicePoint.setPointAmount(amount);
			servicePoint.setCreatedDate(giveDate);
			servicePoint.setCreatedUser(ContextUtil.getMemberNo().toString());
			servicePoint.setLastUpdateDate(giveDate);
			servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());
			
			// サービスポイント残高テーブルに登録する
			servicePointDao.save(servicePoint);
		} else {
			// 残高 = 元の残高 + 今回のポイント数
			servicePoint.setPointAmount(servicePoint.getPointAmount().add(amount));
			servicePoint.setPointEndDate(endDate);
			servicePoint.setLastUpdateDate(giveDate);
			servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());
			
			// 残高を更新する
			servicePointDao.update(servicePoint);
		}
		
		// サービスポイント贈与履歴
		ServicePointGiveHist servicePointGiveHist = new ServicePointGiveHist();
		servicePointGiveHist.setServicePointNo(servicePoint.getServicePointNo());
		servicePointGiveHist.setMemNum(ContextUtil.getMemberNo());
		servicePointGiveHist.setServicePointTypeId(servicePointTypeMst.getServicePointTypeId());
		servicePointGiveHist.setTitleId(settlementHist.getTitleId());
		servicePointGiveHist.setGiveDate(giveDate);
		servicePointGiveHist.setPointStartDate(giveDate);
		servicePointGiveHist.setPointEndDate(endDate);
		servicePointGiveHist.setPointAmount(amount);
		servicePointGiveHist.setCreatedDate(giveDate);
		servicePointGiveHist.setCreatedUser(ContextUtil.getMemberNo().toString());
		servicePointGiveHist.setLastUpdateDate(giveDate);
		servicePointGiveHist.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		
		// サービスポイント贈与履歴テーブルに登録する
		servicePointGiveHistDao.save(servicePointGiveHist);
	}
	
	/**
	 * 該当会員の親の会員番号を取得する
	 * @return
	 */
	private Long getParentNum() {
		Long parentNum = null;
		
		// 子の会員番号より、招待情報を検索する
		InviteInfo invite = inviteInfoDao.selectParentByChildNum(ContextUtil.getMemberNo());
		if (invite != null) {
			parentNum = invite.getMemNum();
		}
		
		return parentNum;
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
	 * @param memSettlementHistDao
	 *            the memSettlementHistDao to set
	 */
	public void setMemSettlementHistDao(
			IMemSettlementHistDao memSettlementHistDao) {
		this.memSettlementHistDao = memSettlementHistDao;
	}

	/**
	 * @return the memberInfoDao
	 */
	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	/**
	 * @param memberInfoDao
	 *            the memberInfoDao to set
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
	 * @param pointMstDao
	 *            the pointMstDao to set
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
	 * @param titleMstDao
	 *            the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

	/**
	 * @return the servicePointTypeMstDao
	 */
	public IServicePointTypeMstDao getServicePointTypeMstDao() {
		return servicePointTypeMstDao;
	}

	/**
	 * @param servicePointTypeMstDao
	 *            the servicePointTypeMstDao to set
	 */
	public void setServicePointTypeMstDao(
			IServicePointTypeMstDao servicePointTypeMstDao) {
		this.servicePointTypeMstDao = servicePointTypeMstDao;
	}

	/**
	 * @return the servicePointDao
	 */
	public IServicePointDao getServicePointDao() {
		return servicePointDao;
	}

	/**
	 * @param servicePointDao the servicePointDao to set
	 */
	public void setServicePointDao(IServicePointDao servicePointDao) {
		this.servicePointDao = servicePointDao;
	}

	/**
	 * @return the servicePointGiveHistDao
	 */
	public IServicePointGiveHistDao getServicePointGiveHistDao() {
		return servicePointGiveHistDao;
	}

	/**
	 * @param servicePointGiveHistDao the servicePointGiveHistDao to set
	 */
	public void setServicePointGiveHistDao(
			IServicePointGiveHistDao servicePointGiveHistDao) {
		this.servicePointGiveHistDao = servicePointGiveHistDao;
	}

	/**
	 * @return the inviteInfoDao
	 */
	public IInviteInfoDao getInviteInfoDao() {
		return inviteInfoDao;
	}

	/**
	 * @param inviteInfoDao the inviteInfoDao to set
	 */
	public void setInviteInfoDao(IInviteInfoDao inviteInfoDao) {
		this.inviteInfoDao = inviteInfoDao;
	}

	/**
	 * @return the validDays
	 */
	public Integer getValidDays() {
		return validDays;
	}

	/**
	 * @param validDays the validDays to set
	 */
	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}

}
