<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<title><decorator:title default="遊びから生まれる可能性"/> | ゲームイフ | ブラウザゲームポータルサイト</title>
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<base href="<%=getServletContext().getInitParameter("portalTopUrl")%>/"/>
	<link type="text/css" href="css/joint/main.css" rel="stylesheet"></link>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<decorator:head />
</head>
<body>
<!-- ページトップ：開始 -->
<div>
	<div class="page_top">
		<div class="pt_left"><img src="images/joint/legion_logo.png" title="ゲームイフ | ブラウザゲームポータルサイト"/></div>
		<div class="pt_right"></div>
		<div class="clearbox"></div>
	</div>
</div>
<!-- ページトップ：終了 -->
<!-- ページメニュー：開始 -->
<div class="page_top_menu">
	
</div>
<!-- ページメニュー：終了 -->
<!-- ページメインエリア：開始 -->
<div class="page_main_box">
	<decorator:body />
</div>
<!-- ページメインエリア：終了 -->
<!-- ページフッター：開始 -->
<div class="page_bottom">
Copyright ©2009 Qiku, Inc./Game-if Co., Ltd. All Rights Reserved.
</div>
<!-- ページフッター：終了 -->
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-11566933-1");
pageTracker._setDomainName(".game-if.com");
pageTracker._trackPageview();
} catch(err) {}</script>
</body>
</html>