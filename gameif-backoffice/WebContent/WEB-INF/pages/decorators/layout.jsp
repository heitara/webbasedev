<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%> 
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>   
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="edu.yale.its.tp.cas.client.filter.CASFilter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<title><decorator:title default="新感覚の楽しみ方"/> | ゲームイフ | ブラウザゲームポータルサイト</title>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
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
		<div class="pt_right">
			<a href="#" title="初心者ガイド">初心者ガイド</a> |
			<div style="font-size:10px;color:#855;margin-top:10px;text-align:right;">さん、ようこそ！</div>
		</div>
		<div class="clearbox"/>
	</div>
</div>
<!-- ページメニュー：終了 -->
<!-- ページメインエリア：開始 -->
<div class="page_main_box">
	<!-- ページメイン：終了 -->	
	<!-- ページ右パネル：開始 -->
	<div class="page_main_right">
		
		<!-- 初めての方へ：開始 -->
		<dl class="title_box tspace_b">
			<dt><strong>初めての方へ</strong><span>&nbsp;</span></dt>
			<dd class="guide">
				<a href="#" title="会員登録方法">会員登録方法</a>
				<a href="#" title="ＧＩポイントについて">ＧＩポイントについて</a>
				<a href="#" title="ご利用上の注意">ご利用上の注意</a>
				<a href="#" title="ＦＡＱ">ＦＡＱ</a>
				<a href="#" title="お問合せ">お問合せ</a>
			</dd>
		</dl>
	</div>
	<!-- ページ右パネル：終了 -->
	<div class="clearbox"></div>
	<!-- ページメイン：開始 -->
	<div class="page_main_main">
		<decorator:body />  
	</div>
</div>
<!-- ページメインエリア：終了 -->
<!-- ページフッター：開始 -->
<div class="page_bottom">
	<div class="pb_left">
		<a href="http://company.game-if.com" title="会社概要">会社概要</a> | 
		<a href="agreement.html" title="利用規約">利用規約</a> | 
		<a href="immunity.html" title="免責事項">免責事項</a> | 
		<a href="privacy.html" title="プライバシーポリシー">プライバシーポリシー</a> | 
		<a href="shop_info.html" title="特定商取引法に基づく表示内容">特定商取引法に基づく表示内容</a>
	</div>
	<div class="pb_right">Copyright &copy; 2009 Game-IF Co.,Ltd. All Rights Reserved.</div>
	<div class="pb_browser">
			このウェブサイトは、Internet Explorer 7.0 或いは Firefox3.0 以上のブラウザでご利用いただくことを推奨しております。<br/>
			他のブラウザでは正常にご覧いただけない場合がございます。
	</div>
</div>
<!-- ページフッター：終了 -->
</body>
</html>