<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>問合せ返信テンプレート管理</title>
	<script src="js/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>新規追加</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form name="frm_template_add" action="createInquiryTemplate" cssClass="entry">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="inquirySendmailName">テンプレート名：</label></th>
					<td>
						<s:textfield name="inquirySendmailName" cssStyle="width:400px;" maxlength="25" title="テンプレート名" onblur="validate(this, 'REQ');"/>
						<span id="error_inquirySendmailName" class="input_error"><s:fielderror><s:param>inquirySendmailName</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="inquirySendmailContents">返信内容：</label></th>
					<td>
						<s:textarea name="inquirySendmailContents" rows="10" cssClass="big ime_mode_n" cssStyle="width:580px;" title="返信内容" onblur="validate(this, 'REQ,LEN_0_1000');" />
						<span id="error_inquirySendmailContents" class="input_error"><s:fielderror><s:param>inquirySendmailContents</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
			</table>
			<div class="submit">
				<s:token />
				<s:submit value="登録"/>
				<a href="inputListInquiryTemplate.html" title="戻る">戻る</a>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>