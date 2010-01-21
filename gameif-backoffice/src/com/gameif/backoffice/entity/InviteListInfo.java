package com.gameif.backoffice.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class InviteListInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6640566970251918135L;

	private Long memNum;
	private String memId;
	private String nickName;
	private String mailAdd;
	private String entryIp;
	private Date entryDate;
	private Long childMemNum;
	private String childMemId;
	private String childNickName;
	private String childMailAdd;
	private String childEntryIp;
	private Date childEntryDate;

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
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the mailAdd
	 */
	public String getMailAdd() {
		return mailAdd;
	}

	/**
	 * @param mailAdd
	 *            the mailAdd to set
	 */
	public void setMailAdd(String mailAdd) {
		this.mailAdd = mailAdd;
	}

	/**
	 * @return the entryIp
	 */
	public String getEntryIp() {
		return entryIp;
	}

	/**
	 * @param entryIp
	 *            the entryIp to set
	 */
	public void setEntryIp(String entryIp) {
		this.entryIp = entryIp;
	}

	/**
	 * @return the childMemNum
	 */
	public Long getChildMemNum() {
		return childMemNum;
	}

	/**
	 * @param childMemNum
	 *            the childMemNum to set
	 */
	public void setChildMemNum(Long childMemNum) {
		this.childMemNum = childMemNum;
	}

	/**
	 * @return the childMemId
	 */
	public String getChildMemId() {
		return childMemId;
	}

	/**
	 * @param childMemId
	 *            the childMemId to set
	 */
	public void setChildMemId(String childMemId) {
		this.childMemId = childMemId;
	}

	/**
	 * @return the childNickName
	 */
	public String getChildNickName() {
		return childNickName;
	}

	/**
	 * @param childNickName
	 *            the childNickName to set
	 */
	public void setChildNickName(String childNickName) {
		this.childNickName = childNickName;
	}

	/**
	 * @return the childMailAdd
	 */
	public String getChildMailAdd() {
		return childMailAdd;
	}

	/**
	 * @param childMailAdd
	 *            the childMailAdd to set
	 */
	public void setChildMailAdd(String childMailAdd) {
		this.childMailAdd = childMailAdd;
	}

	/**
	 * @return the childEntryIp
	 */
	public String getChildEntryIp() {
		return childEntryIp;
	}

	/**
	 * @param childEntryIp
	 *            the childEntryIp to set
	 */
	public void setChildEntryIp(String childEntryIp) {
		this.childEntryIp = childEntryIp;
	}

	/**
	 * @return the entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate
	 *            the entryDate to set
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the childEntryDate
	 */
	public Date getChildEntryDate() {
		return childEntryDate;
	}

	/**
	 * @param childEntryDate the childEntryDate to set
	 */
	public void setChildEntryDate(Date childEntryDate) {
		this.childEntryDate = childEntryDate;
	}

}
