<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
	<html>

	<head>	
		<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
		<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
		<title>ゲームイフ | 友達紹介履歴</title>
		<script charset="UTF-8" src="js/portal/common.js" language="JavaScript" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>友達紹介履歴</strong><span><a href="inputInvite.html">► 友達紹介</a></span></dt>
			<dd>
				<dl class="friendhist tspace_b">
					<dt>
						このページでは、ゲームイフへ友達を紹介したステータスを確認できます。<br/>
						相手から応答がない場合は、お知らせを送ってみましょう。
					</dt>

					<dd></dd>
				</dl>
				<table class="friendhist tspace_y" align="center">
					<tr>
						<th class="select">
							<s:checkbox name="selAll" value="false" fieldValue="1"/>
						</th>
						<th class="friend">友達</th>
						<th class="mail">メールアドレス</th>
						<th class="status">
							<s:select name="questionCd" list="portalProperties.questionList" headerKey="00000" headerValue="" />
						</th>
						<th class="present_ymd">紹介日</th>
						<th class="entry_ymd">会員登録日</th>
					</tr>
					<s:iterator value="listInviteHist" id="inviteId" status="st">
						<tr <s:if test="#st.odd">class="odd"</s:if>>
							<td><s:checkbox name="selSingle" value="false" fieldValue="1"></s:checkbox></td>
							<td class="friend"><s:property value="inviteMailTo"/></td>
							<td class="mail"><s:property value="inviteMailTo"/></td>
							<td><s:property value="inviteMailTo"/></td>
							<td><s:property value="inviteDate"/></td>
							<td><s:property value="friendCreateDate"/></td>
						</tr>
					</s:iterator>
				</table>
				<br/>
				<s:submit action="sendMailInvite" value="選択した友達に再送信する" cssClass="big"></s:submit>
				<s:submit action="deleteInvite" value="選択した友達を削除する" cssClass="big"></s:submit>
			</dd>
		</dl>
	</body>


	</html>
</s:i18n>