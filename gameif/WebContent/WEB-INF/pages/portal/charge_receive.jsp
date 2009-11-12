<%@ page language="java" contentType="text/csv; charset=Shift-JIS" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ポイントチャージ</title>
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
			<s:property value="result" /><s:property value=","/><s:property value="errMsg"/>
			
			<s:hidden name="requestUrl" id="requestUrl"></s:hidden>
		</form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>