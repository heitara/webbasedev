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
import com.gameif.common.exception.OutOfMaxCountException;
import com.gameif.common.exception.SystemException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.portal.businesslogic.IServicePointBusinessLogic;
import com.gameif.portal.businesslogic.titleif.charge.ChargeConstants;
import com.gameif.portal.businesslogic.titleif.charge.ChargeParameter;
import com.gameif.portal.businesslogic.titleif.charge.TitleCharge;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IGameLoginCountDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.dao.IServerMstDao;
import com.gameif.portal.dao.IServicePointDao;
import com.gameif.portal.dao.IServicePointGiveHistDao;
import com.gameif.portal.dao.IServicePointTypeMstDao;
import com.gameif.portal.dao.IServicePointUseHistDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.GameLoginCount;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.MySPGiveHist;
import com.gameif.portal.entity.MySPInfo;
import com.gameif.portal.entity.MySPUseHist;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.entity.ServicePoint;
import com.gameif.portal.entity.ServicePointGiveHist;
import com.gameif.portal.entity.ServicePointTypeMst;
import com.gameif.portal.entity.ServicePointUseHist;
import com.gameif.portal.util.ContextUtil;

public class ServicePointBusinessLogicImpl extends BaseBusinessLogic implements
		IServicePointBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7841256358571690329L;
	
	private final static Log logger = LogFactory.getLog(ServicePointBusinessLogicImpl.class);

	private IGameLoginCountDao gameLoginCountDao;
	private IServicePointTypeMstDao servicePointTypeMstDao;
	private IServicePointDao servicePointDao;
	private IServicePointGiveHistDao servicePointGiveHistDao;
	private TemplateMailer templateMailer;
	private ITitleMstDao titleMstDao;
	private IServicePointUseHistDao servicePointUseHistDao;
	private IServerMstDao serverMstDao;
	private TitleCharge titleCharge;
	private IMemberInfoDao memberInfoDao;
	
	// 有効期間
	private Integer validDays;

	/**
	 * サービスポイント受取を行う
	 * @param titleId タイトルID
	 */
	@Transactional
	@Override
	public void getGameLoginServicePoint(Integer titleId) throws LogicException {
		
		// サービスポイントが貰えるかどうかのチェック
		GameLoginCount gameLoginCount = gameLoginCountDao.selectByKeyForUpdate(ContextUtil.getMemberNo(), titleId);
		if (gameLoginCount == null) {
			
			// データが存在しない
			throw new DataNotExistsException("Data does not exist!!");
		}
		
		// 有効なサービスポイントを取得する
		ServicePointTypeMst servicePointTypeMst = servicePointTypeMstDao.
													selectValidGameloginPoint(PortalConstants.ServicePointTypeCd.GAME_LOGIN, 
																			  gameLoginCount.getGameLoginCount());
		if (servicePointTypeMst == null || servicePointTypeMst.getServicePointTypeId() == null) {
			
			// データが存在しない
			throw new DataNotExistsException("Data does not exist!");
			
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
		servicePoint.setTitleId(titleId);
		// 有効なデータが存在かどうか
		servicePoint = servicePointDao.selectForUpdate(servicePoint);
		if (servicePoint == null) {
			
			servicePoint = new ServicePoint();
			
			servicePoint.setMemNum(ContextUtil.getMemberNo());
			servicePoint.setPointEndDate(endDate);
			servicePoint.setTitleId(titleId);
			servicePoint.setPointAmount(servicePointTypeMst.getPointAmount());
			servicePoint.setCreatedDate(giveDate);
			servicePoint.setCreatedUser(ContextUtil.getMemberNo().toString());
			servicePoint.setLastUpdateDate(giveDate);
			servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());
			
			// サービスポイント残高テーブルに登録する
			servicePointDao.save(servicePoint);
		} else {
			// 既に期限切れました
			if (giveDate.compareTo(servicePoint.getPointEndDate()) > 0) {
				// 残高 = 今回のポイント数
				servicePoint.setPointAmount(servicePointTypeMst.getPointAmount());
			} else {
				// 残高 = 元の残高 + 今回のポイント数
				servicePoint.setPointAmount(servicePoint.getPointAmount().add(servicePointTypeMst.getPointAmount()));
			}
			servicePoint.setPointEndDate(endDate);
			servicePoint.setLastUpdateDate(giveDate);
			servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());
			
			// 残高を更新する
			servicePointDao.update(servicePoint);
		}
		
		// サービスポイント贈与履歴
		ServicePointGiveHist servicePointGiveHist = new ServicePointGiveHist();
		servicePointGiveHist.setMemNum(ContextUtil.getMemberNo());
		servicePointGiveHist.setServicePointTypeId(servicePointTypeMst.getServicePointTypeId());
		servicePointGiveHist.setServicePointTypeCd(PortalConstants.ServicePointTypeCd.GAME_LOGIN);
		servicePointGiveHist.setTitleId(titleId);
		servicePointGiveHist.setGiveDate(giveDate);
		servicePointGiveHist.setPointEndDate(endDate);
		servicePointGiveHist.setPointAmount(servicePointTypeMst.getPointAmount());
		servicePointGiveHist.setCreatedDate(giveDate);
		servicePointGiveHist.setCreatedUser(ContextUtil.getMemberNo().toString());
		servicePointGiveHist.setLastUpdateDate(giveDate);
		servicePointGiveHist.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		
		// サービスポイント贈与履歴テーブルに登録する
		servicePointGiveHistDao.save(servicePointGiveHist);
		
		// ゲームログイン回数を「０」に設定する
		gameLoginCount.setGameLoginCount(0);
		gameLoginCount.setLastUpdateDate(giveDate);
		gameLoginCount.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		// ゲームログイン回数を更新する
		gameLoginCountDao.update(gameLoginCount);

		try {
			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 名前
			props.put("nickName", ContextUtil.getNickName());
			// ゲーム
			props.put("titleName", titleMstDao.selectNameById(titleId));
			// データID
			props.put("point", servicePointTypeMst.getPointAmount().toString());
			// 送信
			templateMailer.sendAsyncMail(ContextUtil.getMemberInfo().getMailPc(), "presentServicePoint", props, true);
		} catch (Exception ex) {
			logger.error("error has occurred in sending presentServicePoint mail. ", ex);
		}
		
	}

	/**
	 * サービスポイントを利用する
	 */
	@Transactional
	@Override
	public void useServicePoint(Integer titleId, Integer serverId, BigDecimal pointAmount) throws LogicException {
		
		// サービスポイント残高情報を取得する(ForUpdate)
		ServicePoint servicePoint = new ServicePoint();
		servicePoint.setMemNum(ContextUtil.getMemberNo());
		servicePoint.setTitleId(titleId);
		servicePoint = servicePointDao.selectForUpdate(servicePoint);
		if (servicePoint == null) {
			// データが存在しない
			throw new DataNotExistsException("ServicePoint Data does not exist!");
		}
		
		if (0 < pointAmount.compareTo(servicePoint.getPointAmount())) {

			// データが存在しない
			throw new OutOfMaxCountException("ServicePoint is not enough.");
			
		}
		
		MemberInfo member = new MemberInfo();
		member = memberInfoDao.selectForUpdate(ContextUtil.getMemberNo());
		if (member == null) {
			// データが存在しない
			throw new DataNotExistsException("MemberInfo Data does not exist!");
		}
		
		Date now = new Date();
		
		// サービスポイント = 残高 - 今回使うポイント
		servicePoint.setPointAmount(servicePoint.getPointAmount().subtract(pointAmount));
		servicePoint.setLastUpdateDate(now);
		servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		// サービスポイント情報を更新する
		servicePointDao.update(servicePoint);
		
		ServicePointUseHist servicePointUseHist = new ServicePointUseHist();
		servicePointUseHist.setMemNum(ContextUtil.getMemberNo());
		servicePointUseHist.setTitleId(titleId);
		servicePointUseHist.setServerId(serverId);
		servicePointUseHist.setUseDate(now);
		servicePointUseHist.setPointAmount(pointAmount);
		servicePointUseHist.setCreatedDate(now);
		servicePointUseHist.setCreatedUser(ContextUtil.getMemberNo().toString());
		servicePointUseHist.setLastUpdateDate(now);
		servicePointUseHist.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		// サービスポイント利用履歴を保存する
		servicePointUseHistDao.save(servicePointUseHist);

		// ポイントチャージ
		ChargeParameter params = new ChargeParameter();
		params.setMemNum(ContextUtil.getMemberNo());
		params.setMemId(ContextUtil.getAccountId());
		params.setOrderNo(servicePointUseHist.getServicePointUseNo());
		params.setTitleId(titleId);
		params.setServerId(serverId);
		params.setChargePoint(pointAmount.intValue());
		params.setChargeDate(now);

		ServerMst server = new ServerMst();
		server.setTitleId(titleId);
		server.setServerId(serverId);
		server.setProviderId(PortalConstants.ProviderKind.PORTAL);
		server = serverMstDao.selectByKey(server);
		if (server == null) {

			// データが存在しない
			throw new SystemException("Server Data does not exist.");
		}

		params.setChargeUrl(server.getChargeUrl());
		params.setSpType(PortalConstants.ChargeSpType.SERVICE_POINT);
		
		// チャージを行う
		int chargeRes = titleCharge.chargePoint(params);
		if (chargeRes != ChargeConstants.Result.SUCCESS) {
			throw new SystemException("Failed to charge.");
		}

		try {
			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 名前
			props.put("nickName", ContextUtil.getNickName());
			// ゲーム
			props.put("titleName", titleMstDao.selectNameById(titleId));
			// サーバ
			props.put("serverName", server.getServerName());
			// データID
			props.put("point",pointAmount.toString());
			// 送信
			templateMailer.sendAsyncMail(member.getMailPc(), "pointCharge", props, true);
		} catch (Exception ex) {
			logger.error("error has occurred in sending pointCharge mail. ", ex);
		}
		
	}

	/**
	 * サービスポイント消費履歴一覧を取得する
	 */
	@Override
	public List<MySPUseHist> getMyUseHistList() {
		return servicePointUseHistDao.selectMyUseHistList(ContextUtil.getMemberNo());
	}

	/**
	 * サービスポイント付与履歴一覧を取得する
	 */
	@Override
	public List<MySPGiveHist> getMyGiveHistList() {
		return servicePointGiveHistDao.selectMyGiveHistList(ContextUtil.getMemberNo());
	}

	/**
	 * サービスポイント残高履歴一覧を取得する
	 */
	@Override
	public List<MySPInfo> getMyServicePointList() {
		return servicePointDao.selectMyServicePointList(ContextUtil.getMemberNo());
	}

	@Override
	public BigDecimal getBalanceByTitle(Integer titleId, Long memNum) {
		
		return servicePointDao.selectBalanceByTitle(titleId, memNum);
	}

	/**
	 * @return the gameLoginCountDao
	 */
	public IGameLoginCountDao getGameLoginCountDao() {
		return gameLoginCountDao;
	}

	/**
	 * @param gameLoginCountDao
	 *            the gameLoginCountDao to set
	 */
	public void setGameLoginCountDao(IGameLoginCountDao gameLoginCountDao) {
		this.gameLoginCountDao = gameLoginCountDao;
	}

	/**
	 * @return the servicePointTypeMstDao
	 */
	public IServicePointTypeMstDao getServicePointTypeMstDao() {
		return servicePointTypeMstDao;
	}

	/**
	 * @param servicePointTypeMstDao the servicePointTypeMstDao to set
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

	/**
	 * @param servicePointUseHistDao the servicePointUseHistDao to set
	 */
	public void setServicePointUseHistDao(
			IServicePointUseHistDao servicePointUseHistDao) {
		this.servicePointUseHistDao = servicePointUseHistDao;
	}

	/**
	 * @param serverMstDao the serverMstDao to set
	 */
	public void setServerMstDao(IServerMstDao serverMstDao) {
		this.serverMstDao = serverMstDao;
	}

	/**
	 * @param titleCharge the titleCharge to set
	 */
	public void setTitleCharge(TitleCharge titleCharge) {
		this.titleCharge = titleCharge;
	}

	/**
	 * @param memberInfoDao the memberInfoDao to set
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
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
