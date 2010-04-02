<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%> 
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>   
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.gameif.portal.businesslogic.ITitlePlayBusinessLogic"%>
<%@page import="com.gameif.portal.util.ContextUtil"%>
<%@page import="edu.yale.its.tp.cas.client.filter.CASFilter"%>
<%@page import="com.gameif.portal.entity.MyTitle"%>
<%@page import="com.gameif.portal.constants.PortalConstants"%>
<%@page import="com.gameif.portal.entity.MyServer"%>
<%@page import="com.gameif.portal.businesslogic.IBetaTesterBusinessLogic"%>
<%
	/* =======================================　頁内共通変数設定  =======================================*/

//ログイン状態
boolean isLogined = false;
//ログインエリア表示・非表示制御
boolean isNoLoginPage = false;
//会員番号
Long memNum = null;
//アカウントＩＤ
String accountId = null;
//ニックネーム
String nickname = null;

//ログインエリア表示しない頁
String noLoginPages = getServletContext().getInitParameter("noLoginPage");

//ポータルサイトベースＵＲＬ
String portalTopUrl = getServletContext().getInitParameter("portalTopUrl");
//コミュニティサイトＵＲＬ
String communityTopUrl = getServletContext().getInitParameter("communityTopUrl");
//ポータルニュースＵＲＬ
String portalNewsTopUrl = getServletContext().getInitParameter("portalNewsTopUrl");
//認証サーバＵＲＬ
String portalAuthTopUrl = getServletContext().getInitParameter("portalAuthTopUrl");

//ログインセッション情報
String sessionInfo = (String)session.getAttribute(CASFilter.CAS_FILTER_USER);

//SpringContext
ApplicationContext ctxt = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());

/* =======================================　ログイン情報取得  =======================================*/
if (sessionInfo != null) {
	
	isLogined = true;
	memNum = Long.valueOf(sessionInfo.split(",")[0]);
	accountId = sessionInfo.split(",")[1];
	nickname = com.gameif.common.util.ByteUtil.stringFromHexString(sessionInfo.split(",")[2]);	
}
/* =======================================　ログインエリア非表示判断  =================================*/
if (noLoginPages != null) {
	
	String[] pages = noLoginPages.split(",");
	
	for (int i = 0; i < pages.length; i++) {
		
		if (request.getRequestURI().indexOf(pages[i]) >= 0) {
	
	isNoLoginPage = true;
	break;
		}
	}
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
	<title><decorator:title default="遊びから生まれる可能性"/> | ゲームイフ | ブラウザゲームポータルサイト</title>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<meta content="index, follow" name="robots"/>
	<base href="<%=getServletContext().getInitParameter("portalTopUrl")%>/"/>
	<link type="text/css" href="css/common.css" rel="stylesheet"></link>
	<link type="text/css" href="css/main.css" rel="stylesheet"></link>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
	<script type="text/javascript">
	function selectServer(titleId) {
		var serverSel = document.getElementById("game_sel_" + titleId);
		serverSel.style.display = serverSel.style.display == "none" ? "block" : "none";
	}
	</script>
	<decorator:head />
</head>
<body>
<!-- ページトップ：開始 -->
<div>
	<div class="page_top">
		<div class="pt_left"><a href="<%=portalTopUrl%>" title="ゲームイフ | ブラウザゲームポータルサイト" ><img src="images/logo.gif" title="ゲームイフ | ブラウザゲームポータルサイト"/></a></div>
		<div class="pt_right">
<%
	if (isLogined) {
%>
				<a href="logoutProxy.html" title="ログアウト">ログアウト</a> | 
<%
					} else {
				%>
				<a href="mypage.html" title="ログイン">ログイン</a> |
				<a href="registryMember.html" title="会員登録">会員登録</a> |
<%
					}
				%>
			<a href="<%=isLogined ? "inputMemberInquiry.html" : "inputInquiry.html"%>" title="お問合せ">お問合せ</a> |
			<script language="javascript">doBookmarkLink()</script>
<%
	if (isLogined) {
%>
			<div style="font-size:10px;color:#855;margin-top:10px;text-align:right;"><%=nickname%>さん、ようこそ！</div>
<%
	}
%>
		</div>
		<div class="clearbox"></div>
	</div>
</div>
<!-- ページトップ：終了 -->
<!-- ページメニュー：開始 -->
<div class="page_top_menu">
	<a href="<%=portalTopUrl%>" title="トップページ">トップ</a>
	<a href="games.html" title="ゲーム">ゲーム</a>
	<a href="chargePointSelect.html" title="ポイントチャージ">ポイントチャージ</a>
	<!-- <a href="<%=communityTopUrl%>" title="コミュニティ">コミュニティ</a> -->
	<a href="<%=portalNewsTopUrl%>" title="お知らせ">お知らせ</a>
</div>
<!-- ページメニュー：終了 -->
<!-- ページメインエリア：開始 -->
<div class="page_main_box">
	<!-- ページメイン：開始 -->
	<div class="page_main_main">
		<decorator:body />  
	</div>
	<!-- ページメイン：終了 -->	
	<!-- ページ右パネル：開始 -->
	<div class="page_main_right">

	</div>
	<!-- ページ右パネル：終了 -->
	<div class="clearbox"></div>
</div>
<!-- ページメインエリア：終了 -->
<!-- ページフッター：開始 -->
<div class="page_bottom">
	<div class="pb_left">
		<a href="http://company.game-if.com" target="_blank" title="会社概要">会社概要</a> | 
		<a href="<%=portalNewsTopUrl%>/component/content/article/1-kiyaku" title="利用規約">利用規約</a> | 
		<a href="<%=portalNewsTopUrl%>/component/content/article/3-menseki" title="免責事項">免責事項</a> | 
		<a href="<%=portalNewsTopUrl%>/component/content/article/2-privarypolicy" title="プライバシーポリシー">プライバシーポリシー</a> | 
		<a href="<%=portalNewsTopUrl%>/component/content/article/4-shopinfo" title="特定商取引法に基づく表示内容">特定商取引法に基づく表示内容</a>
	</div>
	<div class="pb_right">Copyright &copy; 2009 Game-IF Co.,Ltd. All Rights Reserved.</div>
	<div class="pb_browser">
			このウェブサイトは、Internet Explorer 7.0 或いは Firefox3.0 以上のブラウザでご利用いただくことを推奨しております。<br/>
			他のブラウザでは正常にご覧いただけない場合がございます。
	</div>
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