<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.gameif.portal.util.ContextUtil"%>
<%@page import="edu.yale.its.tp.cas.client.filter.CASFilter"%>
<%@page import="com.gameif.portal.entity.MyTitle"%>
<%@page import="com.gameif.portal.businesslogic.IBetaTesterBusinessLogic"%>
<html>
<head>
<title>アカウント有効化完了</title>
<style>
dl.finish dd div p {font-weight:bold; color:#833;}
dl.finish dd div a {color:#833; }
dl.finish dd div a:hover {color:#F90; text-decoration:underline;}
</style>
<meta http-equiv="refresh" content='8; url=loginStatusProxy.html?target=<s:property value="urlAfterLogin" escape="false"/>' />
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>アカウント有効化完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>アカウントの有効化が完了しました。</dt>
			<dd>
				<div>
				<p>ゲームプレイ、テスターに応募、ポイントチャージ等機能がご利用になるには、ポータルサイトにログインする必要があります。</p>
				
				8秒後、画面が自動的にログイン画面に遷移します。<br/>
				時間が8秒以上経ってもログイン画面が見えない場合は、下のログインボタンををクリックしてください。	
				</div>
				<a href='loginStatusProxy.html?target=<s:property value="urlAfterLogin" escape="false"/>' title="ログイン"><img src="images/btn_s_login.gif" alt="ログイン"/></a>
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a><br/><br/>
			<dd>
		</dl>
	</dd>
</dl>
<img src="https://is.accesstrade.net/cgi-bin/isatV2/legion/isatWeaselV2.cgi?result_id=13&verify=<s:property value="memNum"/>" width="1" height="1"/>
</body>
</html>