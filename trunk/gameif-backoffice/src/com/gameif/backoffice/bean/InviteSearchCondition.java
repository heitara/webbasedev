package com.gameif.backoffice.bean;

import java.io.Serializable;
import java.util.Date;

public class InviteSearchCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9185989497166778902L;
	private Date entryStartDate;
	private Date entryEndDate;
	private String memId;
	private String childMemId;
	private String inviteType;

	/**
	 * @return the entryStartDate
	 */
	public Date getEntryStartDate() {
		return entryStartDate;
	}

	/**
	 * @param entryStartDate
	 *            the entryStartDate to set
	 */
	public void setEntryStartDate(Date entryStartDate) {
		this.entryStartDate = entryStartDate;
	}

	/**
	 * @return the entryEndDate
	 */
	public Date getEntryEndDate() {
		return entryEndDate;
	}

	/**
	 * @param entryEndDate
	 *            the entryEndDate to set
	 */
	public void setEntryEndDate(Date entryEndDate) {
		this.entryEndDate = entryEndDate;
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
	 * @return the inviteType
	 */
	public String getInviteType() {
		return inviteType;
	}

	/**
	 * @param inviteType
	 *            the inviteType to set
	 */
	public void setInviteType(String inviteType) {
		this.inviteType = inviteType;
	}

}
