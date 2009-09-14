<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title>パスワード再発行 | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script charset="UTF-8" src="js/portal/common.js" language="JavaScript" type="text/javascript"></script>
</head>

<body>
	<div class="contents">
		<s:form name="frm_mem_forget_pwd">
			<table>
				<tr>
					<td><s:property value="%{getText('mail_address')}" /></td>
					<td><s:textfield name="mail_address"></s:textfield></td>
				</tr>
				<tr>
					<td><s:property value="%{getText('question')}" /></td>
					<td><s:textfield name="question"></s:textfield></td>
				</tr>
				<tr>
					<td><s:property value="%{getText('answer')}" /></td>
					<td><s:textfield name="answer"></s:textfield></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>

<s:include value="../common/footer.jsp"></s:include>

</html>