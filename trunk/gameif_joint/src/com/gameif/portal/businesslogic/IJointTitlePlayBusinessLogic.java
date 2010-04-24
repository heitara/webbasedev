package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.JointPlayHist;

public interface IJointTitlePlayBusinessLogic {

	/**
	 * ゲームプレイ履歴を登録する。
	 * @param playHist ゲームプレイ履歴 
	 */
	public void savePlayHist(JointPlayHist playHist);
}
