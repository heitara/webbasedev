<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>チケット使用履歴</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>チケット使用履歴</strong><span><a href="inputListTicket.html">► チケット使用</a>　<a href="inputUseListTicket.html">► チケット使用履歴</a>　<a href="inputGiveListTicket.html">► チケット付与履歴</a></span></dt>
		<dd>
			<table class="friendhist tspace_y" align="center">
				<tr id="listTitle" style="height:20px;">
					<th>使用日時</th>
					<th>使用チケット</th>
					<th>使用枚数</th>
					<th>獲得ポイント</th>
				</tr>
				<s:iterator value="useHistList" id="useHistList" status="st">
					<tr>
						<td><s:date name="ticketUseDate" format="yyyy/MM/dd HH:mm:ss"/></td>
						<td><s:property value="ticketName"/></td>
						<td><s:property value="ticketCount"/></td>
						<td><s:property value="pointAmount"/></td>
					</tr>
				</s:iterator>
			</table>
		</dd>
	</dl>
</body>
</html>