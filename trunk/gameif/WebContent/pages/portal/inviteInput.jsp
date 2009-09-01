<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
	<html>

	<head>
		<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
		<meta content="index, follow" name="robots"/>
		<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
		<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
		<title><s:property value="%{getText('invite_input_title')}" /></title>
		<link type="text/css" href="css/common/common.css" rel="stylesheet"></link>
		<link type="text/css" href="css/main.css" rel="stylesheet"></link>
		<script charset="UTF-8" src="js/portal/common.js" language="JavaScript" type="text/javascript"></script>
		<s:include value="../common/header.jsp"></s:include>
	</head>
	
	<body>
	<div class="light_box tspace_n"><s:form name="frm_invite_input"
		method="POST" action="saveInvite">
		<table>
			<tr>
				<td><s:property value="%{getText('invite_from')}" /></td>
				<td><s:textfield value="inviteFrom" /></td>
			</tr>
			<tr>
				<td><s:property value="%{getText('invite_to')}" /></td>
				<td><s:textarea name="inviteTo" /></td>
			</tr>
			<tr>
				<td />
				<td><s:property value="%{getText('invite_split_msg')}" /></td>
			</tr>
			<tr>
				<td><s:property value="%{getText('invite_title')}" /></td>
				<td><s:select name="titleId" list="listInviteTitle"
					listKey="key" listValue="value" /></td>
			</tr>
			<tr>
				<td />
				<td><s:property value="%{getText('invite_title_msg')}" /></td>
			</tr>
			<tr>
				<td><s:property value="%{getText('invite_msg')}" /></td>
				<td><s:select name="inviteTemplate" list="listInviteTemplate"
					listKey="key" listValue="value" /></td>
			</tr>
			<tr>
				<td />
				<td><s:property value="%{getText('invite_template_msg')}" /></td>
			</tr>
			<tr>
				<td />
				<td><s:textarea name="inviteMsg" /></td>
			</tr>
			<tr>
				<td />
				<td><s:property value="%{getText('invite_confirm_msg')}" /></td>
			</tr>

			<tr>
				<td><s:submit value="%{getText('sendMail')}"></s:submit></td>
				<td><s:submit value="%{getText('clear')}"></s:submit>
			</tr>
		</table>
	</s:form></div>
	</body>

	<s:include value="../common/footer.jsp"></s:include>

	</html>
</s:i18n>