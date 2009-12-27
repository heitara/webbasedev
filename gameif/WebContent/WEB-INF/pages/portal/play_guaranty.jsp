<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>プレー保証</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>プレー保証</strong></dt>
			<dd>
				<div style="margin:30px 0px;line-height:20px;">
				同一IPに対して、複数アカウントが存在するので、プレー規約を確認ください。<br/>
				一旦的に規約を違反したら、該当IPに対してユーザを全部凍結します。<br/>
				同意すれば、下記のボタンを押して、ゲームプレーを続きます。<br/>
				</div>
				<s:form name="frm_nosubmit_play_link" method="post" cssClass="entry">
					<table>
						<tr height="40">
							<th></th>
							<td>
								<s:hidden name="serverId"></s:hidden>
								<s:hidden name="titleId"></s:hidden>
								<s:hidden name="server"></s:hidden>
								<s:submit value="同意してゲームプレー" action="createPlayGuaranty"></s:submit>
							</td>
						</tr>
					</table>
				</s:form>
			</dd>
		</dl>
	</body>
</html>