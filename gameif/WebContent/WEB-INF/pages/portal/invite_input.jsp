<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
	<head>
		<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
		<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
		<title>友達紹介 | ゲームイフ | ブラウザゲームのポータルサイト</title>
		<script charset="UTF-8" src="js/portal/common.js" language="JavaScript" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>友達紹介</strong><span><a href="friendhist.html">► 友達紹介履歴</a></span></dt>
			<dd>
				<s:form name="frm_invite_input" method="post" cssClass="entry">
					<dl>
						<dt><span class="required">*</span><label for="mail_from">紹介者のメールアドレス：</label></dt>
						<dd>
							<s:textfield name="inviteMailFrom" maxlength="100" cssClass="big ime_mode_n"/>
							<span class="input_error"><s:fielderror><s:param>inviteMailFrom</s:param></s:fielderror></span><br/>
						</dd>
						
						<dt><span class="required">*</span><label for="friends">友達のメールアドレス：</label></dt>
						<dd>
							<s:textarea name="inviteMailTo" rows="8" cssClass="big ime_mode_n f_left"/>
							<span class="input_error"><s:fielderror><s:param>inviteMailTo</s:param></s:fielderror></span><br/>
							<div class=" mail_import">
	
								<span class="explain">下記のＷＥＢメールならアドレス帳から直接アドレスをインポートすることができます。</span><br/>
								<a href="javascript:openPopup('fimsel.html', 600, 540);" title="hotmailアドレス帳からインポートする。"><img src="images/icon_hotmail.gif"/></a><br/>
								<a href="javascript:openPopup('fimsel.html', 600, 540);" title="gmailアドレス帳からインポートする。"><img src="images/icon_gmail.gif"/></a><br/>
								<a href="javascript:openPopup('fimsel.html', 600, 540);" title="Yahoo!メールアドレス帳からインポートする。"><img src="images/icon_yahoo_mail.gif"/></a><br/><br/>
								<input type="button" value="メールアドレスインポート" class="big" onclick="openPopup('fimsel.html', 600, 540);"/>
							</div>
							<div class="clearbox"></div>
							<span class="explain">複数人の場合、一行に一件ずつ入力してください。</span>
						</dd>
						<dt></dt>
						<dd>&nbsp;</dd>
						
						<dt><span class="required">*</span><label for="game">紹介するゲーム：</label></dt>
						<dd>
							<s:select name="titleId" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName"  headerKey="0" headerValue="" title="紹介するゲーム"  onblur="validate(this,'REQ');" />
							<span class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span><br/>
							<br/>
							<span class="explain">紹介するゲームを選んでください。</span>
						</dd>
						
						<dt><label for="message_tmpl">招待メッセージ：</label></dt>
						<dd>
							<s:select name="inviteTemplate" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName"  headerKey="0" headerValue="" cssClass="big"/>
							<br/>
							<span class="explain">テンプレートから選ぶと、大枠が自動的に入力されますので、<br/>入力時間を省けられます。</span>
						</dd>
						<dt/>
						<dd>
							<s:textarea name="inviteMsg" rows="8" cssClass="big ime_mode_n"/><br/>
							<span class="explain">招待メールの本文を入力してください。</span>
						</dd>
	
					</dl>
					<div class="submit">
						<s:submit action="createInvite" value="送信" cssClass="submit"></s:submit>
						<s:reset value="クリア" cssClass="submit"></s:reset>
					</div>
	
				</s:form>
			</dd>
		</dl>
	</body>
</html>