package com.gameif.portal.businesslogic.titleif.proxy;

import java.util.Map;

public class TitleProxy {

	/** タイトルＩＤとキー生成クラスのマップ */
	private Map<Integer, IProxyKeyGenerator> proxyKeyGenerators;
	
	/**
	 * ゲームIFアクセスに必要なＵＲＬパラメータを取得する。
	 * @param parameter ProxyParameter
	 * @return ゲームIFアクセスに必要なＵＲＬパラメータ
	 */
	public String getTitleProxyKey(ProxyParameter parameter) {
		
		return proxyKeyGenerators.get(parameter.getTitleId()).getProxyKey(parameter);
	}

	public void setProxyKeyGenerators(Map<Integer, IProxyKeyGenerator> proxyKeyGenerators) {
		
		this.proxyKeyGenerators = proxyKeyGenerators;
	}
}