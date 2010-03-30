<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>ãã¤ã³ããã£ã¼ã¸å®äº</title></head>
<body>
<center>
<div class="alert">
<dl class="warning">
	<dt>ãã¤ã³ããã£ã¼ã¸ãå®äºãã¾ããã</dt>
	<dd>
		<div>å¼ãç¶ããæ¥½ãã¿ãã ããã</div><br/><br/>
		<input type="button" value="ç¶ç¶ãã¦ãã£ã¼ã¸ãã" onclick="location='opensocial/chargePointSelect.html?titleId=<s:property value="titleId"/>&serverId=<s:property value="serverId"/>';" />
		<input type="button" value="ç»é¢ãéãã" onclick="window.close();"/>
	<dd>
</dl>
</div>
</center>
</body>
</html>