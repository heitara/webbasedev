package com.gameif.portal.action.pointCharge;

import java.util.List;

import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.ServerMst;

public class PointChargeBindMasterAction {
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

	private Integer titleId;
	private List<ServerMst> serverList;
	private Integer serverId;
	private List<PointMst> pointList;

	/**
	 * タイトルIDにより、有効なサーバ情報を取得する
	 * @return
	 */
	public String bindServer() {
		serverList = masterInfoBusinessLogic.getAllValidServerListByTitle(titleId);
		return "success";
	}

	/**
	 * サーバIDにより、有効なポイント情報を取得する
	 * @return
	 */
	public String bindPoint() {
		pointList = masterInfoBusinessLogic.getAllValidPointListByServer(serverId);
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
	 * @return the serverId
	 */
	public Integer getServerId() {
		return serverId;
	}

	/**
	 * @param serverId the serverId to set
	 */
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
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
