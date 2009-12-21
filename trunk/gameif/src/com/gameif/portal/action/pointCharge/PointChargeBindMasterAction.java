package com.gameif.portal.action.pointCharge;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IServicePointBusinessLogic;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.util.ContextUtil;

public class PointChargeBindMasterAction {
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IServicePointBusinessLogic servicePointBusinessLogic;

	private Integer titleId;
	private List<ServerMst> serverList;
	private List<PointMst> pointList;
	private BigDecimal balance;

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
		// 指定タイトルのサービスポイント残高情報
		balance = servicePointBusinessLogic.getBalanceByTitle(titleId, ContextUtil.getMemberNo());
		if (balance == null) {
			balance = new BigDecimal("0");
		}
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

//	/**
//	 * @return the servicePointBusinessLogic
//	 */
//	public IServicePointBusinessLogic getServicePointBusinessLogic() {
//		return servicePointBusinessLogic;
//	}

	/**
	 * @param servicePointBusinessLogic the servicePointBusinessLogic to set
	 */
	public void setServicePointBusinessLogic(
			IServicePointBusinessLogic servicePointBusinessLogic) {
		this.servicePointBusinessLogic = servicePointBusinessLogic;
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

	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
