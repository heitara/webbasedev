package com.gameif.common.interceptor;

import com.gameif.common.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CommonInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -3936772203980270629L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		
		return null;
	}
	
	protected String getRequestInfo(ActionInvocation ai) {

		StringBuffer msgBuff = new StringBuffer();
		
		msgBuff.append(ContextUtil.getRequestBaseInfo());

		msgBuff.append(" | ");
		msgBuff.append(ai.getAction().getClass().getSimpleName());
		msgBuff.append(".");
		msgBuff.append(ai.getProxy().getMethod());
		msgBuff.append("()");
		
		return msgBuff.toString();
	}
}
