
<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%> 
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>   
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.gameif.portal.businesslogic.ITitlePlayBusinessLogic"%>
<%@page import="com.gameif.common.util.ContextUtil"%>
<%@page import="edu.yale.its.tp.cas.client.filter.CASFilter"%>
<%@page import="com.gameif.portal.entity.MyTitle"%>
<%@page import="com.gameif.portal.constants.PortalConstants"%>
<%@page import="com.gameif.portal.entity.MyServer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<meta content="index, follow" name="robots"/>
	<base href="<%=request.getScheme()%>://<%=request.getServerName()%><%if(request.getServerPort() != 80 && request.getServerPort() != 443) out.print(":" + request.getServerPort());%><%=request.getContextPath()%>/"/>
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
	<title><decorator:title default="ゲームイフ | ブラウザゲームポータルサイト"/></title>
	<decorator:head />
</head>
<body>
<!-- ページトップ：開始 -->
<div>
	<div class="page_top">
		<div class="pt_left"><a href="http://www.game-if.com"><img src="images/logo.gif" title="ブラウザゲームポータルサイト　ゲームイフ"/></a></div>
		<div class="pt_right">
			<%
			if (session.getAttribute(CASFilter.CAS_FILTER_USER) == null) {
			%>
			<a href="mypage.html" title="ログイン">ログイン</a> |
			<a href="registryMember.html" title="会員登録">会員登録</a> |
			<%
			}
			%>
			<a href="#" title="初心者ガイド">初心者ガイド</a> |
			<%
			if (session.getAttribute(CASFilter.CAS_FILTER_USER) == null) {
			%>
			<a href="inputInquiry.html" title="お問合せ">お問合せ</a> |
			<%
			} else {
			%>
			<a href="inputMemberInquiry.html" title="お問合せ">お問合せ</a> |
			<%
			}
			%>
			<a href="#" title="お気に入り">お気に入り</a>
		</div>
		<div class="clearbox"/>
	</div>
</div>
<!-- ページトップ：終了 -->
<!-- ページメニュー：開始 -->
<div class="page_top_menu">
	<a href="index.html" title="トップページ">トップ</a>
	<a href="games.html" title="ゲーム">ゲーム</a>
	<a href="point.html" title="ポイントチャージ">ポイントチャージ</a>
	<a href="#" title="コミュニティ">コミュニティ</a>
	<a href="#" title="お知らせ">お知らせ</a>
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
	<%
		if (session.getAttribute(CASFilter.CAS_FILTER_USER) == null) {
	%>
		<form id="myLoginForm" action="https://auth.test.game-if.com:8443/cas/remoteLogin" method="post" onsubmit="this.service.value='<%=request.getScheme()%>://<%=request.getServerName()%><%if(request.getServerPort() != 80 && request.getServerPort() != 443) out.print(":" + request.getServerPort());%><%=request.getContextPath()%>/loginStatusProxy.html?target=' + encodeURIComponent(location.href); return true;">
			<input type="hidden" id="service" name="service" value="<%=request.getScheme()%>://<%=request.getServerName()%><%if(request.getServerPort() != 80 && request.getServerPort() != 443) out.print(":" + request.getServerPort());%><%=request.getContextPath()%>/mypage.html"/>
			<input type="hidden" name="submit" value="true" />
			<table>
			    <tr>
			        <td>アカウントＩＤ：</td>
			        <td><input type="text" name="username"/></td>
			    </tr>
			    <tr>
			        <td>パスワード：</td>
			        <td><input type="password" name="password"/></td>
			    </tr>
			    <tr>
			        <td colspan="2"><input type="submit" value="ログイン" /></td>
			    </tr>
			</table>
		</form>
		<!-- ショットカットボタンエリア：開始 -->
		<dl class="quickstart tspace_n">
			<dt><a href="mypage.html" title="ログイン"><img src="images/btn_b_login.gif" alt="ログイン"/></a></dt>
			<dd></dd>
		</dl>
		<dl class="quickstart tspace_s">
			<dt><a href="registryMember.html" title="会員登録"><img src="images/btn_b_entry.gif" alt="会員登録"/></a></dt>
			<dd><a href="inputInvite.html" title="友達招待"><img src="images/btn_b_friend.gif" alt="友達招待"/></a></dd>
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
	<%
		} else {
	%>
	<a href="logoutProxy.html">ログアウト</a>
		<!-- ショットカットボタンエリア：開始 -->
		<dl class="quickstart tspace_n">
			<dt><a href="point.html" title="ポイントチャージ"><img src="images/btn_b_point.gif" alt="ポイントチャージ"/></a></dt>
			<dd><a href="inputInvite.html" title="友達招待"><img src="images/btn_b_friend.gif" alt="友達招待"/></a></dd>
		</dl>
		<dl class="quickstart tspace_s">
			<dt><a href="editMemberInfo.html" title="会員情報変更"><img src="images/btn_b_chinfo.gif" alt="会員情報変更"/></a></dt>
			<dd><a href="editPassword.html" title="パスワード変更"><img src="images/btn_b_chpass.gif" alt="パスワード変更"/></a></dd>
		</dl>

		<!-- ショットカットボタンエリア：終了 -->
			<%
			Long memNum = ContextUtil.getMemberNo((String)session.getAttribute(CASFilter.CAS_FILTER_USER));
			
			ApplicationContext ctxt = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
			ITitlePlayBusinessLogic mstLogic = (ITitlePlayBusinessLogic)ctxt.getBean("titlePlayBusinessLogic");
			
			List<MyTitle> titles = mstLogic.getPlayedTitles(memNum);
			
			if (!titles.isEmpty()) {%>
		<!-- マイゲーム：開始 -->
		<dl class="title_box tspace_b">
			<dt><strong>マイゲーム</strong><span></span></dt>
			<dd><%
				for (int i = 0; i < titles.size(); i++) {
					MyTitle title = titles.get(i);
					List<MyServer> servers = mstLogic.getPlayedServers(memNum, title.getTitleId());%>
				<dl class="mygame tspace_y">
					<dt><a class="mygame_icon" href="<%=title.getSiteUrl()%>" title="<%=title.getTitleName()%>"><img border="0px;" src="<%=title.getSmallIconUrl()%>" alt="<%=title.getTitleName()%>"/></a></dt>
					<dd>
						<div class="mygame_title"><%=title.getTitleName()%></div>
						<a href="javascript:selectServer(<%=title.getTitleId()%>);" title="プレイ">プレイ</a>
						<a href="<%=title.getSiteUrl()%>" title="公式">公式</a>
						<a href="<%=title.getForumUrl()%>" title="掲示板">掲示板</a>
					</dd>
				</dl>
				<div id="game_sel_<%=title.getTitleId()%>" class="mygame_select" style="display: none;">
					<fieldset>
						<legend>サーバ選択</legend>
					<%
					if (PortalConstants.ServerStatus.MAINTENANCE.equals(title.getServiceStatus())) {%>
						<ul><li style="color:#666;font-size:10px;">このタイトルは、はただいま<br/>メンテナンスしております。	</li></ul>
					<%
					} else {
					%>
						<ul><%
						for (int j = 0; j < servers.size(); j++) {
							MyServer server = servers.get(j);
							String serverNo = "00" + server.getServerId();
							serverNo = serverNo.substring(serverNo.length() - 2);
							
							if (PortalConstants.ServerStatus.MAINTENANCE.equals(server.getServiceStatus())) {%>
							<li title="このサーバはただいまメンテナンスしております。">S<%=serverNo%> <%=server.getServerName()%><span style="color:#900;font-size:10px;">（メンテ）</span></li>
							<%
							} else {
								
							%>
							<li><a href="playGame.html?serverId=<%=server.getServerId()%>&titleId=<%=server.getTitleId()%>" title="サーバ「<%=server.getServerName()%>」で「<%=title.getTitleName()%>」をプレイする。">S<%=serverNo%> <%=server.getServerName()%></a></li><%
							}
						}%>
						</ul>
						<%
					}%>
					</fieldset>
				</div><%
				}%>
			</dd>
		</dl>
		<!-- マイゲーム：終了 --><%
			}
		}%>
	</div>
	<!-- ページ右パネル：終了 -->
	<div class="clearbox"></div>
</div>
<!-- ページメインエリア：終了 -->
<!-- ページフッター：開始 -->
<div class="page_bottom">
	<div class="pb_left">
		<a href="http://www.game-if.com" title="会社概要">会社概要</a> | 
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