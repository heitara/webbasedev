package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.entity.PointMst;
import com.gameif.common.dao.IBaseDao;

public interface IPointMstDao extends IBaseDao<PointMst, PointMst> {
	
	public List<PointMst> selectPointListByTitle(Integer titleId);

}
