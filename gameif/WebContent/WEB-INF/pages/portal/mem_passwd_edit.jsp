<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<title>パスワード変更 | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>

<body>
<!-- パスワード変更：開始 -->
<dl class="light_box tspace_n">
	<dt>
		<strong>パスワード変更</strong>
		<span><a href="editMemberInfo.html">► 会員情報変更</a></span>
	</dt>
	<dd>
		<s:form action="updatePassword" method="post" cssClass="entry">
			<table>
				<tr>
					<th><span class="required">*</span> <label for="updatePassword_memPwd">旧いパスワード：</label></th>
					<td>
						<s:password name="memPwd" maxlength="20" cssClass="ime_mode_n" title="旧いパスワード" onblur="validate(this, 'REQ,ALN,LEN_6_20');"/>
						<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
						<span id="error_memPwd" class="input_error"><s:fielderror><s:param>memPwd</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span> <label for="updatePassword_newPwd">新しいパスワード：</label></th>
					<td>
						<s:password name="newPwd" maxlength="20" cssClass="ime_mode_n" title="新しいパスワード" onblur="validate(this, 'REQ,ALN,LEN_6_20');"/>
						<span class="explain">※ 6～20桁の半角英数字で入力してください。</span>
						<span id="error_newPwd" class="input_error"><s:fielderror><s:param>newPwd</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span> <label for="updatePassword_confirmPwd">パスワード再入力：</label></th>
					<td>
						<s:password name="confirmPwd" maxlength="20" cssClass="ime_mode_n" title="パスワード再入力" onblur="validate(this, 'REQ,ALN,LEN_6_20,EQU_newPwd');"/>
						<span class="explain">※ 確認のためパスワードを再入力してください。</span>
						<span id="error_confirmPwd" class="input_error"><s:fielderror><s:param>confirmPwd</s:param></s:fielderror></span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token/>
				<s:hidden name="model.versionNo"/>
				<s:submit value="更新" cssClass="submit"/>
				<s:reset value="クリア" cssClass="submit"/>
			</div>

		</s:form>
	</dd>
</dl>
<!-- パスワード変更：終了 -->

</body>
</html>