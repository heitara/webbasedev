<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.gameif.payment.constants.PortalConstants"%>
<html>
<head><title><%=PortalConstants.ServerStatus.CBT.equals(request.getParameter("status")) ? "クローズβ" : "オープンβ" %>テスター応募完了</title></head>
<body>
<dl class="light_box tspace_n">
	<dt><strong><%=PortalConstants.ServerStatus.CBT.equals(request.getParameter("status")) ? "クローズβ" : "オープンβ" %>テスター応募完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>テスターにご応募いただきまして、どうもありがとうございます。</dt>
			<dd>
				<div class="msg">
					<p>当選された場合は、ご登録のメールアドレスにでご案内メールを送信致しますので、しばらくお待ちください。</p>
					下のボタンをクリックしていただきますと、テストプレイに一緒に参加するよう友達を誘うことができます。<br/>
					友達紹介で成果をあげた方には、サービスポイント或いはゲーム内アイテムのプレゼントもございますので、ぜひご利用ください。
					<br/><br/>
						<a href="inputInvite.html?titleId=<%=request.getParameter("titleId") == null ? "" : request.getParameter("titleId")%>" title="友達に紹介する"><img src="images/btn_c_invite.png" alt="友達に紹介する"/></a>
					</div>
				<div class="rbox_side" style="margin-top:30px;"></div><div class="rbox_round"></div><div class="rbox_main">
						<div style="overflow:hidden;margin:10px;">
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