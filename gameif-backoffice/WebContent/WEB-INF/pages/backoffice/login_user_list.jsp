<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ユーザ管理</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			var count = 0;
		    var checkboxs = document.getElementsByName("selectedAuthList");
		    for(var i=0;i<checkboxs.length;i++){
		    	if (!checkboxs[i].disabled) {
			    	if (checkboxs[i].checked) {
				    	count++;
			    	}
		    	}
		    }
		    if (count < 1) {
			    alert("ユーザを選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>ユーザ一覧</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form cssClass="entry" method="post">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><label for="searchLoginUser_nickName">ユーザID：</label></th>
					<td>
						<s:textfield name="userId" maxlength="20" cssClass="ime_mode_n" />
					</td>
				</tr>
				<tr>
					<th><label for="searchLoginUser_nickName">ニックネーム：</label></th>
					<td>
						<s:textfield name="nickName" maxlength="30" />
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th></th>
					<td>
						<s:submit value="検索" action="searchLoginUser" />
						<s:submit value="新規追加" action="inputAddLoginUser" />
						<s:reset value="クリア"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<td colspan="2">
						<table class="friendhist tspace_y" align="center">
							<tr id="listTitle">
								<th>*</th>
								<th>ユーザID</th>
								<th>ニックネーム</th>
							</tr>
							<s:iterator value="loginUserList" id="authorityCode" status="st">
								<tr <s:if test="#st.odd">class="odd" </s:if> >
									<td>
										<s:hidden name="authorityCode"></s:hidden>
										<s:checkbox name="selectedAuthList" id="selectedAuthList" value="false" fieldValue="%{authorityCode}"></s:checkbox>
									</td>
									<td>
										<a href="inputEditAuthority.html?authority.authorityCode=<s:property value="userId"/>" ><s:property value="authorityCode"/></a>
									</td>
									<td>
										<s:property value="nickName"/>
									</td>
								</tr>
							</s:iterator>
							<s:if test="loginUserList != null && loginUserList.size() > 0">
								<tr>
									<td colspan="3">
										<s:submit value="削除" action="deleteLoginUser" cssClass="big" onclick="return checkCount();"/>
									</td>
								</tr>
							</s:if>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</dd>
</dl>
</body>
</html>