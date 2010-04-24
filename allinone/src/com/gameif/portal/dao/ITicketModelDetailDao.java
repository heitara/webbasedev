package com.gameif.portal.dao;

import java.math.BigDecimal;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.TicketModelDetail;
import com.gameif.portal.entity.TicketModelMst;

public interface ITicketModelDetailDao extends IBaseDao<TicketModelDetail, TicketModelDetail> {
	
	public Integer selectSumPersonCount(TicketModelMst model);
	public BigDecimal selectActpoint(TicketModelMst model, Integer randomCount);

}
