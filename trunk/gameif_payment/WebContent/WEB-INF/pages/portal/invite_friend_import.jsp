<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<s:form name="frm_friend_import" method="post" cssClass="address_sel">
<div class="" style="margin:10px 0px;font-size:12px;font-weight:bold;color:#900;">紹介したい友達のメールアドレスを選んでください。</div>
<div style="margin:20px 0px;font-size:10px;">
	一日に送信できる紹介メール数は最大5件ですので、5名以上は選択しないでください。<br/>
	紹介したい友達が5名を超える場合は、明日もう一度ご利用ください。
</div>
<!--<label><input type="checkbox" id="selAll" name="selAll" onclick="checkAll(this,'selectedFriends');"/> 全選択・解除</label> -->
<div class="select_mail" style="scrollbars:yes;">
	<table align="left" style="scrollbars:yes;">
		<s:iterator value="friendList" id="email" status="st">
			<tr <s:if test="#st.odd">class="odd"</s:if>>
				<td width="30">
					<s:checkbox name="selectedFriends" id="selectedFriends" value="flase" fieldValue="%{name} < %{email} >"></s:checkbox>
				</td>
				<td class="friend"><s:property value="name"/></td>
				<td class="mail"><s:property value="email"/></td>
			</tr>
		</s:iterator>
	</table>
</div>
<div class="submit">
	<a href="javascript:importFriends('selectedFriends');" title="紹介状に追加"><img src="images/btn_c_invite_mail_import_return.png" alt="紹介状に追加"/></a>
</div>
</s:form>

</body>


</html>