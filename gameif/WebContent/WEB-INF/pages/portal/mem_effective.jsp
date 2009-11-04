<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.gameif.portal.util.ContextUtil"%>
<%@page import="edu.yale.its.tp.cas.client.filter.CASFilter"%>
<%@page import="com.gameif.portal.entity.MyTitle"%>
<%@page import="com.gameif.portal.businesslogic.ICbtTesterBusinessLogic"%>
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
				<!-- <span><s:property value="memNum"/></span><br/> -->
				<a href="mypage.html" title="ログイン"><img src="images/btn_s_login.gif" alt="ログイン"/></a>
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a><br/><br/>
				<%
					Long memNum = ContextUtil.getMemberNo((String)session.getAttribute(CASFilter.CAS_FILTER_USER));
					ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
					ICbtTesterBusinessLogic cbtLogic = (ICbtTesterBusinessLogic)ac.getBean("cbtTesterBusinessLogic");
					List<MyTitle> cbtTitles = cbtLogic.getCbtTitleList(memNum);
					if (!cbtTitles.isEmpty()) { %>
						<table class="games">
						<%	for (int i = 0; i < cbtTitles.size(); i++) {
							MyTitle title = cbtTitles.get(i);
							if (title.getCbtTester() == 0) {
							%> 
							<tr>
								<td class="sidecell"><a href="<%=title.getSiteUrl()%>" title="<%=title.getTitleName()%>"><img src="<%=title.getBigIconUrl()%>" alt="<%=title.getTitleName()%>" /></a></td>
								<td>
									<div class="g_menu">
										<a href="<%=title.getSiteUrl()%>" title="公式サイト">公式サイト</a><a href="<%=title.getForumUrl()%>" title="掲示板">掲示板</a>
									</div>
									<div class="g_title"><%=title.getTitleName()%></div>
									<div class="g_about" style="overflow:hidden;"><%=title.getTitleAbout()%></div>
									<div class="g_announce"><%=title.getAnnounce()%></div>
								</td>
								<td class="sidecell">
									<div>
										<a href="inputCBTTester.html" title="クローズドβテスター募集"><img src="images/btn_c_cbt.gif" title="クローズドβテスター募集" style="margin-bottom:2px;margin-right:2px;"/></a>
									</div>
								</td>
							</tr>
						<% }} %>
						</table>
				<% } %>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>