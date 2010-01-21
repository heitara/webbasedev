package com.gameif.backoffice.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.backoffice.bean.SalesSearchCondition;
import com.gameif.backoffice.entity.MemSettlementHist;
import com.gameif.backoffice.entity.MySettlementList;
import com.gameif.common.dao.IBaseDao;

public interface IMemSettlementHistDao extends IBaseDao<MemSettlementHist, MemSettlementHist> {
	
	public List<MySettlementList> selectPersonDayList(SalesSearchCondition salesSearchConditoin);
	public List<MySettlementList> selectPersonMonthList(SalesSearchCondition salesSearchConditoin);
	public List<MySettlementList> selectTitleDayList(SalesSearchCondition salesSearchConditoin);
	public List<MySettlementList> selectTitleMonthList(SalesSearchCondition salesSearchConditoin);
	public BigDecimal selectPersonDayTotal(SalesSearchCondition salesSearchConditoin);
	public BigDecimal selectPersonMonthTotal(SalesSearchCondition salesSearchConditoin);
	public BigDecimal selectTitleDayTotal(SalesSearchCondition salesSearchConditoin);
	public BigDecimal selectTitleMonthTotal(SalesSearchCondition salesSearchConditoin);

}
