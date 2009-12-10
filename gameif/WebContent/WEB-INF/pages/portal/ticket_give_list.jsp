<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>チケット付与履歴</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>チケット付与履歴</strong><span><a href="inputListTicket.html">► チケット残高照会</a><a href="inputUseListTicket.html">► チケット利用履歴</a></span></dt>
		<dd>
			<s:form name="frm_ticket_give_list" method="post" cssClass="entry">
				<table class="friendhist tspace_y" align="center">
					<tr id="listTitle">
						<th class="entry_ymd">付与日期</th>
						<th class="friend">チケット</th>
						<th class="mail">枚数</th>
						<th class="mail">開始日期</th>
						<th class="mail">失効日期</th>
					</tr>
					<s:iterator value="giveHistList" id="giveHistList" status="st">
						<tr <s:if test="#st.odd">class="odd" </s:if> >
							<td class="entry_ymd"><s:property value="ticketGiveDate"/></td>
							<td class="friend"><s:property value="ticketName"/></td>
							<td class="mail"><s:property value="ticketCount"/></td>
							<td class="mail"><s:property value="ticketStartDate"/></td>
							<td class="mail"><s:property value="ticketEndDate"/></td>
						</tr>
					</s:iterator>
				</table>
				<br/>
			</s:form>
		</dd>
	</dl>
</body>
</html>