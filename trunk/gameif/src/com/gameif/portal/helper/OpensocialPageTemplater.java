package com.gameif.portal.helper;

import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.gameif.common.exception.SystemException;

import freemarker.template.Template;

public class OpensocialPageTemplater {
	    
    private FreeMarkerConfigurer opensocialFreeMarkerConfigurer = null;
	private Map<String, Map<String, String>> templates;

	
	private String getTemplateFileName(String provider, String templateKey) {
		
		return templates.get(provider).get(templateKey);
	}

	public String getRenderedText(String provider, String templateKey, Map<String, ?> props) {
		
		String result = null;

		try {
			
			Template tpl = opensocialFreeMarkerConfigurer.getConfiguration().getTemplate(getTemplateFileName(provider, templateKey));
			result = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, props);
			
		} catch (Exception ex) {
			
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return result;
	}

	public void setOpensocialFreeMarkerConfigurer(FreeMarkerConfigurer opensocialFreeMarkerConfigurer) {
		
		this.opensocialFreeMarkerConfigurer = opensocialFreeMarkerConfigurer;
	}

	public void setTemplates(Map<String, Map<String, String>> templates) {
		
		this.templates = templates;
	}	
}
