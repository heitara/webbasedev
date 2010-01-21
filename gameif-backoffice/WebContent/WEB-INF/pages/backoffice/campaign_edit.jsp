<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>問合せ返信テンプレート管理</title>
	<script src="js/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>テンプレート更新</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form name="frm_campaign_edit" action="updateCampaign" cssClass="entry">
			<s:hidden name="campaignId"></s:hidden>
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="campaignSubject">キャンペーン名：</label></th>
					<td>
						<s:textfield name="model.campaignSubject" cssStyle="width:400px;" maxlength="200" title="キャンペーン名" onblur="validate(this, 'REQ');"/>
						<span id="error_campaignSubject" class="input_error"><s:fielderror><s:param>campaignSubject</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><label for="campaignDate">キャンペーン期間：</label></th>
					<td>
						<s:textfield name="model.campaignStartDate" title="開始日期" size="10" onblur="validate(this, 'REQ');"/>
						<span class="explain">～</span>
						<s:textfield name="model.campaignEndDate" size="10" title="終了日期" onblur="validate(this, 'REQ');"/>
						<span id="error_campaignStartDate" class="input_error"><s:fielderror><s:param>campaignStartDate</s:param></s:fielderror></span>
						<span id="error_campaignEndDate" class="input_error"><s:fielderror><s:param>campaignEndDate</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="campaignContents">キャンペーン内容：</label></th>
					<td>
						<s:textarea name="model.campaignContents" rows="20" cssClass="big ime_mode_n" cssStyle="width:580px;" title="キャンペーン内容" onblur="validate(this, 'REQ');" />
						<span id="error_campaignContents" class="input_error"><s:fielderror><s:param>campaignContents</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
			</table>
			<div class="submit">
				<s:token />
				<s:submit value="更新"/>
				<a href="inputListCampaign.html" title="戻る">戻る</a>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>