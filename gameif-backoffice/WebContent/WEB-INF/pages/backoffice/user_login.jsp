<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<html>
<head>
	<title>ログイン</title>
	<script src="js/validate.js" type="text/javascript"></script>
</head>

<body>
<!-- パスワード変更：開始 -->
<dl class="light_box tspace_n">
	<dd>
		<form name="frm_nosubmit_login" action="checkUserLogin.html" class="entry" method="post">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span> <label for="checkUserLogin_password">ユーザID：</label></th>
					<td>
						<s:textfield name="userId" maxlength="20" cssClass="ime_mode_n" title="ユーザID" onblur="validate(this, 'REQ,ALN,LEN_4_20');"/>
						<span id="error_userId" class="input_error"><s:fielderror><s:param>userId</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span> <label for="checkUserLogin_password">パスワード：</label></th>
					<td>
						<s:password name="password" maxlength="20" cssClass="ime_mode_n" title="パスワード" onblur="validate(this, 'REQ,ALN,LEN_4_20');"/>
						<span id="error_password" class="input_error"><s:fielderror><s:param>password</s:param></s:fielderror></span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<input type="submit" class="submit" value="ログイン"/>
				<input type="reset" class="submit" value="クリア"/>
			</div>

		</form>
	</dd>
</dl>
<!-- パスワード変更：終了 -->

</body>
</html>