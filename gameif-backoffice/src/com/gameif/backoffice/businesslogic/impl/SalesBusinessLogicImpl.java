package com.gameif.backoffice.businesslogic.impl;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.backoffice.bean.SalesSearchCondition;
import com.gameif.backoffice.businesslogic.ISalesBusinessLogic;
import com.gameif.backoffice.dao.IMemSettlementHistDao;
import com.gameif.backoffice.dao.IPointMstDao;
import com.gameif.backoffice.entity.MySettlementList;
import com.gameif.backoffice.entity.PointMst;
import com.gameif.common.businesslogic.BaseBusinessLogic;

public class SalesBusinessLogicImpl extends BaseBusinessLogic implements ISalesBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3024721167978877451L;
	
	private IPointMstDao pointMstDao;
	private IMemSettlementHistDao memSettlementHistDao;

	@Override
	public List<PointMst> getPointListByTitleId(Integer titleId) {
		return pointMstDao.selectPointListByTitle(titleId);
	}

	@Override
	public List<MySettlementList> getPersonDayList(SalesSearchCondition salesSearchConditoin) {
		return memSettlementHistDao.selectPersonDayList(salesSearchConditoin);
	}

	@Override
	public List<MySettlementList> getPersonMonthList(SalesSearchCondition salesSearchConditoin) {
		return memSettlementHistDao.selectPersonMonthList(salesSearchConditoin);
	}

	@Override
	public List<MySettlementList> getTitleDayList(SalesSearchCondition salesSearchConditoin) {
		return memSettlementHistDao.selectTitleDayList(salesSearchConditoin);
	}

	@Override
	public List<MySettlementList> getTitleMonthList(SalesSearchCondition salesSearchConditoin) {
		return memSettlementHistDao.selectTitleMonthList(salesSearchConditoin);
	}

	@Override
	public BigDecimal getPersonDayTotal(SalesSearchCondition salesSearchConditoin) {
		return memSettlementHistDao.selectPersonDayTotal(salesSearchConditoin);
	}

	@Override
	public BigDecimal getPersonMonthTotal(SalesSearchCondition salesSearchConditoin) {
		return memSettlementHistDao.selectPersonMonthTotal(salesSearchConditoin);
	}

	@Override
	public BigDecimal getTitleDayTotal(SalesSearchCondition salesSearchConditoin) {
		return memSettlementHistDao.selectTitleDayTotal(salesSearchConditoin);
	}

	@Override
	public BigDecimal getTitleMonthTotal(SalesSearchCondition salesSearchConditoin) {
		return memSettlementHistDao.selectTitleMonthTotal(salesSearchConditoin);
	}

	/**
	 * @param pointMstDao the pointMstDao to set
	 */
	public void setPointMstDao(IPointMstDao pointMstDao) {
		this.pointMstDao = pointMstDao;
	}

	/**
	 * @param memSettlementHistDao the memSettlementHistDao to set
	 */
	public void setMemSettlementHistDao(IMemSettlementHistDao memSettlementHistDao) {
		this.memSettlementHistDao = memSettlementHistDao;
	}

}
