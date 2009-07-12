<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><s:property value="%{getText('mem_change_pwd_title')}" /></title>
	<link rel="stylesheet" type="text/css" media="screen" href="css/common/screen.css" />
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/mem_login.js" type="text/javascript"></script>
	<s:include value="../common/header.jsp"></s:include>
</head>

<body>
	<div class="contents">
		<s:form name="frm_mem_change_pwd" method="POST" action="changePwdMemberInfoControl">
			<table>
				<tr>
					<td><s:property value="%{getText('current_passwd')}" /></td>
					<td><s:password name="mempwd" /></td>
				</tr>
				<tr>
					<td><s:property value="%{getText('new_passwd')}" /></td>
					<td><s:password name="newpwd" /></td>
				</tr>
				<tr>
					<td><s:property value="%{getText('confirm_passwd')}" /></td>
					<td><s:password name="mempwd" /></td>
				</tr>
				
				<tr>
					<td><s:submit value="%{getText('update')}"></s:submit></td>
					<td/>
				</tr>
			</table>
		</s:form>
	</div>
</body>

<s:include value="../common/footer.jsp"></s:include>

</html>
</s:i18n>