package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.BetaTester;
import com.gameif.payment.entity.MyTitle;

public interface IBetaTesterDao extends IBaseDao<BetaTester, BetaTester> {

	public BetaTester selectByKey(Long memNum, Integer titleId);
	public List<MyTitle> selectMyBetaTestTitleList(Long memNum);
}
