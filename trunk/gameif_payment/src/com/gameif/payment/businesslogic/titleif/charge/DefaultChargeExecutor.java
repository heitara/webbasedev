package com.gameif.payment.businesslogic.titleif.charge;

import java.io.InputStream;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class DefaultChargeExecutor implements IChargeExcutor {
	
	private final static Log logger = LogFactory.getLog(DefaultChargeExecutor.class);
	
	/** 付与結果文字列とエラー番号のマッピング */
	private Map<String, Integer> resultMap;

	/** XMLの中から結果コード（result）の位置を示すXPATH */
	private String xmlResultNode;
	
	/** XMLの中から処理番号（tradeNum）の位置を示すXPATH */
	private String xmlTradeNoNode;

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
	 *  <li>spType ポイント区分(1:ServicePoint充值 0:真实购买充值)</li>
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
	public int excute(ChargeParameter parameter) {
		
		InputStream inputStream = null;
		
		int resultCd = ChargeConstants.Result.SUCCESS;
		
		String result;
		String tradeNo;
		
		try {
			
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(parameter.getChargeFullUrl());
			HttpResponse httpRes = httpClient.execute(httpGet);
			
			inputStream = httpRes.getEntity().getContent();
			
			Document document = new SAXReader().read(inputStream);
			
			result = document.selectSingleNode(xmlResultNode).getStringValue();
			tradeNo = document.selectSingleNode(xmlTradeNoNode).getStringValue();
			
			resultCd = getResultCode(result);
			
			if (resultCd == ChargeConstants.Result.SUCCESS) {

				logger.info("charge point to the game server is successed. " + getLogMessage(parameter, result, tradeNo));
				
			} else {

				logger.warn("charge point to the game server is failed. " + getLogMessage(parameter, result, tradeNo));
			}

		} catch (Exception ex) {
			
			resultCd = ChargeConstants.Result.SYSTEM_ERROR;
			
			logger.error("error occurred in the time charge point to the game server. " + getLogMessage(parameter, "SYSTEM_ERROR", ""), ex);

		}
		
		return resultCd;
	}
	
	/**
	 * ログ出力用メッセージを生成する。
	 * @param parameter ポイント付与引数オブジェクト
	 * @param result　付与処理結果コード
	 * @param tradeNo 処理番号
	 * @return ログ出力用メッセージ
	 */
	private String getLogMessage(ChargeParameter parameter, String result, String tradeNo) {
		
		return new StringBuffer()
			.append("[ orderNo=")
			.append(parameter.getOrderNo())
			.append(", point=")
			.append(parameter.getChargePoint())
			.append(", server=")
			.append(getServerName(parameter.getChargeUrl()))
			.append(", memNum=")
			.append(parameter.getMemNum())
			.append(", memId=")
			.append(parameter.getMemId())
			.append(", spType=")
			.append(parameter.getSpType())
//			.append(", parentMemNum=")
//			.append(parameter.getParentNum())
			.append(", result=")
			.append(result)
			.append(", tradeNo=")
			.append(tradeNo)
			.append(" ]")
			.toString();
	}
	
	/**
	 * URLからサーバ名を抽出する。
	 * @param url URL
	 * @return サーバ名
	 */
	private String getServerName(String url) {
		
		String res = null;
		
		if (url != null) {
			
			int i = url.indexOf("://");
			
			if (i >= 0) {

				res = url.substring(i);
			}
			
			i = res.indexOf("/");
			
			if (i >= 0) {
				
				res = res.substring(0, i);
			}
		}
		
		return res;
	}
	
	public int getResultCode(String result) {
		
		return resultMap.get(result);
	}

	public void setResultMap(Map<String, Integer> resultMap) {
		this.resultMap = resultMap;
	}

	public void setXmlResultNode(String xmlResultNode) {
		this.xmlResultNode = xmlResultNode;
	}

	public void setXmlTradeNoNode(String xmlTradeNoNode) {
		this.xmlTradeNoNode = xmlTradeNoNode;
	}
}
