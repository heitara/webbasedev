package com.gameif.payment.businesslogic.titleif.charge;


public interface IChargeExcutor {

	/**
	 * 指定したユーザに対してゲームサーバでポイントを付与する。
	 * @param parameter ポイント付与引数オブジェクト<br/>
	 * <blockquote>
	 * 下記の項目が設定されていること。
	 * <ul>
	 *  <li>memNum 会員番号</li>
	 *  <li>memId アカウントＩＤ</li>
	 *  <li>orderNo 受注番号</li>
	 *  <li>chargePoint チャージポイント数</li>
	 *  <li>chargeDate チャージ日時</li>
	 *  <li>chargeFullUrl チャージＵＲＬ（キー付）</li>
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
	public abstract int excute(ChargeParameter parameter);
}