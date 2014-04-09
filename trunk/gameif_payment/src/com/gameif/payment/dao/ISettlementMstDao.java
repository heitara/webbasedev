package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.SettlementMst;

public interface ISettlementMstDao extends IBaseDao<SettlementMst, SettlementMst> {
	
	public List<SettlementMst> selectValidSettlementList();

}
