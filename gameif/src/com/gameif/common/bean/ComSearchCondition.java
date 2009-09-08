package com.gameif.common.bean;

import com.gameif.common.entity.BaseEntity;

public class ComSearchCondition extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2310176065830515982L;

	/** クライドIP */
	private String clientIp;
	/** 限定時間 */
	private int checkTime;

	/**
	 * 
	 * @param clientIp
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getClientIp() {
		return this.clientIp;
	}

	public void setCheckTime(int checkTime) {
		this.checkTime = checkTime;
	}

	public int getCheckTime() {
		return this.checkTime;
	}

}
