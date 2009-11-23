<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%> 
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>   
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.gameif.backoffice.constants.BackofficeConstants"%>
<%
	/* =======================================　頁内共通変数設定  =======================================*/

//ログイン状態
boolean isLogined = false;
//ユーザＩＤ
String userId = (String)session.getAttribute(BackofficeConstants.SessionKey.USER_ID);
//ニックネーム
String nickname = (String)session.getAttribute(BackofficeConstants.SessionKey.NICK_NAME);

/* =======================================　ログイン情報取得  =======================================*/
if (userId != null && userId.length() != 0) {
	isLogined = true;
}
/* =============================================================================================*/
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control", "no-store");
response.setDateHeader("Expires",0);
/* =============================================================================================*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<title><decorator:title default="新感覚の楽しみ方"/> | ゲームイフ | バックオフィス</title>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のバックオフィス" />
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<meta content="index, follow" name="robots"/>
	<link type="text/css" href="css/common.css" rel="stylesheet"></link>
	<link type="text/css" href="css/main.css" rel="stylesheet"></link>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
	<decorator:head />
</head>
<body>
<!-- ページトップ：開始 -->
<div>
	<div class="page_top">
		<div class="pt_left">
			<img src="images/logo.gif" title="ゲームイフ | バックオフィス"/>
			<span style="font-size:14px;color:#855;text-align:right;">----BackOffice</span>
		</div>
<%
		if (isLogined) {
%>
		<div class="pt_right">
			<a href="logoutProxy.html" title="ログアウト">ログアウト</a> 
			<div style="font-size:10px;color:#855;margin-top:10px;text-align:right;"><%=nickname%>さん、ようこそ！</div>
		</div>
<%
		}
%>
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
	<!-- ページメイン：終了 -->	
	<!-- ページ右パネル：開始 -->
	<div class="page_main_left">
		
<%
		if (isLogined) {
%>
		<!-- 初めての方へ：開始 -->
		<dl class="title_box tspace_b">
			<dd class="guide">
				<a href="#" title="会員管理">会員管理</a>
				<a href="inputInquriyList.html" title="問合せ管理">問合せ管理</a>
				<a href="#" title="友達紹介管理">友達紹介管理</a>
				<a href="#" title="キャンペーン管理">キャンペーン管理</a>
				<a href="#" title="サービスポイント管理">サービスポイント管理</a>
				<a href="#" title="売上げ集計">売上げ集計</a>
				<a href="inputListAuthority.html" title="権限管理">権限管理</a>
			</dd>
		</dl>
<%
		}
%>
	</div>
	<!-- ページメイン：開始 -->
	<div class="page_main_main">
		<decorator:body />  
	</div>
	<!-- ページ右パネル：終了 -->
	<div class="clearbox"></div>
</div>
<!-- ページメインエリア：終了 -->
<!-- ページフッター：開始 -->
<div class="page_bottom">
	<div class="pb_left">
			このウェブサイトは、Internet Explorer 7.0 或いは Firefox3.0 以上のブラウザでご利用いただくことを推奨しております。<br/>
			他のブラウザでは正常にご覧いただけない場合がございます。
	</div>
	<div class="pb_right">Copyright &copy; 2009 Game-IF Co.,Ltd. All Rights Reserved.</div>
</div>
<!-- ページフッター：終了 -->
</body>
</html>