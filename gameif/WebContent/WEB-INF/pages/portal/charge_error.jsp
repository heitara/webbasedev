<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>エラー | ポイントチャージ</title></head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>エラー</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>予期できないえらーが発生しました、管理者にご問い合わせてください。</dt>
			<dd>
				<div>引き続きお楽しみください。</div>
				<a href="games.html" title="ゲームプレイ"><img src="images/btn_s_play.gif" title="ゲームプレイ"/></a>
				<a href="chargePointSelect.html" title="ポイントチャージ"><img src="images/btn_s_point.gif" title="ポイントチャージ"/></a>
				<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>