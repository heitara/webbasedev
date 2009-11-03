<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>パスワードを忘れた方へ</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>



<body>
<dl class="light_box tspace_n">
	<dt>
		<strong>パスワード再発行</strong>
		<span></span>
	</dt>
	<dd>
		<s:form name="frm_pwd_reget" method="post" cssClass="entry">
			<table>
				<tr>
					<th><span class="required">*</span><label for="createPwdReget_memId">アカウントＩＤ：</label></th>
					<td>
						<s:textfield name="memId" maxlength="20" cssClass="ime_mode_n" title="アカウントＩＤ" onblur="validate(this, 'REQ,ALN,LEN_6_20');"/>
						<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
						<span id="error_memId" class="input_error"><s:fielderror><s:param>memId</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createPwdReget_mailPc">メールアドレス：</label></th>
					<td>
						<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ,EML');"/>
						<span class="explain">※ メールアドレスを小文字で入力してください。</span>
						<span id="error_mailPc" class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token />
				<s:submit action="createPwdReget" value="発行"/>
				<s:reset value="クリア" />
			</div>

		</s:form>
	</dd>
</dl>

</body>
</html>