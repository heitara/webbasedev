<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>チャージ履歴</title>
</head>
<body>
<table align="center">
	<tr id="listTitle" align="center">
		<th>チャージ日期</th>
		<th>タイトル</th>
		<th>サーバー</th>
		<th>チャージポイント</th>
		<th>決済方式</th>
	</tr>
	<s:iterator value="settleHistList" id="settleHistList" status="st">
		<tr align="center">
			<td><s:date name="settlementDate" format="yyyy/MM/dd HH:mm:ss"/></td>
			<td><s:property value="titleName"/></td>
			<td><s:property value="serverName"/></td>
			<td>
				<s:text name="format.money">
					<s:param value="pointAmountAct" />
				</s:text>
			</td>
			<td><s:property value="settlementName"/></td>
		</tr>
	</s:iterator>
</table>
</body>
</html>