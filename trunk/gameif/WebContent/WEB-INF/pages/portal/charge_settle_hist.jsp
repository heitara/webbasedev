<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>チャージ履歴</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>チャージ履歴</strong><span><a href="chargePointSelect.html">► ポイントチャージ</a>　<a href="chargeSettlementHist.html">► チャージ履歴</a></span></dt>
		<dd>
			<table class="friendhist tspace_y" align="center">
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
		</dd>
	</dl>
</body>
</html>