package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IOpensocialSettlementHistDao;
import com.gameif.portal.entity.MySettlementHist;
import com.gameif.portal.entity.OpensocialSettlementHist;

public class OpensocialSettlementHistDaoImpl extends AbstractBaseDao<OpensocialSettlementHist, OpensocialSettlementHist>
implements IOpensocialSettlementHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MySettlementHist> selectSettlementHistListByMemNum(Long memNum) {
		
		return (List<MySettlementHist>)getSqlMapClientTemplate().queryForList(namespace + ".selectSettlementHistListByMemNum", memNum);
	}
}