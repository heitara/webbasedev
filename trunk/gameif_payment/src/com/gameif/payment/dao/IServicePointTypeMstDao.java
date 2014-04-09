package com.gameif.payment.dao;

import java.util.HashMap;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.ServicePointTypeMst;

public interface IServicePointTypeMstDao extends IBaseDao<ServicePointTypeMst, ServicePointTypeMst> {
	
	public ServicePointTypeMst selectValidGameloginPoint(Integer servicePointTypeCd, Integer standardLevel);
	
	@SuppressWarnings("unchecked")
	public ServicePointTypeMst selectChargePointRateForUpdate(HashMap params);

	@SuppressWarnings("unchecked")
	public ServicePointTypeMst selectChargeFixPointForUpdate(HashMap params);

}
