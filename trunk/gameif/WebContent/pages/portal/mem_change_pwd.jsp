<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="%{getText('mem_change_pwd_title')}" /></title>
</head>
<body>
<s:form name="frm_mem_change_pwd">
	<table>
		<tr>
			<td><s:property value="%{getText('current_passwd')}" /></td>
			<td><s:password name="current_passwd" /></td>
		</tr>
		<tr>
			<td><s:property value="%{getText('new_passwd')}" /></td>
			<td><s:password name="new_passwd" /></td>
		</tr>
		<tr>
			<td><s:property value="%{getText('confirm_passwd')}" /></td>
			<td><s:password name="confirm_passwd" /></td>
		</tr>
		
		<tr>
			<td><s:url id="updatePwd" action="newUserInfo" /> <s:a
				href="%{updatePwd}">
				<s:property value="%{getText('update')}" />
			</s:a></td>
			<td />
		</tr>
	</table>
</s:form>
</body>
</html>
</s:i18n>