<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>友達招待</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>友達招待</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form name="frm_nosubmit_invite_guide" method="post" cssClass="entry">
			<table>
				<tr>
					<td colspan="2"><span class="explain">いつも『ゲームイフ』ご利用いただき、誠にありがとうございます。</span></td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<td colspan="2"><span class="explain">「友達招待」は、すでに本作を遊んでいるユーザーが、本作をプレイしたことのない人を招待するというもの。<br/>招待したユーザーには、招待された人のキャラクタが一定レベルに達すれば、或は、紹介した友達の人数が<br/>一定数量を超えれば、アイテムやサービスポイントなどの特典がプレゼントされる。</span></td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<td colspan="2"><span class="explain">招待方法について：</span></td>
				</tr>
				<tr>
					<th><label >Step1：</label></th>
					<td>
						<span class="explain">「メールで友達を招待する」、或は、「リンクで友達を招待する」をクリックしてお友達に招待メールを送信する。</span>
					</td>
				</tr>
				<tr>
					<th><label >Step2：</label></th>
					<td>
						<span class="explain">紹介したお友達が招待メール或は招待リンクから新規会員登録をする。</span>
					</td>
				</tr>
				<tr>
					<th><label >Step3：</label></th>
					<td>
						<span class="explain">紹介したお友達がキャラクタが一定レベルに到達する、或は、人数が一定数量を超える。</span>
					</td>
				</tr>
				<tr>
					<th><label >Step4：</label></th>
					<td>
						<span class="explain">あなたにプレゼントを贈与する。</span>
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<td colspan="2"><span class="explain">友達を招待する場合は、下記の招待方法を選択して、専用フォームから招待メールを送信する。</span></td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
			</table>
			<div class="submit">
				<a href="inputMailInvite.html">メールで友達を招待する</a>
				<a href="inputLinkInvite.html">リンクで友達を招待する</a>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>