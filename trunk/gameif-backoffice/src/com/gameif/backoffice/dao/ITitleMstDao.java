package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.entity.TitleMst;
import com.gameif.common.dao.IBaseDao;

public interface ITitleMstDao extends IBaseDao<TitleMst, TitleMst> {
	public String selectNameById(Integer titileId);
	public List<TitleMst> selectValidTitleList();

}
