package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.TitleMst;

public class TitleMstDaoImpl extends
	AbstractBaseDao<TitleMst, TitleMst> implements ITitleMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TitleMst> selectValidTitleList() {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectValidTitleList", null);
	}

	@Override
	public String selectNameById(Integer titileId) {
		return (String)this.getSqlMapClientTemplate().queryForObject(namespace + ".selectNameById", titileId);
	}

	@Override
	public TitleMst selectValidTitleByKey(Integer titleId) {
		return (TitleMst)this.getSqlMapClientTemplate().queryForObject(namespace + ".selectValidTitleByKey", titleId);
	}

	/**
	 * 募集中のタイトルを取得する
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MyTitle> selectCBTTitleList(Long memNum) {
		
		return (List<MyTitle>)this.getSqlMapClientTemplate().queryForList(namespace + ".selectCBTTitleList", memNum);
	}
}
