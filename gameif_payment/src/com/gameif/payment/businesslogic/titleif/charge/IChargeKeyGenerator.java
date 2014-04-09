package com.gameif.payment.businesslogic.titleif.charge;

public interface IChargeKeyGenerator {
	
	/**
	 * ポイントチャージに必要なＵＲＬパラメータを生成する。
	 * @param parameter ポイント付与引数オブジェクト<br/>
	 * <blockquote>
	 * 下記の項目が設定されていること。
	 * <ul>
	 *  <li>memNum 会員番号</li>
	 *  <li>memId アカウントＩＤ</li>
	 *  <li>orderNo 受注番号</li>
	 *  <li>chargePoint チャージポイント数</li>
	 *  <li>chargeDate チャージ日時</li>
	 * </ul>
	 * </blockquote>
	 * @return ポイントチャージに必要なＵＲＬパラメータ
	 */
	public String getChargeKey(ChargeParameter parameter);

}