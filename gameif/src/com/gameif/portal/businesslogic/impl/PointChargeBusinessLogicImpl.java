package com.gameif.portal.businesslogic.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
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
import com.gameif.portal.dao.ISettlementMstDao;
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
import com.gameif.portal.entity.SettlementMst;
import com.gameif.portal.util.ContextUtil;

public class PointChargeBusinessLogicImpl extends BaseBusinessLogic implements IPointChargeBusinessLogic {

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
	private ISettlementMstDao settlementMstDao;
	
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
	public int createSettlementTrns(MemSettlementTrns settlementTrns) {
		
		int retCode = 0;
					
		// 会員情報を取得する
		MemberInfo memberInfo = getMemberInfoForUpdate(settlementTrns.getMemNum());
		// チャージポイント情報を取得する
		PointMst pointMst = getPointMst(settlementTrns.getPointId());
		
		// 年齢とクレジット決済の限度額のチェック
		if ((retCode = checkByBirthday(settlementTrns, pointMst, memberInfo.getBirthYmd())) == 0
				&& (retCode = checkForCreditCard(settlementTrns, pointMst, memberInfo.getEntryDate())) == 0) {
				
			// 仮決済を登録する
			saveSettlementTrns(settlementTrns, pointMst, memberInfo.getMemAtbtCd());
		}
	
		return retCode;
	}
	
	protected MemberInfo getMemberInfoForUpdate(Long memNum) {

		MemberInfo memberInfo = memberInfoDao.selectForUpdate(memNum);
		
		if (memberInfo == null) {

			// データが存在しない
			throw new SystemException("Data not exists.");
		}
		
		return memberInfo;
	}
	
	/**
	 * 本決済を登録する
	 */
	@Transactional
	@Override
	public void createSettlementHist(MemSettlementHist settlementHist) throws Exception {
		
		// 仮決済情報を取得する
		MemSettlementTrns settleTrns = getSettlementTrnsForUpdate(settlementHist.getSettlementTrnsNum());
		MemberInfo member = getMemberInfoForUpdate(settleTrns.getMemNum());

		// 会員属性：「一般会員」＝＞「課金会員」
		if (PortalConstants.MemberAtbtCd.NORMAL.equals(member.getMemAtbtCd())) {
			
			member.setMemAtbtCd(PortalConstants.MemberAtbtCd.CHARGE);
			member.setLastUpdateDate(new Date());
			member.setLastUpdateIp(ContextUtil.getClientIP());
			member.setLastUpdateUser(String.valueOf(settleTrns.getMemNum()));
	
			updateMemberInfo(member);
		}

		setSettlementTrnsToHist(settlementHist, settleTrns, member);
		
		// 決済情報を登録する。
		saveSettlementHist(settlementHist);

		// 仮決済情報を削除する
		memSettlementTrnsDao.deleteByKey(settleTrns.getSettlementTrnsNum());
		
		// サービスポイントプレゼント
		presentServicePoint(settlementHist, member);

		ServerMst server = getServerMst(settleTrns.getTitleId(), settleTrns.getServerId(), settleTrns.getProviderId());

		// ポイント付与
		doCharge(settlementHist, member, server);

		// メールを送信する。
		sendChargeMail(settlementHist, member, server);
	}
	
	protected void setSettlementTrnsToHist(MemSettlementHist settlementHist, MemSettlementTrns settleTrns, MemberInfo member) {

		settlementHist.setSettlementTrnsNum(settleTrns.getSettlementTrnsNum());
		settlementHist.setSettlementCode(settleTrns.getSettlementCode());
		settlementHist.setMemNum(settleTrns.getMemNum());
		settlementHist.setMemAtbtCd(member.getMemAtbtCd());
		settlementHist.setTitleId(settleTrns.getTitleId());
		settlementHist.setServerId(settleTrns.getServerId());
		settlementHist.setPointId(settleTrns.getPointId());
		settlementHist.setSettlementDate(new Date());
		settlementHist.setPointAmount(settleTrns.getPointAmount());
		settlementHist.setPointAmountAct(settleTrns.getPointAmountAct());
		settlementHist.setSettlementLog(settleTrns.getSettlementLog());
		settlementHist.setCreatedUser(settleTrns.getCreatedUser());
		settlementHist.setCreatedDate(settlementHist.getSettlementDate());
	}

	/**
	 * 仮決済番号より、仮決済情報を取得する
	 */
	private MemSettlementTrns getSettlementTrnsForUpdate(Long settleTrnsNum) {

		MemSettlementTrns settleTrns = memSettlementTrnsDao.selectForUpdate(settleTrnsNum);
		
		if (settleTrns == null) {

			// データが存在しない
			throw new SystemException("MemSettlementTrns Data not exists.");
		}
		
		return settleTrns;
	}
	
	protected void updateMemberInfo(MemberInfo member) {
		
		memberInfoDao.update(member);
	}
	
	protected void saveSettlementHist(MemSettlementHist settlementHist) {
		
		memSettlementHistDao.save(settlementHist);
	}
	
	protected void sendChargeMail(MemSettlementHist settlementHist, MemberInfo member, ServerMst server) {
		
		try {
			
			// メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			props.put("nickName", member.getNickName());
			props.put("titleName", titleMstDao.selectNameById(settlementHist.getTitleId()));
			props.put("serverName", server.getServerName());
			props.put("point", settlementHist.getPointAmountAct().toString());
			
			templateMailer.sendAsyncMail(member.getMailPc(), "pointCharge", props, true);
			
		} catch (Exception ex) {
			
			logger.error("error has occurred in sending pointCharge mail. ", ex);
		}
	}
		
	private PointMst getPointMst(Integer pointId) {

		// チャージポイント情報を取得する
		PointMst pointMst = new PointMst();
		
		pointMst.setPointId(pointId);
		
		pointMst = pointMstDao.selectByKey(pointMst);
		
		if (pointMst == null) {

			// データが存在しない
			throw new SystemException("Data not exists.");
		}
		
		return pointMst;
	}
	
	private int checkByBirthday(MemSettlementTrns settlementTrns, PointMst pointMst, Date birthYmd) {

		int retCode = 0;
		
		// 会員生年月日が入力した場合
		if (birthYmd != null) {
			
			Calendar c = Calendar.getInstance();
			c.setTime(birthYmd);
			// 会員生年月日　+　18年
			c.add(Calendar.YEAR, 18);
			
			Date ageDate = c.getTime();
			
			// 18歳未満の方
			if (ageDate.compareTo(new Date()) > 0 ) {
				
				if (PortalConstants.SettlementCode.CREDIT.equals(settlementTrns.getSettlementCode())) {
					
					retCode = 1;
					
				} else {
					
					// 最近一ヶ月間チャージするポイントを計算する
					BigDecimal limitAmouont = memSettlementHistDao.selectAmountByMonth(null, settlementTrns.getMemNum());
					
					if (limitAmouont.add(pointMst.getPointAmountAct()).compareTo(limitAmountMin) > 0) {
						
						retCode = 2;
					}
				}
			}
		}
		
		return retCode;
	}
	
	private int checkForCreditCard(MemSettlementTrns settlementTrns, PointMst pointMst, Date memEntryDate) {

		int retCode = 0;

		// クレジットカード決済の場合、限度額のチェックを行う
		if (PortalConstants.SettlementCode.CREDIT.equals(settlementTrns.getSettlementCode())) {
			
			// 最近一ヶ月間チャージするポイントを計算する
			BigDecimal sumPointAmouont = getTheMonthAmountByCreditCard(settlementTrns.getMemNum());
			
			Calendar c = Calendar.getInstance();
			c.setTime(memEntryDate);
			// 会員登録から30日間、
			c.add(Calendar.DATE, 30);
			Date loginDate = c.getTime();
			
			// 登録の31日目から、一ヶ月間に購入できるポイントの限度額が100,000
			if (loginDate.compareTo(new Date()) <= 0) {
				
				if (sumPointAmouont.add(pointMst.getPointAmountAct()).compareTo(limitAmountMax) > 0) {
					
					retCode = 3;
				}
				
			// 登録からの30日間、一ヶ月間に購入できるポイントの限度額が30,000
			} else {
				
				if (sumPointAmouont.add(pointMst.getPointAmountAct()).compareTo(limitAmountMin) > 0) {
					
					retCode = 4;
				}
			}
		}
		
		return retCode;
	}
	
	protected BigDecimal getTheMonthAmountByCreditCard(Long memNum) {

		// 最近一ヶ月間チャージするポイントを計算する
		return memSettlementHistDao.selectAmountByMonth(PortalConstants.SettlementCode.CREDIT, memNum);
	}
	
	private void saveSettlementTrns(MemSettlementTrns settlementTrns, PointMst pointMst, String memAtbtCd) {

		// 仮決済を登録する
		settlementTrns.setMemAtbtCd(memAtbtCd);
		settlementTrns.setSettlementDate(new Date());
		settlementTrns.setPointAmount(pointMst.getPointAmount());
		settlementTrns.setPointAmountAct(pointMst.getPointAmountAct());
		settlementTrns.setSettlementLog(makeSettlementTrnsLog(settlementTrns));
		settlementTrns.setCreatedDate(settlementTrns.getSettlementDate());
		settlementTrns.setCreatedUser(String.valueOf(settlementTrns.getMemNum()));
		
		memSettlementTrnsDao.save(settlementTrns);
	}
	
	/**
	 * 決済ログを作成する
	 * @param settlementTrns 仮決済情報
	 * @return
	 */
	private String makeSettlementTrnsLog(MemSettlementTrns settlementTrns) {
		
		return new StringBuilder()
			.append(settlementTrns.getSettlementCode())
			.append(",")
			.append(settlementTrns.getMemNum())
			.append(",")
			.append(settlementTrns.getMemAtbtCd())
			.append(",")
			.append(settlementTrns.getTitleId())
			.append(",")
			.append(settlementTrns.getServerId())
			.append(",")
			.append(settlementTrns.getPointId())
			.append(",")
			.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(settlementTrns.getSettlementDate()))
			.append(",")
			.append(settlementTrns.getPointAmount())
			.append(",")
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
	
	private ServerMst getServerMst(Integer titleId, Integer serverId, String providerId) {
		
		ServerMst server = new ServerMst();
		
		server.setTitleId(titleId);
		server.setServerId(serverId);
		server.setProviderId(providerId);
		
		server = serverMstDao.selectByKey(server);
		
		if (server == null) {

			// データが存在しない
			throw new SystemException("Server Data does not exist.");
		}
		
		return server;
	}
	
	private void outputChargeLog(ChargeParameter params) {
		
		String chargeLog = new StringBuilder()
			.append(ContextUtil.getRequestBaseInfo())
			.append(" | External I/F--TitleCharge params: memnum=")
			.append(params.getMemNum())
			.append(", memId=")
			.append(params.getMemId())
			.append(", orderNo=")
			.append(params.getOrderNo())
			.append(", titleId=")
			.append(params.getTitleId())
			.append(", chargePoint=")
			.append(params.getChargePoint())
			.append(", chargeDate=")
			.append(params.getChargeDate())
			.append(", chargeUrl=")
			.append(params.getChargeUrl())
			.append(", spType=")
			.append(params.getSpType())
			.toString();
		
		logger.info(chargeLog);
	}
	
	private void outputChargeFailLog(int chargeRes) {
		
		String chargeLog = new StringBuilder()
			.append(ContextUtil.getRequestBaseInfo())
			.append(" | External I/F--TitleCharge Result: ")
			.append(chargeRes)
			.toString();
		
		logger.warn(chargeLog);
	}
	
	private void doCharge(MemSettlementHist settlementHist, MemberInfo member, ServerMst server) {

		// ポイント付与
		ChargeParameter params = new ChargeParameter();
		
		params.setMemNum(getMemberNumForIdentifyInTitle(member));
		params.setMemId(member.getMemId());
		params.setOrderNo(settlementHist.getSettlementNum());
		params.setTitleId(settlementHist.getTitleId());
		params.setServerId(settlementHist.getServerId());
		params.setChargePoint(settlementHist.getPointAmountAct().intValue());
		params.setChargeDate(settlementHist.getSettlementDate());
		params.setChargeUrl(server.getChargeUrl());
		params.setSpType(PortalConstants.ChargeSpType.ACCOUNT_POINT);

		// チャージを行う
		int chargeRes = titleCharge.chargePoint(params);
		
		if (chargeRes == ChargeConstants.Result.SUCCESS) {
			
			outputChargeLog(params);
			
		} else {
			
			outputChargeFailLog(chargeRes);
			
			throw new SystemException("Failed to charge.");
		}
	}
	
	protected Long getMemberNumForIdentifyInTitle(MemberInfo memberInfo) {
		
		return memberInfo.getMemNum();
	}

	/**
	 * サービスポイントを贈与する
	 * @param settlementHist
	 */
	@SuppressWarnings("unchecked")
	protected void presentServicePoint(MemSettlementHist settlementHist, MemberInfo member) {

		ServicePointTypeMst servicePointTypeMst = null;
		BigDecimal amount = null;

		FunctionControlInfo functionControlInfo = new FunctionControlInfo();
		functionControlInfo.setFunctionCode(PortalConstants.FunctionCode.CHARGE);
		
		functionControlInfo = functionControlInfoDao.selectByKey(functionControlInfo);
		
		// チャージするときに、サービスポイント付与機能が開放の場合、
		if (functionControlInfo == null || PortalConstants.FunctionServiceStatus.OFF.equals(functionControlInfo.getServiceStatus())) {
			// サービスポイントを贈与する
			return;
		}

		// 有効なサービスポイントを取得する(最近一ヶ月の累計課金金額が一定金額を超えた場合)
		if (PortalConstants.FunctionServiceStatus.ON.equals(functionControlInfo.getServiceStatus())) {

			HashMap params = new HashMap();
			params.put("servicePointTypeCd", PortalConstants.ServicePointTypeCd.CHARGE_PERCENT);
			params.put("titleId", settlementHist.getTitleId());
			params.put("memNum", settlementHist.getMemNum());
			params.put("chargeStartDate", functionControlInfo.getServiceStartDate());
			params.put("chargeEndDate", functionControlInfo.getServiceEndDate());
			
			servicePointTypeMst = servicePointTypeMstDao.selectChargePointRateForUpdate(params);
			
		// タイムセール、今回決済金額によって、固定額のサービスポイントを付与する
		} else if (PortalConstants.FunctionServiceStatus.CHARGE_FIX.equals(functionControlInfo.getServiceStatus())) {

			HashMap params = new HashMap();
			params.put("servicePointTypeCd", PortalConstants.ServicePointTypeCd.CHARGE_FIX);
			params.put("chargePoint", settlementHist.getPointAmountAct());
			
			servicePointTypeMst = servicePointTypeMstDao.selectChargeFixPointForUpdate(params);
		}

		if (servicePointTypeMst == null || servicePointTypeMst.getServicePointTypeId() == null) {
			
			return;
		}

		// 有効なサービスポイントを取得する(最近一ヶ月の累計課金金額が一定金額を超えた場合)
		if (PortalConstants.FunctionServiceStatus.ON.equals(functionControlInfo.getServiceStatus())) {
			
			amount = settlementHist.getPointAmountAct().multiply(servicePointTypeMst.getPointAmount()).divide(new BigDecimal(100));
			
		// タイムセール、今回決済金額によって、固定額のサービスポイントを付与する
		} else if (PortalConstants.FunctionServiceStatus.CHARGE_FIX.equals(functionControlInfo.getServiceStatus())) {
			
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
	public Integer countPlayHist(Long memNum, Integer titleId, Integer serverId) {
		
		return playHistDao.selectPlayHistCount(memNum, titleId, serverId);
	}

	@Override
	public List<MySettlementHist> getSettlementHistListByMemNum(Long memNum) {
		
		return memSettlementHistDao.selectSettlementHistListByMemNum(memNum);
	}

	/**
	 * 会員属性より、すべて決済情報を取得する
	 */
	@Override
	public List<SettlementMst> getSettlementListForCharge(Long memNum) {
		
		MemberInfo member = getMemberInfo(memNum);
		
		if (member != null && member.getMemAtbtCd().equals(PortalConstants.MemberAtbtCd.TEST)) {
			
			return settlementMstDao.selectAll(null);
			
		} else {
			
			return settlementMstDao.selectValidSettlementList();
		}
	}
	
	protected MemberInfo getMemberInfo(Long memNum) {
		
		MemberInfo member = new MemberInfo();
		member.setMemNum(memNum);
		return memberInfoDao.selectByKey(member);
	}

	public void setMemSettlementTrnsDao(IMemSettlementTrnsDao memSettlementTrnsDao) {
		this.memSettlementTrnsDao = memSettlementTrnsDao;
	}

	public void setMemSettlementHistDao(IMemSettlementHistDao memSettlementHistDao) {
		this.memSettlementHistDao = memSettlementHistDao;
	}

	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	public void setPointMstDao(IPointMstDao pointMstDao) {
		this.pointMstDao = pointMstDao;
	}

	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

	public void setServicePointTypeMstDao(
			IServicePointTypeMstDao servicePointTypeMstDao) {
		this.servicePointTypeMstDao = servicePointTypeMstDao;
	}

	public void setServicePointDao(IServicePointDao servicePointDao) {
		this.servicePointDao = servicePointDao;
	}

	public void setServicePointGiveHistDao(
			IServicePointGiveHistDao servicePointGiveHistDao) {
		this.servicePointGiveHistDao = servicePointGiveHistDao;
	}

	public void setTemplateMailer(TemplateMailer templateMailer) {
		this.templateMailer = templateMailer;
	}

	public void setTitleCharge(TitleCharge titleCharge) {
		this.titleCharge = titleCharge;
	}

	public void setPlayHistDao(IPlayHistDao playHistDao) {
		this.playHistDao = playHistDao;
	}

	public void setServerMstDao(IServerMstDao serverMstDao) {
		this.serverMstDao = serverMstDao;
	}

	public void setFunctionControlInfoDao(
			IFunctionControlInfoDao functionControlInfoDao) {
		this.functionControlInfoDao = functionControlInfoDao;
	}

	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}

	public void setLimitAmountMax(BigDecimal limitAmountMax) {
		this.limitAmountMax = limitAmountMax;
	}

	public void setLimitAmountMin(BigDecimal limitAmountMin) {
		this.limitAmountMin = limitAmountMin;
	}

	public IMemSettlementTrnsDao getMemSettlementTrnsDao() {
		return memSettlementTrnsDao;
	}

	public void setSettlementMstDao(ISettlementMstDao settlementMstDao) {
		this.settlementMstDao = settlementMstDao;
	}
}
