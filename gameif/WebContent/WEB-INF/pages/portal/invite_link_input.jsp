<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>友達紹介 | リンクで紹介</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>友達紹介（リンク）</strong><span><a href="showLinkInviteHist.html">► 友達紹介履歴（リンク）</a></span></dt>
			<dd>
				<div style="margin:30px 0px;line-height:20px;">
				紹介するゲームを選択して「紹介リンク表示」ボタンをクリックしますと、あなた専用の紹介用リンクが表示されます。<br/>
				そのリンクをコピーして、MSN、Skype、ブログ、個人サイト、掲示板等で友達に渡してください。<br/>
				</div>
				<s:form name="frm_nosubmit_invite_link" method="post" cssClass="entry">
					<table>
						<tr>
							<th><label for="game">紹介するゲーム：</label></th>
							<td>
								<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName" title="紹介するゲーム" />
								<span class="explain">※紹介するゲームを選んでください。</span>
							</td>
						</tr>
						<tr height="40">
							<th></th>
							<td>
								<s:submit type="image" src="images/btn_c_invite_link_view.png" action="createLinkInvite"></s:submit>
							</td>
						</tr>
						<tr height="30" valign="top">
							<th></th>
							<td>
								<s:property value="link"/>
							</td>
						</tr>
					</table>
				</s:form>
			</dd>
		</dl>
	</body>
</html>