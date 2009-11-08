package com.gameif.portal.action.menu;

import java.util.Map;
import javax.servlet.http.Cookie;
import org.apache.struts2.ServletActionContext;

import com.gameif.portal.constants.PortalConstants;

public class EntryProxyAction {

	private String enc;
	private String title;
	private String titleEntryUrl;
	private Integer cookieAge;
	private Map<String, String> titleEntryUrls;
	
	public String execute() {
		
		if (enc != null) {
			
			addEncToCookie();
		}
		
		if (title != null) {

			titleEntryUrl = titleEntryUrls.get(title);
		}
		
		if (titleEntryUrl == null) {

			titleEntryUrl = titleEntryUrls.get("0");
		}		
		
		return "success";
	}
	
	private void addEncToCookie() {
		
	    Cookie cookie = new Cookie(PortalConstants.Key.SEURE_PARAM_KEY, enc);
	    cookie.setPath("/");
	    cookie.setMaxAge(60*60);
	    ServletActionContext.getResponse().addCookie(cookie);
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