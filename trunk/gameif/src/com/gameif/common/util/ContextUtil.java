package com.gameif.common.util;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class ContextUtil {

	public final static String getAccountId() {
		
		return (String)ActionContext.getContext().getSession().get("account");
	}

	public final static String getClientIP() {
		
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	public final static String getRequestedURIQuery() {

		StringBuffer uriq = new StringBuffer();
		
		uriq.append(ServletActionContext.getRequest().getRequestURI());
		
		if (ServletActionContext.getRequest().getQueryString() != null) {
			uriq.append("?");
			uriq.append(ServletActionContext.getRequest().getQueryString());
		}
		
		return uriq.toString();
	}
	
	public final static String getRequestBaseInfo() {
		
		StringBuffer info = new StringBuffer();
		
		String account = getAccountId();
		
		info.append(getClientIP());
		info.append(" | ");
		info.append(account == null ? "-" : account);
		info.append(" | ");
		info.append(getRequestedURIQuery());
		
		return info.toString();
	}
}
