package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.BetaTestException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.MaintenanceException;
import com.gameif.portal.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.TitleMst;

public class MaintenanceBusinessLogicImpl extends BaseBusinessLogic implements
		IMaintenanceBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6729159308071707221L;
	
	private ITitleMstDao titleMstDao;

	/**
	 * メンテナンスチェックを行う
	 * @param titleId タイトルID
	 */
	@Override
	public void maintenanceCheckByTitleId(Integer titleId)
			throws LogicException {
		
		TitleMst title = new TitleMst();
		title = titleMstDao.selectValidTitleByKey(titleId);
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
