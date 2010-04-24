<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<META name="decorator" content="mixi">
<title>エラー</title>
</head>
<body>
<div style="margin-bottom:20px;text-align:center;">
	<img src="images/point_flow_10.gif"/>
	<img src="images/point_flow_00.gif"/>
	<img src="images/point_flow_20.gif"/>
	<img src="images/point_flow_00.gif"/>
	<img src="images/point_flow_30.gif"/>
	<img src="images/point_flow_00.gif"/>
	<img src="images/point_flow_40.gif"/>
	<img src="images/point_flow_00.gif"/>
	<img src="images/point_flow_50.gif"/>
</div>
<center>
<div class="alert">
<dl class="warning">
	<dt>エラーが発生しました。</dt>
	<dd>
		<div class="msg">同じ現象が何度も繰り返す場合、運営者に連絡してください。</div><br/><br/>
		<input type="button" value="もう一度やり直す" onclick="location='opensocial/chargePointSelect.html';" />
		<input type="button" value="画面を閉じる" onclick="window.close();"/>
	</dd>
</dl>
</div>
</center>
</body>
</html>