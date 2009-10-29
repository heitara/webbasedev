<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title>メディア様のお問合せ</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function RefreshImg(){
			$("#kaptchaPic").attr({src: "images/kaptcha.jpg?" + new Date().getSeconds()});
		}
	</script>
</head>

<body>
	<dl class="light_box tspace_n">
		<dt><strong>メディア様のお問合せ</strong><span><a href="inputInquiry.html">► 一般のお問合せ</a> &nbsp; <a href="inputMemberInquiry.html">► 会員様のお問合せ</a></span></dt>
		<dd>
			<s:form name="frm_inquiry_media_input" method="post" cssClass="entry">
				<table>
					<tr>
						<th><span class="required">*</span><label for="company_name">御社名：</label></th>
						<td>
							<s:textfield name="companyName" maxlength="40" cssClass="ime_mode_y big" title="御社名" onblur="validate(this, 'REQ,ZEN');"/>
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_companyName" class="input_error"><s:fielderror><s:param>companyName</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="company_media_name">御社媒体名：</label></th>
						<td>
							<s:textfield name="companyMediaName" maxlength="40" cssClass="ime_mode_y big" title="御社媒体名" onblur="validate(this, 'REQ,ZEN');"/>
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_companyMediaName" class="input_error"><s:fielderror><s:param>companyMediaName</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="company_user_name">担当者名：</label></th>
						<td>
							<s:textfield name="companyUserName" maxlength="20" cssClass="ime_mode_y big" title="担当者名" onblur="validate(this, 'REQ,ZEN');"/>
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_companyUserName" class="input_error"><s:fielderror><s:param>companyUserName</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="mail">メールアドレス：</label></th>
						<td>
							<s:textfield name="userMailadd" maxlength="100" cssClass="ime_mode_n big" title="メールアドレス" onblur="validate(this, 'REQ,EML');"/>
							<span class="explain">※ メールアドレスを小文字で入力してください。</span>
							<span id="error_userMailadd" class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><label for="tel_num">電話番号：</label></th>
						<td>
							<s:textfield name="telNum" maxlength="15" cssClass="ime_mode_n big" title="電話番号" onblur="validate(this, 'NUM,LEN_8_15');"/>
							<span class="explain">※ ハイフンなしの半角数字で入力してください。</span><br/>
							<span id="error_telNum" class="input_error"><s:fielderror><s:param>telNum</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="object">お問合せ件名：</label></th>
						<td>
							<s:textfield name="inquiryObject" maxlength="100" cssStyle="width:360px;" title="お問合せ件名" onblur="validate(this, 'REQ,ZEN');" />
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_inquiryObject" class="input_error"><s:fielderror><s:param>inquiryObject</s:param></s:fielderror></span>
						</td>
					</tr>					
					<tr>
						<th><span class="required">*</span><label for="contents">内容：</label></th>
						<td>
							<s:textarea name="inquiryContents" rows="15" cssClass="big ime_mode_n" cssStyle="width:360px;" title="内容" onblur="validate(this, 'REQ,ZEN,LEN_10_1000');" />
							<span class="explain">※ 全角文字で入力してください。</span>
							<span id="error_inquiryContents" class="input_error"><s:fielderror><s:param>inquiryContents</s:param></s:fielderror></span>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span><label for="createMember_kaptcha">画像認証：</label></th>
						<td>
							<img id="kaptchaPic" src="images/kaptcha.jpg"/>
							<a href="javascript:RefreshImg();"><img id="newKaptcha" src="images/capture_update.gif"/></a><br/>
							<s:textfield name="kaptcha" maxlength="20"  cssClass="ime_mode_n" title="画像認証" onblur="validate(this,'REQ,ALN');"/>
							<span class="explain">※ 画像認証コードを入力してください。</span>
							<span id="error_kaptcha" class="input_error"><s:fielderror><s:param>kaptcha</s:param></s:fielderror></span>
						</td>
					</tr>
				</table>
				<div class="submit">
					<s:token />
					<s:submit action="createMediaInquiry" value="送信" cssClass="submit"></s:submit>
					<s:reset value="クリア" cssClass="submit"></s:reset>
				</div>
			</s:form>
		</dd>
	</dl>
</body>
</html>