<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>お問合せ情報</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script src="js/bindMaster.js" type="text/javascript"></script>
</head>

<body>
	<dl class="light_box tspace_n">
		<dt><strong>一般のお問合せ</strong></dt>
		<dd>
			<s:form name="frm_inquiry_input" method="post" cssClass="entry">
				<s:hidden name="inquiryType"></s:hidden>
				<s:hidden name="inquiryNum"></s:hidden>
				<s:hidden name="nickName"></s:hidden>
				<table>
					<s:if test="model.inquiryType == 0">
						<tr class="space_row"><td colspan="2"></td></tr>
						<tr>
							<th><label for="user_name">お名前：</label></th>
							<td>
								<s:property value="model.userName"/>
							</td>
						</tr>
						<tr>
							<th><label for="game">対象タイトル：</label></th>
							<td>
								<s:property value="titleName"/>
							</td>
						</tr>
						<tr>
							<th><label for="inquiry_kind">種類</label></th>
							<td>
								<s:property value="inquiryKindName"/>
							</td>
						</tr>
					</s:if>
					<s:elseif test="model.inquiryType == 1">
						<tr>
							<th><label for="company_name">御社名：</label></th>
							<td>
								<s:property value="model.companyName"/>
							</td>
						</tr>
						<tr>
							<th><label for="company_media_name">御社媒体名：</label></th>
							<td>
								<s:property value="model.companyMediaName"/>
							</td>
						</tr>
						<tr>
							<th><label for="company_user_name">担当者名：</label></th>
							<td>
								<s:property value="model.companyUserName"/>
							</td>
						</tr>
						<tr>
							<th><label for="tel_num">電話番号：</label></th>
							<td>
								<s:property value="model.telNum"/>
							</td>
						</tr>
					</s:elseif>
					<s:elseif test="model.inquiryType == 2">
						<tr>
							<th><label for="user_name">お名前：</label></th>
							<td>
								<s:property value="model.userName"/>
							</td>
						</tr>
						<tr>
							<th><label for="game">対象タイトル：</label></th>
							<td>
								<s:property value="titleName"/>
							</td>
						</tr>
					</s:elseif>
					<tr>
						<th><label for="mail">IPアドレス：</label></th>
						<td>
							<s:property value="model.inquiryIp"/>
						</td>
					</tr>
					<tr>
						<th><label for="mail">対応状態：</label></th>
						<td>
							<s:property value="backOfficeProperties.correspondStatus[model.correspondStatus]"/>
						</td>
					</tr>
					<tr>
						<th><label for="mail">メールアドレス：</label></th>
						<td>
							<s:property value="model.userMailadd"/>
						</td>
					</tr>
					<tr>
						<th><label for="object">お問合せ件名：</label></th>
						<td>
							<s:property value="model.inquiryObject"/>
						</td>
					</tr>
					<tr>
						<th><label for="contents">内容：</label></th>
						<td>
							<s:property value="model.inquiryContents"/>
						</td>
					</tr>
					<tr class="space_row"><td colspan="2"></td></tr>
					<!-- 
					<s:if test="model.correspondStatus == null || model.correspondStatus == 0 || model.correspondStatus == 2">
					 -->
						<tr>
							<th><span class="required">*</span><label for="object">回答件名：</label></th>	
							<td>
								<s:textfield name="model.responseSubject" maxlength="100" cssClass="big ime_mode_y" cssStyle="width:360px;" title="回答件名" onblur="validate(this, 'REQ');" />
								<span id="error_responseSubject" class="input_error"><s:fielderror><s:param>responseSubject</s:param></s:fielderror></span>
							</td>
						</tr>
						<tr>
							<th><label for="object">返信テンプレート：</label></th>	
							<td>
								<s:select name="inquirySendmailId" list="masterInfoBusinessLogic.allInquirySendmailTemplate" title="返信テンプレート" listKey="inquirySendmailId" listValue="inquirySendmailName" cssClass="big" headerKey="0" headerValue="" onchange="importContents(this, 'responseContents');"></s:select>
							</td>
						</tr>
						<tr>
							<th><span class="required">*</span><label for="contents">回答内容：</label></th>
							<td>
								<s:textarea id="responseContents" name="model.responseContents" rows="15" cssClass="big ime_mode_n" cssStyle="width:580px;" title="回答内容" onblur="validate(this, 'REQ,LEN_10_1000');" />
								<span id="error_responseContents" class="input_error"><s:fielderror><s:param>responseContents</s:param></s:fielderror></span>
							</td>
						</tr>
					<!-- 
					</s:if>
					<s:elseif test="model.correspondStatus == 1">
						<tr>
							<th><span class="required">*</span><label for="object">回答件名：</label></th>	
							<td>
								<s:textfield name="model.responseSubject" maxlength="100" cssClass="big ime_mode_y" cssStyle="width:360px;" title="回答件名" disabled="true" />
							</td>
						</tr>
						<tr>
							<th><label for="object">返信テンプレート：</label></th>	
							<td>
								<s:select name="inquirySendmailId" list="masterInfoBusinessLogic.allInquirySendmailTemplate" title="返信テンプレート" listKey="inquirySendmailId" listValue="inquirySendmailName" cssClass="big" headerKey="0" headerValue="" disabled="true"></s:select>
							</td>
						</tr>
						<tr>
							<th><span class="required">*</span><label for="contents">回答内容：</label></th>
							<td>
								<s:textarea name="model.responseContents" rows="15" cssClass="big ime_mode_n" cssStyle="width:580px;" title="回答内容" disabled="true" />
							</td>
						</tr>
					</s:elseif>
					 -->
				</table>
				<div class="submit">
					<s:token />
					<!-- 
					<s:if test="model.correspondStatus == null || model.correspondStatus == 0 || model.correspondStatus == 2">
					 -->
						<s:submit value="対応中に返信" action="reserveInquriy" />
						<s:submit value="対応済に返信" action="replyInquriy" />
						<s:submit value="クリア" onclick="this.form.reset();return false;" />
					<!-- 
					</s:if>
					<s:elseif test="model.correspondStatus == 1">
						<s:submit value="対応中に返信" disabled="true"/>
						<s:submit value="対応済に返信" disabled="true"/>
						<s:submit value="クリア" disabled="true"/>
					</s:elseif>
					 -->
					<a href="inputInquriyList.html" title="戻る">戻る</a>
				</div>

			</s:form>
		</dd>
	</dl>
</body>

</html>