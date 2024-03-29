package com.gameif.portal.action.menu;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.util.ByteUtil;
import com.gameif.common.util.SecurityUtil;
import com.gameif.portal.constants.PortalConstants;

public class EntryProxyAction {

	private String enc;
	private String title;
	private String apply;
	private String titleEntryUrl;
	private Integer cookieAge;
	private Map<String, String> titleEntryUrls;
	
	public String execute() throws UnsupportedEncodingException {
		
		if (enc != null) {
			
			addEntryDataToCookie();
		}
		
		setTitleEntryUrl();
		
		return "success";
	}
	
	private void addEntryDataToCookie() {
		
	    Cookie cookie = null;
	    
	    if (enc != null) {

		    cookie = new Cookie(PortalConstants.Key.SEURE_PARAM_KEY, ByteUtil.stringToHexString(enc));
		    cookie.setPath("/");
		    cookie.setMaxAge(cookieAge);
		    ServletActionContext.getResponse().addCookie(cookie);
	    }
	    
	    if (title != null) {
	    	
		    cookie = new Cookie("title", title);
		    cookie.setPath("/");
		    cookie.setMaxAge(cookieAge);
		    ServletActionContext.getResponse().addCookie(cookie);
	    }
	    
	    if (apply != null) {
	    	
		    cookie = new Cookie("apply", apply);
		    cookie.setPath("/");
		    cookie.setMaxAge(cookieAge);
		    ServletActionContext.getResponse().addCookie(cookie);
	    }
	}
	
	private void setTitleEntryUrl() {		
		
		String advertNum = getAdvertNum();
		
		if (title != null) {

			if (advertNum != null) {

				titleEntryUrl = titleEntryUrls.get(title + "." + advertNum);
			}
			
			if (titleEntryUrl == null) {

				titleEntryUrl = titleEntryUrls.get(title);
			}
		}
		
		if (titleEntryUrl == null) {

			if (advertNum != null) {

				titleEntryUrl = titleEntryUrls.get("0." + advertNum);
			}
			
			if (titleEntryUrl == null) {

				titleEntryUrl = titleEntryUrls.get("0");
			}

			titleEntryUrl = titleEntryUrls.get("0");
		}
	}
	
	private String getAdvertNum() {
		
		String advertNum = null;
			
		if (enc != null) {
			
			Map<String, String> paramMap = SecurityUtil.decodeParam(enc);
			
			advertNum = paramMap.get("advertNum");
		}
		
		return advertNum;
	}

	public String getEnc() {
		return enc;
	}

	public void setEnc(String enc) {
		this.enc = enc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getApply() {
		return apply;
	}

	public void setApply(String apply) {
		this.apply = apply;
	}

	public String getTitleEntryUrl() {
		return titleEntryUrl;
	}

	public void setTitleEntryUrl(String titleEntryUrl) {
		this.titleEntryUrl = titleEntryUrl;
	}

	public Integer getCookieAge() {
		return cookieAge;
	}

	public void setCookieAge(Integer cookieAge) {
		this.cookieAge = cookieAge;
	}

	public Map<String, String> getTitleEntryUrls() {
		return titleEntryUrls;
	}

	public void setTitleEntryUrls(Map<String, String> titleEntryUrls) {
		this.titleEntryUrls = titleEntryUrls;
	}
}