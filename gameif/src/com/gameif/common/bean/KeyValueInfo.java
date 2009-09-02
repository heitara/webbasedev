package com.gameif.common.bean;

import com.gameif.common.entity.BaseEntity;

public class KeyValueInfo extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8528861061993715380L;

	private String key;
	private String value;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
