<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>決済処理キャンセル | ポイントチャージ</title></head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>決済キャンセル</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>決済処理がキャンセルされました。</dt>
			<dd>
				<div class="msg">引き続きお楽しみください。</div>
				<div class="rbox_side" style="margin-top:30px;"></div><div class="rbox_round"></div><div class="rbox_main">
					<div style="overflow:hidden;margin:10px;">
						<a href="games.html" title="ゲームプレイ"><img src="images/btn_s_play.gif" title="ゲームプレイ"/></a>
						<a href="chargePointSelect.html" title="ポイントチャージ"><img src="images/btn_s_point.gif" title="ポイントチャージ"/></a>
						<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
						<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
					</div>
				</div><div class="rbox_round"></div><div class="rbox_side"></div>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>