package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemSettlementTrnsDao;
import com.gameif.portal.entity.MemSettlementTrns;

public class MemSettlementTrnsDaoImpl extends AbstractBaseDao<MemSettlementTrns, MemSettlementTrns>
		implements IMemSettlementTrnsDao {
	
	/**
	 * 会員番号でロック状態で会員情報を取得する。
	 * 
	 * @param memNum
	 *            会員番号
	 * @return　会員情報
	 */
	@Override
	public MemSettlementTrns selectForUpdate(Long settleTrnsNum) {

		return (MemSettlementTrns) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectForUpdate", settleTrnsNum));
	}

	@Override
	public int deleteByKey(Long settleTrnsNum) {

		return getSqlMapClientTemplate().delete(namespace + ".deleteByKey", settleTrnsNum);
	}

}
