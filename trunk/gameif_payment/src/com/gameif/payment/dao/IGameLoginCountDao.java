package com.gameif.payment.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.GameLoginCount;

public interface IGameLoginCountDao extends IBaseDao<GameLoginCount, GameLoginCount> {
	
	/**
	 * 
	 * ゲームのプレイ回数情報を取得する。
	 * @param memNum 会員番号
	 * @param titleId タイトルＩＤ
	 * @return ゲームのプレイ回数情報
	 */
	public GameLoginCount selectByKeyForUpdate(Long memNum, Integer titleId);

}
