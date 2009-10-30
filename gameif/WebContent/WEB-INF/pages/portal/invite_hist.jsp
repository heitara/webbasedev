<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>友達紹介履歴</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>友達紹介履歴</strong><span><a href="inputInvite.html">► 友達紹介</a></span></dt>
		<dd>
		<s:form name="frm_invite_hist" method="post" cssClass="entry">
			<div>
					このページでは、ゲームイフへ友達を紹介したステータスを確認できます。<br/>
					相手から応答がない場合は、お知らせを送ってみましょう。
			</div>
			<table class="friendhist tspace_y" align="center">
				<tr id="listTitle">
					<th class="select">
						<s:checkbox name="selAll" id="selAll" value="false" fieldValue="1" onchange="checkAll(this,'selectedInvites');"/>
					</th>
					<th class="friend">友達</th>
					<th class="mail">メールアドレス</th>
					<th class="status">
						<s:select name="inviteStatusSelect" list="portalProperties.inviteStatusList"  headerKey="9999" headerValue="全て" onchange="selectInvitedHist(this, 'inviteStatus_')"/>
					</th>
					<th class="present_ymd">紹介日</th>
					<th class="entry_ymd">会員登録日</th>
				</tr>
				<s:iterator value="listInviteHist" id="inviteId" status="st">
					<tr id="inviteStatus_<s:property value='inviteStatus'/>" <s:if test="#st.odd">class="odd" </s:if> >
						<td>
							<s:hidden name="inviteId"></s:hidden>
							<s:if test='inviteStatus.equals("0")'>
								<s:checkbox name="selectedInvites" id="selectedInvites" value="false" fieldValue="%{inviteId}"></s:checkbox>
							</s:if>
							<s:else>
								<s:checkbox name="selectedInvites" id="selectedInvites" value="false" fieldValue="%{inviteId}" disabled="true"></s:checkbox>
							</s:else>
						</td>
						<td class="friend"><s:property value="friendName"/></td>
						<td class="mail"><s:property value="inviteMailTo"/></td>
						<td>
							<s:property value="portalProperties.inviteStatusList[inviteStatus]"/>
						</td>
						<td><s:property value="inviteDate"/></td>
						<td><s:property value="friendCreateDate"/></td>
					</tr>
				</s:iterator>
			</table>
			<br/>
			<s:submit action="sendMailInviteHist" value="選択した友達に再送信する" cssClass="big"></s:submit>
			<s:submit action="deleteInviteHist" value="選択した友達を削除する" cssClass="big"></s:submit>

			</s:form>
		</dd>
	</dl>
</body>
</html>