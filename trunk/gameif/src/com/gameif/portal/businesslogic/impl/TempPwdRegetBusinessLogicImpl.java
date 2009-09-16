package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.ITempPwdRegetBusinessLogic;
import com.gameif.portal.dao.ITempPwdInfoDao;
import com.gameif.portal.entity.TempPwdInfo;

public class TempPwdRegetBusinessLogicImpl extends BaseBusinessLogic implements ITempPwdRegetBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5764703108289976473L;
	
	private ITempPwdInfoDao tempPwdInfoDao;

	/**
	 * @return the tempPwdInfoDao
	 */
	public ITempPwdInfoDao getTempPwdInfoDao() {
		return tempPwdInfoDao;
	}


	/**
	 * @param tempPwdInfoDao the tempPwdInfoDao to set
	 */
	public void setTempPwdInfoDao(ITempPwdInfoDao tempPwdInfoDao) {
		this.tempPwdInfoDao = tempPwdInfoDao;
	}


	@Override
	public void saveTempPwdInfo(TempPwdInfo tempPwdInfo) {
		
	}

}
