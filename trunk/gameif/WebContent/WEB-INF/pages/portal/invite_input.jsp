<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
	<head>
		<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
		<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
		<title>友達紹介 | ゲームイフ | ブラウザゲームのポータルサイト</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>友達紹介</strong><span><a href="showInviteHist.html">► 友達紹介履歴</a></span></dt>
			<dd>
				<s:form name="frm_invite_input" action="createInvite" method="post" cssClass="entry">
					<table>
						<tr>
							<th><span class="required">*</span><label for="mail_from">紹介者のメールアドレス：</label></th>
							<td>
								<s:textfield name="inviteMailFrom" maxlength="100" cssClass="ime_mode_n big" title="紹介者のメールアドレス" onblur="validate(this, 'REQ,EML');"/>
								<span id="error_inviteMailFrom" class="input_error"><s:fielderror><s:param>inviteMailFrom</s:param></s:fielderror></span><br/>
							</td>
						</tr>						
						<tr>
							<th><span class="required">*</span><label for="friends">友達のメールアドレス：</label></th>
							<td>
								<s:textarea name="inviteMailTo" id="inviteMailTo" rows="10" cssClass="big ime_mode_n f_left" title="友達のメールアドレス" onblur="validate(this, 'REQ');"/>
								<div class=" mail_import">
									<span class="explain">下記のＷＥＢメールならアドレス帳から直接アドレスをインポートすることができます。</span><br/>
									<a href="javascript:openPopup('inputMailSelInvite.html?domain=@hotmail.co.jp', 600, 540);" title="hotmailアドレス帳からインポートする。"><img src="images/icon_hotmail.gif"/></a><br/>
									<a href="javascript:openPopup('inputMailSelInvite.html?domain=@gmail.com', 600, 540);" title="gmailアドレス帳からインポートする。"><img src="images/icon_gmail.gif"/></a><br/>
									<a href="javascript:openPopup('inputMailSelInvite.html?domain=@yahoo.co.jp', 600, 540);" title="Yahoo!メールアドレス帳からインポートする。"><img src="images/icon_yahoo_mail.gif"/></a><br/><br/>
									<input type="button" value="メールアドレスインポート" class="big" onclick="openPopup('inputMailSelInvite.html', 600, 540);"/>
								</div>
								<div class="clearbox"></div>
								<span id="error_inviteMailTo" class="input_error"><s:fielderror><s:param>inviteMailTo</s:param></s:fielderror></span>
								<span class="explain">※複数人の場合、一行に一件ずつ入力してください。</span>
							</td>
						</tr>
						<tr class="space_row">
							<td colspan="2"></td>
						</tr>
						<!-- 
						<tr>
							<th><span class="required">*</span><label for="game">紹介するゲーム：</label></th>
							<td>
								<s:select name="titleId" cssClass="big" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName"  headerKey="0" headerValue="" title="紹介するゲーム"  onblur="validate(this,'REQ');" />
								<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span><br/>
								<span class="explain">※紹介するゲームを選んでください。</span>
							</td>
						</tr>						
						<tr>
							<th><span class="required">*</span><label for="message_tmpl">招待メッセージ：</label></th>
							<td>
								<s:select name="inviteTemplate" list="masterInfoBusinessLogic.inviteTemplateList" listKey="inviteTemplateId" listValue="inviteTemplateSubject"  headerKey="0" headerValue="" cssClass="big"/>
								<br/>
								<span class="explain">※テンプレートから選ぶと、大枠が自動的に入力されますので、<br/>入力時間を省けられます。</span>
							</td>
						</tr>
						 -->
						<tr>
							<th valign="top"><span class="required">*</span><label for="game">紹介するゲーム：</label><br/><br/>
								<span class="required">*</span><label for="game">招待メッセージ：</label></th>
							<td>
								<s:doubleselect name="titleId" list="titleList" listKey="titleId" listValue="titleName" doubleName="inviteTemplate" doubleList="inviteTemplateList.get(top.titleId)" doubleListKey="inviteTemplateId" doubleListValue="inviteTemplateSubject" />
								
								<br/>
								<span class="explain">※テンプレートから選ぶと、大枠が自動的に入力されますので、<br/>入力時間を省けられます。</span>
							</td>
						</tr>
						<tr>
							<th></th>
							<td>
								<s:textarea name="inviteMsg" rows="15" cssClass="big ime_mode_n" cssStyle="width:360px;" title="招待メッセージ" onblur="validate(this, 'REQ,LEN_5_1000');" />
								<span id="error_inviteMsg" class="input_error"><s:fielderror><s:param>inviteMsg</s:param></s:fielderror></span><br/>
								<span class="explain">※招待メールの本文を入力してください。</span>
							</td>
						</tr>
					</table>
					<div class="submit">
						<s:submit value="送信" cssClass="submit"></s:submit>
						<s:reset value="クリア" cssClass="submit"></s:reset>
					</div>
	
				</s:form>
			</dd>
		</dl>
	</body>
</html>