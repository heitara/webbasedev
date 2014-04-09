package com.gameif.payment.action.payment;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.payment.businesslogic.IPaymentBusinessLogic;
import com.gameif.payment.constants.PortalConstants;
import com.gameif.payment.entity.MemSettlementHist;
import com.gameif.payment.entity.MemSettlementTrns;
import com.gameif.payment.util.ContextUtil;

public class BiglobePaymentControlAction extends ModelDrivenActionSupport<MemSettlementHist> {
	
	private static final long serialVersionUID = -7492565950587701715L;

	private IPaymentBusinessLogic paymentBusinessLogic;
	
	private String biglobeShopCode;
	private String biglobeGoodsCode;
	private String biglobeUserId;
	private String requestUrl;
	private String providerIps;
	private String shopGoodsCodes;
	
	/**
	 * 仮決済情報をテーブルに登録する
	 * @return
	 */
	public String chargePrepare() {
		
		MemSettlementTrns settlementTrns = new MemSettlementTrns();

		settlementTrns.setSettlementCode(PortalConstants.SettlementCode.BIGLOBE);
		settlementTrns.setMemNum(ContextUtil.getMemberNoWithExt());
		settlementTrns.setTitleId(getModel().getTitleId());
		settlementTrns.setServerId(getModel().getServerId());
		settlementTrns.setPointId(getModel().getPointId());
		settlementTrns.setProviderId(PortalConstants.NO);

		// 仮決済を登録する
		paymentBusinessLogic.createSettlementTrns(settlementTrns);

		getModel().setSettlementTrnsNum(settlementTrns.getSettlementTrnsNum());
		biglobeGoodsCode = getShopGoodsCode(settlementTrns.getPointId());
		
		outputPreLog(settlementTrns);

		return "bigLobeDetail";
	}

	protected int getPlayHistCount() {
		
		return paymentBusinessLogic.countPlayHist(ContextUtil.getMemberNo(), getModel().getTitleId(), getModel().getServerId());
	}
	
	private String getShopGoodsCode(Integer pointId) {
		
		String result = null;
		
		String[] codes = shopGoodsCodes.split(",");
		
		for (String code : codes) {
			
			String[] cs = code.split(":");
			
			if (cs[0].equals(pointId.toString())) {
				
				result = cs[1];
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 購入結果を受取る(For BigLobe)
	 * 
	 * @return
	 */
	public void chargeReceive() {
		
		// BiglobeサーバIPチェック
		if (isCallFromProvider()) {

			HttpServletRequest request = ServletActionContext.getRequest();
			
			String gwShopCode = request.getParameter("GwShopCode");
			String gwGoodsCode = request.getParameter("GwGoodsCode");
			String gwUserId = request.getParameter("GwUserId");
			
			MemSettlementTrns settlementTrns = paymentBusinessLogic.getSettlementTrnsByKey(getModel().getSettlementTrnsNum());
			
			// パラメータ有効性チェック
			if (settlementTrns != null
					&& biglobeShopCode.equals(gwShopCode)
					&& getShopGoodsCode(settlementTrns.getPointId()).equals(gwGoodsCode)
					&& PortalConstants.SettlementCode.BIGLOBE.equals(settlementTrns.getSettlementCode())) {

				try {
					
					getModel().setSettlementRemarks(gwUserId);
					
					paymentBusinessLogic.createSettlementHist(getModel());

					outputPostLog();
					doResponse("OK");
					
					return;
					
				} catch (Exception ex) {
					
					logger.warn(ContextUtil.getRequestBaseInfo() + " | " + ex.getMessage());

					doResponse("NG");
					
					return;
				}
			}
		}
		
		doResponse("NG");
	}
	
	/**
	 * 決済完了画面に案内する
	 * 
	 * @return
	 */
	public String chargeSuccess() {
		
		return SUCCESS;
	}
	
	/**
	 * エラーが発生しました場合、エラー画面に案内する
	 * 
	 * @return
	 */
	public String chargeError() {
		
		return ERROR;
	}
	
	/**
	 * 決済結果をBigLobeへレスポンスする
	 * @param resultStatus
	 * @param errMsg
	 */
	private void doResponse(String result) {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		try {
			
			response.setContentType("text/csv; charset=Shift_JIS");
			response.setCharacterEncoding("Shift_JIS");
			response.setHeader("X-BLRETSTAT", result);
			response.getWriter().println();
			
		} catch (Exception ex) {
			
			logger.warn(ContextUtil.getRequestBaseInfo() + " | " + ex.getMessage());	
		}
	}
	
	/**
	 * BIGLOBEサーバからの呼出かをチェック
	 * @return true:BIGLOBEサーバからの呼出, false:不正呼出
	 */
	private boolean isCallFromProvider() {
		
		boolean isCallFromProvider = false;
		String clientIp = ContextUtil.getClientIP();
		
		String[] ips = providerIps.split(",");
		
		for (String ip : ips) {
			
			if (clientIp.equals(ip.trim())) {
				
				isCallFromProvider = true;
				break;				
			}
		}
		
		return isCallFromProvider;
	}
		
	/**
	 * 仮決済情報をログに出力する(For BigLobe)
	 * @param settlementTrns
	 * @return
	 */
	private void outputPreLog(MemSettlementTrns settlementTrns) {
		
		String logBuff = new StringBuilder()
			.append(ContextUtil.getRequestBaseInfo())
			.append(" | External I/F--SettlementTrns Result For Biglobe: settlementTrnsNum=")
			.append(settlementTrns.getSettlementTrnsNum())
			.append(", custCode=")
			.append(settlementTrns.getMemNum())
			.append(", title=")
			.append(settlementTrns.getTitleId())
			.append(", serverId=")
			.append(settlementTrns.getServerId())
			.append(", itemId=")
			.append(settlementTrns.getPointId())
			.append(", pointAmount=")
			.append(settlementTrns.getPointAmount())
			.append(", pointAmountAct=")
			.append(settlementTrns.getPointAmountAct())
			.append(", settlementDate=")
			.append(new SimpleDateFormat("yyyyMMddHHmmss")
			.format(settlementTrns.getSettlementDate()))
			.toString();
		
		logger.info(logBuff);
	}

	/**
	 * ポイントチャージ完了のログ出力
	 */
	private void outputPostLog() {

		// ログ出力
		String logBuff = new StringBuilder()
			.append(ContextUtil.getRequestBaseInfo())
			.append(" | External I/F--Settlement Result For Biglobe: GwShopCode=")
			.append(biglobeShopCode)
			.append(", GwGoodsCode=")
			.append(biglobeGoodsCode)
			.append(", GwUserId=")
			.append(biglobeUserId)
			.append(", settlementTrnsNum=")
			.append(getModel().getSettlementTrnsNum())
			.append(", clientIp=")
			.append(ContextUtil.getClientIP())
			.toString();

		logger.info(logBuff.toString());
	}

	public void setPaymentBusinessLogic(IPaymentBusinessLogic paymentBusinessLogic) {
		this.paymentBusinessLogic = paymentBusinessLogic;
	}


	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public void setBiglobeUserId(String biglobeUserId) {
		this.biglobeUserId = biglobeUserId;
	}

	public void setProviderIps(String providerIps) {
		this.providerIps = providerIps;
	}

	public void setShopGoodsCodes(String shopGoodsCodes) {
		this.shopGoodsCodes = shopGoodsCodes;
	}

	public String getBiglobeShopCode() {
		return biglobeShopCode;
	}

	public void setBiglobeShopCode(String biglobeShopCode) {
		this.biglobeShopCode = biglobeShopCode;
	}

	public String getBiglobeGoodsCode() {
		return biglobeGoodsCode;
	}
}