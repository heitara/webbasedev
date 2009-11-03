<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.gameif.portal.businesslogic.IMasterInfoBusinessLogic"%>
<%@page import="com.gameif.portal.entity.TitleMst"%>
<html>
<head><title>会員有効化完了</title></head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>会員有効化完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>会員情報の有効化が完了しました。</dt>
			<dd>
				<div>会員様専用サービスをご利用になるには、ログインする必要がございます。</div>
				<!--<span></span><s:property value="memNum"/></span>-->
				<a href="mypage.html" title="ログイン"><img src="images/btn_s_login.gif" alt="ログイン"/></a>
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
				<%
					ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
					IMasterInfoBusinessLogic masterLogic = (IMasterInfoBusinessLogic)ac.getBean("masterInfoBusinessLogic");
					List<TitleMst> cbtTitles = masterLogic.getCbtTitleList();
					if (!cbtTitles.isEmpty()) {%> 
						<a href="inputCBTTester.html" title="クローズドβテスター募集"><img src="images/btn_c_cbt.gif" title="クローズドβテスター募集" style="margin-bottom:2px;margin-right:2px;"/></a>
				<% } %>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>