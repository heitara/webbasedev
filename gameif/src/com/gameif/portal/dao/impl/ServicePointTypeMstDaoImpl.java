package com.gameif.portal.dao.impl;

import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IServicePointTypeMstDao;
import com.gameif.portal.entity.ServicePointTypeMst;

public class ServicePointTypeMstDaoImpl extends
		AbstractBaseDao<ServicePointTypeMst, ServicePointTypeMst> implements
		IServicePointTypeMstDao {

	/**
	 * 有効なサービスポイントを検索する
	 * @param servicePointTypeCd サービスポイント区別
	 * @param loginCount 連続してゲームにログイン回数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ServicePointTypeMst selectValidGameloginPoint(Integer servicePointTypeCd, Integer standardLevel) {
		
		HashMap params = new HashMap();
		
		params.put("servicePointTypeCode", servicePointTypeCd);
		params.put("standardLevel", standardLevel);
		
		return (ServicePointTypeMst) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectValidGameloginPoint", params);
	}

	/**
	 * 都度購入サービスポイントのレートを取得する
	 * @param servicePointTypeCd サービスポイント区別
	 * @param titleId タイトルID
	 * @param memNum 会員番号
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ServicePointTypeMst selectChargePointRateForUpdate(HashMap params) {
		
		return (ServicePointTypeMst) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectChargePointRateForUpdate", params);
	}

}
