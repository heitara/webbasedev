package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.TitleMst;

public interface ITitleMstDao extends IBaseDao<TitleMst, TitleMst> {

	public List<TitleMst> selectValidTitleList();
	public String selectNameById(Integer titileId);
	public TitleMst selectValidTitleByKey(Integer titleId);

}
