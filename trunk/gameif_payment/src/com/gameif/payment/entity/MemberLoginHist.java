package com.gameif.payment.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemberLoginHist extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6281733780671270981L;

	private Long memNum;
	private Date loginDate;
	private String loginIp;
	private String successFlg;

	/**
	 * @return the memNum
	 */
	public Long getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum
	 *            the memNum to set
	 */
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	/**
	 * @return the loginDate
	 */
	public Date getLoginDate() {
		return loginDate;
	}

	/**
	 * @param loginDate
	 *            the loginDate to set
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * @return the loginIp
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * @param loginIp
	 *            the loginIp to set
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	/**
	 * @return the successFlg
	 */
	public String getSuccessFlg() {
		return successFlg;
	}

	/**
	 * @param successFlg
	 *            the successFlg to set
	 */
	public void setSuccessFlg(String successFlg) {
		this.successFlg = successFlg;
	}

}
