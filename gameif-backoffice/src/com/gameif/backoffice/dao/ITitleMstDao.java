package com.gameif.backoffice.dao;

import com.gameif.backoffice.entity.TitleMst;
import com.gameif.common.dao.IBaseDao;

public interface ITitleMstDao extends IBaseDao<TitleMst, TitleMst> {
	public String selectNameById(Integer titileId);

}
