package com.gameif.payment.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.payment.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.payment.constants.PortalConstants;
import com.gameif.payment.dao.IMaintenanceInfoDao;
import com.gameif.payment.entity.MaintenanceInfo;

public class MaintenanceBusinessLogicImpl extends BaseBusinessLogic implements
		IMaintenanceBusinessLogic {

	private static final long serialVersionUID = 6729159308071707221L;
	
	private IMaintenanceInfoDao maintenanceInfoDao;

	/**
	 * 各機能のメンテナンスチェック
	 * @param functionCd 機能コード
	 * @return true:メンテナンス中、false：メンテナンス無し
	 */
	@Override
	public Boolean maintenanceCheckByFunctionCd(String functionCd) {
		
		Boolean bReturn = true;
		MaintenanceInfo mainten = maintenanceInfoDao.selectByFunctionCd(functionCd);
		
		if (mainten != null) {
			
			// メンテナンス中
			if (mainten.getMaintenStatus().equals(PortalConstants.MaintenanceStatus.MAINTENANCE)) {
				
				bReturn = true;
				
			// 稼動中
			} else if (mainten.getMaintenStatus().equals(PortalConstants.MaintenanceStatus.RUNNING)) {
				
				bReturn = false;
			}
		}
		
		return bReturn;
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