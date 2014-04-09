package com.gameif.payment.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MemSettlementHist;
import com.gameif.payment.entity.MySettlementHist;

public interface IMemSettlementHistDao extends IBaseDao<MemSettlementHist, MemSettlementHist> {
	
	public BigDecimal selectAmountByMonth(String settlementCode, Long memNum);
	public List<MySettlementHist> selectSettlementHistListByMemNum(Long memNum);

}
