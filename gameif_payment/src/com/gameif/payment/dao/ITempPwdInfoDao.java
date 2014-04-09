package com.gameif.payment.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.TempPwdInfo;

public interface ITempPwdInfoDao extends IBaseDao<TempPwdInfo, TempPwdInfo> {
	
	public Integer deleteByMemNum(Long memNum);
	public TempPwdInfo selectByMemNumAndTempKey(TempPwdInfo tempPwdInfo);

}
