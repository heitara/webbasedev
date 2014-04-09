package com.gameif.payment.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IBetaTesterDao;
import com.gameif.payment.entity.BetaTester;
import com.gameif.payment.entity.MyTitle;

public class BetaTesterDaoImpl extends
AbstractBaseDao<BetaTester, BetaTester> implements IBetaTesterDao {
	/**
	 * 
	 * ゲームのプレイ回数情報を取得する。
	 * @param memNum 会員番号
	 * @param titleId タイトルＩＤ
	 * @return ゲームのプレイ回数情報
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BetaTester selectByKey(Long memNum, Integer titleId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", memNum);
		params.put("titleId", titleId);
		
		return (BetaTester) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectByKey", params);
	}

	/**
	 * 募集中のタイトルを取得する
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MyTitle> selectMyBetaTestTitleList(Long memNum) {
		
		return (List<MyTitle>)this.getSqlMapClientTemplate().queryForList(namespace + ".selectMyBetaTestTitleList", memNum);
	}
}
