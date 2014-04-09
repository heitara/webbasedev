package com.gameif.payment.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IAdvertMstDao;
import com.gameif.payment.entity.AdvertMst;

public class AdvertMstDaoImpl extends AbstractBaseDao<AdvertMst, AdvertMst>
		implements IAdvertMstDao {

	/**
	 * 現時点で有効な広告マスタを取得する
	 */
	@Override
	public AdvertMst selectAdvertByKey(Integer advertNum) {
		
		return (AdvertMst) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectAdvertByKey", advertNum);
	}

}
