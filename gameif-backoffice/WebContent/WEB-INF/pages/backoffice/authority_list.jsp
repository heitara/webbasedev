<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>権限管理</title>
	<script src="js/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>新規追加</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form cssClass="entry">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><label for="createAuthority_authorityCode">権限コード：</label></th>
					<td>
						<s:textfield name="authority.authorityCode" maxlength="20" cssClass="ime_mode_n" />
					</td>
				</tr>
				<tr>
					<th><label for="createAuthority_authorityName">権限名：</label></th>
					<td>
						<s:textfield name="authority.authorityName" maxlength="25" />
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th></th>
					<td>
						<s:submit value="検索" action="searchAuthority" />
						<s:submit value="新規追加" action="inputAddAuthority" />
						<s:reset value="クリア"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<td colspan="2">
						<table>
							<tr id="listTitle">
								<th>*</th>
								<th>権限コード</th>
								<th>権限名</th>
							</tr>
							<s:iterator value="authorityList" id="authorityCode" status="st">
								<tr <s:if test="#st.odd">class="odd" </s:if> >
									<td>
										<s:hidden name="authorityCode"></s:hidden>
										<s:checkbox name="selectedAuthoritys" id="selectedAuthoritys" value="false" fieldValue="%{authorityCode}"></s:checkbox>
									</td>
									<td>
										<a href="inputEditAuthority.html?authorityCode=<s:property value="authorityCode"/>" ><s:property value="authorityCode"/></a>
									</td>
									<td>
										<s:property value="authorityName"/>
									</td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</dd>
</dl>
</body>
</html>