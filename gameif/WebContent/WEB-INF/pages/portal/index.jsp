<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.gameif.portal.helper.RSSNews"%>
<%@page import="com.gameif.portal.helper.RSSReader"%>
<html>
<head><title>トップページ</title>
<script language="javascript" type="text/javascript">

var imgs = new Array("bn_b_main_02.jpg", "bn_b_main_01.jpg", "bn_b_main_03.jpg");
var urls = new Array("inputInvite.html", "chargePointSelect.html", "http://info.game-if.com/home/event/189-2010-01-30-19-39-39");
/*
var imgs = new Array("bn_b_main_02.jpg", "bn_b_main_02.jpg", "bn_b_main_03.jpg");
var urls = new Array("inputInvite.html", "inputInvite.html.html", "http://info.game-if.com/home/event/189-2010-01-30-19-39-39");
*/
function changeBana() {

	if (window.chgIdx == null) {
		window.chgIdx = 0;
	}
	
	window.chgIdx = (window.chgIdx + 1) % imgs.length;
	document.getElementById("bana_img").src = "images/" + imgs[chgIdx];
	document.getElementById("bana_url").href = urls[chgIdx];
}

window.onload = function() { setInterval(changeBana, 5000); };
</script>
</head>
<body>
<!-- イラスト画像：開始 -->
<div id="illustration">
	<div class="rbox_side"></div><div class="rbox_round"></div><div class="rbox_main">
		<div style="overflow:hidden;">
			<!--画像-->
			<a id="bana_url" href="inputInvite.html"><img id="bana_img" src="images/bn_b_main_02.jpg"/></a>
		</div>
	</div><div class="rbox_round"></div><div class="rbox_side"></div>
</div>
<!-- イラスト画像：終了 -->
<!-- お知らせ一覧：開始 -->
<dl class="title_box tspace_b">
	<dt><strong>お知らせ</strong><span><a href="<%=getServletContext().getInitParameter("portalNewsTopUrl")%>" title="お知らせをもっと見る">MORE</a></span></dt>
	<dd class="news_list">
	<ul>
<%
		ApplicationContext ctxt = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		RSSReader rssReader = (RSSReader)ctxt.getBean("rssReader");
		List<RSSNews> rssNewsList = rssReader.getRssByCache();		
		for (RSSNews rssNews : rssNewsList) {%>
			<li><span><%=rssNews.getCreateDateStr()%></span><a href="<%=rssNews.getLink()%>"><%=rssNews.getTitle()%></a></li><%
		}%>
	</ul>
	</dd>
</dl>
<!-- お知らせ一覧：終了 -->
</body>
</html>