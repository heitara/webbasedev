package com.gameif.portal.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemSettlementHistDao;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MySettlementHist;

public class MemSettlementHistDaoImpl extends AbstractBaseDao<MemSettlementHist, MemSettlementHist>
	implements IMemSettlementHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal selectAmountByMonth(String settlementCode, Long memNum) {
		
		HashMap params = new HashMap();
		
		params.put("settlementCode", settlementCode);
		params.put("memNum", memNum);
		
		return (BigDecimal)getSqlMapClientTemplate().queryForObject(namespace + ".selectAmountByMonth", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MySettlementHist> selectSettlementHistListByMemNum(Long memNum) {
		
		return (List<MySettlementHist>)getSqlMapClientTemplate().queryForList(namespace + ".selectSettlementHistListByMemNum", memNum);
	}

}
