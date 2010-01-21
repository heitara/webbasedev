package com.gameif.backoffice.action.sales;

import java.util.List;

import com.gameif.backoffice.businesslogic.ISalesBusinessLogic;
import com.gameif.backoffice.entity.PointMst;

public class SalesBindMasterAction {
	private Integer titleId;
	private List<PointMst> pointList;
	
	private ISalesBusinessLogic salesBusinessLogic;
	
	public String bindPointMst() {
		pointList = salesBusinessLogic.getPointListByTitleId(titleId);
		return "success";
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
	 * @return the pointList
	 */
	public List<PointMst> getPointList() {
		return pointList;
	}

	/**
	 * @param pointList
	 *            the pointList to set
	 */
	public void setPointList(List<PointMst> pointList) {
		this.pointList = pointList;
	}

	/**
	 * @param salesBusinessLogic the salesBusinessLogic to set
	 */
	public void setSalesBusinessLogic(ISalesBusinessLogic salesBusinessLogic) {
		this.salesBusinessLogic = salesBusinessLogic;
	}

}
