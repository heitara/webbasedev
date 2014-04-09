package com.gameif.payment.businesslogic.titleif.entry;

import java.util.Map;

public class TitleEntry {

	/** タイトルＩＤとキー生成クラスのマップ */
	private Map<Integer, IEntryKeyGenerator> entryKeyGenerators;
	
	/**
	 * ゲームログイン必要なＵＲＬパラメータを取得する。
	 * @param titleId タイトルＩＤ
	 * @param memberInfo 会員情報（会員番号、アカウントＩＤ、ニックネームが設定されていること）
	 * @param playDate ゲーム起動時間
	 * @param from 紹介媒体コード（ＮＵＬＬの場合はデフォルトで「0」をとる）
	 * @return ゲームログイン必要なＵＲＬパラメータ
	 */
	public String getTitleEntryKey(EntryParameter parameter) {
		
		return entryKeyGenerators.get(parameter.getTitleId()).getEntryKey(parameter);
	}

	public void setEntryKeyGenerators(Map<Integer, IEntryKeyGenerator> entryKeyGenerators) {
		
		this.entryKeyGenerators = entryKeyGenerators;
	}
}