package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.dao.ITicketMstDao;
import com.gameif.backoffice.entity.TicketMst;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class TicketMstDaoImpl extends AbstractBaseDao<TicketMst, TicketMst> implements ITicketMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketMst> selectTicketListByTitleId(Integer titleId) {
		return (List<TicketMst>) this.getSqlMapClientTemplate().queryForList(namespace + ".selectTicketListByTitleId", titleId);
	}

}
