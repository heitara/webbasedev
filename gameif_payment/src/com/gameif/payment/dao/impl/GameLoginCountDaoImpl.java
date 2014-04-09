package com.gameif.payment.dao.impl;

import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IGameLoginCountDao;
import com.gameif.payment.entity.GameLoginCount;

public class GameLoginCountDaoImpl extends
AbstractBaseDao<GameLoginCount, GameLoginCount> implements IGameLoginCountDao {
	
	/**
	 * 
	 * ゲームのプレイ回数情報を取得する。
	 * @param memNum 会員番号
	 * @param titleId タイトルＩＤ
	 * @return ゲームのプレイ回数情報
	 */
	@SuppressWarnings("unchecked")
	@Override
	public GameLoginCount selectByKeyForUpdate(Long memNum, Integer titleId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", memNum);
		params.put("titleId", titleId);
		
		return (GameLoginCount) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectByKeyForUpdate", params);
	}

}
