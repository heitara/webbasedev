<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>OpenID有効化</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>OpenID有効化</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form action="createOpenID" cssClass="entry">
			<s:hidden name="inviteId"></s:hidden>
			<s:hidden name="advertNum"></s:hidden>
			<s:hidden name="linkKey"></s:hidden>
			<table>
				<tr>
					<th><span class="required">*</span><label for="createMember_nickName">ニックネーム：</label></th>
					<td>
						<s:textfield name="nickName" maxlength="20" title="ニックネーム" onblur="validate(this, 'REQ,KOT,NEQ_memId,EXN');"/>
						<span class="explain">※ 記号とスペース以外の文字で入力してください。</span>
						<span id="error_nickName" class="input_error"><s:fielderror><s:param>nickName</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createMember_mailPc">メールアドレス：</label></th>
					<td>
						<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ,EML,EXM');"/>
						<span class="explain">※ メールアドレスをで入力してください。（携帯用メールアドレス不可）</span>
						<span id="error_mailPc" class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><span class="required">*</span><label>利用規約：</label></th>
					<td>
						<span>登録する前に、必ず <a href="http://info.game-if.com/component/content/article/1-kiyaku" class="agreement" target="_blank">こちらをクリックして利用規約を確認</a> してください。</span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:hidden name="memId"/>
				<s:hidden name="openIdSign" />
				<s:token />
				<s:submit type="image" src="images/btn_c_registry.png"></s:submit>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>