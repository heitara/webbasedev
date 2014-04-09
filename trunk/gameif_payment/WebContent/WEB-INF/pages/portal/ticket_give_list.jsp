<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.payment.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>チケット付与履歴</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>チケット付与履歴</strong><span><a href="inputListTicket.html">► チケット使用</a>　<a href="inputUseListTicket.html">► チケット使用履歴</a>　<a href="inputGiveListTicket.html">► チケット付与履歴</a></span></dt>
		<dd>
			<table class="friendhist tspace_y" align="center">
				<tr id="listTitle">
					<th>付与日期</th>
					<th>付与チケット</th>
					<th>枚数</th>
					<th>使用可能日</th>
					<th>使用期限</th>
				</tr>
				<s:iterator value="giveHistList" id="giveHistList">
					<tr>
						<td><s:date name="ticketGiveDate" format="yyyy/MM/dd HH:mm:ss"/></td>
						<td><s:property value="ticketName"/></td>
						<td><s:property value="ticketCount"/></td>
						<td><s:date name="ticketStartDate" format="yyyy/MM/dd"/></td>
						<td><s:date name="ticketEndDate" format="yyyy/MM/dd"/></td>
					</tr>
				</s:iterator>
			</table>
		</dd>
	</dl>
</body>
</html>