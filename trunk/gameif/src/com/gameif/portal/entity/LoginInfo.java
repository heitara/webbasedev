package com.gameif.portal.entity;

import com.gameif.common.entity.BaseEntity;

public class LoginInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3084374401153985882L;
	private Long memNum;
	private String memId;
	private String mempwd;
	private String mailPc;
	private String confirmpwd;
	private String newpwd;

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
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}

	/**
	 * @param memId
	 *            the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
	}

	/**
	 * @return the mempwd
	 */
	public String getMempwd() {
		return mempwd;
	}

	/**
	 * @param mempwd
	 *            the mempwd to set
	 */
	public void setMempwd(String mempwd) {
		this.mempwd = mempwd;
	}

	/**
	 * @return the mailPc
	 */
	public String getMailPc() {
		return mailPc;
	}

	/**
	 * @param mailPc
	 *            the mailPc to set
	 */
	public void setMailPc(String mailPc) {
		this.mailPc = mailPc;
	}

	/**
	 * @return the confirmpwd
	 */
	public String getConfirmpwd() {
		return confirmpwd;
	}

	/**
	 * @param confirmpwd
	 *            the confirmpwd to set
	 */
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}

	/**
	 * @return the newpwd
	 */
	public String getNewpwd() {
		return newpwd;
	}

	/**
	 * @param newpwd
	 *            the newpwd to set
	 */
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

}
