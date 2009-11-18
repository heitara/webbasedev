package com.gameif.portal.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gameif.common.util.SecurityUtil;
import com.gameif.portal.constants.PortalConstants;
import com.opensymphony.xwork2.ActionInvocation;

public class SecureParameterInterceptor extends BaseParameterInterceptor {

	protected final static Log logger = LogFactory.getLog(SecureParameterInterceptor.class);
	private static final long serialVersionUID = -3936772203980270629L;

	@Override
	public String doIntercept(ActionInvocation ai) throws Exception {
		
		String encodedParams = ServletActionContext.getRequest().getParameter(PortalConstants.Key.SEURE_PARAM_KEY);

		if (encodedParams != null) {
			
			try {
				
				Map<String, String> paramMap = SecurityUtil.decodeParam(encodedParams);
				
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					
					setProperty(ai.getAction(), entry.getKey(), entry.getValue());
				}
				
			} catch (Exception ex) {
	
				logger.warn(ex.getMessage());
			}
		}
		
		return ai.invoke();
	}
}