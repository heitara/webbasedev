package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.ServicePointTypeMst;

public interface IServicePointTypeMstDao extends IBaseDao<ServicePointTypeMst, ServicePointTypeMst> {
	
	public ServicePointTypeMst selectValidGameloginPoint(String servicePointTypeCd, Integer standardLevel);
	
	public ServicePointTypeMst selectChargePointRate(String servicePointTypeCd, Integer titleId, Long memNum);

}
