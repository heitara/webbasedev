package com.gameif.portal.businesslogic.titleif.proxy;

import java.util.Map;

import com.gameif.common.util.SecurityUtil;

public class DefaultProxyKeyGenerator implements IProxyKeyGenerator {
	
	/** アカウントパラメータ名 */
	private String accountKey;
	/** UNIX時間のパラメータ名 */
	private String timeKey;
	/** セキュリティ文字列のパラメータ名 */
	private String validateCdKey;
	
	/** サーバ間連携パスワード */
	private Map<Integer, String> unionCdMap;

	/**
	 * ゲームアクセスに必要なＵＲＬパラメータを生成する。
	 * @param parameter ProxyParameter
	 * @return ゲームアクセスに必要なＵＲＬパラメータ
	 */
	@Override
	public String getProxyKey(ProxyParameter parameter) {
		
		String unixTime = String.valueOf(parameter.getAccessDate().getTime() / 1000);
		String validateCd = SecurityUtil.getMD5String(
								new StringBuffer()
								.append(parameter.getMemNum())
								.append(unixTime)
								.append(unionCdMap.get(parameter.getServerId()))
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

	public void setUnionCdMap(Map<Integer, String> unionCdMap) {
		this.unionCdMap = unionCdMap;
	}
}
