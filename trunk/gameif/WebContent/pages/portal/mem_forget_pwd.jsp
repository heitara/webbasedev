<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LogIn</title>
</head>
<body>
<s:form name="frm_mem_forget_pwd">
	<table>
		<tr>
			<td><s:property value="%{getText('mail_address')}" /></td>
			<td><s:textfield name="mail_address"></s:textfield></td>
		</tr>
		<tr>
			<td><s:property value="%{getText('question')}" /></td>
			<td><s:textfield name="question"></s:textfield></td>
		</tr>
		<tr>
			<td><s:property value="%{getText('answer')}" /></td>
			<td><s:textfield name="answer"></s:textfield></td>
		</tr>
	</table>
</s:form>
</body>
</html>