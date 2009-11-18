<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>友達紹介 | メールで紹介</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
		<script src="js/portal/bindMaster.js" type="text/javascript"></script>
		<script type="text/javascript">
			window.onload = function(){   
				 var titleId = document.getElementById("titleId");
				 var inviteTemplate = $("#inviteTemplate");
				 bindTemplate(titleId, inviteTemplate);
	        }
		</script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>友達紹介（メール）</strong><span><a href="showMailInviteHist.html">► 友達紹介履歴（メール）</a></span></dt>
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
								<s:textarea name="inviteMailTo" id="inviteMailTo" rows="7" cssClass="big ime_mode_n f_left" cssStyle="height:100px;" title="友達のメールアドレス" onblur="validate(this, 'REQ');"/>
								<div class=" mail_import">
									<span class="explain">下のウェブメールのお持ちの方は、連絡帳から<br/>友達のメールをインポートすることができます。</span>
									<table>
										<tr>
											<td align="right"><img src="images/icon_hotmail.gif" alt="Hotmail、Liveメール"/></td>
											<td><a href="javascript:openPopup('inputMailSelInvite.html?domain=@hotmail.co.jp', 600, 540);" title="hotmailアドレス帳からインポートする。"><img src="images/btn_c_import.png" alt="インポート"/></a></td>
										</tr>
										<tr>
											<td align="right"><img src="images/icon_gmail.gif" alt="Gmail"/></td>
											<td><a href="javascript:openPopup('inputMailSelInvite.html?domain=@gmail.com', 600, 540);" title="Gmailアドレス帳からインポートする。"><img src="images/btn_c_import.png" alt="インポート"/></a></td>
										</tr>
										<tr>
											<td align="right"><img src="images/icon_yahoo_mail.gif" alt="Yahooメール"/></td>
											<td><a href="javascript:openPopup('inputMailSelInvite.html?domain=@yahoo.co.jp', 600, 540);" title="Yahooメールアドレス帳からインポートする。"><img src="images/btn_c_import.png" alt="インポート"/></a></td>
										</tr>
									</table>
								</div>
								<div class="clearbox"></div>
								<span id="error_inviteMailTo" class="input_error"><s:fielderror><s:param>inviteMailTo</s:param></s:fielderror></span>
								<span class="explain">※複数人の場合、一行に一件ずつ入力してください。（改行必須）</span><br/>
								<span class="explain">※毎日メールで紹介できる友達は最大5名です。</span>
							</td>
						</tr>
						<tr class="space_row">
							<td colspan="2"></td>
						</tr>
						<tr>
							<th><span class="required">*</span><label for="game">紹介するゲーム：</label></th>
							<td>
								<s:select name="titleId" id="titleId" cssClass="big" cssStyle="font-size:12px;" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName" title="紹介するゲーム" onchange="bindTemplate(this, inviteTemplate);"  />
								<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span><br/>
							</td>
						</tr>						
						<tr>
							<th><span class="required">*</span><label for="message_tmpl">招待メッセージ：</label></th>
							<td>
								<select id="inviteTemplate" name="inviteTemplate" class="big" style="font-size:12px;" onchange="changeMessage(this, inviteMsg)"></select>
								<span class="explain">※選択すると下のメッセージ欄に内容が入ります。</span>
							</td>
						</tr>
						<tr>
							<th></th>
							<td>
								<s:textarea name="inviteMsg" rows="10" cssClass="big ime_mode_n" title="招待メッセージ" onblur="validate(this, 'REQ,LEN_5_1000');" />
								<span id="error_inviteMsg" class="input_error"><s:fielderror><s:param>inviteMsg</s:param></s:fielderror></span><br/>
								<span class="explain">※招待メールの本文を入力してください。</span>
							</td>
						</tr>
					</table>
					<div class="submit">
						<s:submit type="image" src="images/btn_c_invite_mail_send.png"></s:submit>
					</div>
				</s:form>
			</dd>
		</dl>
	</body>
</html>