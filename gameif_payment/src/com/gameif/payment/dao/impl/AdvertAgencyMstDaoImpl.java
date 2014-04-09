package com.gameif.payment.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IAdvertAgencyMstDao;
import com.gameif.payment.entity.AdvertAgencyMst;

public class AdvertAgencyMstDaoImpl extends
		AbstractBaseDao<AdvertAgencyMst, AdvertAgencyMst> implements
		IAdvertAgencyMstDao {

	/**
	 * 広告番号より、広告代理店を検索する
	 * @param advertNum 広告番号
	 */
	@Override
	public AdvertAgencyMst selectByAdvertNum(Integer advertNum) {
		
		return (AdvertAgencyMst) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectByAdvertNum", advertNum);
	}

}
