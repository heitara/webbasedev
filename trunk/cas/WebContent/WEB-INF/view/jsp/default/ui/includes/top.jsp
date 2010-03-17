<%@ page pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<meta content="index, follow" name="robots"/>
	<base href="https://<%=request.getServerName()%><%if(request.getServerPort() != 443 && request.getServerPort() != 80) out.print(":" + request.getServerPort());%><%=request.getContextPath()%>/"/>
	<link type="text/css" href="css/common.css" rel="stylesheet"></link>
	<link type="text/css" href="css/main.css" rel="stylesheet"></link>
	<script type="text/javascript" src="js/common_rosters.js"></script>
	<title>ゲームイフ | ブラウザゲームポータルサイト</title>
</head>
<body onload="init();">
<!-- ページトップ：開始 -->
<div>
	<div class="page_top">
		<div class="pt_left"><a href="<%=getServletContext().getInitParameter("portalTopUrl")%>"><img src="images/logo.gif" title="ブラウザゲームポータルサイト　ゲームイフ"/></a></div>
		<div class="pt_right">
			<a href="<%=getServletContext().getInitParameter("portalNewsTopUrl")%>/component/content/article/11-faq" title="よくある質問">よくある質問</a> |
			<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/inputInquiry.html" title="お問合せ">お問合せ</a>
		</div>
		<div class="clearbox"/>
	</div>
</div>
<!-- ページトップ：終了 -->
<!-- ページメニュー：開始 -->
<div class="page_top_menu">
	<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/" title="トップページ">トップ</a>
	<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/games.html" title="ゲーム">ゲーム</a>
	<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/chargePointSelect.html" title="ポイントチャージ">ポイントチャージ</a>
	<!-- <a href="<%=getServletContext().getInitParameter("comunityTopUrl")%>/" title="コミュニティ">コミュニティ</a> -->
	<a href="<%=getServletContext().getInitParameter("portalNewsTopUrl")%>/" title="お知らせ">お知らせ</a>
</div>
<!-- ページメニュー：終了 -->
<div class="page_main_box">