package com.gameif.portal.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public abstract class BaseParameterInterceptor extends MethodFilterInterceptor {

	protected final static Log logger = LogFactory.getLog(BaseParameterInterceptor.class);
	private static final long serialVersionUID = 715134549579521474L;

	public abstract String doIntercept(ActionInvocation ai) throws Exception;
	
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