package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.PointMst;

public interface IPointMstDao extends IBaseDao<PointMst, PointMst> {
	
	public List<PointMst> selectValidPointListByTitle(Integer titleId);

}
