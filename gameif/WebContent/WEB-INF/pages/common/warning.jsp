<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<title>処理中断</title>
	<link rel="stylesheet" href="css/common/common.css" type="text/css" />
	<link rel="stylesheet" href="css/common/main.css" type="text/css" />
</head>
<body>
<!-- 警告メッセージ：開始 -->
<dl class="light_box tspace_n">
	<dt>
		<strong>処理中断</strong><span>&nbsp;</span>
	</dt>
	<dd>
		<dl class="warning">
			<dt>お客様から要求された処理が継続できませんでした。</dt>
			<dd>
				<div>原因としては下記のようなものが考えられます。</div>
				<ul>
					<li>存在しないデータへのアクセスを要求している。</li>
					<li>期限切れデータへのアクセスを要求している。</li>
					<li>サーバ側の処理が終わっていないうちに、繰り返して同じリクエストを重複送信している。</li>
					<li>複数人が同じデータを処理している。</li>
					<li>ハッキング目的でサイト攻撃している。</li>
				</ul>
				<div>正常に使っているにもかかわらず何度もこの画面が表示される場合は、サイト管理者にご連絡ください。</div>
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
				<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
			</dd>
		</dl>
	</dd>
</dl>
<!-- 警告メッセージ：終了 -->
</body>
</html>