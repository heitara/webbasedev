<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>売上集計情報</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script src="js/bindMaster.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>売上集計一覧</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form name="frm_nosubmit_salelist" cssClass="entry" method="post">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><label for="salesList_salesType">集計種別：</label></th>
					<td>
						<s:select id="salesType" name="salesType" list="backOfficeProperties.salesType" cssClass="big"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th><label for="salesList_settleDate">集計期間：</label></th>
					<td>
						<s:textfield id="settleStartDate" name="settleStartDate" size="10" />
						<span class="explain">～</span>
						<s:textfield id="settleEndDate" name="settleEndDate" size="10" />
					</td>
				</tr>
				<tr>
					<th><label for="salesList_memId">アカウントID：</label></th>
					<td>
						<s:textfield id="memId" name="memId" maxlength="20" cssClass="ime_mode_n" title="アカウントID" />
						<span class="explain">（部分一致）</span>
					</td>
				</tr>
				<tr>
					<th><label for="inquiryList_titleId">タイトル：</label></th>
					<td>
						<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.allTitleList" listKey="titleId" listValue="titleName" title="タイトル" headerKey="" headerValue="" onchange="bindPoint(this, pointId);" />
					</td>
				</tr>
				<tr>
					<th><label for="inquiryList_pointId">ポイント：</label></th>
					<td>
						<select id="pointId" name="pointId" title="ポイント" class="big" ></select>
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th></th>
					<td>
						<s:submit value="検索" name="search" action="searchSalesList"/>
						<s:submit value="クリア" name="clear" method="clear" />
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th><label>売上総額：</label></th>
					<td><s:property value="totalPointAmount"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<table class="friendhist tspace_y" align="center">
							<s:if test='"1".equals(model.salesType)'>
								<tr id="listTitle">
									<th class="friend">アカウントID</th>
									<th class="friend">ニックネーム</th>
									<th class="entry_ymd">決済日</th>
									<th class="mail">決済金額</th>
								</tr>
								<s:iterator value="personDayList" id="personDayList" status="st">
									<tr <s:if test="#st.odd">class="odd" </s:if> >
										<td class="friend"><s:property value="memId"/></td>
										<td class="friend"><s:property value="nickName"/></td>
										<td class="entry_ymd"><s:date name="settlementDate" format="yyyy/MM/dd"/></td>
										<td class="mail"><s:property value="pointAmount"/></td>
									</tr>
								</s:iterator>
							</s:if>
							<s:elseif test='"2".equals(model.salesType)'>
								<tr id="listTitle">
									<th class="friend">アカウントID</th>
									<th class="friend">ニックネーム</th>
									<th class="entry_ymd">決済月</th>
									<th class="mail">決済金額</th>
								</tr>
								<s:iterator value="personMonthList" id="personMonthList" status="st">
									<tr <s:if test="#st.odd">class="odd" </s:if> >
										<td class="friend"><s:property value="memId"/></td>
										<td class="friend"><s:property value="nickName"/></td>
										<td class="entry_ymd"><s:date name="settlementDate" format="yyyy/MM"/></td>
										<td class="mail"><s:property value="pointAmount"/></td>
									</tr>
								</s:iterator>
							</s:elseif>
							<s:elseif test='"3".equals(model.salesType)'>
								<tr id="listTitle">
									<th class="friend">タイトル名</th>
									<th class="entry_ymd">決済日</th>
									<th class="mail">決済金額</th>
								</tr>
								<s:iterator value="titleDayList" id="titleDayList" status="st">
									<tr <s:if test="#st.odd">class="odd" </s:if> >
										<td class="friend"><s:property value="titleName"/></td>
										<td class="entry_ymd"><s:date name="settlementDate" format="yyyy/MM/dd"/></td>
										<td class="mail"><s:property value="pointAmount"/></td>
									</tr>
								</s:iterator>
							</s:elseif>
							<s:elseif test='"4".equals(model.salesType)'>
								<tr id="listTitle">
									<th class="friend">タイトル名</th>
									<th class="entry_ymd">決済月</th>
									<th class="mail">決済金額</th>
								</tr>
								<s:iterator value="titleMonthList" id="titleMonthList" status="st">
									<tr <s:if test="#st.odd">class="odd" </s:if> >
										<td class="friend"><s:property value="titleName"/></td>
										<td class="entry_ymd"><s:date name="settlementDate" format="yyyy/MM"/></td>
										<td class="mail"><s:property value="pointAmount"/></td>
									</tr>
								</s:iterator>
							</s:elseif>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</dd>
</dl>
</body>
</html>