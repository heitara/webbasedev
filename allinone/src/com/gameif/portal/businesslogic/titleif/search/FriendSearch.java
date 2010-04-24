package com.gameif.portal.businesslogic.titleif.search;

import java.util.Map;

public class FriendSearch {

	/** タイトルＩＤとキー生成クラスのマップ */
	private Map<Integer, ISearchKeyGenerator> searchKeyGenerators;
	
	/**
	 * ゲームログイン必要なＵＲＬパラメータを取得する。
	 * @param titleId タイトルＩＤ
	 * @param memberInfo 会員情報（会員番号、アカウントＩＤ、ニックネームが設定されていること）
	 * @param playDate ゲーム起動時間
	 * @param from 紹介媒体コード（ＮＵＬＬの場合はデフォルトで「0」をとる）
	 * @return ゲームログイン必要なＵＲＬパラメータ
	 */
	public String getFriendSearchKey(SearchParameter parameter) {
		
		return searchKeyGenerators.get(parameter.getTitleId()).getSearchKey(parameter);
	}

	/**
	 * @param searchKeyGenerators the searchKeyGenerators to set
	 */
	public void setSearchKeyGenerators(Map<Integer, ISearchKeyGenerator> searchKeyGenerators) {
		this.searchKeyGenerators = searchKeyGenerators;
	}

}
