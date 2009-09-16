package com.gameif.portal.businesslogic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.ITitlePlayBusinessLogic;
import com.gameif.portal.dao.IPlayHistDao;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.PlayHist;

public class TitlePlayBusinessLogicImpl extends BaseBusinessLogic implements ITitlePlayBusinessLogic {

	private static final long serialVersionUID = 5404743047758769861L;
	
	private IPlayHistDao playHistDao;

	/**
	 * ゲームプレイ履歴を登録する。
	 * @param playHist
	 */
	@Transactional
	public void savePlayHist(PlayHist playHist) {

		playHist.setPlayDate(new Date());
		playHistDao.save(playHist);
	}

	/**
	 * プレイしたことのあるゲーム一覧を取得する。
	 * @param memNum 会員番号
	 * @return プレイしたことのあるゲーム一覧
	 */
	@Override
	public List<MyTitle> getPlayedTitles(Long memNum) {
		
		return playHistDao.selectTitlesOnlyPlay(memNum);
	}

	/**
	 * ゲーム一覧をプレイ情報付で取得する。
	 * @param memNum 会員番号
	 * @return プレイしたことのあるゲーム一覧
	 */
	@Override
	public List<MyTitle> getTitlesWithPlayInfo(Long memNum) {
		
		return playHistDao.selectTitlesWithPlay(memNum);
	}

	public void setPlayHistDao(IPlayHistDao playHistDao) {
		this.playHistDao = playHistDao;
	}
}
