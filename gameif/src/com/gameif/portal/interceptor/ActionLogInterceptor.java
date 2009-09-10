package com.gameif.portal.interceptor;

import org.apache.log4j.Logger;

import com.gameif.common.interceptor.CommonInterceptor;
import com.opensymphony.xwork2.ActionInvocation;

public class ActionLogInterceptor extends CommonInterceptor {

        private final static Logger logger = Logger.getLogger(ActionLogInterceptor.class);
        
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
