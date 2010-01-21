package com.gameif.backoffice.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.backoffice.bean.SalesSearchCondition;
import com.gameif.backoffice.dao.IMemSettlementHistDao;
import com.gameif.backoffice.entity.MemSettlementHist;
import com.gameif.backoffice.entity.MySettlementList;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class MemSettlementHistDaoImpl extends AbstractBaseDao<MemSettlementHist, MemSettlementHist>
	implements IMemSettlementHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MySettlementList> selectPersonDayList(SalesSearchCondition salesSearchConditoin) {
		
		return (List<MySettlementList>)getSqlMapClientTemplate().queryForList(namespace + ".selectPersonDayList", salesSearchConditoin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MySettlementList> selectPersonMonthList(SalesSearchCondition salesSearchConditoin) {
		return (List<MySettlementList>)getSqlMapClientTemplate().queryForList(namespace + ".selectPersonMonthList", salesSearchConditoin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MySettlementList> selectTitleDayList(SalesSearchCondition salesSearchConditoin) {
		return (List<MySettlementList>)getSqlMapClientTemplate().queryForList(namespace + ".selectTitleDayList", salesSearchConditoin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MySettlementList> selectTitleMonthList(SalesSearchCondition salesSearchConditoin) {
		return (List<MySettlementList>)getSqlMapClientTemplate().queryForList(namespace + ".selectTitleMonthList", salesSearchConditoin);
	}

	@Override
	public BigDecimal selectPersonDayTotal(SalesSearchCondition salesSearchConditoin) {
		
		return (BigDecimal)getSqlMapClientTemplate().queryForObject(namespace + ".selectPersonDayTotal", salesSearchConditoin);
	}

	@Override
	public BigDecimal selectPersonMonthTotal(SalesSearchCondition salesSearchConditoin) {
		
		return (BigDecimal)getSqlMapClientTemplate().queryForObject(namespace + ".selectPersonMonthTotal", salesSearchConditoin);
	}

	@Override
	public BigDecimal selectTitleDayTotal(SalesSearchCondition salesSearchConditoin) {
		
		return (BigDecimal)getSqlMapClientTemplate().queryForObject(namespace + ".selectTitleDayTotal", salesSearchConditoin);
	}

	@Override
	public BigDecimal selectTitleMonthTotal(SalesSearchCondition salesSearchConditoin) {
		
		return (BigDecimal)getSqlMapClientTemplate().queryForObject(namespace + ".selectTitleMonthTotal", salesSearchConditoin);
	}

}
