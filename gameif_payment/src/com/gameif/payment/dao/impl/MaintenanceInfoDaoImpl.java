package com.gameif.payment.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IMaintenanceInfoDao;
import com.gameif.payment.entity.MaintenanceInfo;

public class MaintenanceInfoDaoImpl extends AbstractBaseDao<MaintenanceInfo, MaintenanceInfo> implements IMaintenanceInfoDao {

	/**
	 * 機能コードより、メンテナンス情報を取得する
	 * @param functionCd 機能コード
	 */
	@Override
	public MaintenanceInfo selectByFunctionCd(String functionCd) {

		return (MaintenanceInfo) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectByFunctionCd", functionCd));
	}

}
