<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>お問合せ情報</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>

<body>
	<dl class="light_box tspace_n">
		<dt><strong>一般のお問合せ</strong><span><a href="inputMediaInquiry.html">► メディア様のお問合せ</a> &nbsp; <a href="inputMemberInquiry.html">► 会員様のお問合せ</a></span></dt>
		<dd>
			<s:form name="frm_inquiry_input" method="post" cssClass="entry">
				<s:hidden name="inquiryType"></s:hidden>
				<s:hidden name="inquiryNum"></s:hidden>
				<table>
					<s:if test="model.inquiryType == 0">
						<tr class="space_row"><td colspan="2"></td></tr>
						<tr>
							<th><label for="user_name">アカウント：</label></th>
							<td>
								<s:property value="memId"/>
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
								<s:property value="model.inquiryKind"/>
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
					<tr>
						<th><span class="required">*</span><label for="mail">From表示名：</label></th>
						<td>
							<s:textfield name="fromSubject" maxlength="20" cssClass="ime_mode_y big"  title="From表示名" onblur="validate(this, 'REQ,ZEN');"/>
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_fromSubject" class="input_error"><s:fielderror><s:param>fromSubject</s:param></s:fielderror></span>
						</td>
					</tr>	
					<tr>
						<th><span class="required">*</span><label for="mail">Fromメール：</label></th>
						<td>
							<s:textfield name="fromMailadd" maxlength="100" cssClass="ime_mode_n big" title="Fromメール" onblur="validate(this, 'REQ,EML');"/>
							<span class="explain">※メールアドレスを小文字で入力してください。</span>
							<span id="error_fromMailadd" class="input_error"><s:fielderror><s:param>fromMailadd</s:param></s:fielderror></span>
						</td>
					</tr>
					 -->
					<tr>
						<th><span class="required">*</span><label for="object">回答件名：</label></th>	
						<td>
							<s:textfield name="responseSubject" maxlength="100" cssClass="big ime_mode_y" cssStyle="width:360px;" title="回答件名" onblur="validate(this, 'REQ,ZEN');" />
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_responseSubject" class="input_error"><s:fielderror><s:param>responseSubject</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="contents">回答内容：</label></th>
						<td>
							<s:textarea name="responseContents" rows="15" cssClass="big ime_mode_n" cssStyle="width:360px;" title="回答内容" onblur="validate(this, 'REQ,ZEN,LEN_10_1000');" />
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_responseContents" class="input_error"><s:fielderror><s:param>responseContents</s:param></s:fielderror></span>
						</td>
					</tr>
				</table>
				<div class="submit">
					<s:token />
					<s:submit value="返信" action="replyInquriy"/>
					<s:submit value="クリア" onclick="this.form.reset();return false;" />
					<s:submit value="戻る" />
				</div>

			</s:form>
		</dd>
	</dl>
</body>

</html>