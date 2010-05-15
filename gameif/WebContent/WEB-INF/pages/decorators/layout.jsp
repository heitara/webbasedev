<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%> 
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>   
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.gameif.portal.businesslogic.ITitlePlayBusinessLogic"%>
<%@page import="com.gameif.portal.util.ContextUtil"%>
<%@page import="edu.yale.its.tp.cas.client.filter.CASFilter"%>
<%@page import="com.gameif.portal.entity.MyTitle"%>
<%@page import="com.gameif.portal.constants.PortalConstants"%>
<%@page import="com.gameif.portal.entity.MyServer"%>
<%@page import="com.gameif.portal.businesslogic.IBetaTesterBusinessLogic"%>
<%
	/* =======================================　頁内共通変数設定  =======================================*/

//ログイン状態
boolean isLogined = false;
//ログインエリア表示・非表示制御
boolean isNoLoginPage = false;
//会員番号
Long memNum = null;
//アカウントＩＤ
String accountId = null;
//ニックネーム
String nickname = null;

//ログインエリア表示しない頁
String noLoginPages = getServletContext().getInitParameter("noLoginPage");

//ポータルサイトベースＵＲＬ
String portalTopUrl = getServletContext().getInitParameter("portalTopUrl");
//コミュニティサイトＵＲＬ
String communityTopUrl = getServletContext().getInitParameter("communityTopUrl");
//ポータルニュースＵＲＬ
String portalNewsTopUrl = getServletContext().getInitParameter("portalNewsTopUrl");
//認証サーバＵＲＬ
String portalAuthTopUrl = getServletContext().getInitParameter("portalAuthTopUrl");

//ログインセッション情報
String sessionInfo = (String)session.getAttribute(CASFilter.CAS_FILTER_USER);

//SpringContext
ApplicationContext ctxt = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());

/* =======================================　ログイン情報取得  =======================================*/
if (sessionInfo != null) {
	
	isLogined = true;
	memNum = Long.valueOf(sessionInfo.split(",")[0]);
	accountId = sessionInfo.split(",")[1];
	nickname = com.gameif.common.util.ByteUtil.stringFromHexString(sessionInfo.split(",")[2]);	
}
/* =======================================　ログインエリア非表示判断  =================================*/
if (noLoginPages != null) {
	
	String[] pages = noLoginPages.split(",");
	
	for (int i = 0; i < pages.length; i++) {
		
		if (request.getRequestURI().indexOf(pages[i]) >= 0) {
	
	isNoLoginPage = true;
	break;
		}
	}
}
/* =============================================================================================*/
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control", "no-store");
response.setDateHeader("Expires",0);
/* =============================================================================================*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<title><decorator:title default="遊びから生まれる可能性"/> | ゲームイフ | ブラウザゲームポータルサイト</title>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<meta content="index, follow" name="robots"/>
	<base href="<%=getServletContext().getInitParameter("portalTopUrl")%>/"/>
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
	<decorator:head />
</head>
<body>
<!-- ページトップ：開始 -->
<div>
	<div class="page_top">
		<div class="pt_left"><a href="<%=portalTopUrl%>" title="ゲームイフ | ブラウザゲームポータルサイト" ><img src="images/logo.gif" title="ゲームイフ | ブラウザゲームポータルサイト"/></a></div>
		<div class="pt_right">
<%
	if (isLogined) {
%>
				<a href="logoutProxy.html" title="ログアウト">ログアウト</a> | 
<%
					} else {
				%>
				<a href="mypage.html" title="ログイン">ログイン</a> |
				<a href="registryMember.html" title="会員登録">会員登録</a> |
<%
					}
				%>
			<a href="<%=isLogined ? "inputMemberInquiry.html" : "inputInquiry.html"%>" title="お問合せ">お問合せ</a> |
			<script language="javascript">doBookmarkLink()</script>
<%
	if (isLogined) {
%>
			<div style="font-size:10px;color:#855;margin-top:10px;text-align:right;"><%=nickname%>さん、ようこそ！</div>
<%
	}
%>
		</div>
		<div class="clearbox"></div>
	</div>
</div>
<!-- ページトップ：終了 -->
<!-- ページメニュー：開始 -->
<div class="page_top_menu">
	<a href="<%=portalTopUrl%>" title="トップページ">トップ</a>
	<a href="games.html" title="ゲーム">ゲーム</a>
	<a href="chargePointSelect.html" title="ポイントチャージ">ポイントチャージ</a>
	<!-- <a href="<%=communityTopUrl%>" title="コミュニティ">コミュニティ</a> -->
	<a href="<%=portalNewsTopUrl%>" title="お知らせ">お知らせ</a>
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
	if (isLogined) {
%>
		<!-- ショットカットボタンエリア：開始 -->
		<dl class="quickstart tspace_n">
			<dt><a href="chargePointSelect.html" title="ポイントチャージ"><img src="images/btn_b_point.gif" alt="ポイントチャージ"/></a></dt>
			<dd><a href="inputInvite.html" title="友達紹介"><img src="images/btn_b_friend.gif" alt="友達紹介"/></a></dd>
		</dl>
		<dl class="quickstart tspace_s">
			<dt><a href="editMemberInfo.html" title="会員情報変更"><img src="images/btn_b_chinfo.gif" alt="会員情報変更"/></a></dt>
			<dd><a href="editPassword.html" title="パスワード変更"><img src="images/btn_b_chpass.gif" alt="パスワード変更"/></a></dd>
		</dl>
			
		<dl class="quickstart tspace_s" style="height:27px;">
			<dt><a href="inputListTicket.html" title="サービスチケット"><img src="images/btn_c_serviceticket.gif" alt="サービスチケット"/></a></dt>
			<dd><a href="inputChargeServicePoint.html" title="サービスポイント"><img src="images/btn_c_servicepoint.gif" alt="サービスポイント"/></a></dd>
		</dl>
<%
	} else {
	
		if (!isNoLoginPage) {
%>
			<form id="myLoginForm" action="<%=portalAuthTopUrl%>/remoteLogin" method="post" onsubmit="this.service.value='<%=portalTopUrl%>/loginStatusProxy.html?target=' + encodeURIComponent(location.href); return true;" style="padding:0px;margin:0px;">
				<div style="width:200px;height:155px;text-align:right;background:url('images/bg_login.gif');">
					<div style="height:133px;">
						<input type="text" name="username" class="ime_mode_n" style="width:100px;margin-right:20px;margin-top:25px;border:1px solid #EEE;border-top:1px solid #999;border-left:1px solid #999;height:18px;background:url('images/bg_login_id.gif');" onfocus="this.style.background='none';"/><br/>
						<input type="password" name="password" class="ime_mode_n" style="width:100px;margin-right:20px;margin-top:7px;border:1px solid #EEE;border-top:1px solid #999;border-left:1px solid #999;height:18px;background:url('images/bg_login_password.gif');" onfocus="this.style.background='none';"/><br/>
						<input type="image" src="images/btn_c_login_w.gif" value="ログイン" style="margin-right:20px;margin-top:7px;"/>
						<input type="hidden" id="service" name="service" value="<%=getServletContext().getInitParameter("portalTopUrl")%>/mypage.html"/>
						<input type="hidden" name="submit" value="true" />
					</div>
					<div class="height:22px;width:200px;">
						<a href="inputPwdReget.html" title="パスワードをわすれた方へ"><img src="images/btn_c_passwdremind.gif" title="パスワードをわすれた方へ" style="margin-bottom:2px;margin-right:2px;"/></a>
					</div>
				</div>
			</form>
			
			<br/>
			<div style="width:130;height:70px;background:url('images/bg_pnl_openid.gif');">
				<div style="padding:28px 2px 5px 2px;text-align:center;">
					<a href="<%=getServletContext().getInitParameter("portalAuthTopUrl")%>/openIDSelect?_eventId=submit&op=Yahoo" title="Yahoo! IDでログイン"><img src="images/btn_s_openid_yahoo.gif" alt="Yahoo! IDでログイン"/></a>
					<a href="<%=getServletContext().getInitParameter("portalAuthTopUrl")%>/openIDSelect?_eventId=submit&op=Mixi" title="Mixi IDでログイン"><img src="images/btn_s_openid_mixi.gif" alt="Mixi IDでログイン"/></a>
					<a href="<%=getServletContext().getInitParameter("portalAuthTopUrl")%>/openIDSelect?_eventId=submit&op=Google" title="Google IDでログイン"><img src="images/btn_s_openid_google.gif" alt="Google IDでログイン"/></a>
					<a href="<%=getServletContext().getInitParameter("portalAuthTopUrl")%>/openIDSelect?_eventId=submit&op=Excite" title="Excite IDでログイン"><img src="images/btn_s_openid_excite.gif" alt="Excite IDでログイン"/></a>
					<a href="<%=getServletContext().getInitParameter("portalAuthTopUrl")%>/openIDSelect?_eventId=submit&op=Biglobe" title="Biglobe IDでログイン"><img src="images/btn_s_openid_biglobe.gif" alt="Biglobe IDでログイン"/></a>
				</div>
			</div>
			
			<br/>
<%
		}
%>
		<!-- ショットカットボタンエリア：開始 -->
		<dl class="quickstart tspace_n">
			<dt><a href="registryMember.html" title="会員登録"><img src="images/btn_b_entry.gif" alt="会員登録"/></a></dt>
			<dd><a href="inputInvite.html" title="友達招待"><img src="images/btn_b_friend.gif" alt="友達招待"/></a></dd>
		</dl>
		<!-- ショットカットボタンエリア：終了 -->
<%
	}
%>
	<!-- <a href="http://www.webmoney.jp/campaign/2010gw/" target="_blank" style="margin-top:200px;"><img src="images/advert/wm_cp_0426_200x120.jpg"/></a> -->
<%

	/* =============================================== マイゲーム ===================================================== */
	
	List<MyTitle> myTitles = null;
	ITitlePlayBusinessLogic titlePlayLogic = null;
	
	if (isLogined) {

		titlePlayLogic = (ITitlePlayBusinessLogic)ctxt.getBean("titlePlayBusinessLogic");
		myTitles = titlePlayLogic.getPlayedTitles(memNum);
	}

	/* ============================================ βテストテスタ募集 ================================================== */

	IBetaTesterBusinessLogic betaTestLogic = (IBetaTesterBusinessLogic)ctxt.getBean("betaTesterBusinessLogic");
	List<MyTitle> betaTestTitles = betaTestLogic.getMyBetaTestTitleList(memNum);
	
	for (MyTitle title : betaTestTitles) {
		
		/* 0:何も表示しない
		 * 1:応募ボタン表示
		 * 2:当選済情報表示
		 * 3:応募済情報表示
		 * 4:応募済・未当選情報表示
		 */
		int status = 0;
		
		if (PortalConstants.RecruitStatus.RUNNING.equals(title.getRecruitStatus())) {

			//募集要らず誰でもプレイ可能、マイゲームプレイリストに追加
			if (isLogined) {
				myTitles.add(title);
			}
			continue;
			
		} else if (PortalConstants.RecruitStatus.RECRUITING.equals(title.getRecruitStatus())) {
			//募集中、テスト未開始
			if (title.getElectStatus() == null) {
				//応募ボタン表示
				status = 1;
			} else if (PortalConstants.ElectStatus.ELECTED.equals(title.getElectStatus())) {
				//当選済情報表示
				status = 2;
			} else {
				//応募済情報表示
				status = 3;
			}

		} else if (PortalConstants.RecruitStatus.TEST.equals(title.getRecruitStatus())) {
			//募集中、テスト実施中
			if (title.getElectStatus() == null) {
				//応募ボタン表示
				status = 1;
			} else if (PortalConstants.ElectStatus.ELECTED.equals(title.getElectStatus())) {
				//当選済、マイゲームプレイリストに追加
				myTitles.add(title);
				continue;
			} else {
				//応募済・未当選
				//何も表示しない
				continue;
			}
			
		} else if (PortalConstants.RecruitStatus.COMPLETE.equals(title.getRecruitStatus())) {
			//募集終了、テスト実施中
			if (title.getElectStatus() == null) {
				//未応募
				//何も表示しない
				continue;
			} else if (PortalConstants.ElectStatus.ELECTED.equals(title.getElectStatus())) {
				//当選済、マイゲームプレイリストに追加
				myTitles.add(title);
				continue;
			} else {
				//応募済・未当選
				//何も表示しない
				continue;
			}
		}
%>
		<dl class="title_box tspace_b">
			<dt><strong>テスター募集</strong><span>&nbsp;</span></dt>
			<dd>
				<dl class="mygame tspace_y">
					<dt><a class="mygame_icon" href="<%=title.getSiteUrl()%>" title="<%=title.getTitleName()%>"><img border="0px;" src="<%=title.getSmallIconUrl()%>" alt="<%=title.getTitleName()%>"/></a></dt>
					<dd>
						<div class="mygame_title"><%=title.getTitleName()%></div>
						<div>
<%
		switch (status) {
		case 1:
			//1:応募ボタン表示
			%>
			<a href="applyBetaTester.html?titleId=<%=title.getTitleId()%>&status=<%=title.getServiceStatus()%>" title="<%=PortalConstants.ServerStatus.CBT.equals(title.getServiceStatus()) ? "クローズβ" : "オープンβ" %>テスターに応募">
				<img src="images/btn_c_apply_<%=PortalConstants.ServerStatus.CBT.equals(title.getServiceStatus()) ? "cb" : "ob" %>tester.gif" alt="<%=PortalConstants.ServerStatus.CBT.equals(title.getServiceStatus()) ? "クローズβ" : "オープンβ" %>テスターに応募"/>
			</a>
			<%
			break;
		case 2:
			//2:当選済情報表示
			%>
			<%=PortalConstants.ServerStatus.CBT.equals(title.getServiceStatus()) ? "クローズβ" : "オープンβ" %>テスター（当選済）
			<%
			break;
		case 3:
			//3:応募済情報表示
			%>
			<%=PortalConstants.ServerStatus.CBT.equals(title.getServiceStatus()) ? "クローズβ" : "オープンβ" %>テスター（応募済）
			<%
			break;
		}
%>
						</div>
					</dd>
				</dl>
			</dd>
		</dl>
<%
	}
%>
	<!-- 
	<div style="margin-top:18px;">
		<a href="inputQuestionnaireAnswer.html?questionNo=1" title="アンケートに参加してサービスポイントをもらいましょう！"><img src="images/btn_cb_questionnaire.gif" alt="アンケートに参加してサービスポイントをもらいましょう！"/></a>
	</div>
	 -->
	
<%
	/* =============================================== マイゲーム ===================================================== */
		
	if (isLogined && !myTitles.isEmpty()) {
		
%>
		<dl class="title_box tspace_b">
			<dt><strong>マイゲーム</strong><span>&nbsp;</span></dt>
			<dd>
<%
		for (int i = 0; i < myTitles.size(); i++) {
			
			MyTitle title = myTitles.get(i);
			List<MyServer> servers = null;
			
			if (PortalConstants.ServerStatus.CBT.equals(title.getServiceStatus())
					|| PortalConstants.ServerStatus.OBT.equals(title.getServiceStatus())) {

				servers = titlePlayLogic.getServersWithPlayInfo(memNum, title.getTitleId());
				
			} else {

				servers = titlePlayLogic.getPlayedServers(memNum, title.getTitleId());
			}
%>
				<dl class="mygame tspace_y">
					<dt><a class="mygame_icon" href="<%=title.getSiteUrl()%>" title="<%=title.getTitleName()%>"><img border="0px;" src="<%=title.getSmallIconUrl()%>" alt="<%=title.getTitleName()%>"/></a></dt>
					<dd>
						<div class="mygame_title"><%=title.getTitleName()%></div>
						<a href="javascript:selectServer(<%=title.getTitleId()%>);" title="プレイ" class="btn">プレイ</a>
						<a href="<%=title.getSiteUrl()%>" title="公式" class="btn">公式</a>
						<a href="<%=title.getForumUrl()%>" title="掲示板" class="btn">掲示板</a>
					</dd>
				</dl>
				<div id="game_sel_<%=title.getTitleId()%>" class="mygame_select" style="display: none;">
					<fieldset>
						<legend>サーバ選択</legend>
<%
			if (PortalConstants.ServerStatus.MAINTENANCE.equals(title.getServiceStatus())) {
					
				/* ==== メンテナンス中 =============================================================　*/
%>
							<ul><li style="color:#666;font-size:10px;">メンテナンス中です。</li></ul>
<%
			} else {
				
				/* ==== 正式稼動或いはプレイ可能なβテスト中のタイトル ===================================　*/
%>
							<ul>
<%
				for (int j = 0; j < servers.size(); j++) {
					
					MyServer server = servers.get(j);
					
					if (PortalConstants.ServerStatus.MAINTENANCE.equals(server.getServiceStatus())) {
%>
								<li title="メンテナンス中です。"><%=server.getServerName()%><span style="color:#900;font-size:10px;">（メンテ）</span></li>
<%
					} else {
%>
								<li><a href="playGame.html?serverId=<%=server.getServerId()%>&titleId=<%=server.getTitleId()%>" title="サーバ「<%=server.getServerName()%>」でプレイ！"><%=server.getServerName()%></a></li><%
					}
				}
%>
							</ul>
<%			}
%>
					</fieldset>
				</div>
<%
		}
%>
			</dd>
		</dl>
		<!-- <a href="inputInvite.html" title="友達を紹介してサービスポイントを獲得しよう！"><img src="images/bn_b_friends.gif" alt="友達紹介"/></a> -->
<%
	}
%>
		<!-- サポート：開始 -->
		<dl class="title_box tspace_b">
			<dt><strong>サポート</strong><span>&nbsp;</span></dt>
			<dd class="guide">
				<a href="<%=portalNewsTopUrl%>/component/content/article/11-faq" title="よくある質問">よくある質問</a>
				<a href="<%=isLogined ? "inputMemberInquiry.html" : "inputInquiry.html"%>" title="お問合せ">お問合せ</a>
				<!-- 
				<a href="inputQuestionnaireAnswer.html?questionNo=1" title="アンケート">アンケート</a>
				<a href="inputWithDrawInfo.html" title="退会">退会</a>
				 -->
			</dd>
		</dl>
		<!-- サポート：終了 -->
	</div>
	<!-- ページ右パネル：終了 -->
	<div class="clearbox"></div>
</div>
<!-- ページメインエリア：終了 -->
<!-- ページフッター：開始 -->
<div class="page_bottom">
	<div class="pb_left">
		<a href="http://company.game-if.com" target="_blank" title="会社概要">会社概要</a> | 
		<a href="<%=portalNewsTopUrl%>/component/content/article/1-kiyaku" title="利用規約">利用規約</a> | 
		<a href="<%=portalNewsTopUrl%>/component/content/article/3-menseki" title="免責事項">免責事項</a> | 
		<a href="<%=portalNewsTopUrl%>/component/content/article/2-privarypolicy" title="プライバシーポリシー">プライバシーポリシー</a> | 
		<a href="<%=portalNewsTopUrl%>/component/content/article/4-shopinfo" title="特定商取引法に基づく表示内容">特定商取引法に基づく表示内容</a>
	</div>
	<div class="pb_right">Copyright &copy; 2009 Game-IF Co.,Ltd. All Rights Reserved.</div>
	<div class="pb_browser">
			このウェブサイトは、Internet Explorer 7.0 或いは Firefox3.0 以上のブラウザでご利用いただくことを推奨しております。<br/>
			他のブラウザでは正常にご覧いただけない場合がございます。
	</div>
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