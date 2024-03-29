package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemAdvertActualInfo;

public interface IMemAdvertActualInfoDao extends IBaseDao<MemAdvertActualInfo, MemAdvertActualInfo> {
	public MemAdvertActualInfo selectMemAdvertActualInfoByMemNum(Long memNum);
}
