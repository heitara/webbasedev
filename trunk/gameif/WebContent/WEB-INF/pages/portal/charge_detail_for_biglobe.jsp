<%@ page contentType="text/html; charset=shift-jis" pageEncoding="shift-jis"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ポイントチャージ(BigLobe)</title>
	<meta content="text/html; charset=shift-jis" http-equiv="content-type"/>
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
			<s:hidden name="GwShopCode"></s:hidden>
			<s:hidden name="GwGoodsCode"></s:hidden>
			<s:hidden name="GoodsName"></s:hidden>
			<s:hidden name="NextUrl"></s:hidden>
			<s:hidden name="Params" value="settlementTrnsNum"></s:hidden>
			<s:hidden name="settlementTrnsNum"></s:hidden>
			<s:hidden name="Print"></s:hidden>
			
			<s:hidden name="requestUrlForBligLobe" id="requestUrlForBligLobe"></s:hidden>
		</form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>