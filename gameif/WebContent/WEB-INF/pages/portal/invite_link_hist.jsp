<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>友達招待履歴</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>友達招待履歴</strong><span><a href="inputInvite.html">► 友達招待</a></span></dt>
		<dd>
		<s:form name="frm_invite_hist" method="post" cssClass="entry">
			<div>
					このページでは、リンクで招待して、相手から招待に応じたお友達のニックネームとなります。<br/>
					<br/>
					━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
			</div>
			<table class="friendhist tspace_y" align="center">
				<s:iterator value="memLinkHistList" id="linkHist" status="st">
					<s:if test="#st.index % 4 == 0">
						<tr <s:if test="#st.odd">class="odd" </s:if> >
					</s:if>
						<td class="friend"><s:property value="nickName"/></td>
					<s:if test="#st.index % 4 == 3 || #st.last">
						</tr>
					</s:if>
				</s:iterator>
			</table>
			<br/>

			</s:form>
		</dd>
	</dl>
</body>
</html>