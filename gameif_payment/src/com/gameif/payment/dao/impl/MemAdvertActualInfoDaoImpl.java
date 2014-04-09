package com.gameif.payment.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IMemAdvertActualInfoDao;
import com.gameif.payment.entity.MemAdvertActualInfo;

public class MemAdvertActualInfoDaoImpl extends
		AbstractBaseDao<MemAdvertActualInfo, MemAdvertActualInfo> implements
		IMemAdvertActualInfoDao {

	@Override
	public MemAdvertActualInfo selectMemAdvertActualInfoByMemNum(Long memNum) {
		return (MemAdvertActualInfo) (getSqlMapClientTemplate().queryForObject(namespace + ".selectMemAdvertActualInfoByMemNum", memNum));
	}

}
