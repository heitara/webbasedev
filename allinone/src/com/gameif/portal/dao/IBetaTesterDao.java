package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.BetaTester;
import com.gameif.portal.entity.MyTitle;

public interface IBetaTesterDao extends IBaseDao<BetaTester, BetaTester> {

	public BetaTester selectByKey(Long memNum, Integer titleId);
	public List<MyTitle> selectMyBetaTestTitleList(Long memNum);
}
