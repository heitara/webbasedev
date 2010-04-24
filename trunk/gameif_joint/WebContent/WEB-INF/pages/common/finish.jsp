<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.gameif.portal.util.ContextUtil"%>
<html>
<head><title><s:property value="actionTitle"/>完了</title></head>
<body>
<dl class="light_box tspace_n">
	<dt><strong><s:property value="actionTitle"/>完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt><s:property value="actionTitle"/>が完了しました。</dt>
			<dd>
				<div class="msg">引き続きお楽しみください。</div>
				<div class="rbox_side" style="margin-top:30px;"></div><div class="rbox_round"></div><div class="rbox_main">
					<div style="overflow:hidden;margin:10px;">					
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
					</div>
				</div><div class="rbox_round"></div><div class="rbox_side"></div>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>