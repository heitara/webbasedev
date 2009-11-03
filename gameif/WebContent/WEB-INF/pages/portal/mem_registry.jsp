<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>会員登録</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function RefreshImg(){
			$("#kaptchaPic").attr({src: "images/kaptcha?" + new Date().getSeconds()});
		}
	</script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>会員登録</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form action="createTempMember" cssClass="entry">
			<s:hidden name="inviteId"></s:hidden>
			<table>
				<tr>
					<th><span class="required">*</span><label for="createMember_memId">アカウントＩＤ：</label></th>
					<td>
						<s:textfield name="memId" maxlength="20" cssClass="ime_mode_n" title="アカウントＩＤ" onblur="validate(this, 'REQ,ALN,LEN_6_20,EXI');"/>
						<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
						<span id="error_memId" class="input_error"><s:fielderror><s:param>memId</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createMember_nickName">ニックネーム：</label></th>
					<td>
						<s:textfield name="nickName" maxlength="20" title="ニックネーム" onblur="validate(this, 'REQ,KOT,EXN');"/>
						<span class="explain">※ 記号とスペース以外の文字で入力してください。</span>
						<span id="error_nickName" class="input_error"><s:fielderror><s:param>nickName</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createMember_mailPc">メールアドレス：</label></th>
					<td>
						<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ,EML,EXM');"/>
						<span class="explain">※ メールアドレスを小文字で入力してください。</span>
						<span id="error_mailPc" class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><span class="required">*</span><label for="createMember_memPwd">パスワード：</label></th>
					<td>
	
						<s:password name="memPwd" maxlength="20" cssClass="ime_mode_n" title="パスワード" onblur="validate(this, 'REQ,ALN,LEN_6_20');"/>
						<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
						<span id="error_memPwd" class="input_error"><s:fielderror><s:param>memPwd</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createMember_confirmPwd">パスワード再入力：</label></th>
					<td>
						<s:password name="confirmPwd" maxlength="20" cssClass="ime_mode_n" title="パスワード再入力" onblur="validate(this, 'REQ,ALN,LEN_6_20,EQU_memPwd');"/>
						<span class="explain">※ 確認のためパスワードを再入力してください。</span>
						<span id="error_confirmPwd" class="input_error"><s:fielderror><s:param>confirmPwd</s:param></s:fielderror></span>
					</td>
				</tr>
				<!-- 
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><span class="required">*</span><label for="createMember_questionCd">秘密質問：</label></th>
					<td>
						<s:select name="questionCd" list="masterInfoBusinessLogic.allQuestionList" listKey="questionCode" listValue="questionName" headerKey="0" headerValue="" title="秘密質問" onblur="validate(this,'REQ');"/>
						<span class="explain">※ パスワードを忘れた時に使います。（変更不可）</span>
						<span id="error_questionCd" class="input_error"><s:fielderror><s:param>questionCd</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createMember_answer">秘密質問の答え：</label></th>
					<td>
						<s:textfield name="answer" maxlength="20" cssClass="ime_mode_y" title="秘密質問の答え" onblur="validate(this,'REQ,ZEN');"/>
						<span class="explain">※ 2～10桁の全角文字で入力してください。</span>
						<span id="error_answer" class="input_error"><s:fielderror><s:param>answer</s:param></s:fielderror></span>
					</td>
				</tr>
				 -->
				<tr class="space_row"><td colspan="2"></td></tr>

				<tr>
					<th><span class="required">*</span><label for="createMember_kaptcha">画像認証：</label></th>
					<td>
						<img id="kaptchaPic" src="images/kaptcha"/>
						<a href="javascript:RefreshImg();"><img id="newKaptcha" src="images/capture_update.gif"/></a><br/>
						<s:textfield name="kaptcha" maxlength="20"  cssClass="ime_mode_n" title="画像認証" onblur="validate(this,'REQ,ALN');"/>
						<span class="explain">※ 画像認証コードを入力してください。</span>
						<span id="error_kaptcha" class="input_error"><s:fielderror><s:param>kaptcha</s:param></s:fielderror></span>
					</td>
				</tr>
				<!-- 
				<tr>
					<th></th>
					<td>
						<s:checkbox name="mailmagReqCd" value="%{magazine == null ? true : (mailmagReqCd == 1 ? true : false)}" fieldValue="1" title="メルマガ受信" />
						<label for="createMember_mailmagReqCd">メルマガを受信する。</label>
					</td>
				</tr>
				 -->
				<tr>
					<th></th>
					<td>
						<span>上記の登録フォームを送信することにより、あなたは<a href="#" class="agreement">利用規約</a> に同意したこととなります。</span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token />
				<s:submit value="利用規約に同意して登録する" cssClass="submit"/>
				<s:reset value="クリア"/>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>