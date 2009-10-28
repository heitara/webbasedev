package com.gameif.portal.businesslogic.titleif.charge;

import java.util.Map;

public class TitleCharge {
	
	/** タイトルＩＤとキー生成クラスのマップ */
	private Map<Integer, IChargeKeyGenerator> chargeKeyGenerators;
	
	/** タイトルＩＤとキーポイント付与処理クラスのマップ */
	private Map<Integer, IChargeExcutor> chargeExecutors;

	/**
	 * 指定したユーザに対してゲームサーバでポイントを付与する。
	 * @param parameter ポイント付与引数オブジェクト<br/>
	 * <blockquote>
	 * 下記の項目が設定されていること。
	 * <ul>
	 *  <li>memNum 会員番号</li>
	 *  <li>memId アカウントＩＤ</li>
	 *  <li>orderNo 受注番号</li>
	 *  <li>titleId タイトルＩＤ</li>
	 *  <li>chargePoint チャージポイント数</li>
	 *  <li>chargeDate チャージ日時</li>
	 *  <li>chargeUrl チャージＵＲＬ（TitleMstから取得したＵＲＬそのまま）</li>
	 *  <li>pointType ポイント区分(1:ServicePoint充值 0:真实购买充值)</li>
	 *  <li>parentNum 親の会員番号</li>
	 * </ul>
	 * </blockquote>
	 * @return 付与結果コード
	 * <blockquote>
	 * <p>結果コードについての詳細な情報はChargeConstantsクラスで各定数の説明を参照すること。</p>
	 * <ul>
	 *  <li>0: チャージ成功</li>
	 *  <li>-1: 重複チャージで、他のトランザクションにて既にポイントが反映されている。</li>
	 *  <li>1: アカウントが存在しない原因で、ポイントが反映されていない。</li>
	 *  <li>2: パラメータ不正が原因で、ポイントが反映されていない。</li>
	 *  <li>3: セキュリティキーが不正で、ポイントが反映されていない。</li>
	 *  <li>9: 通信障害等のシステムエラーで、ポイントが反映されたか、されていないのかは調査しなければ判断できない。</li>
	 * </ul>
	 * </blockquote>
	 */
	public int chargePoint(ChargeParameter parameter) {
		
		// ポイント付与に必要なＵＲＬパラメータ（セキュリティキー付）を取得する。
		String chargeKey = chargeKeyGenerators.get(parameter.getTitleId()).getChargeKey(parameter);
		
		// ポイント付与ＵＲＬを作る。
		parameter.setChargeFullUrl(parameter.getChargeUrl() + "?" + chargeKey);
		
		// ポイント付与を実行して結果コードを返す。
		return chargeExecutors.get(parameter.getTitleId()).excute(parameter);
	}

	public void setChargeKeyGenerators(
			Map<Integer, IChargeKeyGenerator> chargeKeyGenerators) {
		this.chargeKeyGenerators = chargeKeyGenerators;
	}

	public void setChargeExecutors(Map<Integer, IChargeExcutor> chargeExecutors) {
		this.chargeExecutors = chargeExecutors;
	}
}
