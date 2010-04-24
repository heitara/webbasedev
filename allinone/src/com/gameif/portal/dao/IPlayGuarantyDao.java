package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.PlayGuaranty;

public interface IPlayGuarantyDao extends IBaseDao<PlayGuaranty, PlayGuaranty> {
	
	public Integer selectGuarantyByMenNum(Long memNum, Integer titleId, Integer serverId);

}
