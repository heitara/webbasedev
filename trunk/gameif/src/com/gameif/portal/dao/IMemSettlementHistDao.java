package com.gameif.portal.dao;

import java.math.BigDecimal;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemSettlementHist;

public interface IMemSettlementHistDao extends IBaseDao<MemSettlementHist, MemSettlementHist> {
	
	public BigDecimal selectAmountByMonth(String settlementCode, Long memNum);

}
