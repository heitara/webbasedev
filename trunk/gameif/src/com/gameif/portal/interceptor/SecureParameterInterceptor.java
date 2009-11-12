package com.gameif.portal.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
	
	protected void setProperty(Object action, String key, String value) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		if (!setFieldValue(action, key, value)) {
			
			Object model = getModel(action);
			
			if (model != null) {

				setFieldValue(model, key, value);
			}			
		}
	}
	
	protected boolean setFieldValue(Object obj, String key, String value) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		boolean success = false;
		Field field = findField(obj, key);
		
		if (field != null) {

			Object typedV = null;
			
			if (String.class.equals(field.getType())) {

				typedV = value;
				
			} else {

				typedV = field.getType().getMethod("valueOf", String.class).invoke(null, value);
			}
			
			String methdName = "set" + Character.toUpperCase(key.charAt(0)) + key.substring(1);
			
			Method method = obj.getClass().getMethod(methdName, new Class[] {field.getType()});
			
			if (method != null) {
				
				method.invoke(obj, new Object[] {typedV});
				success = true;
			}
		}
		
		return success;
	}
	
	protected Object getModel(Object action) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		Object model = null;
		
		Method method = action.getClass().getMethod("getModel");	
		
		if (method != null) {
			
			model = method.invoke(action);
		}
		
		return model;
	}
	
	protected Field findField(Object obj, String fieldName) {
		
		Field result = null;
		Field[] fields = obj.getClass().getDeclaredFields();
				
		for (Field field : fields) {
			
			if (field.getName().equals(fieldName)) {
				
				result = field;
				break;
			}
		}
		
		return result;
	}
}