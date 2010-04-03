<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<title><decorator:title default="遊びから生まれる可能性"/> | おたくま | おたく趣味でつながろう</title>
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<base href="<%=getServletContext().getInitParameter("portalTopUrl")%>/"/>
	<link type="text/css" href="css/joint/otakuma.css" rel="stylesheet"></link>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<decorator:head />
</head>
<body>
<!-- ページトップ：開始 -->
<div class="portal_bar">
	<div class="f_left"><span class="styletop"><a href="http://www.otakuma.net/" target="_blank"><img src="images/joint/otakuma/charge_logo.gif" alt="ソーシャルマッチングサービス おたくま"/></a></span></div>
	<div class="f_right"><span class="styletop"><a href="http://www.otakuma.net/index.php/home">マイページ</a> | <a href="http://www.otakuma.net/info.html" target="_blank">お知らせ</a> | <a href="http://www.otakuma.net/u_mailform/" target="_blank">お問い合わせ</a> | <a href="http://www.otakuma.net/help.html" target="_blank">ヘルプ</a> | <a href="http://www.otakuma.net/index.php/login/logout">ログアウト</a></span></div>
</div>
<!-- ページトップ：終了 -->
<!-- ページメインエリア：開始 -->
<div class="page_main_box">
	<div class="left_area">
		<div class="line_bar">ポイントチャージ<span class="charge_history"><a href="joint/chargeSettlementHist.html">▸ ポイントチャージ履歴</a></span></div>
		<decorator:body />
	</div>
	<div class="right_area">
		<a href="http://www.otakuma.net/index.php/login/chargeLegion"><img src="images/joint/otakuma/r_01.gif" border="0"/></a>　<a href="joint/chargeSettlementHist.html"><img src="images/joint/otakuma/r_02.gif" border="0"/></a><br />
		<br />
		<a href="http://www.otakuma.net/index.php/home/prof_edit?"><img src="images/joint/otakuma/r_03.gif" border="0"/></a>　<a href="http://www.otakuma.net/index.php/home/config?"><img src="images/joint/otakuma/r_04.gif" border="0"/></a><br />
		<br />
		<img src="images/joint/otakuma/r_apri_line.gif"/><br />
		<br />
		<a href="http://legion.otakuma.net/"><img src="images/joint/otakuma/title_legion.jpg" border="0" alt="レジオン -創世伝説"/></a><br />
		<br />
		<a href="http://www.otakuma.net/"><img src="images/joint/otakuma/title_otakuma.jpg" border="0" alt="ソーシャルマッチングサービス「おたくま」"/></a><br />
		<br />
		<br />
		<img src="images/joint/otakuma/r_support_line.gif"/><br />
		<br />
		<a href="http://www.otakuma.net/help.html"><img src="images/joint/otakuma/r_help.gif" border="0" alt="ヘルプ"/></a><br />
		<a href="http://www.otakuma.net/u_mailform/"><img src="images/joint/otakuma/r_support.gif" border="0" alt="お問い合わせ"/></a><br />
	</div>
	<div class="clearbox"></div>
</div>
<!-- ページメインエリア：終了 -->
<!-- ページフッター：開始 -->
<div class="page_bottom">
	<a href="http://www.otakuma.net/company.html" target="_blank">運営会社</a>　|
	<a href="http://www.otakuma.net/policy.html" target="_blank">プライバシーポリシー</a>　|
	<a href="http://www.otakuma.net/use.html" target="_blank">会員規約</a>　|
	<a href="http://www.otakuma.net/help.html" target="_blank">ヘルプ</a>　|
	<a href="http://www.otakuma.net/n_mailform/" target="_blank">プレスリリース</a>　|
	<a href="http://www.otakuma.net/c_mailform/" target="_blank">広告掲載</a>　|
	<a href="http://www.otakuma.net/u_mailform/" target="_blank">お問い合わせ</a>　|
	<a href="http://www.otakuma.net/release.html" target="_blank">メディア様掲載履歴</a>　|
	<a href="http://www.otakuma.net/sitemap.html" target="_blank">サイトマップ</a><br />
	<br/>
Copyright ©2010 Qiku, Inc./ C.S.T.ENTERTAINMENT Inc./ Game-if Co., Ltd. All Rights Reserved.
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