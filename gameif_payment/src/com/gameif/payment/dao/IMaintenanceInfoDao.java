package com.gameif.payment.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MaintenanceInfo;

public interface IMaintenanceInfoDao extends IBaseDao<MaintenanceInfo, MaintenanceInfo> {
	
	public MaintenanceInfo selectByFunctionCd(String functionCd);

}
