package com.gameif.portal.businesslogic.titleif.charge;

import com.gameif.common.util.SecurityUtil;

public class DefaultChargeKeyGenerator implements IChargeKeyGenerator {
	
	/** アカウントパラメータ名 */
	private String accountKey;
	/** UNIX時間のパラメータ名 */
	private String timeKey;
	/** 受注番号のパラメータ名 */
	private String orderKey;
	/** 受注番号のパラメータ名 */
	private String pointKey;
	/** ポイント区別のパラメータ名 */
	private String spKey;
	/** 親の会員番号のパラメータ名 */
//	private String parentAccountKey;

	/** セキュリティ文字列のパラメータ名 */
	private String validateCdKey;
	
	/** サーバ間連携パスワード */
	private String unionCd;

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
	 *  <li>pointType ポイント区分(1:ServicePoint充值 0:真实购买充值)</li>
	 *  <li>parentNum 親の会員番号</li>
	 * </ul>
	 * </blockquote>
	 * @return ポイントチャージに必要なＵＲＬパラメータ
	 */
	@Override
	public String getChargeKey(ChargeParameter parameter) {
		
		String unixTime = String.valueOf(parameter.getChargeDate().getTime() / 1000);
		String chargeInfo = new StringBuffer()
							.append(accountKey)
							.append("=")
							.append(parameter.getMemNum())
							.append("&")
							.append(orderKey)
							.append("=")
							.append(parameter.getOrderNo())
							.append("&")
							.append(pointKey)
							.append("=")
							.append(parameter.getChargePoint())
							.append("&")
							.append(timeKey)
							.append("=")
							.append(unixTime)
//							.append(unionCd)
//							.append("&")
//							.append(spKey)
//							.append("=")
//							.append(parameter.getSpType())
//							.append("&")
//							.append(parentAccountKey)
//							.append("=")
//							.append(parameter.getParentNum())
							.toString();
		String validateCd = SecurityUtil.getMD5String(chargeInfo + unionCd + "&sp=" + parameter.getSpType());
		
		return new StringBuffer()
				.append(chargeInfo)
				.append("&sp=")
				.append(parameter.getSpType())
				.append("&")
				.append(validateCdKey)
				.append("=")
				.append(validateCd)
				.toString();
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public void setPointKey(String pointKey) {
		this.pointKey = pointKey;
	}

	/**
	 * @param spKey the spKey to set
	 */
	public void setSpKey(String spKey) {
		this.spKey = spKey;
	}

//	/**
//	 * @param parentAccountKey the parentAccountKey to set
//	 */
//	public void setParentAccountKey(String parentAccountKey) {
//		this.parentAccountKey = parentAccountKey;
//	}
	
	public void setValidateCdKey(String validateCdKey) {
		this.validateCdKey = validateCdKey;
	}

	public void setUnionCd(String unionCd) {
		this.unionCd = unionCd;
	}
}
