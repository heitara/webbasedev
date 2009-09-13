<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
<html>
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title><s:property value="メディア問合せ" /></title>
	<script charset="UTF-8" src="js/portal/common.js" language="JavaScript" type="text/javascript"></script>
</head>

<body>
	<dl class="light_box tspace_n">
		<dt><strong>メディア様のお問合せ</strong></dt>
		<dd>
			<s:form name="frm_inquiry_media_input" method="post" cssClass="entry">
				<dl>
					<dt><span class="required">*</span><label for="company_name">御社名：</label></dt>
					<dd>
						<s:textfield name="companyName" maxlength="40" cssClass="big ime_mode_n"/>
						<span class="input_error">
							<s:fielderror><s:param>companyName</s:param></s:fielderror>
						</span><br/>
					</dd>
					
					<dt><span class="required">*</span><label for="company_media_name">御社媒体名：</label></dt>
					<dd>
						<s:textfield name="companyMediaName" maxlength="40" cssClass="big ime_mode_n"/>
						<span class="input_error">
							<s:fielderror><s:param>companyMediaName</s:param></s:fielderror>
						</span><br/>
					</dd>
					
					<dt><span class="required">*</span><label for="company_user_name">担当者名：</label></dt>
					<dd>
						<s:textfield name="companyUserName" maxlength="20" cssClass="big ime_mode_n"/>
						<span class="input_error">
							<s:fielderror><s:param>companyUserName</s:param></s:fielderror>
						</span><br/>
					</dd>
		
					<dt><span class="required">*</span><label for="mail">メールアドレス：</label></dt>
					<dd>
						<s:textfield name="userMailadd" maxlength="100" cssClass="ime_mode_n" /><br/>
						<span class="explain">メールアドレスを小文字で入力してください。</span>
						<span class="input_error"><s:fielderror><s:param>userMailadd</s:param></s:fielderror></span><br/>
					</dd>
					
					<dt><label for="tel_num">電話番号：</label></dt>
					<dd>
						<s:textfield name="telNum" maxlength="20" cssClass="big ime_mode_n"/>
						<span class="explain">「‐」なし</span>
						<span class="input_error"><s:fielderror><s:param>telNum</s:param></s:fielderror></span><br/>
					</dd>
					
					<dt><span class="required">*</span><label for="object">お問合せ件名：</label></dt>
					<dd>
						<s:textfield name="inquiryObject" maxlength="100" cssClass="big ime_mode_n"/>
						<span class="input_error"><s:fielderror><s:param>inquiryObject</s:param></s:fielderror></span><br/>
					</dd>
					
					<dt><span class="required">*</span><label for="contents">内容：</label></dt>
					<dd>
						<s:textarea name="inquiryContents" rows="8" cssClass="big ime_mode_n f_left"/>
						<span class="input_error"><s:fielderror><s:param>inquiryContents</s:param></s:fielderror></span><br/>
					</dd>
					<dt></dt>
					<dd>&nbsp;</dd>

				</dl>
				<div class="submit">
					<s:submit action="createMediaInquiry" value="送信" cssClass="submit"></s:submit>
					<s:reset value="クリア" cssClass="submit"></s:reset>
				</div>

			</s:form>
		</dd>
	</dl>
</body>

</html>
</s:i18n>