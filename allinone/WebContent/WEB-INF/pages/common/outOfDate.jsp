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
				<div class="msg">期限切れデータへのアクセスを要求しているため、お客様から要求された処理が継続できませんでした。</div>
				<div class="rbox_side" style="margin-top:30px;"></div><div class="rbox_round"></div><div class="rbox_main">
					<div style="overflow:hidden;margin:10px;">
						<a href="games.html" title="ゲームプレイ"><img src="images/btn_s_play.gif" title="ゲームプレイ"/></a>
						<a href="chargePointSelect.html" title="ポイントチャージ"><img src="images/btn_s_point.gif" title="ポイントチャージ"/></a>
						<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
						<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
					</div>
				</div><div class="rbox_round"></div><div class="rbox_side"></div>
			</dd>
		</dl>
	</dd>
</dl>
<!-- 警告メッセージ：終了 -->
</body>
</html>