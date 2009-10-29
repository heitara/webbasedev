<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<meta content="index, follow" name="robots"/>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<base href="<%=request.getScheme()%>://<%=request.getServerName()%><%if(request.getServerPort() != 80 && request.getServerPort() != 443) out.print(":" + request.getServerPort());%><%=request.getContextPath()%>/"/>
	<link type="text/css" href="css/common.css" rel="stylesheet"></link>
	<link type="text/css" href="css/main.css" rel="stylesheet"></link>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<title>メールアドレスインポート | 友達紹介</title>
</head>

<body>
<s:form name="frm_friend_import" method="post" cssClass="address_sel">
<dl class="pop_top">
	<dt><a href="http://www.game-if.com"><img src="images/logo.gif" title="WEBGAMEポータル ゲームイフ" border="0"/></a></dt>
	<dd>
		<dl class="title_width tspace_n top_align">
			<dt><strong>友達メールアドレスインポート</strong><span>&nbsp;</span></dt>
			<dd></dd>
		</dl>
	</dd>

</dl>
	<div class="" style="margin:10px 70px;font-size:12px;font-weight:bold;">友達にゲームイフを紹介しよう！</div>
	<div style="color:#900;margin:20px 70px;font-size:10px;">
		紹介したい人を以下のリストから選択してください。
	</div>
	
	<label><input type="checkbox" id="selAll" name="selAll" onclick="checkAll(this,'selectedFriends');"/> 全選択・解除</label>
	<div class="select_mail" style="scrollbars:yes;">
		<table align="center" style="scrollbars:yes;">
			<s:iterator value="friendList" id="email" status="st">
				<tr <s:if test="#st.odd">class="odd"</s:if>>
					<td>
						<s:checkbox name="selectedFriends" id="selectedFriends" value="flase" fieldValue="%{name} < %{email} >"></s:checkbox>
					</td>
					<td class="friend"><s:property value="name"/></td>
					<td class="mail"><s:property value="email"/></td>
				</tr>
			</s:iterator>
		</table>
	</div>

	<div class="submit">
		<input type="button" value="紹介状に追加" class="submit" onclick="importFriends('selectedFriends');"/>
		<input type="button" value="キャンセル" class="submit" onclick="window.close();"/>
	</div>

</s:form>

</body>


</html>