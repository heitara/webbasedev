package com.gameif.portal.action.titleif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.struts2.ServletActionContext;

import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.titleif.proxy.ProxyParameter;
import com.gameif.portal.businesslogic.titleif.proxy.TitleProxy;
import com.gameif.portal.entity.ServerMst;

public class OpensocialProxyAction {

	private static final long serialVersionUID = -6317164626114870434L;
	private final static Log logger = LogFactory.getLog(OpensocialProxyAction.class);
	
	private TitleProxy titleProxy;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	
	private String memId;
	private String targetUri;
	private String providerId;
	private Integer titleId;
	private Integer serverId;
	private String htmlText;
	
	@SuppressWarnings("unchecked")
	public String execute() {
		
		String result = "success";
		
		Map<String, String> paramMap = new HashMap<String, String>();
		Enumeration paramNames = ServletActionContext.getRequest().getParameterNames();
		
		while (paramNames.hasMoreElements()) {
			
			String paramName = (String)paramNames.nextElement();
			String paramValue = ServletActionContext.getRequest().getParameter(paramName);
			
			if (paramName.startsWith("pr.")) {
				
				paramMap.put(paramName, paramValue);
			}
		}

		String serverDomain = getServer().getServerDomain();
		
		ProxyParameter proxyParam = new ProxyParameter();
		proxyParam.setMemNum(Long.valueOf(memId));
		proxyParam.setTitleId(titleId);
		proxyParam.setServerId(serverId);
		proxyParam.setAccessDate(new Date());
		
		String proxySecParam = titleProxy.getTitleProxyKey(proxyParam);
		
		String titleIfUrl = new StringBuffer()
								.append("http://")
								.append(serverDomain)
								.append("/")
								.append(targetUri)
								.append("?")
								.append(proxySecParam)
								.toString();
		try {
			
			htmlText = doProxy(titleIfUrl, paramMap);
			
		} catch (Exception ex) {
			
			logger.error(ex.getMessage(), ex);
		}
		
		return result;
	}
	
	public String doProxy(String targetUrl, Map<String, String> params) {
		
		DefaultHttpClient httpClient = null;
		HttpPost httpPost = null;
		BufferedReader reader = null;
		HttpEntity entity = null;
		
		StringBuffer result = new StringBuffer();
		
		try {
			
			httpClient = new DefaultHttpClient();
			httpPost = new HttpPost(targetUrl);

			List <NameValuePair> nvps = new ArrayList <NameValuePair>();
			
			for (Map.Entry<String, String> entry : params.entrySet()) {

				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}

			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			
			HttpResponse response = httpClient.execute(httpPost);
			entity = response.getEntity();
			
			reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				result.append(line);
			}
			
		} catch (Exception ex) {
			
			httpPost.abort();
			logger.error(ex.getMessage(), ex);
			
		} finally {

			try {
				
				if (reader != null) {

					reader.close();
				}
				
				entity.consumeContent();
				
			} catch (Exception ex) {
				
				logger.error(ex.getMessage(), ex);
			}
		}
		
		if (httpClient != null) {
			
			httpClient.getConnectionManager().shutdown();
		}
		
		return result.toString();
	}
	
	private ServerMst getServer() {

		ServerMst server = null;
		
		if (titleId != null && serverId != null && providerId != null) {

			ServerMst serverSelCond = new ServerMst();
			serverSelCond.setTitleId(titleId);
			serverSelCond.setServerId(serverId);
			serverSelCond.setProviderId(providerId);
						
			server = masterInfoBusinessLogic.getServer(serverSelCond);
		}
		
		return server;
	}

	public String getHtmlText() {
		
		return htmlText;
	}

	public void setTargetUri(String targetUri) {
		this.targetUri = targetUri;
	}

	public void setTitleProxy(TitleProxy titleProxy) {
		this.titleProxy = titleProxy;
	}

	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
}