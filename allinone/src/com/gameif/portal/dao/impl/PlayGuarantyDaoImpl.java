package com.gameif.portal.dao.impl;

import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IPlayGuarantyDao;
import com.gameif.portal.entity.PlayGuaranty;

public class PlayGuarantyDaoImpl extends AbstractBaseDao<PlayGuaranty, PlayGuaranty> implements IPlayGuarantyDao {

	@SuppressWarnings("unchecked")
	@Override
	public Integer selectGuarantyByMenNum(Long memNum, Integer titleId, Integer serverId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", memNum);
		params.put("titleId", titleId);
		params.put("serverId", serverId);
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectGuarantyByMenNum", params);
	}

}
