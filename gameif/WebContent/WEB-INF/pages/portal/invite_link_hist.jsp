<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>友達紹介履歴 | リンクで紹介</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>友達紹介履歴（リンク）</strong><span><a href="inputLinkInvite.html">► 友達紹介（リンク）</a></span></dt>
		<dd>
			<div style="margin:30px 0px;line-height:20px;">
			こちらのページでは、あなたの紹介リンクをクリックして、会員登録を行ったユーザの一覧が表示されます。
			</div>
			<s:form name="frm_invite_hist" method="post" cssClass="entry">
				<table class="friendhist tspace_y" align="center">
					<tr id="listTitle">
						<th class="friend">ニックネーム</th>
						<th class="entry_ymd">登録日</th>
						<th class="mail">タイトル</th>
					</tr>
					<s:iterator value="inviteLinkHistList" id="linkHist" status="st">
						<tr <s:if test="#st.odd">class="odd" </s:if> >
							<td class="friend"><s:property value="nickName"/></td>
							<td class="entry_ymd"><s:property value="entryDate"/></td>
							<td class="mail"><s:property value="titleName"/></td>
						</tr>
					</s:iterator>
				</table>
				<br/>
			</s:form>
		</dd>
	</dl>
</body>
</html>