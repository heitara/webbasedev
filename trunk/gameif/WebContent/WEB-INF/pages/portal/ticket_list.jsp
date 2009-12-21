<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>チケット残高照会</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
	<script type="text/javascript">
		window.onload = function(){   
			var point = document.getElementById("point").value;
			if (point != null && point > 0) {
				alert(point + "ポイントをもらいました。");
				document.getElementById("point").value = 0;
			}
        };
	</script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>チケット残高照会</strong><span><a href="inputUseListTicket.html">► チケット利用履歴</a><a href="inputGiveListTicket.html">► チケット付与履歴</a></span></dt>
		<dd>
			<s:form name="frm_ticket_list" method="post" cssClass="entry">
				<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
				<span style="font-size:13px;color:#500;font-weight:bold;">► サービスポイント残高照会</span><br/>
				<table class="friendhist tspace_y" align="center">
					<tr id="listTitle">
						<th class="friend">タイトル</th>
						<th class="mail">残高</th>
						<th class="entry_ymd">失効期限</th>
					</tr>
					<s:iterator value="servicePointList" id="servicePointList" status="st">
						<tr <s:if test="#st.odd">class="odd" </s:if> >
							<td class="friend">
								<s:if test="titleName != null">
									<s:property value="titleName"/>
								</s:if>
								<s:else>
									<span>--</span>
								</s:else>
							</td>
							<td class="mail">
								<s:if test="pointAmount != null">
									<s:text name="format.money">
										<s:param value="pointAmount" />
									</s:text>
								</s:if>
								<s:else>
									<span>--</span>
								</s:else>
							</td>
							<td class="entry_ymd">
								<s:if test="pointEndDate != null">
									<s:date name="pointEndDate" format="yyyy/MM/dd"/>
								</s:if>
								<s:else>
									<span>--</span>
								</s:else>
							</td>
						</tr>
					</s:iterator>
				</table>
				<br/>
				<span style="font-size:13px;color:#500;font-weight:bold;">► チケット残高照会</span><br/>
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
							<td class="mail"><s:date name="ticketStartDate" format="yyyy/MM/dd"/></td>
							<td class="mail"><s:date name="ticketEndDate" format="yyyy/MM/dd"/></td>
							<td class="mail"><s:property value="titleName"/></td>
							<td class="entry_ymd"><s:property value="ticketCount"/></td>
							<td class="mail"><a href="useTicket.html?ticketId=<s:property value="ticketId"/>" >使用</a></td>
						</tr>
					</s:iterator>
				</table>
				<s:hidden id="point" name="point"></s:hidden>
				<br/>
			</s:form>
		</dd>
	</dl>
</body>
</html>