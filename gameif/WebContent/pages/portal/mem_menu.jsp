<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><s:property value="%{getText('mem_menu_tilte')}" /></title>
	<link rel="stylesheet" type="text/css" media="screen" href="css/common/screen.css" />
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/mem_login.js" type="text/javascript"></script>
</head>

<body>
	<div class="contents">
		<s:form name="frm_mem_menu">
			<table>
				<tr>
					<td><s:url id="change_pwd" action="changePwdMember" /> <s:a
						href="%{change_pwd}">
						<s:property value="%{getText('mem_change_pwd_title')}" />
					</s:a></td>
				</tr>
				<tr>
					<td><s:url id="login" action="loginUserInfo" /> <s:a
						href="%{login}">
						<s:property value="%{getText('log_in')}" />
					</s:a></td>
				</tr>
				<tr>
					<td><s:url id="new" action="newUserInfo" /> <s:a
						href="%{new}">
						<s:property value="%{getText('new')}" />
					</s:a></td>
				</tr>
				<tr>
					<td><s:url id="inviteFriend" action="inputInvite" /> <s:a
						href="%{inviteFriend}">
						<s:property value="%{getText('invite_input_title')}" />
					</s:a></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>

</html>