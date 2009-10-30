<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title>会員登録完了</title>
</head>

<body>
<dl class="light_box tspace_n">
	<dt><strong>会員登録完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>会員登録が完了しました。</dt>
			<dd>
				<div>会員様専用サービスをご利用になるには、ログインする必要がございます。</div>
				<s:property value="memNum"/>
				<a href="mypage.html" title="ログイン"><img src="images/btn_s_login.gif" alt="ログイン"/></a>
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>