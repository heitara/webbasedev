<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><s:property value="%{getText('mem_change_pwd_title')}" /></title>
	<link rel="stylesheet" type="text/css" media="screen" href="css/common/screen.css" />
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/mem_login.js" type="text/javascript"></script>
</head>

<body>
	<!-- ページメイン：開始 -->
	<div id="page_main_main">
		<!-- パスワード変更：開始 -->
		<dl class="light_box tspace_n">
			<dt><strong>パスワード変更</strong><span><a href="chinfo.html">► 会員情報変更</a></span></dt>
			<dd>
				<s:form name="frm_mem_change_pwd" method="POST" action="updatePwdMember">
					<dl>
						<dt><span class="required">*</span> <label for="passwd">旧いパスワード：</label></dt>
						<dd>
							<s:password name="memPwd" maxlength="20" cssClass="ime_mode_n"/>
							<img src="images/icn_check_ok.gif" class="input_check" align="top"/><br/>
							<span class="explain">6～20桁の半角英数字で入力してください。</span>
						</dd>
						<dt><span class="required">*</span> <label for="passwd_new">新しいパスワード：</label></dt>
						<dd>
							<s:password name="newPwd" maxlength="20" cssClass="ime_mode_n"/>
							<img src="images/icn_check_ok.gif" class="input_check" align="top"/><br/>
							<span class="explain">6～20桁の半角英数字で入力してください。</span>
						</dd>
						<dt><span class="required">*</span> <label for="passwd_crm">パスワード再入力：</label></dt>
						<dd>
							<s:password name="confirmPwd" maxlength="20" cssClass="ime_mode_n" />
							<img src="images/icn_check_ok.gif" class="input_check" align="top"/><br/>
							<span class="explain">確認のためパスワードを再入力してください。</span>
						</dd>

					</dl>
					<div class="submit">
						<s:submit action="changePwdMember" value="更新" formId="frm_mem_change_pwd" cssClass="submit"></s:submit>
						<s:reset value="クリア" cssClass="submit"></s:reset>
					</div>

				</s:form>
			</dd>
		</dl>
		<!-- パスワード変更：終了 -->
	</div>
	<!-- ページメイン：終了 -->
	
</body>


</html>
</s:i18n>