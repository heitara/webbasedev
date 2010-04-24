<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>エラー</title></head>
<body>
<dl class="light_box tspace_n">
	<dt>
		<strong>エラー</strong><span>&nbsp;</span>
	</dt>
	<dd>
		<dl class="warning">
			<dt>エラーが発生しました。</dt>
			<dd>
				<div class="msg">同じ現象が何度も繰り返す場合、サイト運営者に連絡してください。</div>
				<div class="rbox_side" style="margin-top:30px;"></div><div class="rbox_round"></div><div class="rbox_main">
					<div style="overflow:hidden;margin:10px;">
						<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
						<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
					</div>
				</div><div class="rbox_round"></div><div class="rbox_side"></div>
			</dd>
		</dl>
	</dd>
</dl>
</body>
</html>