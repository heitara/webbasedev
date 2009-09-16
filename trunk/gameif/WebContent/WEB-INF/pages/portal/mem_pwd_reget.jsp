<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title>パスワード再発行 | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>

<body>
<dl class="light_box tspace_n">
<dt><strong>パスワード再発行</strong><span></span></dt>
	<dd>
		<s:form name="frm_pwd_reget" cssClass="entry">
			<dl>
				<dt><span class="required">*</span><label for="createMember_mailPc">メールアドレス：</label></dt>
				<dd>
					<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ,EML,EXM');"/>
					<span class="explain">※ メールアドレスを小文字で入力してください。</span>
					<span id="error_mailPc" class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span>
				</dd>
				
				<dt><span class="required">*</span><label for="createMember_questionCd">秘密質問：</label></dt>
				<dd>
					<s:select name="questionCd" list="masterInfoBusinessLogic.allQuestionList" listKey="questionCode" listValue="questionName" headerKey="0" headerValue="" title="秘密質問" onblur="validate(this,'REQ');"/>
					<span id="error_questionCd" class="input_error"><s:fielderror><s:param>questionCd</s:param></s:fielderror></span>
				</dd>
				
				<dt><span class="required">*</span><label for="createMember_answer">秘密質問の答え：</label></dt>
				<dd>
					<s:textfield name="answer" maxlength="20" cssClass="ime_mode_y" title="秘密質問の答え" onblur="validate(this,'REQ,ZEN');"/>
					<span class="explain">※ 2～10桁の全角文字で入力してください。</span>
					<span id="error_answer" class="input_error"><s:fielderror><s:param>answer</s:param></s:fielderror></span>
				</dd>
				
				<dt></dt>
				<dd></dd>
			</dl>
			<div class="submit">
				<s:token />
				<s:submit action="createPwdReget" value="再発行"/>
				<s:reset value="クリア"/>
			</div>
		</s:form>
	</dd>
</dl>
</body>

</html>