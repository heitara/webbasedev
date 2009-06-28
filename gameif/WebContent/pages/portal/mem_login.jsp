<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="%{getText('mem_log_in_title')}" /></title>
</head>
<body>
<s:form name="frm_login" method="POST" action="loginMember">
	<table>
		<tr>
			<s:actionerror />
			<s:actionmessage />
		</tr>
		<tr>
			<td><s:property value="%{getText('mem_id')}" /></td>
			<td></td>
			<td><s:textfield name="memId"></s:textfield></td>
		</tr>
		<tr>
			<td><s:property value="%{getText('passwd')}" /></td>
			<td></td>
			<td><s:password name="mempwd" /></td>
		</tr>
		<tr />
		<tr>
			<td><s:url id="reget" action="regetMember" /> <s:a
				href="%{reget}">
				<s:property value="%{getText('reget')}" />
			</s:a></td>
			<td />
			<td>
				<s:submit value="%{getText('log_in')}"></s:submit>
			</td>
		</tr>
		<tr>
			<td><s:url id="new" action="creatMember" /> <s:a
				href="%{new}">
				<s:property value="%{getText('new')}" />
			</s:a></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</s:form>
</body>
</html>