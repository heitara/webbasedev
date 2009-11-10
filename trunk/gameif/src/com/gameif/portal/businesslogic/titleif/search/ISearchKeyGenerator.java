package com.gameif.portal.businesslogic.titleif.search;

public interface ISearchKeyGenerator {
	
	/**
	 * ゲームログイン必要なＵＲＬパラメータを生成する。
	 * @param memberInfo 会員情報（会員番号、アカウントＩＤ、ニックネームが設定されていること）
	 * @param playDate ゲーム起動時間
	 * @param from 紹介媒体コード（ＮＵＬＬの場合はデフォルトで「0」をとる）
	 * @return ゲームログイン必要なＵＲＬパラメータ
	 */
	public String getSearchKey(SearchParameter parameter);
}
