<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ユーザ変更</title>
	<script src="js/validate.js" type="text/javascript"></script>
</head>

<body>
	<dl class="light_box tspace_n">
		<dt><strong>ユーザ変更</strong></dt>
		<dd>
			<s:form name="frm_login_user_input" method="post" cssClass="entry">
				<table>
					<tr>
						<th><span class="required">*</span><label for="createLoginUser_userId">ユーザＩＤ：</label></th>
						<td>
							<s:textfield name="userId" maxlength="20" cssClass="ime_mode_n" title="ユーザＩＤ" onblur="validate(this, 'REQ,ALN,LEN_6_20,EXI');"/>
							<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
							<span id="error_userId" class="input_error"><s:fielderror><s:param>userId</s:param></s:fielderror></span>
							
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="createLoginUser_nickName">ニックネーム：</label></th>
						<td>
							<s:textfield name="nickName" maxlength="20" title="ニックネーム" onblur="validate(this, 'REQ,KOT,NEQ_memId,EXN');"/>
							<span class="explain">※ 記号とスペース以外の文字で入力してください。</span>
							<span id="error_nickName" class="input_error"><s:fielderror><s:param>nickName</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="point_titleId">権限：</label></th>
						<td>
							<s:select name="authorityCode" id="authorityCode" cssClass="big" list="authorityBusinessLogic.all" listKey="authorityCode" listValue="authorityName" title="権限"  onblur="validate(this,'REQ');" />
							<span id="error_authorityCode" class="input_error"><s:fielderror><s:param>authorityCode</s:param></s:fielderror></span><br/>
							<span class="explain">権限を選択してください。</span>
						</td>
					</tr>
					<tr class="space_row"><td colspan="2"></td></tr>
					<tr>
						<th><span class="required">*</span><label for="createLoginUser_password">パスワード：</label></th>
						<td>
							<s:password name="password" maxlength="20" cssClass="ime_mode_n" title="パスワード" onblur="validate(this, 'REQ,ALN,LEN_6_20,NEQ_memId');"/>
							<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
							<span id="error_password" class="input_error"><s:fielderror><s:param>password</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="createLoginUser_confirmPassword">パスワード再入力：</label></th>
						<td>
							<s:password name="confirmPassword" maxlength="20" cssClass="ime_mode_n" title="パスワード再入力" onblur="validate(this, 'REQ,ALN,LEN_6_20,EQU_memPwd');"/>
							<span class="explain">※ 確認のためパスワードを再入力してください。</span>
							<span id="error_confirmPassword" class="input_error"><s:fielderror><s:param>confirmPassword</s:param></s:fielderror></span>
						</td>
					</tr>
				</table>
				<div class="submit">
					<s:token />
					<s:submit value="保存" action="addLoginUser" />
					<s:submit value="クリア" onclick="this.form.reset();return false;" />
					<a href="inputInquriyList.html" title="戻る">戻る</a>
				</div>

			</s:form>
		</dd>
	</dl>
</body>

</html>