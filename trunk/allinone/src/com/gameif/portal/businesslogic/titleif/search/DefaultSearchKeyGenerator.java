package com.gameif.portal.businesslogic.titleif.search;

import com.gameif.common.util.SecurityUtil;

public class DefaultSearchKeyGenerator implements ISearchKeyGenerator {
	
	/** アカウントパラメータ名 */
	private String accountKey;
	/** セキュリティ文字列のパラメータ名 */
	private String validateCdKey;
	
	/** サーバ間連携パスワード */
	private String unionCd;

	/**
	 * ゲームに紹介結果検索用必要なＵＲＬパラメータを取得する。
	 * @param titleId タイトルＩＤ
	 * @param memNum 紹介者番号
	 * @return ゲームログイン必要なＵＲＬパラメータ
	 */
	@Override
	public String getSearchKey(SearchParameter parameter) {
		
		String validateCd = SecurityUtil.getMD5String(
								new StringBuffer()
								.append(parameter.getMemNum())
								.append(unionCd)
								.toString());
		
		return new StringBuffer()
			.append(accountKey)
			.append("=")
			.append(parameter.getMemNum())
			.append("&")
			.append(validateCdKey)
			.append("=")
			.append(validateCd)
			.toString();
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

	public void setValidateCdKey(String validateCdKey) {
		this.validateCdKey = validateCdKey;
	}

	public void setUnionCd(String unionCd) {
		this.unionCd = unionCd;
	}

}
