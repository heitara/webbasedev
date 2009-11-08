<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.gameif.portal.constants.PortalConstants"%>
<html>
<head><title><%=PortalConstants.ServerStatus.CBT.equals(request.getParameter("status")) ? "クローズβ" : "オープンβ" %>テスター応募完了</title></head>
<body>
<dl class="light_box tspace_n">
	<dt><strong><%=PortalConstants.ServerStatus.CBT.equals(request.getParameter("status")) ? "クローズβ" : "オープンβ" %>テスター応募完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>テスターにご応募いただきまして、どうもありがとうございます。</dt>
			<dd>
				<div>当選された場合メールでご案内致しますので、しばらくお待ちください。</div>
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
				<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>