<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>友達招待</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>友達招待</strong><span><a href="showLinkInviteHist.html">► 友達招待履歴</a></span></dt>
			<dd>
				<s:form name="frm_nosubmit_invite_link" method="post" cssClass="entry">
					<table>
						<tr>
							<th></th>
							<td>
								<span class="explain">紹介するゲームを選択して、「リンク生成」をクリックすると、招待リンクを生成する。<br/>
													     生成したリンクを友達にメッセージで送信して、友達がそのリンクによって登録してか<br/>
													     ら、招待フローが完了です。とても簡単です。</span>
							</td>
						</tr>
						<tr class="space_row">
							<td colspan="2"></td>
						</tr>
						<tr>
							<th><label for="game">紹介するゲーム：</label></th>
							<td>
								<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName" title="紹介するゲーム" />
								<span class="explain">※紹介するゲームを選んでください。</span>
							</td>
						</tr>
					</table>
					<div class="submit">
						<s:submit value="リンク生成" action="createLinkInvite" cssClass="submit"></s:submit>
					</div>
					<table>
						<tr class="space_row">
							<td colspan="2"></td>
						</tr>
						<tr>
							<th><label for="link">招待リンク：</label></th>
							<td>
								<span><s:property value="link"/></span>
							</td>
						</tr>
					</table>
	
				</s:form>
			</dd>
		</dl>
	</body>
</html>