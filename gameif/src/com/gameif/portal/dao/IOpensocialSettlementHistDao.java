package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MySettlementHist;
import com.gameif.portal.entity.OpensocialSettlementHist;

public interface IOpensocialSettlementHistDao extends IBaseDao<OpensocialSettlementHist, OpensocialSettlementHist> {

	public List<MySettlementHist> selectSettlementHistListByMemNum(Long memNum);

}
