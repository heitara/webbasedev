package com.gameif.portal.businesslogic.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.portal.businesslogic.IServicePointBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IGameLoginCountDao;
import com.gameif.portal.dao.IServicePointDao;
import com.gameif.portal.dao.IServicePointGiveHistDao;
import com.gameif.portal.dao.IServicePointTypeMstDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.GameLoginCount;
import com.gameif.portal.entity.ServicePoint;
import com.gameif.portal.entity.ServicePointGiveHist;
import com.gameif.portal.entity.ServicePointTypeMst;
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
		ServicePointTypeMst servicePointTypeMst = servicePointTypeMstDao.selectValidGameloginPoint(PortalConstants.ServicePointTypeCd.GAME_LOGIN, gameLoginCount.getGameLoginCount());
		if (servicePointTypeMst == null || servicePointTypeMst.getServicePointTypeId() == null) {
			
			// データが存在しない
			throw new DataNotExistsException("Data does not exist!!");
			
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
		servicePoint.setGiveDate(giveDate);
		// 有効なデータが存在かどうか
		servicePoint = servicePointDao.selectByTitleAndMemnumForUpdate(servicePoint);
		if (servicePoint == null) {
			
			servicePoint = new ServicePoint();
			
			servicePoint.setMemNum(ContextUtil.getMemberNo());
			servicePoint.setGiveDate(giveDate);
			servicePoint.setPointStartDate(giveDate);
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
			// 残高 = 元の残高 + 今回のポイント数
			servicePoint.setPointAmount(servicePoint.getPointAmount().add(servicePointTypeMst.getPointAmount()));
			servicePoint.setPointEndDate(endDate);
			servicePoint.setLastUpdateDate(giveDate);
			servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());
			
			// 残高を更新する
			servicePointDao.update(servicePoint);
		}
		
		// サービスポイント贈与履歴
		ServicePointGiveHist servicePointGiveHist = new ServicePointGiveHist();
		servicePointGiveHist.setMemNum(ContextUtil.getMemberNo());
		servicePointGiveHist.setServicePointNo(servicePoint.getServicePointNo());
		servicePointGiveHist.setServicePointTypeId(servicePointTypeMst.getServicePointTypeId());
		servicePointGiveHist.setTitleId(titleId);
		servicePointGiveHist.setGiveDate(giveDate);
		servicePointGiveHist.setPointStartDate(giveDate);
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
