package com.gameif.common.bean;

import com.gameif.common.entity.BaseEntity;

public class ComSearchCondition extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2310176065830515982L;
	
	private Long memNum;
	
	private String memId;
	
	private String nickName;
	
	private String mailPc;

	// クライドIP 
	private String clientIp;
	// 限定時間 
	private int checkTime;
	
	// 限定日数前のデータ削除する
	private Integer days;

	public Long getMemNum() {
		return memNum;
	}

	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMailPc() {
		return mailPc;
	}

	public void setMailPc(String mailPc) {
		this.mailPc = mailPc;
	}

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

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

}
