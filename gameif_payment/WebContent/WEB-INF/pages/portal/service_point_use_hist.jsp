<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.payment.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>サービスポイント利用履歴</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>サービスポイント利用履歴</strong><span><a href="inputChargeServicePoint.html">► サービスポイント利用</a>　<a href="inputUseListServicePoint.html">► サービスポイント利用履歴</a>　<a href="inputGiveListServicePoint.html">► サービスポイント獲得履歴</a></span></dt>
		<dd>
			<table class="friendhist tspace_y" align="center">
				<tr id="listTitle">
					<th class="entry_ymd">消費日期</th>
					<th class="friend">タイトル</th>
					<th class="mail">サーバー</th>
					<th class="mail">消費ポイント</th>
				</tr>
				<s:iterator value="useHistList" id="useHistList" status="st">
					<tr <s:if test="#st.odd">class="odd" </s:if> >
						<td class="entry_ymd"><s:date name="useDate" format="yyyy/MM/dd HH:mm:ss"/></td>
						<td class="friend"><s:property value="titleName"/></td>
						<td class="mail"><s:property value="serverName"/></td>
						<td class="mail"><s:property value="pointAmount"/></td>
					</tr>
				</s:iterator>
			</table>
		</dd>
	</dl>
</body>
</html>