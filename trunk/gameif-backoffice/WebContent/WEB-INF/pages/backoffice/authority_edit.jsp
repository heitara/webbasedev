<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>権限管理</title>
	<script src="js/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>権限変更</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form action="updateAuthority" cssClass="entry">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createAuthority_authorityCode">権限コード：</label></th>
					<td>
						<s:textfield name="authority.authorityCode" maxlength="20" cssClass="ime_mode_n" disabled="false" />
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="createAuthority_authorityName">権限名：</label></th>
					<td>
						<s:textfield name="authority.authorityName" maxlength="25" title="権限名" onblur="validate(this, 'REQ,KOT,EXN');"/>
						<span class="explain">※ 記号とスペース以外の文字で入力してください。</span>
						<span id="error_authority.authorityName" class="input_error"><s:fielderror><s:param>authority.nickName</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><label for="createAuthority_mailPc">備考：</label></th>
					<td>
						<s:textarea name="authority.remarks" rows="10" cssClass="big ime_mode_n" cssStyle="width:360px;" title="備考" onblur="validate(this, 'LEN_0_200');" />
						<span id="error_authority.remarks" class="input_error"><s:fielderror><s:param>authority.remarks</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
				</tr>
				<tr>
					<td colspan="2">
				</tr>
				<tr>
					<td colspan="2">
						<table>
							<tr>
								<td><label>会員管理</label></td>
								<td>
									<s:radio name="member" list="backOfficeProperties.authorityLevels" title="会員管理" onblur="validate(this, 'REQ');"></s:radio>
								</td>
							</tr>
							<tr>
								<td><label>問合せ管理 </label></td>
								<td>
									<s:radio name="inquiry" list="backOfficeProperties.authorityLevels" title="問合せ管理 " onblur="validate(this, 'REQ');"></s:radio>
								</td>
							</tr>
							<tr>
								<td><label>友達紹介管理 </label></td>
								<td>
									<s:radio name="invite" list="backOfficeProperties.authorityLevels" title="友達紹介管理 " onblur="validate(this, 'REQ');"></s:radio>
								</td>
							</tr>
							<tr>
								<td><label>キャンペーン管理</label></td>
								<td>
									<s:radio name="campaign" list="backOfficeProperties.authorityLevels" title="キャンペーン管理" onblur="validate(this, 'REQ');"></s:radio>
								</td>
							</tr>
							<tr>
								<td><label>サービスポイント管理</label></td>
								<td>
									<s:radio name="servicePoint" list="backOfficeProperties.authorityLevels" title="サービスポイント管理" onblur="validate(this, 'REQ');"></s:radio>
								</td>
							</tr>
							<tr>
								<td><label>売上げ集計 </label></td>
								<td>
									<s:radio name="salesInfo" list="backOfficeProperties.authorityLevels" title="売上げ集計 " onblur="validate(this, 'REQ');"></s:radio>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token />
				<s:submit value="変更"/>
				<s:reset value="クリア"/>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>