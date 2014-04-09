<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.payment.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>リンク紹介履歴参照・報酬申請</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>リンク紹介履歴・報酬申請</strong><span><a href="inputLinkInvite.html">► 友達紹介（リンク）</a> <a href="showLinkInviteHist.html" style="color:#FFF;">► リンク紹介履歴・報酬申請</a> <a href="inputMailInvite.html">► 友達紹介（メール）</a> <a href="showMailInviteHist.html">► メール紹介履歴・報酬申請</a></span></dt>
		<dd>
			<div style="margin:30px 0px;line-height:20px;">
			こちらのページでは、紹介リンクから会員登録を行ったユーザの一覧が表示されます。<br/>
			友達紹介の成果報酬を申請するには「報酬申請」をボタンをクリックしてください。
			</div>
			<s:form name="frm_invite_hist" method="post" cssClass="entry">
				<table class="friendhist tspace_y" align="center">
					<tr id="listTitle">
						<th class="friend">ニックネーム</th>
						<th class="entry_ymd">登録日</th>
						<th class="mail">タイトル</th>
						<th class="status">承認ステータス</th>
					</tr>
					<s:iterator value="inviteLinkHistList" id="linkHist" status="st">
						<tr <s:if test="#st.odd">class="odd" </s:if> >
							<td class="friend"><s:property value="nickName"/></td>
							<td class="entry_ymd"><s:property value="entryDate"/></td>
							<td class="mail"><s:property value="titleName"/></td>
							<td class="status">
								<s:if test='"1".equals(approveStatus)'>
									<input type="button" onclick="location='checkLinkStatusInviteHist.html?memNum=<s:property value="memNum"/>&childMemNum=<s:property value="childMemNum"/>';" value="報酬申請"/>
								</s:if>
								<s:else>
									<s:property value="paymentProperties.approveStatus[approveStatus]"/>
								</s:else>
							</td>
						</tr>
					</s:iterator>
				</table>
				<br/>
			</s:form>
		</dd>
	</dl>
</body>
</html>