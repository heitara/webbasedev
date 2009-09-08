package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemberLoginInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4483423658582102343L;
	
	private Integer memNum;
	private String memId;
	private String nickName;
	private String memPwd;
	private String loginIp;
	private Date loginDate;
	private String loginFailIp;
	private Date loginFailDate;
	private Integer loginFailCnt;
	private String lastUpdateIp;
	private Date lastUpdateDate;
	private Integer versionNo;

	private String newPwd;
	private String confirmPwd;
	/**
	 * @return the memNum
	 */
	public Integer getMemNum() {
		return memNum;
	}
	/**
	 * @param memNum the memNum to set
	 */
	public void setMemNum(Integer memNum) {
		this.memNum = memNum;
	}
	/**
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}
	/**
	 * @param memId the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the memPwd
	 */
	public String getMemPwd() {
		return memPwd;
	}
	/**
	 * @param memPwd the memPwd to set
	 */
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	/**
	 * @return the loginIp
	 */
	public String getLoginIp() {
		return loginIp;
	}
	/**
	 * @param loginIp the loginIp to set
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	/**
	 * @return the loginDate
	 */
	public Date getLoginDate() {
		return loginDate;
	}
	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	/**
	 * @return the loginFailIp
	 */
	public String getLoginFailIp() {
		return loginFailIp;
	}
	/**
	 * @param loginFailIp the loginFailIp to set
	 */
	public void setLoginFailIp(String loginFailIp) {
		this.loginFailIp = loginFailIp;
	}
	/**
	 * @return the loginFailDate
	 */
	public Date getLoginFailDate() {
		return loginFailDate;
	}
	/**
	 * @param loginFailDate the loginFailDate to set
	 */
	public void setLoginFailDate(Date loginFailDate) {
		this.loginFailDate = loginFailDate;
	}
	/**
	 * @return the loginFailCnt
	 */
	public Integer getLoginFailCnt() {
		return loginFailCnt;
	}
	/**
	 * @param loginFailCnt the loginFailCnt to set
	 */
	public void setLoginFailCnt(Integer loginFailCnt) {
		this.loginFailCnt = loginFailCnt;
	}
	/**
	 * @return the lastUpdateIp
	 */
	public String getLastUpdateIp() {
		return lastUpdateIp;
	}
	/**
	 * @param lastUpdateIp the lastUpdateIp to set
	 */
	public void setLastUpdateIp(String lastUpdateIp) {
		this.lastUpdateIp = lastUpdateIp;
	}
	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	/**
	 * @return the versionNo
	 */
	public Integer getVersionNo() {
		return versionNo;
	}
	/**
	 * @param versionNo the versionNo to set
	 */
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	/**
	 * @return the newPwd
	 */
	public String getNewPwd() {
		return newPwd;
	}
	/**
	 * @param newPwd the newPwd to set
	 */
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	/**
	 * @return the confirmPwd
	 */
	public String getConfirmPwd() {
		return confirmPwd;
	}
	/**
	 * @param confirmPwd the confirmPwd to set
	 */
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

}
