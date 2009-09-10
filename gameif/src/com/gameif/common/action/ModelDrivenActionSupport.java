package com.gameif.common.action;

import com.opensymphony.xwork2.interceptor.ScopedModelDriven;

public class ModelDrivenActionSupport<T> extends BaseActionSupport implements ScopedModelDriven<T> {
	
	private static final long serialVersionUID = 1L;

	private T model;

	private String scope;

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(T model) {
		this.model = model;
	}

	public T getModel() {
		return model;
	}

	public String getScopeKey() {
		return this.scope;
	}

	public void setScopeKey(String arg0) {
		this.scope = arg0;
	}
}
