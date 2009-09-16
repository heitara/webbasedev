package com.gameif.common.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

public class BaseActionSupport extends ActionSupport {

	private static final long serialVersionUID = -1232609418286925518L;
	
	protected final static Log logger = LogFactory.getLog(BaseActionSupport.class);
	
	protected final static String WARNING = "warning";
	
	protected final static String SELECT = "select";
	
	protected final static String LOGIN = "login";
}
