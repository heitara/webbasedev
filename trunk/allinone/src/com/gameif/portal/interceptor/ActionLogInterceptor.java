package com.gameif.portal.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;

public class ActionLogInterceptor extends CommonInterceptor {

    private final static Log logger = LogFactory.getLog(ActionLogInterceptor.class);
    
    private static final long serialVersionUID = -3936772203980270629L;

    @Override
    public String intercept(ActionInvocation ai) throws Exception {

        String result = null;
        String requestInfo = getRequestInfo(ai);
        
        try {
                logger.info(requestInfo);
                result = ai.invoke();
                
        } catch (Exception ex) {
                
                logger.error(requestInfo + " | " + ex.getMessage(), ex);
                
                return "unhandledException";
        }
        
        return result;
    }
}
