package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IServicePointBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IGameLoginCountDao;
import com.gameif.portal.dao.IServicePointDao;
import com.gameif.portal.dao.IServicePointGiveHistDao;
import com.gameif.portal.dao.IServicePointTypeMstDao;
import com.gameif.portal.entity.GameLoginCount;
import com.gameif.portal.entity.ServicePoint;
import com.gameif.portal.entity.ServicePointGiveHist;
import com.gameif.portal.entity.ServicePointTypeMst;

public class ServicePointBusinessLogicImpl extends BaseBusinessLogic implements
		IServicePointBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7841256358571690329L;

	private IGameLoginCountDao gameLoginCountDao;
	private IServicePointTypeMstDao servicePointTypeMstDao;
	private IServicePointDao servicePointDao;
	private IServicePointGiveHistDao servicePointGiveHistDao;

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
		
		ServicePoint servicePoint = new ServicePoint();
		servicePoint.setGiveDate(giveDate);
		servicePoint.setPointStartDate(giveDate);
		servicePoint.setPointEndDate(giveDate);
		servicePoint.setTitleId(titleId);
		servicePoint.setPointAmount(servicePointTypeMst.getPointAmount());
		servicePoint.setCreatedDate(giveDate);
		servicePoint.setCreatedUser(ContextUtil.getMemberNo().toString());
		servicePoint.setLastUpdateDate(giveDate);
		servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		
		// サービスポイント残高テーブルに登録する
		servicePointDao.save(servicePoint);
		
		ServicePointGiveHist servicePointGiveHist = new ServicePointGiveHist();
		servicePointGiveHist.setServicePointNo(servicePoint.getServicePointNo());
		servicePointGiveHist.setServicePointTypeId(servicePointTypeMst.getServicePointTypeId());
		servicePointGiveHist.setTitleId(titleId);
		servicePointGiveHist.setGiveDate(giveDate);
		servicePointGiveHist.setPointStartDate(giveDate);
		servicePointGiveHist.setPointEndDate(giveDate);
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

}
