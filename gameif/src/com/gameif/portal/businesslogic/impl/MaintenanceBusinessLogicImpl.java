package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.BetaTestException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.MaintenanceException;
import com.gameif.portal.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IMaintenanceInfoDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.MaintenanceInfo;
import com.gameif.portal.entity.TitleMst;

public class MaintenanceBusinessLogicImpl extends BaseBusinessLogic implements
		IMaintenanceBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6729159308071707221L;
	
	private ITitleMstDao titleMstDao;
	private IMaintenanceInfoDao maintenanceInfoDao;

	/**
	 * メンテナンスチェックを行う
	 * @param titleId タイトルID
	 */
	@Override
	public void maintenanceCheckByTitleId(Integer titleId)
			throws LogicException {
		
		TitleMst title = titleMstDao.selectValidTitleByKey(titleId);
		if (title != null) {
			String status = title.getServiceStatus();
			// メンテナンス 中
			if (status.equals(PortalConstants.ServerStatus.MAINTENANCE)) {
				throw new MaintenanceException("title is in maintenance.");
			// CBT中
			} else if (status.equals(PortalConstants.ServerStatus.CBT)) {
				throw new BetaTestException("title is in CBT");
			}
		}
		
	}

	/**
	 * 各機能のメンテナンスチェック
	 * @param functionCd 機能コード
	 * @return true:メンテナンス中、false：メンテナンス無し
	 */
	@Override
	public Boolean maintenanceCheckByFunctionCd(String functionCd) {
		
		MaintenanceInfo mainten = maintenanceInfoDao.selectByFunctionCd(functionCd);
		if (mainten != null && mainten.getMaintenStatus().equals(PortalConstants.MaintenanceStatus.MAINTENANCE)) {
			return true;
		} else {
			return false;
		}
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
	 * @return the maintenanceInfoDao
	 */
	public IMaintenanceInfoDao getMaintenanceInfoDao() {
		return maintenanceInfoDao;
	}

	/**
	 * @param maintenanceInfoDao the maintenanceInfoDao to set
	 */
	public void setMaintenanceInfoDao(IMaintenanceInfoDao maintenanceInfoDao) {
		this.maintenanceInfoDao = maintenanceInfoDao;
	}
}
