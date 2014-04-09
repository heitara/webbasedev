package com.gameif.payment.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MySPInfo;
import com.gameif.payment.entity.ServicePoint;

public interface IServicePointDao extends IBaseDao<ServicePoint, ServicePoint> {
	
	public ServicePoint selectForUpdate(ServicePoint servicePoint);
	public List<MySPInfo> selectMyServicePointList(Long memNum);
	public BigDecimal selectBalanceByTitle(Integer titleId, Long memNum);

}
