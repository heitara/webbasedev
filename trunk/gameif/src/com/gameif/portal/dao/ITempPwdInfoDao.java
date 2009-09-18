package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.TempPwdInfo;

public interface ITempPwdInfoDao extends IBaseDao<TempPwdInfo, TempPwdInfo> {
	
	public Integer deleteByMemNum(Long memNum);

}
