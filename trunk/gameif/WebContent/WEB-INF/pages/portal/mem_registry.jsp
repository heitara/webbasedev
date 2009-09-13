<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title>会員登録 | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function RefreshImg(){
			$("#kaptchaPic").attr({src: "images/kaptcha.jpg?" + new Date().getSeconds()});
		}
	</script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>会員登録</strong><span></span></dt>
	<dd>
		<s:form action="createMember" cssClass="entry">
			<dl>
				<dt><span class="required">*</span><label for="createMember_memId">アカウントＩＤ：</label></dt>
				<dd>
					<s:textfield name="memId" maxlength="20" cssClass="ime_mode_n" title="アカウントＩＤ" onblur="validate(this, 'REQ,ALN,LEN_6_20,EXI');"/>
					<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
					<span id="error_memId" class="input_error"><s:fielderror><s:param>memId</s:param></s:fielderror></span>
				</dd>

				<dt><span class="required">*</span><label for="createMember_nickName">ニックネーム：</label></dt>
				<dd>
					<s:textfield name="nickName" maxlength="20" title="ニックネーム" onblur="validate(this, 'REQ,KOT,EXN');"/>
					<span class="explain">※ 記号とスペース以外の文字で入力してください。</span>
					<span id="error_nickName" class="input_error"><s:fielderror><s:param>nickName</s:param></s:fielderror></span>
				</dd>
				
				<dt><span class="required">*</span><label for="createMember_mailPc">メールアドレス：</label></dt>
				<dd>
					<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ,EML,EXM');"/>
					<span class="explain">※ メールアドレスを小文字で入力してください。</span>
					<span id="error_mailPc" class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span>
				</dd>
				
				<dt></dt>
				<dd>&nbsp;</dd>
				
				<dt><span class="required">*</span><label for="createMember_memPwd">パスワード：</label></dt>
				<dd>

					<s:password name="memPwd" maxlength="20" cssClass="ime_mode_n" title="パスワード" onblur="validate(this, 'REQ,ALN,LEN_6_20');"/>
					<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
					<span id="error_memPwd" class="input_error"><s:fielderror><s:param>memPwd</s:param></s:fielderror></span>
				</dd>
				
				<dt><span class="required">*</span><label for="createMember_confirmPwd">パスワード再入力：</label></dt>
				<dd>
					<s:password name="confirmPwd" maxlength="20" cssClass="ime_mode_n" title="パスワード再入力" onblur="validate(this, 'REQ,ALN,LEN_6_20,EQU_memPwd');"/>
					<span class="explain">※ 確認のためパスワードを再入力してください。</span>
					<span id="error_confirmPwd" class="input_error"><s:fielderror><s:param>confirmPwd</s:param></s:fielderror></span>
				</dd>
				
				<dt></dt>
				<dd>&nbsp;</dd>
				
				<dt><span class="required">*</span><label for="createMember_questionCd">秘密質問：</label></dt>
				<dd>
					<s:select name="questionCd" list="masterInfoBusinessLogic.allQuestionList" listKey="questionCode" listValue="questionName" headerKey="0" headerValue="" title="秘密質問" onblur="validate(this,'REQ');"/>
					<span class="explain">※ パスワードを忘れた時に使います。（変更不可）</span>
					<span id="error_questionCd" class="input_error"><s:fielderror><s:param>questionCd</s:param></s:fielderror></span>
				</dd>
				
				<dt><span class="required">*</span><label for="createMember_answer">秘密質問の答え：</label></dt>
				<dd>
					<s:textfield name="answer" maxlength="20" cssClass="ime_mode_y" title="秘密質問の答え" onblur="validate(this,'REQ,ZEN');"/>
					<span class="explain">※ 2～10桁の全角文字で入力してください。</span>
					<span id="error_answer" class="input_error"><s:fielderror><s:param>answer</s:param></s:fielderror></span>
				</dd>
				
				<dt></dt>
				<dd>&nbsp;</dd>

				<dt><span class="required">*</span><label for="createMember_kaptcha">画像認証：</label></dt>
				<dd>
					<img id="kaptchaPic" src="images/kaptcha.jpg"/>
					<a href="javascript:RefreshImg();"><img id="newKaptcha" src="images/capture_update.gif"/></a><br/>
					<s:textfield name="kaptcha" maxlength="20"  cssClass="ime_mode_n" title="画像認証" onblur="validate(this,'REQ,ALN');"/>
					<span class="explain">※ 画像認証コードを入力してください。</span>
					<span id="error_kaptcha" class="input_error"><s:fielderror><s:param>kaptcha</s:param></s:fielderror></span>
				</dd>
				
				
				<dt></dt>
				<dd>
					<s:checkbox name="mailmagReqCd" value="%{magazine == null ? true : (mailmagReqCd == 1 ? true : false)}" fieldValue="1" title="メルマガ受信" />
					<label for="createMember_mailmagReqCd">メルマガを受信する。</label>
				</dd>
				
				<dt></dt>
				<dd>
					<s:checkbox name="agreement" value="%{agreement == 1 ? true : false}" fieldValue="1" title="利用規約に同意" onblur="validate(this,'REQ');"/>
					<label for="createMember_agreement">利用規約に同意する。</label>
					(<a href="#" class="agreement">利用規約</a> )
					<span id="error_agreement" class="input_error"><s:fielderror><s:param>agreement</s:param></s:fielderror></span>
				</dd>
				<dt></dt>
				<dd></dd>
			</dl>
			<div class="submit">
				<s:token />
				<s:submit value="登録"/>
				<s:reset value="クリア"/>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>