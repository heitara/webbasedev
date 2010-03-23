package com.gameif.portal.action.mixi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.OAuthServiceProvider;
import net.oauth.OAuthValidator;
import net.oauth.SimpleOAuthValidator;
import net.oauth.OAuth.Parameter;
import net.oauth.signature.RSA_SHA1;

import com.gameif.portal.action.mixi.server.OAuthServlet;


public class MixiSignedFetchVerifyAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8080076284344981605L;

	private String memId;
	private Boolean validSigned;
	private String timeStamp;
	private String message;
	
	private final static String CERTIFICATE = "-----BEGIN CERTIFICATE-----\n"
		+ "MIICdzCCAeCgAwIBAgIJAOi/chE0MhufMA0GCSqGSIb3DQEBBQUAMDIxCzAJBgNV\n"
		+ "BAYTAkpQMREwDwYDVQQKEwhtaXhpIEluYzEQMA4GA1UEAxMHbWl4aS5qcDAeFw0w\n"
		+ "OTA0MjgwNzAyMTVaFw0xMDA0MjgwNzAyMTVaMDIxCzAJBgNVBAYTAkpQMREwDwYD\n"
		+ "VQQKEwhtaXhpIEluYzEQMA4GA1UEAxMHbWl4aS5qcDCBnzANBgkqhkiG9w0BAQEF\n"
		+ "AAOBjQAwgYkCgYEAwEj53VlQcv1WHvfWlTP+T1lXUg91W+bgJSuHAD89PdVf9Ujn\n"
		+ "i92EkbjqaLDzA43+U5ULlK/05jROnGwFBVdISxULgevSpiTfgbfCcKbRW7hXrTSm\n"
		+ "jFREp7YOvflT3rr7qqNvjm+3XE157zcU33SXMIGvX1uQH/Y4fNpEE1pmX+UCAwEA\n"
		+ "AaOBlDCBkTAdBgNVHQ4EFgQUn2ewbtnBTjv6CpeT37jrBNF/h6gwYgYDVR0jBFsw\n"
		+ "WYAUn2ewbtnBTjv6CpeT37jrBNF/h6ihNqQ0MDIxCzAJBgNVBAYTAkpQMREwDwYD\n"
		+ "VQQKEwhtaXhpIEluYzEQMA4GA1UEAxMHbWl4aS5qcIIJAOi/chE0MhufMAwGA1Ud\n"
		+ "EwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEAR7v8eaCaiB5xFVf9k9jOYPjCSQIJ\n"
		+ "58nLY869OeNXWWIQ17Tkprcf8ipxsoHj0Z7hJl/nVkSWgGj/bJLTVT9DrcEd6gLa\n"
		+ "H5TbGftATZCAJ8QJa3X2omCdB29qqyjz4F6QyTi930qekawPBLlWXuiP3oRNbiow\n"
		+ "nOLWEi16qH9WuBs=\n" + "-----END CERTIFICATE-----"; 
	
	public String mixiSignedVerify() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		verifyFetch(request, response);
		setTimeStamp(String.valueOf(System.currentTimeMillis()).substring(0, 10));
		return "success";
	} 
	
	private void verifyFetch(HttpServletRequest request, HttpServletResponse resp) {
		
		StringBuilder info = new StringBuilder();
		resp.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = resp.getWriter();

		try {
			OAuthServiceProvider provider = new OAuthServiceProvider(null, null, null);
			OAuthConsumer consumer = new OAuthConsumer(null, "mixi.jp", null, provider);
			consumer.setProperty(RSA_SHA1.X509_CERTIFICATE, CERTIFICATE);

			String method = request.getMethod();
			String requestUrl = getRequestUrl(request);
			List requestParameters = getRequestParameters(request);

			OAuthMessage message = new OAuthMessage(method, requestUrl, requestParameters);

			OAuthAccessor accessor = new OAuthAccessor(consumer);
			info.append("*** OAuthMessage Params:").append("\n");
			info.append("URL: " + OAuthServlet.htmlEncode(message.URL));
			for (Entry param : message.getParameters()) {
				String key = param.getKey().toString();
				String value = param.getValue().toString();
				info.append("");
				info.append("Param Name-->" + OAuthServlet.htmlEncode(key));
				info.append(" ");
				info.append("Value-->" + OAuthServlet.htmlEncode(value));
			}
			info.append("");
			info.append(" VALIDATING SIGNATURE ");
			info.append("");
			OAuthValidator validator = new SimpleOAuthValidator();
			validator.validateMessage(message, accessor);
			info.append("REQUEST STATUS::OK");
			info.append("");
		} catch (OAuthProblemException ope) {
			info.append("");
			info.append("OAuthProblemException-->"
					+ OAuthServlet.htmlEncode(ope.getProblem()));
		} catch (Exception e) {
			info.append(e);
			System.out.println(e);
		} finally {
			setMessage(info.toString());
		}
	}

	/**
	 * Constructs and returns the full URL associated with the passed request
	 * object.
	 * 
	 * @param request
	 *            Servlet request object with methods for retrieving the various
	 *            components of the request URL
	 */
	private String getRequestUrl(HttpServletRequest request) {
		StringBuilder requestUrl = new StringBuilder();
		String scheme = request.getScheme();
		int port = request.getLocalPort();

		requestUrl.append(scheme);
		requestUrl.append("://");
		requestUrl.append(request.getServerName());

		if ((port != 0) && ((scheme.equals("http") && port != 80) || (scheme.equals("https") && port != 443))) {
			requestUrl.append(":");
			requestUrl.append(port);
		}

		requestUrl.append(request.getContextPath());
		requestUrl.append(request.getServletPath());

		return requestUrl.toString();
	}

	/**
	 * Constructs and returns a List of OAuth.Parameter objects, one per
	 * parameter in the passed request.
	 * 
	 * @param request
	 *            Servlet request object with methods for retrieving the full
	 *            set of parameters passed with the request
	 */
	private List getRequestParameters(HttpServletRequest request) {

		List parameters = new ArrayList();

		for (Object e : request.getParameterMap().entrySet()) {
			Entry entry = (Entry) e;

			String[] values = (String[]) entry.getValue();
			for (String value : values) {
				parameters.add(new Parameter(entry.getKey().toString(), value));
			}
		}

		return parameters;
	}

	/**
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}

	/**
	 * @param memId the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
	}

	/**
	 * @return the validSigned
	 */
	public Boolean getValidSigned() {
		return validSigned;
	}

	/**
	 * @param validSigned the validSigned to set
	 */
	public void setValidSigned(Boolean validSigned) {
		this.validSigned = validSigned;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
