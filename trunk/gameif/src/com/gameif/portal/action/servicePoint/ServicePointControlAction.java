package com.gameif.portal.action.servicePoint;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IServicePointBusinessLogic;
import com.gameif.portal.util.ContextUtil;

public class ServicePointControlAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IServicePointBusinessLogic servicePointBusinessLogic;

	private Integer titleId;

	/**
	 * サービスポイント受取画面に案内する
	 * 
	 * @return inputGet サービスポイント受取画面
	 */
	public String inputGet() {
		return "inputGet";
	}

	/**
	 * サービスポイントを取得する(連続してゲームにログインした場合)
	 * 
	 * @return
	 */
	public String getGameLogin() {
		try {
			servicePointBusinessLogic.getGameLoginServicePoint(titleId);
		} catch (DataNotExistsException dneEx) {
			// メンテナンス
			addFieldError("errMessage", getText("servicePoint.noValidPoint"));
			return "inputGet";
		} catch (LogicException lgex) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());
			return "warning";

		}
		return SUCCESS;
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
	 * @return the servicePointBusinessLogic
	 */
	public IServicePointBusinessLogic getServicePointBusinessLogic() {
		return servicePointBusinessLogic;
	}

	/**
	 * @param servicePointBusinessLogic
	 *            the servicePointBusinessLogic to set
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

}
