<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title><s:property value="%{getText('new_mem_tilte')}" /></title>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/mem_login.js" type="text/javascript"></script>
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
		<s:form name="frm_mem_edit" method="POST" cssClass="entry">
			<dl>
				<dt><span class="required">*</span><label for="giid">アカウントID(GI-ID)：</label></dt>
				<dd>
					<s:textfield name="memId" maxlength="20" cssClass="ime_mode_n" />
					<span class="input_error"><s:fielderror><s:param>memId</s:param></s:fielderror></span><br/>
					<span class="explain">6～20桁の半角英数字で入力してください。</span>
				</dd>
				
				<dt><span class="required">*</span><label for="passwd">パスワード：</label></dt>
				<dd>

					<s:password name="memPwd" maxlength="20" cssClass="ime_mode_n" />
					<span class="input_error"><s:fielderror><s:param>memPwd</s:param></s:fielderror></span><br/>
					<span class="explain">6～20桁の半角英数字で入力してください。</span>
				</dd>
				
				<dt><span class="required">*</span><label for="passwd_crm">パスワード再入力：</label></dt>
				<dd>
					<s:password name="confirmPwd" maxlength="20" cssClass="ime_mode_n" />
					<span class="input_error"><s:fielderror><s:param>confirmPwd</s:param></s:fielderror></span><br/>
					<span class="explain">確認のためパスワードを再入力してください。</span>
				</dd>
				
				<dt></dt>
				<dd>&nbsp;</dd>

				<dt><span class="required">*</span><label for="nickname">ニックネーム：</label></dt>
				<dd>
					<s:textfield name="nickName" maxlength="20" />
					<span class="input_error"><s:fielderror><s:param>nickName</s:param></s:fielderror></span><br/>
					<span class="explain">記号とスペース以外の文字で入力してください。</span>
				</dd>
				
				<dt><span class="required">*</span><label for="mail">メールアドレス：</label></dt>
				<dd>
					<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n" />
					<span class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span><br/>
					<span class="explain">メールアドレスを小文字で入力してください。</span>
				</dd>
				
				<dt></dt>
				<dd>&nbsp;</dd>
				
				<dt><span class="required">*</span><label for="question">秘密質問：</label></dt>
				<dd>
					<s:select name="questionCd" list="portalProperties.questionList" headerKey="0" headerValue="" />
					<span class="input_error"><s:fielderror><s:param>questionCd</s:param></s:fielderror></span><br/>
					<span class="explain">パスワードを忘れた時に使います。（変更不可）</span>
				</dd>
				
				<dt><span class="required">*</span><label for="answer">秘密質問の答え：</label></dt>
				<dd>
					<s:textfield name="answer" maxlength="20" />
					<span class="input_error"><s:fielderror><s:param>answer</s:param></s:fielderror></span><br/>
					<span class="explain">2～10桁の全角文字で入力してください。</span>
				</dd>
				
				<dt></dt>
				<dd>&nbsp;</dd>

				<dt><span class="required">*</span><label for="capture">画像認証：</label></dt>
				<dd>
					<img id="kaptchaPic" src="images/kaptcha.jpg"/>
					<a href="javascript:RefreshImg();"><img id="newKaptcha" src="images/capture_update.gif"/></a><br/>
					<s:textfield name="kaptcha" maxlength="6"  cssClass="ime_mode_n" />
					<span class="input_error"><s:fielderror><s:param>kaptcha</s:param></s:fielderror></span><br/>
					<span class="explain">画像認証コードを入力してください。</span>
				</dd>
				
				<dt></dt>
				<dd>&nbsp;</dd>

				<dt></dt>
				<dd>
					<s:checkbox name="mailmagReqCd" value="%{magazine == null ? true : (mailmagReqCd == 1 ? true : false)}" fieldValue="1"/>
					<label for="createMember_mailmagReqCd">メルマガを受信する。</label>
				</dd>
					
				<dt></dt>
				<dd>
					<s:checkbox name="agreement" value="%{agreement == 1 ? true : false}" fieldValue="1"/>
					<label for="createMember_agreement">利用規約に同意する。</label>
					(<a href="#" class="agreement">利用規約</a> )
					<span class="input_error"><s:fielderror><s:param>agreement</s:param></s:fielderror></span>
				</dd>
				<dt></dt>
				<dd></dd>
			</dl>
			<div class="submit">
				<s:token />
				<s:submit action="createMember" formId="frm_mem_edit" value="登録"></s:submit>
				<s:reset action="createMember" value="クリア"></s:reset>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>