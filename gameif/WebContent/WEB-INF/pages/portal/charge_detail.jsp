<%@ page contentType="text/html; charset=shift-jis" pageEncoding="shift-jis"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ポイントチャージ</title>
	<meta content="text/html; charset=shift-jis" http-equiv="content-type"/>
	<script type="text/javascript">
		function doSubmit() {
			document.chargeForm.action = document.getElementById("requestUrl").value;
			document.chargeForm.submit();
			return;
		}
	</script>
</head>

<body onload="doSubmit();">
<!-- ポイントチャージ：開始 -->
<dl>
	<dd>
		<form name="chargeForm" method="post">
			<s:hidden name="pay_method"></s:hidden>
			<s:hidden name="merchant_id"></s:hidden>
			<s:hidden name="service_id"></s:hidden>
			<s:hidden name="cust_code"></s:hidden>
			<s:hidden name="sps_cust_no"></s:hidden>
			<s:hidden name="sps_payment_no"></s:hidden>
			<s:hidden name="order_id"></s:hidden>
			<s:hidden name="item_id" />
			<s:hidden name="pay_item_id" />
			<s:hidden name="item_name" />
			<s:hidden name="tax" />
			<s:hidden name="amount" />
			<s:hidden name="pay_type" />
			<s:hidden name="auto_charge_type" />
			<s:hidden name="service_type" />
			<s:hidden name="div_settele" />
			<s:hidden name="last_charge_month" />
			<s:hidden name="camp_type" />
			<s:hidden name="tracking_id" />
			<s:hidden name="terminal_type" />
			<s:hidden name="success_url" />
			<s:hidden name="cancel_url" />
			<s:hidden name="error_url" />
			<s:hidden name="pagecon_url" />
			<s:hidden name="free1" />
			<s:hidden name="free2" />
			<s:hidden name="free3" />
			<s:hidden name="free_csv" />
			<s:hidden name="dtl_rowno" />
			<s:hidden name="dtl_item_id" />
			<s:hidden name="dtl_item_name" />
			<s:hidden name="dtl_item_count" />
			<s:hidden name="dtl_tax" />
			<s:hidden name="dtl_amount" />
			<s:hidden name="request_date" />
			<s:hidden name="limit_second" />
			<s:hidden name="sps_hashcode" />
			
			<s:hidden name="requestUrl" id="requestUrl"></s:hidden>
		</form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>