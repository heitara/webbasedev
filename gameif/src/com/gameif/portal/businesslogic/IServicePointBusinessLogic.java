package com.gameif.portal.businesslogic;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.exception.LogicException;
import com.gameif.portal.entity.MySPGiveHist;
import com.gameif.portal.entity.MySPInfo;
import com.gameif.portal.entity.MySPUseHist;

public interface IServicePointBusinessLogic {
	
	public void getGameLoginServicePoint(Integer titleId) throws LogicException;
	public void useServicePoint(Integer titleId, Integer serverId, BigDecimal pointAmount) throws LogicException;
	public List<MySPUseHist> getMyUseHistList();
	public List<MySPGiveHist> getMyGiveHistList();
	public List<MySPInfo> getMyServicePointList();
	public BigDecimal getBalanceByTitle(Integer titleId, Long memNum);

}
