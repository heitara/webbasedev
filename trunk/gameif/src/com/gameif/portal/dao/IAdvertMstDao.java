package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.AdvertMst;

public interface IAdvertMstDao extends IBaseDao<AdvertMst, AdvertMst> {
	
	public AdvertMst selectValidAdvertByKey(Integer advertNum);

}
