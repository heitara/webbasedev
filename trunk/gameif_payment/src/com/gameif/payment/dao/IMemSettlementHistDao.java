package com.gameif.payment.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.Settlement;
import com.gameif.payment.entity.MySettlementHist;

public interface IMemSettlementHistDao extends IBaseDao<Settlement, Settlement> {
	
	public BigDecimal selectAmountByMonth(String settlementCode, Long memNum);
	public List<MySettlementHist> selectSettlementHistListByMemNum(Long memNum);

}
