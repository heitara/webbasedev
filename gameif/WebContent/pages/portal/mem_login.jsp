<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="%{getText('mem_log_in_title')}" /></title>
<link rel="stylesheet" type="text/css" media="screen"
	href="css/common/screen.css" />
<script src="js/jquery/jquery.js" type="text/javascript"></script>
<script src="js/portal/mem_login.js" type="text/javascript"></script>
<s:include value="../common/header.jsp"></s:include>
</head>

<body>
<s:fielderror />
<div class="contents"><s:form name="frm_login" method="POST"
	action="loginMember">
	<table>
		<tr>
			<td>
				<s:actionerror />
				<s:actionmessage />
			</td>
		</tr>
		<tr>
			<td><s:property value="%{getText('mem_id')}" /></td>
			<td></td>
			<td>
				<s:textfield name="memId"></s:textfield><s:fielderror><s:param name="model.memId" /></s:fielderror>
			</td>
		</tr>
		<tr>
			<td><s:property value="%{getText('passwd')}" /></td>
			<td></td>
			<td>
				<s:password name="mempwd" /><s:fielderror><s:param name="model.mempwd"/></s:fielderror>
			</td>
		</tr>
		<tr />
		<tr>
			<td><s:url id="reget" action="regetMember" /> <s:a
				href="%{reget}">
				<s:property value="%{getText('reget')}" />
			</s:a></td>
			<td />
			<td><s:submit value="%{getText('log_in')}"></s:submit></td>
		</tr>
		<tr>
			<td><s:url id="new" action="creatMember" /> <s:a href="%{new}">
				<s:property value="%{getText('new')}" />
			</s:a></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</s:form></div>
</body>

<s:include value="../common/footer.jsp"></s:include>

</html>