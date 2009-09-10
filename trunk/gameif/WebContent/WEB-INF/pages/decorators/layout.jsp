<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>   
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>  
<%@taglib prefix="s" uri="/struts-tags"%> 
  
<html>   
<head>   
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<meta content="index, follow" name="robots"/>
	<base href="http://<%=request.getServerName()%><%if(request.getServerPort() != 80) out.print(":" + request.getServerPort());%><%=request.getContextPath()%>/"/>
	<link type="text/css" href="css/common/common.css" rel="stylesheet"></link>
	<link type="text/css" href="css/common/main.css" rel="stylesheet"></link>
	<title><decorator:title default="ゲームイフ | ブラウザゲームポータルサイト"/></title>
	<decorator:head />
</head>
    
<body>
<!-- ページトップ：開始 -->
<dl class="page_top">
	<dt><a href="http://www.game-if.com"><img src="images/logo.gif" title="WEBGAMEポータル ゲームイフ"/></a></dt>
	<dd>
		<a href="mypage.html" title="ログイン">ログイン</a> |
		<a href="entry.html" title="会員登録">会員登録</a> |
		<a href="#" title="初心者ガイド">初心者ガイド</a> |
		<a href="#" title="お問合せ">お問合せ</a> |
		<a href="#" title="お気に入り">お気に入り</a>
	</dd>
</dl>
<!-- ページトップ：終了 -->
<!-- ページメニュー：開始 -->
<dl class="page_top_menu">
	<dt><div>
		<a href="index.html" title="トップページ">トップ</a>
		<a href="games.html" title="ゲーム">ゲーム</a>
		<a href="point.html" title="ポイントチャージ">ポイントチャージ</a>
		<a href="#" title="コミュニティ">コミュニティ</a>
		<a href="#" title="お知らせ">お知らせ</a>
	</div></dt>
</dl>
<!-- ページメニュー：終了 -->
<!-- ページメインエリア：開始 -->
<div id="page_main_box">
	<!-- ページメイン：開始 -->
	<div id="page_main_main">
		<decorator:body />  
	</div>
	<!-- ページメイン：終了 -->	
	<!-- ページ右パネル：開始 -->
	<div id="page_main_right">	
		<!-- ショットカットボタンエリア：開始 -->
		<dl class="quickstart tspace_n">
			<dt><a href="mypage.html" title="ログイン"><img src="images/btn_b_login.gif" alt="ログイン"/></a></dt>
			<dd></dd>
		</dl>
		<dl class="quickstart tspace_s">
			<dt><a href="registryMember.html" title="会員登録"><img src="images/btn_b_entry.gif" alt="会員登録"/></a></dt>
			<dd><a href="friend.html" title="友達招待"><img src="images/btn_b_friend.gif" alt="友達招待"/></a></dd>
		</dl>
		<!-- ショットカットボタンエリア：終了 -->
		
		<!-- 初めての方へ：開始 -->
		<dl class="title_box tspace_b">
			<dt><strong>初めての方へ</strong><span></span></dt>
			<dd class="guide">
				<a href="#" title="会員登録方法">会員登録方法</a>
				<a href="#" title="ＧＩポイントについて">ＧＩポイントについて</a>
				<a href="#" title="ご利用上の注意">ご利用上の注意</a>
				<a href="#" title="ＦＡＱ">ＦＡＱ</a>
				<a href="#" title="お問合せ">お問合せ</a>
			</dd>
		</dl>
		<!-- 初めての方へ：終了 -->
	</div>
	<!-- ページ右パネル：終了 -->
	<div class="clearbox"></div>
</div>
<!-- ページメインエリア：終了 -->
<!-- ページフッター：開始 -->
<dl class="page_bottom">
	<dt>
		<a href="http://www.game-if.com" title="会社概要">会社概要</a> | 
		<a href="agreement.html" title="利用規約">利用規約</a> | 
		<a href="immunity.html" title="免責事項">免責事項</a> | 
		<a href="privacy.html" title="プライバシーポリシー">プライバシーポリシー</a> | 
		<a href="shop_info.html" title="特定商取引法に基づく表示内容">特定商取引法に基づく表示内容</a>
		<div>
			このウェブサイトは、Internet Explorer 7.0 或いは Firefox3.0 以上のブラウザでご利用いただくことを推奨しております。<br/>
			他のブラウザでは正常にご覧いただけない場合がございます。
		</div>
	</dt>
	<dd>Copyright &copy; 2009 Game-IF Co.,Ltd. All Rights Reserved.</dd>
</dl>
<!-- ページフッター：終了 -->
</body>
</html>