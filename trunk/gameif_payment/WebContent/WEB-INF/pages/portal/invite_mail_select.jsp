<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<title>メールアドレスインポート | 友達紹介</title>
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<meta content="index, follow" name="robots"/>
	<base href="<%=getServletContext().getInitParameter("portalTopUrl")%>/"/>
	<link type="text/css" href="css/common.css" rel="stylesheet"></link>
	<link type="text/css" href="css/popup.css" rel="stylesheet"></link>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>

<body>
<table width="100%">
	<tr>
		<td width="170"><a href="http://www.game-if.com"><img src="images/logo.gif" title="WEBGAMEポータル ゲームイフ" border="0"/></a></td>
		<td valign="bottom">
			<dl class="title_width">
				<dt><strong>友達メールアドレスインポート</strong><span>&nbsp;</span></dt>
				<dd></dd>
			</dl>
		</td>
	</tr>
</table>
<s:form name="frm_nosubmit_mail_sel" method="post" cssClass="entry">
	<div class="" style="margin:10px 70px;font-size:12px;font-weight:bold;color:#900;">お持ちのウェブメールの認証情報を入力してください。</div>
	<div style="margin:20px 70px;font-size:10px;">
		現在連絡帳インポート機能が利用できるウェブメールは<span style="color:#F60">hotmail</span>、<span style="color:#F60">Gmail</span>と<span style="color:#F60">Yahooメール</span>のみです。<br/>
		メールアドレスのドメイン部分はブルダウンリストから選択することにし、アカウント欄には<br/>入力しないでください。<br/><br/>
		お客様のメール認証情報はゲームイフで保存したり、ログに出力したりすることが一切ございませんので、<br/>安心してご利用ください。
	</div>	
	<table>
		<tr><th></th><td><span class="logic_error"><s:fielderror><s:param>loginError</s:param></s:fielderror></span></td></tr>
		<tr>
			<th><span class="required">*</span> <label for="mail">メールアドレス：</label></th>
			<td>
				<table cellpadding="0" cellspacing="0">
					<tr valign="top">
						<td>
							<s:textfield name="mailAdd" maxlength="100" cssClass="ime_mode_n" cssStyle="width:150px;" title="アカウント" onblur="validate(this, 'REQ');"/> @&nbsp;
							<span id="error_mailAdd" class="input_error"><s:fielderror><s:param>mailAdd</s:param></s:fielderror></span>
						</td>
						<td>
							<s:select name="domain" list="paymentProperties.domainListMap" headerKey="" headerValue="" cssStyle="width:120px;" title="ドメイン" onblur="validate(this, 'REQ');" />
							<span id="error_domain" class="input_error"><s:fielderror><s:param>domain</s:param></s:fielderror></span>
						</td>
					</tr>				
				</table>
			</td>
		</tr>
		<tr>
			<th><span class="required">*</span> <label for="passwd">パスワード：</label></th>
			<td>
				<s:password name="memPwd" maxlength="100" cssClass="ime_mode_n" cssStyle="width:150px;" title="パスワード" onblur="validate(this, 'REQ');"/>
				<span id="error_memPwd" class="input_error"><s:fielderror><s:param>memPwd</s:param></s:fielderror></span>
			</td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
			<th></th>
			<td>
				<s:token/>
				<s:submit action="loginMailSelInvite" type="image" src="images/btn_c_invite_mail_import.png"/>
			</td>
		</tr>
	</table>
</s:form>

</body>

</html>