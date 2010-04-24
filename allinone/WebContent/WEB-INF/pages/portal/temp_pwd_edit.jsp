<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.gameif.portal.constants.PortalConstants"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>パスワード再設定</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>パスワード再設定</strong> <span><a
		href="inputPwdReget.html">► 仮パスワード発行</a></span></dt>
	<dd><s:form name="frm_temp_pwd_edit" method="post" cssClass="entry">
		<s:hidden name="memNum"></s:hidden>
		<s:hidden name="tempKey"></s:hidden>
		<table>
			<tr>
				<th></th>
				<td>
					<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
				</td>
			</tr>
			<tr>
				<th><span class="required">*</span><label for="createPwdReget_memId">アカウントＩＤ：</label></th>
				<td>
					<s:textfield name="memId" maxlength="20" cssClass="ime_mode_n" title="アカウントＩＤ" onblur="validate(this, 'REQ,ALN,LEN_6_20');"/>
					<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
					<span id="error_memId" class="input_error"><s:fielderror><s:param>memId</s:param></s:fielderror></span>
				</td>
			</tr>
			<tr>
				<th><span class="required">*</span> <label for="updateTempPwd_newPwd">新しいパスワード：</label></th>
				<td>
					<s:password name="newPwd" maxlength="20" cssClass="ime_mode_n" title="新しいパスワード" onblur="validate(this, 'REQ,ALN,LEN_6_20,NEQ_memId');" /> 
					<span class="explain">※ 6～20桁の半角英数字で入力してください。</span> 
					<span id="error_newPwd" class="input_error"><s:fielderror><s:param>newPwd</s:param></s:fielderror></span>
				</td>
			</tr>
			<tr>
				<th><span class="required">*</span> <label
					for="updateTempPwd_confirmPwd">パスワード再入力：</label></th>
				<td>
					<s:password name="confirmPwd" maxlength="20" cssClass="ime_mode_n" title="パスワード再入力" onblur="validate(this, 'REQ,ALN,LEN_6_20,EQU_newPwd');" /> 
					<span class="explain">※ 確認のためパスワードを再入力してください。</span> 
					<span id="error_confirmPwd" class="input_error"><s:fielderror><s:param>confirmPwd</s:param></s:fielderror></span>
				</td>
			</tr>
		</table>
		
		<div class="submit">
			<s:token /> <s:hidden name="model.versionNo" />
			<s:submit action="updateTempPwd" value="設定" cssClass="submit" /> 
			<s:reset value="クリア" cssClass="submit" />
		</div>

	</s:form></dd>
</dl>

</body>
</html>