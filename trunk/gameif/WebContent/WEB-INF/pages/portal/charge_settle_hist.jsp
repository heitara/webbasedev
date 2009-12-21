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
		<dt><strong>チャージ履歴</strong><span><a href="chargePointSelect.html">► ポイントチャージ</a></span></dt>
		<dd>
			<s:form name="frm_sp_use_list" method="post" cssClass="entry">
				<table class="friendhist tspace_y" align="center">
					<tr id="listTitle">
						<th class="entry_ymd">チャージ日期</th>
						<th class="friend">タイトル</th>
						<th class="mail">サーバー</th>
						<th class="mail">チャージポイント</th>
						<th class="friend">決済方式</th>
					</tr>
					<s:iterator value="settleHistList" id="settleHistList" status="st">
						<tr <s:if test="#st.odd">class="odd" </s:if> >
							<td class="entry_ymd"><s:date name="settlementDate" format="yyyy/MM/dd HH:mm:ss"/></td>
							<td class="friend"><s:property value="titleName"/></td>
							<td class="mail"><s:property value="serverName"/></td>
							<td class="mail">
								<s:text name="format.money">
									<s:param value="pointAmountAct" />
								</s:text>
							</td>
							<td class="mail"><s:property value="settlementName"/></td>
						</tr>
					</s:iterator>
				</table>
				<br/>
			</s:form>
		</dd>
	</dl>
</body>
</html>