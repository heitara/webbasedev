package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.OpensocialPlayHist;

public interface IOpensocialTitlePlayBusinessLogic {

	/**
	 * ゲームプレイ履歴を登録する。
	 * @param playHist ゲームプレイ履歴 
	 */
	public void savePlayHist(OpensocialPlayHist playHist);
}
