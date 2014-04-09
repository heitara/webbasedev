package com.gameif.payment.action.servicePoint;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.common.exception.BetaTestException;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.MaintenanceException;
import com.gameif.common.exception.OutOfMaxCountException;
import com.gameif.payment.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.payment.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.payment.businesslogic.IPaymentBusinessLogic;
import com.gameif.payment.businesslogic.IServicePointBusinessLogic;
import com.gameif.payment.constants.PortalConstants;
import com.gameif.payment.entity.MySPGiveHist;
import com.gameif.payment.entity.MySPInfo;
import com.gameif.payment.entity.MySPUseHist;
import com.gameif.payment.util.ContextUtil;

public class ServicePointControlAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IServicePointBusinessLogic servicePointBusinessLogic;
	private IPaymentBusinessLogic paymentBusinessLogic;
	private IMaintenanceBusinessLogic maintenanceBusinessLogic;

	private Integer titleId;
	private Integer serverId;
	private BigDecimal pointAmount;
	
	
	private List<MySPUseHist> useHistList;
	private List<MySPGiveHist> giveHistList;
	private List<MySPInfo> servicePointList;

	/**
	 * サービスポイント受取画面に案内する
	 * 
	 * @return inputGet サービスポイント受取画面
	 */
	public String inputGet() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.SERVICE_POINT)) {
			return "maintenance";
		}
		return "inputGet";
	}

	/**
	 * サービスポイントを取得する(連続してゲームにログインした場合)
	 * 
	 * @return
	 */
	public String getGameLogin() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.SERVICE_POINT)) {
			return "maintenance";
		}
		
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
		return "finishedGet";
	}
	
	/**
	 * サービスポイント利用画面へ案内する
	 * @return サービスポイント利用画面へ
	 */
	public String inputCharge() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.SERVICE_POINT)) {
			return "maintenance";
		}
		
		setServicePointList(servicePointBusinessLogic.getMyServicePointList());
		return "inputCharge";
	}
	
	/**
	 * サービスポイントを利用する
	 * @return
	 */
	public String use() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.SERVICE_POINT)) {
			return "maintenance";
		}
		
		// ゲームをプレーすることがあるかどうかのチェック
		Integer count = paymentBusinessLogic.countPlayHist(ContextUtil.getMemberNo(), getTitleId(), getServerId());
		if (count < 1) {
			// プレーすることがない
			addFieldError("errMessage", getText("title.noData"));
			return "inputCharge";
		}
		
		try {
			// メンテナンスとCBTチェック
			maintenanceBusinessLogic.maintenanceCheckByTitleId(titleId);
			
			servicePointBusinessLogic.useServicePoint(titleId, serverId, pointAmount);
		} catch (MaintenanceException mtEx) {
			// メンテナンス
			addFieldError("errMessage", getText("title.maintenance"));
			return "inputCharge";
		} catch (BetaTestException testEx) {
			// テスト中
			addFieldError("errMessage", getText("title.test"));
			return "inputCharge";
		} catch (DataNotExistsException dneEx) {
			setServicePointList(servicePointBusinessLogic.getMyServicePointList());
			// データ存在しない
			addFieldError("errMessage", getText("servicePoint.noValidPoint"));
			return "inputCharge";
		} catch (OutOfMaxCountException ex) {
			setServicePointList(servicePointBusinessLogic.getMyServicePointList());
			// サービスポイントが足りない
			addFieldError("errMessage", getText("servicePoint.pointLack"));
			return "inputCharge";
		} catch (LogicException lgex) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());
			return "warning";

		}
		return "finishedCharge";
	}
	
	/**
	 * サービスポイント消費履歴画面へ案内する
	 * @return サービスポイント消費履歴画面
	 */
	public String inputUseList() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.SERVICE_POINT)) {
			return "maintenance";
		}
		
		setUseHistList(servicePointBusinessLogic.getMyUseHistList());
		return "inputUseList";
	}
	
	/**
	 * サービスポイント付与履歴画面へ案内する
	 * @return サービスポイント付与履歴画面
	 */
	public String inputGiveList() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.SERVICE_POINT)) {
			return "maintenance";
		}
		
		setGiveHistList(servicePointBusinessLogic.getMyGiveHistList());
		return "inputGiveList";
	}
	
	/**
	 * サービスポイント付与履歴画面へ案内する
	 * @return サービスポイント付与履歴画面
	 */
	public String input() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.SERVICE_POINT)) {
			return "maintenance";
		}
		
		setServicePointList(servicePointBusinessLogic.getMyServicePointList());
		return INPUT;
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
	 * @return the paymentBusinessLogic
	 */
	public IPaymentBusinessLogic getPaymentBusinessLogic() {
		return paymentBusinessLogic;
	}

	/**
	 * @param paymentBusinessLogic the paymentBusinessLogic to set
	 */
	public void setPaymentBusinessLogic(
			IPaymentBusinessLogic paymentBusinessLogic) {
		this.paymentBusinessLogic = paymentBusinessLogic;
	}

	/**
	 * @return the maintenanceBusinessLogic
	 */
	public IMaintenanceBusinessLogic getMaintenanceBusinessLogic() {
		return maintenanceBusinessLogic;
	}

	/**
	 * @param maintenanceBusinessLogic the maintenanceBusinessLogic to set
	 */
	public void setMaintenanceBusinessLogic(
			IMaintenanceBusinessLogic maintenanceBusinessLogic) {
		this.maintenanceBusinessLogic = maintenanceBusinessLogic;
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
	 * @return the pointAmount
	 */
	public BigDecimal getPointAmount() {
		return pointAmount;
	}

	/**
	 * @param pointAmount the pointAmount to set
	 */
	public void setPointAmount(BigDecimal pointAmount) {
		this.pointAmount = pointAmount;
	}

	/**
	 * @return the useHistList
	 */
	public List<MySPUseHist> getUseHistList() {
		return useHistList;
	}

	/**
	 * @param useHistList the useHistList to set
	 */
	public void setUseHistList(List<MySPUseHist> useHistList) {
		this.useHistList = useHistList;
	}

	/**
	 * @return the giveHistList
	 */
	public List<MySPGiveHist> getGiveHistList() {
		return giveHistList;
	}

	/**
	 * @param giveHistList the giveHistList to set
	 */
	public void setGiveHistList(List<MySPGiveHist> giveHistList) {
		this.giveHistList = giveHistList;
	}

	/**
	 * @return the servicePointList
	 */
	public List<MySPInfo> getServicePointList() {
		return servicePointList;
	}

	/**
	 * @param servicePointList the servicePointList to set
	 */
	public void setServicePointList(List<MySPInfo> servicePointList) {
		this.servicePointList = servicePointList;
	}
	
}
