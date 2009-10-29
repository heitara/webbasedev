<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.gameif.portal.util.ContextUtil"%><html>
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title><s:property value="actionTitle"/>完了 | ゲームイフ | ブラウザゲームポータル</title>
</head>

<body>
<dl class="light_box tspace_n">
	<dt><strong><s:property value="actionTitle"/>完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt><s:property value="actionTitle"/>が完了しました。</dt>
			<dd>
				<div>引き続きお楽しみください。</div>
				<!-- 未ログイン状態での諸完了画面で表示 -->
				<%
				if (ContextUtil.userIsLogin()) {
				%>
				<!-- ログイン状態での諸完了画面で表示 -->
				<a href="games.html" title="ゲームプレイ"><img src="images/btn_s_play.gif" title="ゲームプレイ"/></a>
				<a href="chargePointSelect.html" title="ポイントチャージ"><img src="images/btn_s_point.gif" title="ポイントチャージ"/></a>
				<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
				<%
				} else {
				%>
				<a href="mypage.html" title="ログイン"><img src="images/btn_s_login.gif" alt="ログイン"/></a>
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
				<%
				}
				%>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>