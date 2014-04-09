package com.gameif.payment.action.payment;

import java.util.List;

import com.gameif.payment.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.payment.entity.PointMst;
import com.gameif.payment.entity.ServerMst;

public class PaymentBindMasterAction {
	
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

	private Integer titleId;
	private List<ServerMst> serverList;
	private List<PointMst> pointList;

	/**
	 * タイトルIDにより、有効なサーバ情報とポイント情報を取得する
	 * @return
	 */
	public String bindServerAndPoint() {
		// サーバ情報
		serverList = masterInfoBusinessLogic.getAllValidServerListByTitle(titleId);
		// ポイント情報
		pointList = masterInfoBusinessLogic.getAllValidPointListByTitle(titleId);
		return "success";
	}
	
	/**
	 * タイトルIDにより、有効なサーバ情報とサービスポイントの残高を取得する
	 * @return
	 */
	public String bindServerAndBalance() {
		// サーバ情報
		serverList = masterInfoBusinessLogic.getAllValidServerListByTitle(titleId);
		return "success";
	}

	/**
	 * @return the masterInfoBusinessLogic
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	/**
	 * @param masterInfoBusinessLogic
	 *            the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
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
	 * @return the serverList
	 */
	public List<ServerMst> getServerList() {
		return serverList;
	}

	/**
	 * @param serverList
	 *            the serverList to set
	 */
	public void setServerList(List<ServerMst> serverList) {
		this.serverList = serverList;
	}

	/**
	 * @return the pointList
	 */
	public List<PointMst> getPointList() {
		return pointList;
	}

	/**
	 * @param pointList the pointList to set
	 */
	public void setPointList(List<PointMst> pointList) {
		this.pointList = pointList;
	}

}
