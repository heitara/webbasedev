package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.AdvertAgencyMst;

public interface IAdvertAgencyMstDao extends IBaseDao<AdvertAgencyMst, AdvertAgencyMst> {
	
	public AdvertAgencyMst selectByAdvertNum(Integer advertNum);

}
