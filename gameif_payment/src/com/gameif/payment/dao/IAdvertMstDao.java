package com.gameif.payment.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.AdvertMst;

public interface IAdvertMstDao extends IBaseDao<AdvertMst, AdvertMst> {
	
	public AdvertMst selectAdvertByKey(Integer advertNum);

}
