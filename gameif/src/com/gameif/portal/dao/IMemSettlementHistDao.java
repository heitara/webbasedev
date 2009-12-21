package com.gameif.portal.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MySettlementHist;

public interface IMemSettlementHistDao extends IBaseDao<MemSettlementHist, MemSettlementHist> {
	
	public BigDecimal selectAmountByMonth(String settlementCode, Long memNum);
	public List<MySettlementHist> selectSettlementHistListByMemNum(Long memNum);

}
