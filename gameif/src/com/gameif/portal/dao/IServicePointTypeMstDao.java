package com.gameif.portal.dao;

import java.util.HashMap;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.ServicePointTypeMst;

public interface IServicePointTypeMstDao extends IBaseDao<ServicePointTypeMst, ServicePointTypeMst> {
	
	public ServicePointTypeMst selectValidGameloginPoint(String servicePointTypeCd, Integer standardLevel);
	
	@SuppressWarnings("unchecked")
	public ServicePointTypeMst selectChargePointRate(HashMap params);

}
