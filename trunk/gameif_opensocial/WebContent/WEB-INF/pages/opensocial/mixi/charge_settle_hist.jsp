<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<META name="decorator" content="mixi">
	<title>チャージ履歴</title>
</head>
<body>
<table class="settle_list" align="center">
	<tr align="center">
		<th>チャージ日期</th>
		<th>タイトル</th>
		<th>サーバー</th>
		<th>チャージポイント</th>
		<th>決済方法</th>
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