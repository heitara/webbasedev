package com.gameif.portal.businesslogic.titleif.entry;

import com.gameif.common.util.SecurityUtil;

public class DefaultEntryKeyGenerator implements IEntryKeyGenerator {
	
	/** アカウントパラメータ名 */
	private String accountKey;
	/** UNIX時間のパラメータ名 */
	private String timeKey;
	/** セキュリティ文字列のパラメータ名 */
	private String validateCdKey;
	/**紹介者IDのパラメータ名*/
	private String parentKey;
//	/** メディアコードのパラメータ名 */
//	private String fromKey;
	
	/** サーバ間連携パスワード */
	private String unionCd;
//	/** メディアコードのデフォルト値 */
//	private String defaultFrom;

	/**
	 * ゲームログイン必要なＵＲＬパラメータを取得する。
	 * @param titleId タイトルＩＤ
	 * @param memberInfo 会員情報（会員番号、アカウントＩＤ、ニックネームが設定されていること）
	 * @param playDate ゲーム起動時間
	 * @param from 紹介媒体コード（ＮＵＬＬの場合はデフォルトで「0」をとる）
	 * @return ゲームログイン必要なＵＲＬパラメータ
	 */
	@Override
	public String getEntryKey(EntryParameter parameter) {
		
		String unixTime = String.valueOf(parameter.getPlayDate().getTime() / 1000);
		String validateCd = SecurityUtil.getMD5String(
								new StringBuffer()
								.append(parameter.getMemNum())
								.append(unixTime)
								.append(parameter.getParentMemNum())
								.append(unionCd)
								.toString());
		
		return new StringBuffer()
			.append(accountKey)
			.append("=")
			.append(parameter.getMemNum())
			.append("&")
			.append(timeKey)
			.append("=")
			.append(unixTime)
			.append("&")
			.append(validateCdKey)
			.append("=")
			.append(validateCd)
			.append("&")
			.append(parentKey)
			.append("=")
			.append(parameter.getParentMemNum())
			.toString();
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
	}

	public void setValidateCdKey(String validateCdKey) {
		this.validateCdKey = validateCdKey;
	}

//	public void setFromKey(String fromKey) {
//		this.fromKey = fromKey;
//	}

	public void setUnionCd(String unionCd) {
		this.unionCd = unionCd;
	}

	/**
	 * @param parentKey the parentKey to set
	 */
	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

//	public void setDefaultFrom(String defaultFrom) {
//		this.defaultFrom = defaultFrom;
//	}

}
