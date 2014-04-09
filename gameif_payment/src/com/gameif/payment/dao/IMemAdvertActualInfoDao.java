package com.gameif.payment.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MemAdvertActualInfo;

public interface IMemAdvertActualInfoDao extends IBaseDao<MemAdvertActualInfo, MemAdvertActualInfo> {
	public MemAdvertActualInfo selectMemAdvertActualInfoByMemNum(Long memNum);
}
