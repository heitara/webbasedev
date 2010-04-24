<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<META name="decorator" content="otakuma">
<title>エラー</title>
</head>
<body>
<div style="margin-bottom:20px;text-align:center;">
	<img src="images/joint/otakuma/charge_ico01.gif" class="gray"/>
	<img src="images/joint/otakuma/point_flow_00.gif"/>
	<img src="images/joint/otakuma/charge_ico02.gif" class="gray"/>
	<img src="images/joint/otakuma/point_flow_00.gif"/>
	<img src="images/joint/otakuma/charge_ico03.gif" class="gray"/>
	<img src="images/joint/otakuma/point_flow_00.gif"/>
	<img src="images/joint/otakuma/charge_ico04.gif" class="gray"/>
	<img src="images/joint/otakuma/point_flow_00.gif"/>
	<img src="images/joint/otakuma/charge_ico05.gif" class="gray"/>
</div>
<center>
<div class="alert">
<dl class="warning">
	<dt>エラーが発生しました。</dt>
	<dd>
		<div class="msg">同じ現象が何度も繰り返す場合、運営者に連絡してください。</div><br/><br/>
		<input type="button" value="もう一度やり直す" onclick="location='joint/chargePointSelect.html';" />
		<input type="button" value="画面を閉じる" onclick="window.close();"/>
	</dd>
</dl>
</div>
</center>
</body>
</html>