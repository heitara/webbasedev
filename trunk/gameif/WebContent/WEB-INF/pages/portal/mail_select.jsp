<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<title>友達メールアドレスインポート | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>

<body>
<dl class="pop_top">
	<dt><a href="http://www.game-if.com"><img src="images/logo.gif" title="WEBGAMEポータル ゲームイフ" border="0"/></a></dt>
	<dd>
		<dl class="title_box tspace_n bottom_align">
			<dt><strong>友達メールアドレスインポート</strong><span></span></dt>
			<dd></dd>
		</dl>
	</dd>

</dl>
<form name="frm_mail_sel" method="post" class="address_sel">
	<div class="" style="margin:10px 70px;font-size:12px;font-weight:bold;">あなたのＷＥＢメールのアドレスとパスワードを入力してください。</div>
	<div style="color:#900;margin:20px 70px;font-size:10px;">
		ゲームイフがあなたの代わりにアドレス帳から友達のアドレスを検索します。<br/>
		パスワードはこの検索で一回使用するだけで、保存はしません。
	</div>
	<dl class="select_mail">
		<dt><span class="required">*</span> <label for="mail">メールアドレス：</label></dt>
		<dd>
			<s:textfield name="mailAdd" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ');"/>
			<s:select name="domain" list="portalProperties.domainListMap" headerKey="" headerValue="" title="ドメイン" onblur="validate(this, 'REQ');"/>
			<span id="error_mailAdd" class="input_error"><s:fielderror><s:param>mailAdd</s:param></s:fielderror></span>
			<span id="error_domain" class="input_error"><s:fielderror><s:param>domain</s:param></s:fielderror></span>
		</dd>
		
		<dt>
			<span class="required">*</span> <label for="passwd">パスワード：</label>
		</dt>
		<dd>
			<s:password name="memPwd" maxlength="100" cssClass="ime_mode_n" title="パスワード" onblur="validate(this, 'REQ');"/>
			<span id="error_memPwd" class="input_error"><s:fielderror><s:param>memPwd</s:param></s:fielderror></span>
		</dd>
		
	</dl>
	<div class="submit">
		<s:submit action="loginMailSelInvite" value="友達を検索" cssClass="submit"/>
		<input type="button" value="キャンセル" class="submit" onclick="window.close();"/>
	</div>

</form>

</body>

</html>