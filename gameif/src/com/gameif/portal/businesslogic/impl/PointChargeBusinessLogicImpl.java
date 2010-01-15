package com.gameif.portal.businesslogic.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.SystemException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.portal.businesslogic.IPointChargeBusinessLogic;
import com.gameif.portal.businesslogic.titleif.charge.ChargeConstants;
import com.gameif.portal.businesslogic.titleif.charge.ChargeParameter;
import com.gameif.portal.businesslogic.titleif.charge.TitleCharge;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IFunctionControlInfoDao;
import com.gameif.portal.dao.IMemSettlementHistDao;
import com.gameif.portal.dao.IMemSettlementTrnsDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.dao.IPlayHistDao;
import com.gameif.portal.dao.IPointMstDao;
import com.gameif.portal.dao.IServerMstDao;
import com.gameif.portal.dao.IServicePointDao;
import com.gameif.portal.dao.IServicePointGiveHistDao;
import com.gameif.portal.dao.IServicePointTypeMstDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.FunctionControlInfo;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MemSettlementTrns;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.MySettlementHist;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.entity.ServicePoint;
import com.gameif.portal.entity.ServicePointGiveHist;
import com.gameif.portal.entity.ServicePointTypeMst;
import com.gameif.portal.util.ContextUtil;

public class PointChargeBusinessLogicImpl extends BaseBusinessLogic implements
		IPointChargeBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5064320624553235706L;
	
	private final static Log logger = LogFactory.getLog(PointChargeBusinessLogicImpl.class);

	private IMemSettlementTrnsDao memSettlementTrnsDao;
	private IMemSettlementHistDao memSettlementHistDao;
	private IMemberInfoDao memberInfoDao;
	private IPointMstDao pointMstDao;
	private ITitleMstDao titleMstDao;
	private IServicePointTypeMstDao servicePointTypeMstDao;
	private IServicePointDao servicePointDao;
	private IServicePointGiveHistDao servicePointGiveHistDao;
	private TemplateMailer templateMailer;
	private TitleCharge titleCharge;
	private IPlayHistDao playHistDao;
	private IServerMstDao serverMstDao;
	private IFunctionControlInfoDao functionControlInfoDao;
	
	// 有効期間
	private Integer validDays;
	// 購入できるポイントの限度額（100,000）
	private BigDecimal limitAmountMax;
	// 購入できるポイントの限度額（30,000）
	private BigDecimal limitAmountMin;

	/**
	 * 仮決済を登録する
	 * @param settlementTrns　仮決済情報
	 * @return 0:正常終了、１：会員が18歳未満、クレジットカードは利用できない、２：限度額が30000をお超える、３：限度額が100000をお超える
	 */
	@Transactional
	@Override
	public int createSettlementTrns(MemSettlementTrns settlementTrns) throws LogicException {
		
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
		
		// 会員生年月日が入力した場合
		if (memberInfo.getBirthYmd() != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(memberInfo.getBirthYmd());
			// 会員生年月日　+　18年
			c.add(Calendar.YEAR, 18);
			Date ageDate = c.getTime();
			// 18歳未満の方
			if (ageDate.compareTo(settleDate) > 0 ) {
				if ( settlementTrns.getSettlementCode().equals(PortalConstants.SettlementCode.CREDIT)) {
					return 1;
				} else {
					// 最近一ヶ月間チャージするポイントを計算する
					BigDecimal limitAmouont = memSettlementHistDao.selectAmountByMonth(null, ContextUtil.getMemberNo());
					if (limitAmouont.add(pointMst.getPointAmountAct()).compareTo(limitAmountMin) > 0) {
						return 2;
					}
				}
			}
		}
		
		// クレジットカード決済の場合、限度額のチェックを行う
		if (settlementTrns.getSettlementCode().equals(PortalConstants.SettlementCode.CREDIT)) {
			// 最近一ヶ月間チャージするポイントを計算する
			BigDecimal sumPointAmouont = memSettlementHistDao.selectAmountByMonth(PortalConstants.SettlementCode.CREDIT, ContextUtil.getMemberNo());
			
			Calendar c = Calendar.getInstance();
			c.setTime(memberInfo.getEntryDate());
			// 会員登録から30日間、
			c.add(Calendar.DATE, 30);
			Date loginDate = c.getTime();
			
			// 登録の31日目から、一ヶ月間に購入できるポイントの限度額が100,000です
			if (loginDate.compareTo(settleDate) <= 0) {
				if (sumPointAmouont.add(pointMst.getPointAmountAct()).compareTo(limitAmountMax) > 0) {
					return 3;
				}
			// 登録からの30日間、一ヶ月間に購入できるポイントの限度額が30,000です
			} else {
				if (sumPointAmouont.add(pointMst.getPointAmountAct()).compareTo(limitAmountMin) > 0) {
					return 4;
				}
			}
		}
		
		// 仮決済を登録する
		settlementTrns.setMemNum(memberInfo.getMemNum());
		settlementTrns.setMemAtbtCd(memberInfo.getMemAtbtCd());
		settlementTrns.setSettlementDate(settleDate);
		settlementTrns.setPointAmount(pointMst.getPointAmount());
		settlementTrns.setPointAmountAct(pointMst.getPointAmountAct());
		settlementTrns.setSettlementLog(makeSettlementTrnsLog(settlementTrns));
		settlementTrns.setCreatedDate(settleDate);
		settlementTrns.setCreatedUser(memberInfo.getMemNum().toString());
		
		memSettlementTrnsDao.save(settlementTrns);
		
		return 0;
	}
	
	/**
	 * 決済ログを作成する
	 * @param settlementTrns 仮決済情報
	 * @return
	 */
	private String makeSettlementTrnsLog(MemSettlementTrns settlementTrns) {
		return new StringBuilder()
		.append(settlementTrns.getSettlementCode()).append(",")
		.append(settlementTrns.getMemNum()).append(",")
		.append(settlementTrns.getMemAtbtCd()).append(",")
		.append(settlementTrns.getTitleId()).append(",")
		.append(settlementTrns.getServerId()).append(",")
		.append(settlementTrns.getPointId()).append(",")
		.append(settlementTrns.getSettlementDate()).append(",")
		.append(settlementTrns.getPointAmount()).append(",")
		.append(settlementTrns.getPointAmountAct())
		.toString();
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
	/**
	 * 本決済を登録する
	 */
	@Transactional
	@Override
	public void createSettlementHist(MemSettlementHist settlementHist) throws Exception {

		// 仮決済情報を取得する
		MemSettlementTrns settleTrns = memSettlementTrnsDao.selectForUpdate(settlementHist.getSettlementTrnsNum());
		if (settleTrns == null) {

			// データが存在しない
			throw new SystemException("MemSettlementTrns Data not exists.");
		}

		// 本決済を登録する
		Date settlementDate = new Date();
		
		settlementHist.setSettlementTrnsNum(settleTrns.getSettlementTrnsNum());
		settlementHist.setSettlementCode(settleTrns.getSettlementCode());
		settlementHist.setMemNum(settleTrns.getMemNum());
		settlementHist.setMemAtbtCd(settleTrns.getMemAtbtCd());
		settlementHist.setTitleId(settleTrns.getTitleId());
		settlementHist.setServerId(settleTrns.getServerId());
		settlementHist.setPointId(settleTrns.getPointId());
		settlementHist.setSettlementDate(settlementDate);
		settlementHist.setPointAmount(settleTrns.getPointAmount());
		settlementHist.setPointAmountAct(settleTrns.getPointAmountAct());
		// ログ
		settlementHist.setSettlementLog(makeSettlementLog(settlementHist));
		settlementHist.setCreatedUser(settleTrns.getCreatedUser());
		settlementHist.setCreatedDate(settlementDate);
		settlementHist.setLastUpdateUser(settleTrns.getCreatedUser());
		settlementHist.setLastUpdateDate(settlementDate);

		memSettlementHistDao.save(settlementHist);

		// 会員属性を更新する
		MemberInfo member = memberInfoDao.selectForUpdate(settleTrns.getMemNum());
		if (member == null) {

			// データが存在しない
			throw new SystemException("MemberInfo Data does not exist.");
		}

		// 会員属性：「一般会員」＝＞「課金会員」
		if (member.getMemAtbtCd().equals(PortalConstants.MemberAtbtCd.NORMAL)) {
			member.setMemAtbtCd(PortalConstants.MemberAtbtCd.CHARGE);
			member.setLastUpdateDate(settlementDate);
			member.setLastUpdateUser(settleTrns.getMemNum().toString());
	
			memberInfoDao.update(member); 
		}

		// 仮決済情報を削除する
		memSettlementTrnsDao.deleteByKey(settleTrns.getSettlementTrnsNum());
		
		FunctionControlInfo functionControlInfo = new FunctionControlInfo();
		functionControlInfo.setFunctionCode(PortalConstants.FunctionCode.CHARGE);
		functionControlInfo = functionControlInfoDao.selectByKey(functionControlInfo);
		// チャージするときに、サービスポイント付与機能が開放の場合、
		if (functionControlInfo != null && !functionControlInfo.getServiceStatus().equals(PortalConstants.FunctionServiceStatus.OFF)) {
			// サービスポイントを贈与する
			checkSettlementAmount(settlementHist, member, functionControlInfo);
		}

		// ポイントチャージ
		ChargeParameter params = new ChargeParameter();
		params.setMemNum(member.getMemNum());
		params.setMemId(member.getMemId());
		params.setOrderNo(settlementHist.getSettlementNum());
		params.setTitleId(settleTrns.getTitleId());
		params.setChargePoint(Integer.parseInt(settleTrns.getPointAmountAct().toString()));
		params.setChargeDate(settlementDate);

		ServerMst server = new ServerMst();
		server.setTitleId(settleTrns.getTitleId());
		server.setServerId(settleTrns.getServerId());
		server = serverMstDao.selectForUpdate(server);
		if (server == null) {

			// データが存在しない
			throw new SystemException("Server Data does not exist.");
			
		}

		params.setChargeUrl(server.getChargeUrl());
		params.setSpType(PortalConstants.ChargeSpType.ACCOUNT_POINT);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ContextUtil.getRequestBaseInfo())
		.append(" | External I/F--TitleCharge params: ")
		.append("memnum=").append(params.getMemNum()).append(",")
		.append("memId=").append(params.getMemId()).append(",")
		.append("orderNo=").append(params.getOrderNo()).append(",")
		.append("titleId=").append(params.getTitleId()).append(",")
		.append("chargePoint=").append(params.getChargePoint()).append(",")
		.append("chargeDate=").append(params.getChargeDate()).append(",")
		.append("chargeUrl=").append(params.getChargeUrl()).append(",")
		.append("spType=").append(params.getSpType());
		logger.info(sb.toString());
		
		// チャージを行う
		int chargeRes = titleCharge.chargePoint(params);
		if (chargeRes != ChargeConstants.Result.SUCCESS) {
			
			StringBuilder sbWarn = new StringBuilder();
			sbWarn.append(ContextUtil.getRequestBaseInfo())
			.append(" | External I/F--TitleCharge Result: ")
			.append(chargeRes);
			logger.warn(sbWarn.toString());
			
			throw new SystemException("Failed to charge.");
		}

		try {
			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 名前
			props.put("nickName", member.getNickName());
			// ゲーム
			props.put("titleName", titleMstDao.selectNameById(settlementHist.getTitleId()));
			// サーバ
			props.put("serverName", server.getServerName());
			// データID
			props.put("point", settlementHist.getPointAmountAct().toString());
			// 送信
			templateMailer.sendAsyncMail(member.getMailPc(), "pointCharge", props, true);
		} catch (Exception ex) {
			logger.error("error has occurred in sending pointCharge mail. ", ex);
		}

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
	@SuppressWarnings("unchecked")
	private void checkSettlementAmount(MemSettlementHist settlementHist, MemberInfo member, FunctionControlInfo functionControlInfo) {

		ServicePointTypeMst servicePointTypeMst = null;
		BigDecimal amount = new BigDecimal(0);
		HashMap params = new HashMap();

		// 有効なサービスポイントを取得する(最近一ヶ月の累計課金金額が一定金額を超えた場合)
		if (functionControlInfo.getServiceStatus().equals(PortalConstants.FunctionServiceStatus.ON)) {
			params.put("servicePointTypeCd", PortalConstants.ServicePointTypeCd.CHARGE_PERCENT);
			params.put("titleId", settlementHist.getTitleId());
			params.put("memNum", settlementHist.getMemNum());
			params.put("chargeStartDate", functionControlInfo.getServiceStartDate());
			params.put("chargeEndDate", functionControlInfo.getServiceEndDate());
			
			servicePointTypeMst = servicePointTypeMstDao.selectChargePointRateForUpdate(params);
			
		// タイムセール、今回決済金額によって、固定額のサービスポイントを付与する
		} else if (functionControlInfo.getServiceStatus().equals(PortalConstants.FunctionServiceStatus.CHARGE_FIX)) {
			params.put("servicePointTypeCd", PortalConstants.ServicePointTypeCd.CHARGE_FIX);
			params.put("chargePoint", settlementHist.getPointAmountAct());
			
			servicePointTypeMst = servicePointTypeMstDao.selectChargeFixPointForUpdate(params);
		}

		if (servicePointTypeMst == null || servicePointTypeMst.getServicePointTypeId() == null) {
			return;
		}

		// 有効なサービスポイントを取得する(最近一ヶ月の累計課金金額が一定金額を超えた場合)
		if (functionControlInfo.getServiceStatus().equals(PortalConstants.FunctionServiceStatus.ON)) {
			amount = settlementHist.getPointAmountAct().multiply(servicePointTypeMst.getPointAmount()).divide(new BigDecimal(100));
			
		// タイムセール、今回決済金額によって、固定額のサービスポイントを付与する
		} else if (functionControlInfo.getServiceStatus().equals(PortalConstants.FunctionServiceStatus.CHARGE_FIX)) {
			amount = servicePointTypeMst.getPointAmount();
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
		servicePoint.setMemNum(settlementHist.getMemNum());
		servicePoint.setTitleId(settlementHist.getTitleId());
		// 有効なデータが存在かどうか
		servicePoint = servicePointDao.selectForUpdate(servicePoint);
		if (servicePoint == null) {

			servicePoint = new ServicePoint();

			servicePoint.setMemNum(settlementHist.getMemNum());
			servicePoint.setPointEndDate(endDate);
			servicePoint.setTitleId(settlementHist.getTitleId());
			// サービスポイント = 決済ポイント数 * 基準パーセント数
			servicePoint.setPointAmount(amount);
			servicePoint.setCreatedDate(giveDate);
			servicePoint.setCreatedUser(settlementHist.getMemNum().toString());
			servicePoint.setLastUpdateDate(giveDate);
			servicePoint.setLastUpdateUser(settlementHist.getMemNum().toString());

			// サービスポイント残高テーブルに登録する
			servicePointDao.save(servicePoint);
		} else {
			// 既に期限切れました
			if (giveDate.compareTo(servicePoint.getPointEndDate()) > 0) {
				// 残高 = 今回のポイント数
				servicePoint.setPointAmount(amount);
			} else {
				// 残高 = 元の残高 + 今回のポイント数
				servicePoint.setPointAmount(servicePoint.getPointAmount().add(amount));
			}
			servicePoint.setPointEndDate(endDate);
			servicePoint.setLastUpdateDate(giveDate);
			servicePoint.setLastUpdateUser(settlementHist.getMemNum().toString());
			
			// 残高を更新する
			servicePointDao.update(servicePoint);
		}
		
		// サービスポイント贈与履歴
		ServicePointGiveHist servicePointGiveHist = new ServicePointGiveHist();
		servicePointGiveHist.setMemNum(settlementHist.getMemNum());
		servicePointGiveHist.setServicePointTypeId(servicePointTypeMst.getServicePointTypeId());
		servicePointGiveHist.setServicePointTypeCd(PortalConstants.ServicePointTypeCd.CHARGE_PERCENT);
		servicePointGiveHist.setTitleId(settlementHist.getTitleId());
		servicePointGiveHist.setGiveDate(giveDate);
		servicePointGiveHist.setPointEndDate(endDate);
		servicePointGiveHist.setPointAmount(amount);
		servicePointGiveHist.setCreatedDate(giveDate);
		servicePointGiveHist.setCreatedUser(settlementHist.getMemNum().toString());
		servicePointGiveHist.setLastUpdateDate(giveDate);
		servicePointGiveHist.setLastUpdateUser(settlementHist.getMemNum().toString());
		
		// サービスポイント贈与履歴テーブルに登録する
		servicePointGiveHistDao.save(servicePointGiveHist);

		try {
			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 名前
			props.put("nickName", member.getNickName());
			// ゲーム
			props.put("titleName", titleMstDao.selectNameById(settlementHist.getTitleId()));
			// データID
			props.put("point", amount.toString());
			// 送信
			templateMailer.sendAsyncMail(member.getMailPc(), "presentServicePoint", props, true);
		} catch (Exception ex) {
			logger.error("error has occurred in sending presentServicePoint mail. ", ex);
		}
	}
	/**
	 * 会員番号とタイトルIDより、ゲームのプレイ回数を取得する
	 * @param memNum 会員番号
	 * @param titleId タイトルID
	 * @return プレイ回数
	 */
	@Override
	public Integer countPlayHist(Integer titleId) {
		return playHistDao.selectPlayHistCount(ContextUtil.getMemberNo(), titleId);
	}

	@Override
	public List<MySettlementHist> getSettlementHistListByMemNum(Long memNum) {
		return memSettlementHistDao.selectSettlementHistListByMemNum(memNum);
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
	 * @return the templateMailer
	 */
	public TemplateMailer getTemplateMailer() {
		return templateMailer;
	}

	/**
	 * @param templateMailer
	 *            the templateMailer to set
	 */
	public void setTemplateMailer(TemplateMailer templateMailer) {
		this.templateMailer = templateMailer;
	}

	/**
	 * @return the titleCharge
	 */
	public TitleCharge getTitleCharge() {
		return titleCharge;
	}

	/**
	 * @param titleCharge the titleCharge to set
	 */
	public void setTitleCharge(TitleCharge titleCharge) {
		this.titleCharge = titleCharge;
	}

	/**
	 * @return the playHistDao
	 */
	public IPlayHistDao getPlayHistDao() {
		return playHistDao;
	}

	/**
	 * @param playHistDao the playHistDao to set
	 */
	public void setPlayHistDao(IPlayHistDao playHistDao) {
		this.playHistDao = playHistDao;
	}

	/**
	 * @return the serverMstDao
	 */
	public IServerMstDao getServerMstDao() {
		return serverMstDao;
	}

	/**
	 * @param serverMstDao the serverMstDao to set
	 */
	public void setServerMstDao(IServerMstDao serverMstDao) {
		this.serverMstDao = serverMstDao;
	}

	/**
	 * @return the functionControlInfoDao
	 */
	public IFunctionControlInfoDao getFunctionControlInfoDao() {
		return functionControlInfoDao;
	}

	/**
	 * @param functionControlInfoDao the functionControlInfoDao to set
	 */
	public void setFunctionControlInfoDao(
			IFunctionControlInfoDao functionControlInfoDao) {
		this.functionControlInfoDao = functionControlInfoDao;
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

	/**
	 * @return the limitAmountMax
	 */
	public BigDecimal getLimitAmountMax() {
		return limitAmountMax;
	}

	/**
	 * @param limitAmountMax the limitAmountMax to set
	 */
	public void setLimitAmountMax(BigDecimal limitAmountMax) {
		this.limitAmountMax = limitAmountMax;
	}

	/**
	 * @return the limitAmountMin
	 */
	public BigDecimal getLimitAmountMin() {
		return limitAmountMin;
	}

	/**
	 * @param limitAmountMin the limitAmountMin to set
	 */
	public void setLimitAmountMin(BigDecimal limitAmountMin) {
		this.limitAmountMin = limitAmountMin;
	}

}
