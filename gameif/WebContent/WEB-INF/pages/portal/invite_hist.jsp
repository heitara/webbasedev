<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>メール紹介履歴参照・報酬申請</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			var count = 0;
		    var checkboxs = document.getElementsByName("selectedInvites");
		    for(var i=0;i<checkboxs.length;i++){
		    	if (!checkboxs[i].disabled) {
			    	if (checkboxs[i].checked) {
				    	count++;
			    	}
		    	}
		    }
		    if (count < 1) {
			    alert("友達を選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>メール紹介履歴・報酬申請</strong><span><a href="inputLinkInvite.html">► 友達紹介（リンク）</a> <a href="showLinkInviteHist.html">► リンク紹介履歴・報酬申請</a> <a href="inputMailInvite.html">► 友達紹介（メール）</a> <a href="showMailInviteHist.html" style="color:#FFF;">► メール紹介履歴・報酬申請</a></span></dt>
		<dd>
		<s:form name="frm_invite_hist" method="post" cssClass="entry">
			<div>
					このページでは、ゲームイフへ友達を紹介したステータスを確認できます。<br/>
					相手から応答がない場合は、お知らせを送ってみましょう。<br/>
					友達紹介の成果報酬を申請するには「報酬申請」をボタンをクリックしてください。
			</div>
			<table class="friendhist tspace_y" align="center">
				<tr>
					<td colspan="6">
						<span class="logic_error" id="errMessage"></span><br/>
					</td>
				</tr>
				<tr id="listTitle">
					<th class="select">
						<s:checkbox name="selAll" id="selAll" value="false" fieldValue="1" onchange="checkAll(this,'selectedInvites');"/>
					</th>
					<th style="text-align:center;">友達</th>
					<th class="mail">メールアドレス</th>
					<th class="status">
						<s:select name="inviteStatusSelect" list="portalProperties.inviteStatusList" cssStyle="width:100px;" headerKey="9999" headerValue="全て" onclick="selectInvitedHist(this, 'inviteStatus_')"/>
					</th>
					<th class="present_ymd">紹介日</th>
					<th class="entry_ymd">会員登録日</th>
					<th class="status">承認ステータス</th>
				</tr>
				<s:iterator value="listInviteHist" id="inviteId" status="st">
					<tr id="inviteStatus_<s:property value='inviteStatus'/>" <s:if test="#st.odd">class="odd" </s:if> >
						<td class="select">
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
						<td class="status">
							<s:property value="portalProperties.inviteStatusList[inviteStatus]"/>
						</td>
						<td class="present_ymd"><s:property value="inviteDate"/></td>
						<td class="entry_ymd"><s:property value="friendCreateDate"/></td>
						<td class="status">
							<!-- 会員登録済の場合、承認ステータスを表示する -->
							<s:if test='"1".equals(inviteStatus)'>
								<s:if test='"1".equals(approveStatus)'>
									<input type="button" onclick="location='checkMailStatusInviteHist.html?inviteId=<s:property value="inviteId"/>';" value="報酬申請"/>
								</s:if>
								<s:else>
									<s:property value="portalProperties.approveStatus[approveStatus]"/>
								</s:else>
							</s:if>
						</td>
					</tr>
				</s:iterator>
			</table>
			<br/>
			<s:submit action="sendMailInviteHist" value="選択した友達に再送信する" cssClass="big" onclick="return checkCount();"></s:submit>
			<s:submit action="deleteInviteHist" value="選択した友達を削除する" cssClass="big" onclick="return checkCount();"></s:submit>

			</s:form>
		</dd>
	</dl>
</body>
</html>