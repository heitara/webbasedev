<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>サービスポイント残高照会</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>サービスポイント残高照会</strong><span><a href="inputChargeServicePoint.html">► サービスポイント利用</a> <a href="inputGiveListServicePoint.html">► サービスポイント付与履歴</a> <a href="inputUseListServicePoint.html">► サービスポイント利用履歴</a></span></dt>
		<dd>
			<s:form name="frm_sp_give_list" method="post" cssClass="entry">
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
			</s:form>
		</dd>
	</dl>
</body>
</html>