package com.gameif.payment.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.ISettlementMstDao;
import com.gameif.payment.entity.SettlementMst;

public class SettlementMstDaoImpl extends AbstractBaseDao<SettlementMst, SettlementMst>
implements ISettlementMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SettlementMst> selectValidSettlementList() {
		
		return (List<SettlementMst>)this.getSqlMapClientTemplate().queryForList(namespace + ".selectValidSettlementList");
	}

}
