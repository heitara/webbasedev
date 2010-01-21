package com.gameif.backoffice.bean;

import java.io.Serializable;
import java.util.Date;

public class SalesSearchCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8208522868054411076L;

	private String salesType;
	private Date settleStartDate;
	private Date settleEndDate;
	private Date settleStartMonth;
	private Date settleEndMonth;
	private String memId;
	private Integer titleId;
	private Integer pointId;

	/**
	 * @return the salesType
	 */
	public String getSalesType() {
		return salesType;
	}

	/**
	 * @param salesType
	 *            the salesType to set
	 */
	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	/**
	 * @return the settleStartDate
	 */
	public Date getSettleStartDate() {
		return settleStartDate;
	}

	/**
	 * @param settleStartDate
	 *            the settleStartDate to set
	 */
	public void setSettleStartDate(Date settleStartDate) {
		this.settleStartDate = settleStartDate;
	}

	/**
	 * @return the settleEndDate
	 */
	public Date getSettleEndDate() {
		return settleEndDate;
	}

	/**
	 * @param settleEndDate
	 *            the settleEndDate to set
	 */
	public void setSettleEndDate(Date settleEndDate) {
		this.settleEndDate = settleEndDate;
	}

	/**
	 * @return the settleStartMonth
	 */
	public Date getSettleStartMonth() {
		return settleStartMonth;
	}

	/**
	 * @param settleStartMonth
	 *            the settleStartMonth to set
	 */
	public void setSettleStartMonth(Date settleStartMonth) {
		this.settleStartMonth = settleStartMonth;
	}

	/**
	 * @return the settleEndMonth
	 */
	public Date getSettleEndMonth() {
		return settleEndMonth;
	}

	/**
	 * @param settleEndMonth
	 *            the settleEndMonth to set
	 */
	public void setSettleEndMonth(Date settleEndMonth) {
		this.settleEndMonth = settleEndMonth;
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
	 * @return the titleId
	 */
	public Integer getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId
	 *            the titleId to set
	 */
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the pointId
	 */
	public Integer getPointId() {
		return pointId;
	}

	/**
	 * @param pointId
	 *            the pointId to set
	 */
	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

}
