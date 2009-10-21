package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.portal.entity.MyServer;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.PlayHist;

public interface ITitlePlayBusinessLogic {

	/**
	 * ゲームプレイ履歴を登録する。
	 * @param playHist ゲームプレイ履歴 
	 */
	public void savePlayHist(PlayHist playHist);
	
	/**
	 * プレイしたことのあるゲーム一覧を取得する。
	 * @param memNum 会員番号
	 * @return プレイしたことのあるサーバ一覧
	 */
	public List<MyTitle> getPlayedTitles(Long memNum);
	
	/**
	 * ゲーム一覧をプレイ情報付で取得する。
	 * @param memNum 会員番号
	 * @return ゲーム一覧
	 */
	public List<MyTitle> getTitlesWithPlayInfo(Long memNum);

	/**
	 * プレイしたことのあるサーバ一覧を取得する。
	 * @param memNum 会員番号
	 * @param titleId タイトルＩＤ
	 * @return プレイしたことのあるサーバ一覧
	 */
	public List<MyServer> getPlayedServers(Long memNum, Integer titleId);

	/**
	 * サーバ一覧をプレイ情報付で取得する。
	 * @param memNum 会員番号
	 * @param titleId タイトルＩＤ
	 * @return サーバ一覧
	 */
	public List<MyServer> getServersWithPlayInfo(Long memNum, Integer titleId);
}