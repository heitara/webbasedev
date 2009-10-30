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
					<th><span class="required">*</span><label for="createPwdReget_mailPc">メールアドレス：</label></th>
					<td>
						<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ,EML');"/>
						<span class="explain">※ メールアドレスを小文字で入力してください。</span>
						<span id="error_mailPc" class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createPwdReget_questionCd">秘密質問：</label></th>
					<td>
						<s:select name="questionCd" list="masterInfoBusinessLogic.allQuestionList" listKey="questionCode" listValue="questionName" headerKey="0" headerValue="" title="秘密質問" onblur="validate(this,'REQ');"/>
						<span class="explain">※ 以前設定した秘密質問を選択してください。</span>
						<span id="error_questionCd" class="input_error"><s:fielderror><s:param>questionCd</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createPwdReget_answer">秘密質問の答え：</label></th>
					<td>	
						<s:textfield name="answer" maxlength="20" cssClass="ime_mode_y" title="秘密質問の答え" onblur="validate(this,'REQ,ZEN');"/>
						<span class="explain">※ 2～10桁の全角文字で入力してください。</span>
						<span id="error_answer" class="input_error"><s:fielderror><s:param>answer</s:param></s:fielderror></span>
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