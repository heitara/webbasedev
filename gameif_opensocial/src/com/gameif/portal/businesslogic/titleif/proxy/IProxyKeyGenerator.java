package com.gameif.portal.businesslogic.titleif.proxy;

public interface IProxyKeyGenerator {
	
	/**
	 * ゲームアクセスに必要なＵＲＬパラメータを生成する。
	 * @param parameter ProxyParameter
	 * @return ゲームアクセスに必要なＵＲＬパラメータ
	 */
	public String getProxyKey(ProxyParameter parameter);

}