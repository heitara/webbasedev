<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<title><s:property value="%{getText('mem_menu_tilte')}" /></title>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/mem_login.js" type="text/javascript"></script>
</head>
<body>
	<div class="contents">
		<s:form name="frm_mem_menu">
			<table>
				<tr>
					<td>
						<s:property value="memId" />
					</td>
				</tr>
				<tr>
					<td>
						<s:url id="change_pwd" action="changePwdMember"/>
						<s:a href="%{change_pwd}">
							<s:property value="%{getText('mem_change_pwd_title')}" />
						</s:a>
					</td>
				</tr>
				<tr>
					<td>
						<s:url id="show_detail" action="showMember"/>
						<s:a href="%{show_detail}">
							<s:property value="%{getText('mem_info_title')}" />
						</s:a>
					</td>
				</tr>
				<tr>
					<td>
						<s:url id="inviteFriend" action="inputInvite" includeParams="none"/>
						<s:a href="%{inviteFriend}">
							<s:property value="%{getText('invite_input_title')}" />
						</s:a>
					</td>
				</tr>
				<s:hidden id="memId" value="memId" />
			</table>
		</s:form>
	</div>
</body>
</html>