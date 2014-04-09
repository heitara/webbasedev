package com.gameif.payment.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.AdvertAgencyMst;

public interface IAdvertAgencyMstDao extends IBaseDao<AdvertAgencyMst, AdvertAgencyMst> {
	
	public AdvertAgencyMst selectByAdvertNum(Integer advertNum);

}
