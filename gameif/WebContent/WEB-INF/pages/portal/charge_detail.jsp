<%@ page language="java" contentType="html/text; charset=shift-jis" pageEncoding="shift-jis"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<meta content="text/html; charset=shift-jis" http-equiv="content-type"/>
	<title>ポイントチャージ | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/bindMaster.js" type="text/javascript"></script>
	<script type="text/javascript">
		function doSubmit() {
			document.form1.action = document.getElementById("requestUrl").value;
			document.form1.submit();
			return;
		}
	</script>
</head>

<body onload="doSubmit();">
<!-- ポイントチャージ：開始 -->
<dl>
	<dd>
		<form name="form1" method="post">
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
			
			<div>
				<s:submit value="次へ" cssClass="submit" />
			</div>
		</form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>