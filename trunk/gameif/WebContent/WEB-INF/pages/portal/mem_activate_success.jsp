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
<meta http-equiv="refresh" content='5; url=loginStatusProxy.html?target=<s:property value="urlAfterLogin" escape="false"/>' />
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>アカウント有効化完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>アカウントの有効化が完了しました。</dt>
			<dd>
				<div class="msg">
				<p>ゲームプレイ、テスターに応募、ポイントチャージ等機能がご利用になるには、ポータルサイトにログインする必要があります。</p>				
				しばらくお待ちいただきますと、画面が自動的にログイン画面に遷移します。<br/>
				時間が経ってもログイン画面が見えない場合は、下のログインボタンををクリックしてください。	
				<br/><br/>
					<a href="loginStatusProxy.html?target=<s:property value="urlAfterLogin" escape="false"/>" title="ログイン"><img src="images/btn_c_portal_login.png" alt="ログイン"/></a>
				</div>
				<div class="rbox_side" style="margin-top:30px;"></div><div class="rbox_round"></div><div class="rbox_main">
					<div style="overflow:hidden;margin:10px;">
						<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
						<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
					</div>
				</div><div class="rbox_round"></div><div class="rbox_side"></div>
			<dd>
		</dl>
	</dd>
</dl>
<!-- Accesstradeアフィリエイトタグ -->
<img src="https://is.accesstrade.net/cgi-bin/isatV2/legion/isatWeaselV2.cgi?result_id=13&verify=<s:property value="memNum"/>" width="1" height="1"/>
<!-- MicroADアフィリエイトタグ -->
<script type="text/javascript">
<!--
	var mad_client_id='8421';
	var mad_group_id='convtrack';
//-->
</script>
<script src="https://send.microad.jp/js/conv0000.js">
</script>
<!-- JANetアフィリエイトタグ -->
<img src="https://action.j-a-net.jp///<s:property value="memNum"/>/23048" width="1" height="1"/>

<!-- A8Netアフィリエイトタグ -->
<img src="https://px.a8.net/cgi-bin/a8fly/sales?pid=s00000009650001&so=<s:property value="memNum"/>&si=1.1.1.a8" width="1" height="1" />

<!-- BEGIN: Google Code account registry Conversion Page -->
<script type="text/javascript">
<!--
var google_conversion_id = 1056413563;
var google_conversion_language = "ja";
var google_conversion_format = "1";
var google_conversion_color = "ffffff";
var google_conversion_label = "gdcNCI_XRRD7rt73Aw";
var google_conversion_value = 0;
if (200.0) {
  google_conversion_value = 200.0;
}
//-->
</script>
<script type="text/javascript" src="https://www.googleadservices.com/pagead/conversion.js">
</script>
<noscript>
<div style="display:inline;">
<img height="1" width="1" style="border-style:none;" alt="" src="https://www.googleadservices.com/pagead/conversion/1056413563/?value=200.0&amp;label=gdcNCI_XRRD7rt73Aw&amp;guid=ON&amp;script=0"/>
</div>
</noscript>
<!-- END: Google Code account registry Conversion Page -->
<!-- BEGIN: Yahoo account registry Conversion Page -->
<SCRIPT language="JavaScript" type="text/javascript">
<!-- Overture K.K.
window.ysm_customData = new Object();
window.ysm_customData.conversion = "transId=,currency=,amount=";
var ysm_accountid  = "16DANKUL2EQN50VOJRUJOGKM0LK";
document.write("<SCR" + "IPT language='JavaScript' type='text/javascript' " 
+ "SRC=//" + "srv2.wa.marketingsolutions.yahoo.com" + "/script/ScriptServlet" + "?aid=" + ysm_accountid 
+ "></SCR" + "IPT>");
// -->
</SCRIPT>
<!-- END: Yahoo account registry Conversion Page -->
</body>
</html>