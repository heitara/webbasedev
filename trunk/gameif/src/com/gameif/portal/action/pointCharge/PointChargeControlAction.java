package com.gameif.portal.action.pointCharge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.LogicException;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IPointChargeBusinessLogic;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MemSettlementTrns;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.SettlementMst;

public class PointChargeControlAction extends
		ModelDrivenActionSupport<MemSettlementHist> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7492565950587701715L;

	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IPointChargeBusinessLogic pointChargeBusinessLogic;

	private List<SettlementMst> settleList;
	private String requestUrl;

	private Integer titleId;
	private Integer serverId;
	private Integer pointId;
	private Long settleTrnsNum;

	// 購入要求用パラメータ
	private String pay_method;
	private String merchant_id;
	private String service_id;
	private String cust_code;
	private String sps_cust_no;
	private String sps_payment_no;
	private String order_id;
	private String item_id;
	private String pay_item_id;
	private String item_name;
	private String tax;
	private String amount;
	private String pay_type;
	private String auto_charge_type;
	private String service_type;
	private String div_settele;
	private String last_charge_month;
	private String camp_type;
	private String tracking_id;
	private String terminal_type;
	private String success_url;
	private String cancel_url;
	private String error_url;
	private String pagecon_url;
	private String free1;
	private String free2;
	private String free3;
	private String free_csv;
	private String request_date;
	private String limit_second;
	private String sps_hashcode;
	
	// 購入結果通知用パラメータ
	private String result;
	private String errMsg;

	/**
	 * ポイントチャージ（ポイント選択）画面に案内する
	 * 
	 * @return
	 */
	public String PointSelect() {
		return "pointSelect";
	}

	/**
	 * ポイントチャージ（決済方法選択）画面に案内する
	 * 
	 * @return
	 */
	public String SettleSelectInit() {
		return "settleSelectInit";
	}

	/**
	 * ポイントチャージ（決済方法選択）画面初期化
	 * 
	 * @return
	 */
	public String SettleSelect() {
		settleList = masterInfoBusinessLogic.getAllSettlementList();

		this.getModel().setTitleId(titleId);
		this.getModel().setServerId(serverId);
		this.getModel().setPointId(pointId);

		return "settleSelect";
	}

	/**
	 * 仮決済を登録する
	 * 
	 * @return detail（チャージ明細画面に案内する）
	 */
	public String SaveSettleTrns() {
		MemSettlementTrns settlementTrns = new MemSettlementTrns();

		// ゲーム
		settlementTrns.setTitleId(this.getModel().getTitleId());
		// サーバ
		settlementTrns.setServerId(this.getModel().getServerId());
		// チャージポイント
		settlementTrns.setPointId(this.getModel().getPointId());
		// 決済方法
		settlementTrns.setSettlementCode(this.getModel().getSettlementCode());

		try {

			// 仮決済を登録する
			pointChargeBusinessLogic.saveSettlementTrns(settlementTrns);

		} catch (LogicException ex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ex.getMessage());

			return "warning";
		}

		setSettleTrnsNum(settlementTrns.getSettlementTrnsNum());

		return "detail";
	}

	/**
	 * チャージ明細画面に案内する
	 * 
	 * @return detail（チャージ明細画面に案内する、SBPSと連動する）
	 */
	public String Detail() {
		
		setSettleTrnsNum(Long.parseLong(ServletActionContext.getRequest().getParameter("settleTrnsNum")));
		
		MemSettlementTrns settleTrns = pointChargeBusinessLogic.getSettlementTrnsByKey(getSettleTrnsNum());

		initRequestParams(settleTrns);

		return "detailInit";

	}
	
	/**
	 * 購入要求用パラメータを設定する
	 */
	private void initRequestParams(MemSettlementTrns settleTrns) {
		// 支払方法：画面で選択した決済方法
//		setPay_method(settleTrns.getSettlementCode());
		setPay_method("bitcash");
		// マーチャントID：""
		setMerchant_id("30132");
		// サービスID：""
		setService_id("001");
		// 顧客ID：会員番号
//		setCust_code(settleTrns.getMemNum().toString());
		setCust_code("12");
		// SPS顧客ID：””
		setSps_cust_no("");
		// SPS支払方法管理番号
		setSps_payment_no("");
		// 購入ID：仮決済番号
//		setOrder_id(settleTrns.getSettlementTrnsNum().toString());
		setOrder_id("10");
		// 商品ID：チャージポイントID
//		setItem_id(settleTrns.getPointId().toString());
		setItem_id("1");
		// 外部決済機関商品ID：””
		setPay_item_id("");
		
//		// 商品名称：商品IDより、ポイントマスタから取得するポイント名称
//		PointMst pointMst = masterInfoBusinessLogic.getPointMstByKey(settleTrns.getPointId());
//		if (pointMst != null) {
//			setItem_name(pointMst.getPointName());
//		} else {
//			setItem_name("");
//		}
		setItem_name("500 ポイント　　　【     500 円 】");
		
		// 税額：””
		setTax("");
		// 金額(税込)：仮決済の本決済金額
//		setAmount(settleTrns.getPointAmountAct().toString());
		setAmount("500");
		// 購入タイプ：「０:都度購入」
		setPay_type("0");
		// 自動課金タイプ
		setAuto_charge_type("");
		// サービスタイプ：売上(購入)
		setService_type("0");
		// 決済区分：「継続購入」時のみ指定可
		setDiv_settele("");
		// 最終課金月：「継続購入」時のみ指定可
		setLast_charge_month("");
		// キャンペーンタイプ：「継続購入」時のみ指定可
		setCamp_type("");
		// トラッキングID
		setTracking_id("");
		// 顧客利用端末タイプ：「0固定」
		setTerminal_type("0");
		// 決済完了時URL
		setSuccess_url("http://www.game-if.com/chargeSuccess.html");
		// 決済キャンセル時URL
		setCancel_url("http://www.game-if.com/chargeCancel.html");
		// エラー時URL
		setError_url("http://www.game-if.com/chargeError.html");
		// 決済通知用CGI
		setPagecon_url("http://www.game-if.com/chargeReceive.html");
		// 自由欄１
		setFree1("");
		// 自由欄２
		setFree2("");
		// 自由欄３
		setFree3("");
		// 自由欄(CSV形式) 
		setFree_csv("");
		// リックエスと日時
//		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//		setRequest_date(df.format(new Date()));
		setRequest_date("20091021015432");
		// リクエスト許容時間
		setLimit_second("");
		// チェックサム
//		setSps_hashcode(makeSpsHashCode());
		setSps_hashcode("c48e0e2c7d04f0954594f14c7801bd430ca6263e");
	}
	
	/**
	 * チェックサム値生成
	 * @return UTF-8で文字コード変換したハッシュ値
	 */
	private String makeSpsHashCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(getPay_method())
		.append(getMerchant_id())
		.append(getService_id())
		.append(getCust_code())
		.append(getSps_cust_no())
		.append(getSps_payment_no())
		.append(getOrder_id())
		.append(getItem_id())
		.append(getPay_item_id())
		.append(getItem_name())
		.append(getTax())
		.append(getAmount())
		.append(getPay_type())
		.append(getAuto_charge_type())
		.append(getService_type())
		.append(getDiv_settele())
		.append(getLast_charge_month())
		.append(getCamp_type())
		.append(getTracking_id())
		.append(getTerminal_type())
		.append(getSuccess_url())
		.append(getCancel_url())
		.append(getError_url())
		.append(getPagecon_url())
		.append(getFree1())
		.append(getFree2())
		.append(getFree3())
		.append(getFree_csv());
		
//		// 明細情報の数を取得
//		sb.append("1")
//		.append(getItem_id())
//		.append(getItem_name())
//		.append("1")
//		.append(getTax())
//		.append(getAmount());
		
		sb.append(getRequest_date())
		.append(getLimit_second());
		
		String temp = "bitcash3013200112101500 ポイント　　　【     500 円 】500000http://www.game-if.com/chargeSuccess.htmlhttp://www.game-if.com/chargeCancel.htmlhttp://www.game-if.com/chargeError.htmlhttp://www.game-if.com/chargeReceive.html20091021015432";
		String spsHashCd = "";
		try {
			// 文字コードをUTF-8に変換する
//			byte[] shaBytes = sb.toString().getBytes("UTF-8");
//			byte[] shaBytes = temp.getBytes("UTF-8");
			String newStr = new String(sb);
			byte[] shaBytes = newStr.getBytes("UTF-8");
			// UTF-8で取得した値をハッシュ演算する
			spsHashCd = org.apache.commons.codec.digest.DigestUtils.shaHex(shaBytes);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		
		return spsHashCd;
		
	}
	
	/**
	 * 購入結果を受取る
	 * @return
	 */
	public String Receive() {
		
		getResponseParams();
		
		if (!getModel().getResResult().equals("OK")) {
			setResult("NG");
			setErrMsg("要求NG");
			return "receive";
		}
		
		try {
			// 本決済を登録する
			pointChargeBusinessLogic.createSettlementHist(this.getModel());
			setResult("OK");
			setErrMsg("");
		} catch (LogicException ex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ex.getMessage());

			setResult("NG");
			setErrMsg("決済に予期できないエラーが発生しました。");
		}
		
		return "receive";
	}
	
	/**
	 * 購入要用が取消されました場合、取消画面に案内する
	 * @return
	 */
	public String Cancel() {
		return "cancel";
	}
	
	/**
	 * エラーが発生しました場合、エラー画面に案内する
	 * @return
	 */
	public String Error() {
		return "error";
	}
	
	/**
	 * 決済完了画面に案内する
	 * @return
	 */
	public String Success() {
		
		getResponseParams();
		
		if (!getModel().getResResult().equals("OK")) {
			return "error";
		}
		
		return "success";
	}
	
	/**
	 * 購入結果を取得する
	 */
	private void getResponseParams() {
		// 仮決済番号
		this.getModel().setSettlementTrnsNum(Long.parseLong(ServletActionContext.getRequest().getParameter("order_id")));
		// ステータス
		this.getModel().setResResult(ServletActionContext.getRequest().getParameter("res_result"));
		// トラッキングID
		this.getModel().setResTrackingId(ServletActionContext.getRequest().getParameter("res_tracking_id"));
		// SPS顧客ID
		this.getModel().setResSpsCustNo(ServletActionContext.getRequest().getParameter("res_sps_cust_no"));
		// SPS支払方法管理番号
		this.getModel().setResSpsPaymentNo(ServletActionContext.getRequest().getParameter("res_sps_payment_no"));
		// 顧客決済情報
		this.getModel().setResPayinfoKey(ServletActionContext.getRequest().getParameter("res_payinfo_key"));
		// 購入完了処理時間
		this.getModel().setResPaymentDate(ServletActionContext.getRequest().getParameter("res_payment_date"));
		// エラーコード
		this.getModel().setResErrCode(ServletActionContext.getRequest().getParameter("res_err_code"));
		// レスポンス日時
		this.getModel().setResDate(ServletActionContext.getRequest().getParameter("res_date"));
		// レスポンス許容時間
		this.getModel().setLimitSecond(ServletActionContext.getRequest().getParameter("limit_second"));
		// チェックサム
		this.getModel().setSpsHashcode(ServletActionContext.getRequest().getParameter("sps_hashcode"));
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
	 * @return the pointChargeBusinessLogic
	 */
	public IPointChargeBusinessLogic getPointChargeBusinessLogic() {
		return pointChargeBusinessLogic;
	}

	/**
	 * @param pointChargeBusinessLogic
	 *            the pointChargeBusinessLogic to set
	 */
	public void setPointChargeBusinessLogic(
			IPointChargeBusinessLogic pointChargeBusinessLogic) {
		this.pointChargeBusinessLogic = pointChargeBusinessLogic;
	}

	/**
	 * @return the settleList
	 */
	public List<SettlementMst> getSettleList() {
		return settleList;
	}

	/**
	 * @param settleList
	 *            the settleList to set
	 */
	public void setSettleList(List<SettlementMst> settleList) {
		this.settleList = settleList;
	}

	/**
	 * @return the requestUrl
	 */
	public String getRequestUrl() {
		return requestUrl;
	}

	/**
	 * @param requestUrl
	 *            the requestUrl to set
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	/**
	 * @param titleId
	 *            the titleId to set
	 */
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	/**
	 * @param serverId
	 *            the serverId to set
	 */
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	/**
	 * @param pointId
	 *            the pointId to set
	 */
	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	/**
	 * @return the settleTrnsNum
	 */
	public Long getSettleTrnsNum() {
		return settleTrnsNum;
	}

	/**
	 * @param settleTrnsNum the settleTrnsNum to set
	 */
	public void setSettleTrnsNum(Long settleTrnsNum) {
		this.settleTrnsNum = settleTrnsNum;
	}

	/**
	 * @return the pay_method
	 */
	public String getPay_method() {
		return pay_method;
	}

	/**
	 * @param pay_method the pay_method to set
	 */
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	/**
	 * @return the merchant_id
	 */
	public String getMerchant_id() {
		return merchant_id;
	}

	/**
	 * @param merchant_id the merchant_id to set
	 */
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	/**
	 * @return the service_id
	 */
	public String getService_id() {
		return service_id;
	}

	/**
	 * @param service_id the service_id to set
	 */
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	/**
	 * @return the cust_code
	 */
	public String getCust_code() {
		return cust_code;
	}

	/**
	 * @param cust_code the cust_code to set
	 */
	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}

	/**
	 * @return the sps_cust_no
	 */
	public String getSps_cust_no() {
		return sps_cust_no;
	}

	/**
	 * @param sps_cust_no the sps_cust_no to set
	 */
	public void setSps_cust_no(String sps_cust_no) {
		this.sps_cust_no = sps_cust_no;
	}

	/**
	 * @return the sps_payment_no
	 */
	public String getSps_payment_no() {
		return sps_payment_no;
	}

	/**
	 * @param sps_payment_no the sps_payment_no to set
	 */
	public void setSps_payment_no(String sps_payment_no) {
		this.sps_payment_no = sps_payment_no;
	}

	/**
	 * @return the order_id
	 */
	public String getOrder_id() {
		return order_id;
	}

	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	/**
	 * @return the item_id
	 */
	public String getItem_id() {
		return item_id;
	}

	/**
	 * @param item_id the item_id to set
	 */
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	/**
	 * @return the pay_item_id
	 */
	public String getPay_item_id() {
		return pay_item_id;
	}

	/**
	 * @param pay_item_id the pay_item_id to set
	 */
	public void setPay_item_id(String pay_item_id) {
		this.pay_item_id = pay_item_id;
	}

	/**
	 * @return the item_name
	 */
	public String getItem_name() {
		return item_name;
	}

	/**
	 * @param item_name the item_name to set
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	/**
	 * @return the tax
	 */
	public String getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the pay_type
	 */
	public String getPay_type() {
		return pay_type;
	}

	/**
	 * @param pay_type the pay_type to set
	 */
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	/**
	 * @return the auto_charge_type
	 */
	public String getAuto_charge_type() {
		return auto_charge_type;
	}

	/**
	 * @param auto_charge_type the auto_charge_type to set
	 */
	public void setAuto_charge_type(String auto_charge_type) {
		this.auto_charge_type = auto_charge_type;
	}

	/**
	 * @return the service_type
	 */
	public String getService_type() {
		return service_type;
	}

	/**
	 * @param service_type the service_type to set
	 */
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	/**
	 * @return the div_settele
	 */
	public String getDiv_settele() {
		return div_settele;
	}

	/**
	 * @param div_settele the div_settele to set
	 */
	public void setDiv_settele(String div_settele) {
		this.div_settele = div_settele;
	}

	/**
	 * @return the last_charge_month
	 */
	public String getLast_charge_month() {
		return last_charge_month;
	}

	/**
	 * @param last_charge_month the last_charge_month to set
	 */
	public void setLast_charge_month(String last_charge_month) {
		this.last_charge_month = last_charge_month;
	}

	/**
	 * @return the camp_type
	 */
	public String getCamp_type() {
		return camp_type;
	}

	/**
	 * @param camp_type the camp_type to set
	 */
	public void setCamp_type(String camp_type) {
		this.camp_type = camp_type;
	}

	/**
	 * @return the tracking_id
	 */
	public String getTracking_id() {
		return tracking_id;
	}

	/**
	 * @param tracking_id the tracking_id to set
	 */
	public void setTracking_id(String tracking_id) {
		this.tracking_id = tracking_id;
	}

	/**
	 * @return the terminal_type
	 */
	public String getTerminal_type() {
		return terminal_type;
	}

	/**
	 * @param terminal_type the terminal_type to set
	 */
	public void setTerminal_type(String terminal_type) {
		this.terminal_type = terminal_type;
	}

	/**
	 * @return the success_url
	 */
	public String getSuccess_url() {
		return success_url;
	}

	/**
	 * @param success_url the success_url to set
	 */
	public void setSuccess_url(String success_url) {
		this.success_url = success_url;
	}

	/**
	 * @return the cancel_url
	 */
	public String getCancel_url() {
		return cancel_url;
	}

	/**
	 * @param cancel_url the cancel_url to set
	 */
	public void setCancel_url(String cancel_url) {
		this.cancel_url = cancel_url;
	}

	/**
	 * @return the error_url
	 */
	public String getError_url() {
		return error_url;
	}

	/**
	 * @param error_url the error_url to set
	 */
	public void setError_url(String error_url) {
		this.error_url = error_url;
	}

	/**
	 * @return the pagecon_url
	 */
	public String getPagecon_url() {
		return pagecon_url;
	}

	/**
	 * @param pagecon_url the pagecon_url to set
	 */
	public void setPagecon_url(String pagecon_url) {
		this.pagecon_url = pagecon_url;
	}

	/**
	 * @return the free1
	 */
	public String getFree1() {
		return free1;
	}

	/**
	 * @param free1 the free1 to set
	 */
	public void setFree1(String free1) {
		this.free1 = free1;
	}

	/**
	 * @return the free2
	 */
	public String getFree2() {
		return free2;
	}

	/**
	 * @param free2 the free2 to set
	 */
	public void setFree2(String free2) {
		this.free2 = free2;
	}

	/**
	 * @return the free3
	 */
	public String getFree3() {
		return free3;
	}

	/**
	 * @param free3 the free3 to set
	 */
	public void setFree3(String free3) {
		this.free3 = free3;
	}

	/**
	 * @return the free_csv
	 */
	public String getFree_csv() {
		return free_csv;
	}

	/**
	 * @param free_csv the free_csv to set
	 */
	public void setFree_csv(String free_csv) {
		this.free_csv = free_csv;
	}

	/**
	 * @return the request_date
	 */
	public String getRequest_date() {
		return request_date;
	}

	/**
	 * @param request_date the request_date to set
	 */
	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}

	/**
	 * @return the limit_second
	 */
	public String getLimit_second() {
		return limit_second;
	}

	/**
	 * @param limit_second the limit_second to set
	 */
	public void setLimit_second(String limit_second) {
		this.limit_second = limit_second;
	}

	/**
	 * @return the sps_hashcode
	 */
	public String getSps_hashcode() {
		return sps_hashcode;
	}

	/**
	 * @param sps_hashcode the sps_hashcode to set
	 */
	public void setSps_hashcode(String sps_hashcode) {
		this.sps_hashcode = sps_hashcode;
	}

	/**
	 * @return the titleId
	 */
	public Integer getTitleId() {
		return titleId;
	}

	/**
	 * @return the serverId
	 */
	public Integer getServerId() {
		return serverId;
	}

	/**
	 * @return the pointId
	 */
	public Integer getPointId() {
		return pointId;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}
