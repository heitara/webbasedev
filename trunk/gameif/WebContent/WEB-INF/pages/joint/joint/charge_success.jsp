<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>ポイントチャージ完了</title></head>
<body>
<center>
<div class="alert">
<dl class="warning">
	<dt>ポイントチャージが完了しました。</dt>
	<dd>
		<div>引き続きお楽しみください。</div><br/><br/>
		<input type="button" value="継続してチャージする" onclick="location='joint/chargePointSelect.html';" />
		<input type="button" value="画面を閉じる" onclick="window.close();"/>
	<dd>
</dl>
</div>
</center>
</body>
</html>