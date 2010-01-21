package com.gameif.backoffice.businesslogic;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.backoffice.bean.SalesSearchCondition;
import com.gameif.backoffice.entity.MySettlementList;
import com.gameif.backoffice.entity.PointMst;

public interface ISalesBusinessLogic {

	public List<PointMst> getPointListByTitleId(Integer titleId);
	public List<MySettlementList> getPersonDayList(SalesSearchCondition salesSearchConditoin);
	public List<MySettlementList> getPersonMonthList(SalesSearchCondition salesSearchConditoin);
	public List<MySettlementList> getTitleDayList(SalesSearchCondition salesSearchConditoin);
	public List<MySettlementList> getTitleMonthList(SalesSearchCondition salesSearchConditoin);
	public BigDecimal getPersonDayTotal(SalesSearchCondition salesSearchConditoin);
	public BigDecimal getPersonMonthTotal(SalesSearchCondition salesSearchConditoin);
	public BigDecimal getTitleDayTotal(SalesSearchCondition salesSearchConditoin);
	public BigDecimal getTitleMonthTotal(SalesSearchCondition salesSearchConditoin);
}
