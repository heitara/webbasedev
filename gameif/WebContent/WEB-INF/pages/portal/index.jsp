<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta name="robots" content="index, follow" />
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<title>ゲームイフ | ブラウザゲームポータルサイト</title>
	<link rel="stylesheet" href="css/common/common.css" type="text/css" />
	<link rel="stylesheet" href="css/common/main.css" type="text/css" />
	<script type="text/javascript" language="JavaScript" src="js/common.js" charset="UTF-8"></script>
</head>
<body>
<!-- ページメインエリア：開始 -->
<div id="page_main_box">
	<!-- ページメイン：開始 -->
	<div id="page_main_main">
		<!-- イラスト画像：開始 -->
		<div id="illustration">
			<div class="rbox_side"></div><div class="rbox_round"></div><div class="rbox_main">
				<div>
					<!--画像-->
				</div>
			</div><div class="rbox_round"></div><div class="rbox_side"></div>
		</div>
		<!-- イラスト画像：終了 -->		
		<!-- お知らせ一覧：開始 -->

		<dl class="title_box tspace_b">
			<dt><strong>お知らせ</strong><span><a href="#" title="お知らせをもっと見る">MORE</a></span></dt>
			<dd class="news_list">
				<ul>
					<li><span>2009/08/26</span><a href="#">【重要】6月22日 MK-STYLE臨時メンテナンスのお知らせ</a></li>
				</ul>
			</dd>
		</dl>
		<!-- お知らせ一覧：終了 -->
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
			<dt>
				<s:url id="new" action="createCommon" includeParams="none"/> <s:a href="%{new}" title="{getText('new')}">
					<img src="images/btn_b_entry.gif" alt="<s:property value="%{getText('new')}" />"/>
				</s:a>
				</dt>
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

</body>
</html>
</s:i18n>