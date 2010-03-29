package com.gameif.portal.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.util.ByteUtil;
import com.gameif.common.util.SecurityUtil;
import com.gameif.portal.constants.PortalConstants;
import com.opensymphony.xwork2.ActionInvocation;

public class EntryParameterInterceptor extends BaseParameterInterceptor {

	private static final long serialVersionUID = -3936772203980270629L;

	@Override
	public String doIntercept(ActionInvocation ai) throws Exception {
		
		String encodedParams = ByteUtil.stringFromHexString(getParameterFromCookie(PortalConstants.Key.SEURE_PARAM_KEY));
		String title = getParameterFromCookie(PortalConstants.Key.ENTRY_PARAM_TITLE_KEY);
		String apply = getParameterFromCookie(PortalConstants.Key.ENTRY_PARAM_APPLY_KEY);		
			
		try {
			
			if (encodedParams != null) {
				
				Map<String, String> paramMap = SecurityUtil.decodeParam(encodedParams);
				
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					
					setProperty(ai.getAction(), entry.getKey(), entry.getValue());
				}
			}
			
			if (title != null) {

				setProperty(ai.getAction(), PortalConstants.Key.ENTRY_PARAM_TITLE_KEY, title);
			}
			
			if (apply != null) {

				setProperty(ai.getAction(), PortalConstants.Key.ENTRY_PARAM_APPLY_KEY, apply);
			}
			
		} catch (Exception ex) {

			logger.warn(ex.getMessage());
		}
		
		return ai.invoke();
	}

	private String getParameterFromCookie(String key) {
		
		String value = null;
	    Cookie cookies[] = ServletActionContext.getRequest().getCookies();
	    
	    if (cookies != null) {
	    	
	        for (Cookie cookie : cookies) {
	        	
	        	if (cookie.getName().equals(key)) {
	        	
	        		value = cookie.getValue();
	        	}
	        }
	    }
		
		return value;
	}
}