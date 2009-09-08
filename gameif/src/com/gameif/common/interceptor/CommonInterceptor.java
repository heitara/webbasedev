package com.gameif.common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CommonInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -3936772203980270629L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String getRequestInfo(ActionInvocation ai) {

		StringBuffer msgBuff = new StringBuffer();
		String account = (String)ai.getInvocationContext().getSession().get("account");		
		
		msgBuff.append(ServletActionContext.getRequest().getRemoteAddr());
		msgBuff.append(" | ");
		msgBuff.append(account == null ? "-" : account);
		msgBuff.append(" | ");
		msgBuff.append(ServletActionContext.getRequest().getRequestURI());
		
		if (ServletActionContext.getRequest().getQueryString() != null) {
			msgBuff.append("?");
			msgBuff.append(ServletActionContext.getRequest().getQueryString());
		}

		msgBuff.append(" | ");
		msgBuff.append(ai.getAction().getClass().getSimpleName());
		msgBuff.append(".");
		msgBuff.append(ai.getProxy().getMethod());
		msgBuff.append("()");
		
		return msgBuff.toString();		
	}
}
