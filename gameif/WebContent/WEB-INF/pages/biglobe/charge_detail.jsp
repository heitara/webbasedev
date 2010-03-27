<%@ page contentType="text/html; charset=shift-jis" pageEncoding="shift-jis"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>ポイントチャージ（BIGLOBE）</title>
    <meta content="text/html; charset=shift-jis" http-equiv="content-type"/>
    <script type="text/javascript">
        function doSubmit() {
            document.chargeForm.action = document.getElementById("requestUrl").innerHTML;
            document.chargeForm.GwShopCode.value = document.getElementById("biglobeShopCode").innerHTML;
            document.chargeForm.GwGoodsCode.value = document.getElementById("biglobeGoodsCode").innerHTML;
            document.chargeForm.submit();
        }
    </script>
</head>
<body onload="doSubmit();">
<form name="chargeForm" method="post">
	<s:hidden name="GwShopCode"></s:hidden>
	<s:hidden name="GwGoodsCode"></s:hidden>
	<s:hidden name="Params" value="settlementTrnsNum"></s:hidden>
	<s:hidden name="settlementTrnsNum"></s:hidden>
	<span id="biglobeShopCode" style="display:none;"><s:property value="biglobeShopCode" /></span>
	<span id="biglobeGoodsCode" style="display:none;"><s:property value="biglobeGoodsCode" /></span>
	<span id="requestUrl" style="display:none;"><s:property value="requestUrl" /></span>
	BIGLOBE購入決済確認画面に移動します。<br/>
	しばらくお待ちください。
</form>
</body>
</html>