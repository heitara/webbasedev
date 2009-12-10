<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>チケット残高照会</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>チケット残高照会</strong><span><a href="inputUseListTicket.html">► チケット利用履歴</a><a href="inputGiveListTicket.html">► チケット付与履歴</a></span></dt>
		<dd>
			<div style="margin:30px 0px;line-height:20px;">
			こちらのページでは、未使用状態なチケットの一覧が表示されます。
			</div>
			<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
			<s:form name="frm_ticket_list" method="post" cssClass="entry">
				<table class="friendhist tspace_y" align="center">
					<tr id="listTitle" >
						<th class="friend" >チケット</th>
						<th class="mail">開始日時</th>
						<th class="mail">終了日時</th>
						<th class="mail">タイトル</th>
						<th class="entry_ymd">枚数</th>
						<th class="mail">*</th>
					</tr>
					<s:iterator value="ticketList" id="ticketList" status="st">
						<tr <s:if test="#st.odd">class="odd" </s:if> >
							<td class="friend"><img src="<s:property value="iconUrl"/>" title="<s:property value="ticketName"/>"/></td>
							<td class="mail"><s:property value="ticketStartDate"/></td>
							<td class="mail"><s:property value="ticketEndDate"/></td>
							<td class="mail"><s:property value="titleName"/></td>
							<td class="entry_ymd"><s:property value="ticketCount"/></td>
							<td class="mail"><a href="useTicket.html?ticketId=<s:property value="ticketId"/>" >使用</a></td>
						</tr>
					</s:iterator>
				</table>
				<br/>
			</s:form>
		</dd>
	</dl>
</body>
</html>