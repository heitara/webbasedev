<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>お問合せ</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function RefreshImg(){
			$("#kaptchaPic").attr({src: "images/kaptcha?" + new Date().getSeconds()});
		}
	</script>
</head>

<body>
	<dl class="light_box tspace_n">
		<dt><strong>一般のお問合せ</strong><span><a href="inputMediaInquiry.html">► メディア様のお問合せ</a> &nbsp; <a href="inputMemberInquiry.html">► 会員様のお問合せ</a></span></dt>
		<dd>
			<s:form name="frm_inquiry_input" method="post" cssClass="entry">
				<table>
					<tr>
						<th><span class="required">*</span><label for="user_name">お名前：</label></th>
						<td>
							<s:textfield name="userName" maxlength="20" cssClass="ime_mode_y big"  title="お名前" onblur="validate(this, 'REQ,ZEN');"/>
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_userName" class="input_error"><s:fielderror><s:param>userName</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="mail">メールアドレス：</label></th>
						<td>
							<s:textfield name="userMailadd" maxlength="100" cssClass="ime_mode_n big" title="メールアドレス" onblur="validate(this, 'REQ,EML');"/>
							<span class="explain">※ メールアドレスを小文字で入力してください。</span>
							<span id="error_userMailadd" class="input_error"><s:fielderror><s:param>userMailadd</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="game">対象タイトル：</label></th>
						<td>
							<s:select name="titleId" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName" cssClass="big" headerKey="0" headerValue="ポータルサイト" title="対象タイトル" />
							<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="object">お問合せ件名：</label></th>
						<td>
							<s:textfield name="inquiryObject" maxlength="100"  title="お問合せ件名" cssClass="ime_mode_y" cssStyle="width:360px;" onblur="validate(this, 'REQ,ZEN');" />
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_inquiryObject" class="input_error"><s:fielderror><s:param>inquiryObject</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="contents">内容：</label></th>
						<td>
							<s:textarea name="inquiryContents" rows="15" cssClass="ime_mode_y big" cssStyle="width:360px;" title="内容" onblur="validate(this, 'REQ,ZEN,LEN_10_1000');" />
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_inquiryContents" class="input_error"><s:fielderror><s:param>inquiryContents</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="createMember_kaptcha">画像認証：</label></th>
						<td>
							<img id="kaptchaPic" src="images/kaptcha"/>
							<a href="javascript:RefreshImg();"><img id="newKaptcha" src="images/capture_update.gif"/></a><br/>
							<s:textfield name="kaptcha" maxlength="20"  cssClass="ime_mode_n" title="画像認証" onblur="validate(this,'REQ,ALN');"/>
							<span class="explain">※ 画像認証コードを入力してください。</span>
							<span id="error_kaptcha" class="input_error"><s:fielderror><s:param>kaptcha</s:param></s:fielderror></span>
						</td>
					</tr>
				</table>
				<div class="submit">
					<s:token />
					<s:submit action="createInquiry" value="送信" cssClass="submit"></s:submit>
					<s:reset value="クリア" cssClass="submit"></s:reset>
				</div>

			</s:form>
		</dd>
	</dl>
</body>

</html>