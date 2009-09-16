<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
	<head>	
		<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
		<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
		<title>友達紹介履歴 | ゲームイフ | ブラウザゲームのポータルサイト</title>
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
							<s:select name="inviteStatusSelect" list="portalProperties.inviteStatusList"  headerKey="9999" headerValue="全て" />
						</th>
						<th class="present_ymd">紹介日</th>
						<th class="entry_ymd">会員登録日</th>
					</tr>
					<s:iterator value="listInviteHist" id="inviteId" status="st">
						<tr <s:if test="#st.odd">class="odd"</s:if>>
							<td>
								<s:if test='inviteStatus.equals("0")'>
									<s:checkbox name="selSingle" value="false" fieldValue="1"></s:checkbox>
								</s:if>
								<s:else>
									<s:checkbox name="selSingle" value="false" fieldValue="1" disabled="true"></s:checkbox>
								</s:else>
							</td>
							<td class="friend"><s:property value="inviteMailTo"/></td>
							<td class="mail"><s:property value="inviteMailTo"/></td>
							<td>
								<s:if test='inviteStatus.equals("0")'>
									応答無し
								</s:if>
								<s:else>
									会員登録済
								</s:else>
							</td>
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