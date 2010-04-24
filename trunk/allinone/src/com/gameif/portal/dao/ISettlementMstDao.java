package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.SettlementMst;

public interface ISettlementMstDao extends IBaseDao<SettlementMst, SettlementMst> {
	
	public List<SettlementMst> selectValidSettlementList();

}
