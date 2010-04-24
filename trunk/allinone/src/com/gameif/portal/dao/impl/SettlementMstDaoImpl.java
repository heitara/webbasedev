package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.ISettlementMstDao;
import com.gameif.portal.entity.SettlementMst;

public class SettlementMstDaoImpl extends AbstractBaseDao<SettlementMst, SettlementMst>
implements ISettlementMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SettlementMst> selectValidSettlementList() {
		
		return (List<SettlementMst>)this.getSqlMapClientTemplate().queryForList(namespace + ".selectValidSettlementList");
	}

}
