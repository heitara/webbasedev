<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>トップページ</title>
<script language="javascript" type="text/javascript">
var imgs = new Array("bn_b_main_01.jpg", "bn_b_main_02.jpg");
var urls = new Array("http://legion.game-if.com", "inputInvite.html");

function changeBana() {

	if (window.chgIdx == null) {
		window.chgIdx = 0;
	}
	
	window.chgIdx = (window.chgIdx + 1) % imgs.length;
	document.getElementById("bana_img").src = "images/" + imgs[chgIdx];
	document.getElementById("bana_url").href = urls[chgIdx];
}

window.onload = function() { setInterval(changeBana, 4000); };
</script>
</head>
<body>
<!-- イラスト画像：開始 -->
<div id="illustration">
	<div class="rbox_side"></div><div class="rbox_round"></div><div class="rbox_main">
		<div style="overflow:hidden;">
			<!--画像-->
			<a id="bana_url" href="http://legion.game-if.com"><img id="bana_img" src="images/bn_b_main_01.jpg"/></a>
		</div>
	</div><div class="rbox_round"></div><div class="rbox_side"></div>
</div>
<!-- イラスト画像：終了 -->
<!-- お知らせ一覧：開始 -->
<dl class="title_box tspace_b">
	<dt><strong>お知らせ</strong><span><a href="<%=getServletContext().getInitParameter("portalNewsTopUrl")%>" title="お知らせをもっと見る">MORE</a></span></dt>
	<dd class="news_list">
		<ul>
			<li><span>2009/11/25</span><a href="http://info.game-if.com/home/maintenance/137-2009-11-25-03-15-28">「戦闘システムに接続できない」不具合解消のお知らせ</a></li>
			<li><span>2009/11/24</span><a href="http://info.game-if.com/home/notice/136-2009-11-24-15-22-59">「戦闘システムに接続できない」問題について</a></li>
			<li><span>2009/11/24</span><a href="http://info.game-if.com/home/maintenance/135-2009-11-24-11-39-03">「レジオン-創世伝説-」サーバ接続不具合復旧のお知らせ </a></li>
			<li><span>2009/11/24</span><a href="http://info.game-if.com/home/notice/134-2009-11-24-10-02-49">「サーバーに接続できません」問題について</a></li>
			<li><span>2009/11/24</span><a href="http://info.game-if.com/home/event/133-2009-11-23-19-26-41">「レジオン-創世伝説-」、クローズドβテストスタート！</a></li>
			<li><span>2009/11/17</span><a href="http://info.game-if.com/home/event/132-2009-11-16-19-59-17">「レジオン-創世伝説-」、クローズドβテスト募集開始！</a></li>
			<li><span>2009/11/17</span><a href="http://info.game-if.com/home/notice/131-2009-11-16-19-15-29">「創世伝説」、邦題「レジオン-創世伝説-」に決定、ロゴ公開！ </a></li>
			<li><span>2009/11/17</span><a href="http://info.game-if.com/component/content/article/1-kiyaku">【重要】会員サービス利用規約</a></li>
			<!-- <li><span>2009/11/17</span><a href="http://info.game-if.com/component/content/article/2-privarypolicy">【重要】プライバシーポリシー</a></li>
			<li><span>2009/11/17</span><a href="http://info.game-if.com/component/content/article/3-menseki">【重要】免責事項</a></li>
			<li><span>2009/11/17</span><a href="http://info.game-if.com/component/content/article/4-shopinfo">【重要】特定商取引法に基づく表示内容</a></li>
			<li><span>2009/09/04</span><a href="http://info.game-if.com/home/notice/101-2009-09-04-11-00-00">ブラウザゲーム「創世伝説」の国内独占提供契約締結</a></li> -->
		</ul>
	</dd>
</dl>
<!-- お知らせ一覧：終了 -->
</body>
</html>