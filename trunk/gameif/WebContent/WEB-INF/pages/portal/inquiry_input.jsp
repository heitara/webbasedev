<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title>問合せ | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function RefreshImg(){
			$("#kaptchaPic").attr({src: "images/kaptcha.jpg?" + new Date().getSeconds()});
		}
	</script>
</head>

<body>
	<dl class="light_box tspace_n">
		<dt><strong>その他問合せ</strong><span><a href="inputMediaInquiry.html">► メディア様のお問合せ</a></span></dt>
		<dd>
			<s:form name="frm_inquiry_input" method="post" cssClass="entry">
				<dl>
					<dt><span class="required">*</span><label for="user_name">お名前：</label></dt>
					<dd>
						<s:textfield name="userName" maxlength="20" cssClass="ime_mode_y"  title="お名前" onblur="validate(this, 'REQ,ZEN');"/>
						<span class="explain">※ 全角文字で入力してください。</span>
						<span id="error_userName" class="input_error"><s:fielderror><s:param>userName</s:param></s:fielderror></span>
					</dd>
		
					<dt><span class="required">*</span><label for="mail">メールアドレス：</label></dt>
					<dd>
						<s:textfield name="userMailadd" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ,EML');"/>
						<span class="explain">※メールアドレスを小文字で入力してください。</span>
						<span id="error_userMailadd" class="input_error"><s:fielderror><s:param>userMailadd</s:param></s:fielderror></span>
					</dd>
					
					<dt><span class="required">*</span><label for="game">対象タイトル：</label></dt>
					<dd>
						<s:select name="titleId" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName"  headerKey="0" headerValue="" title="対象タイトル"  onblur="validate(this,'REQ');" />
						<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span>
					</dd>
					
					<dt><label for="inquiry_kind">種類：</label></dt>
					<dd>
						<s:select name="inquiryKindCode" list="masterInfoBusinessLogic.allInquiryKindList" listKey="inquiryKindCode" headerKey="0" headerValue="" cssClass="big"/>
					</dd>
					
					<dt><span class="required">*</span><label for="object">お問合せ件名：</label></dt>
					<dd>
						<s:textfield name="inquiryObject" maxlength="100"  title="お問合せ件名" onblur="validate(this, 'REQ,KOT');" />
						<span class="explain">※ 記号とスペース以外の文字で入力してください。</span>
						<span id="error_inquiryObject" class="input_error"><s:fielderror><s:param>inquiryObject</s:param></s:fielderror></span>
					</dd>
					
					<dt><span class="required">*</span><label for="contents">内容：</label></dt>
					<dd>
						<s:textarea name="inquiryContents" rows="8" cssClass="big ime_mode_n f_left" title="内容" onblur="validate(this, 'REQ,KOT');" />
						<span class="explain">※ 記号とスペース以外の文字で入力してください。</span>
						<span id="error_inquiryContents" class="input_error"><s:fielderror><s:param>inquiryContents</s:param></s:fielderror></span>
					</dd>

					<dt><span class="required">*</span><label for="createMember_kaptcha">画像認証：</label></dt>
					<dd>
						<img id="kaptchaPic" src="images/kaptcha.jpg"/>
						<a href="javascript:RefreshImg();"><img id="newKaptcha" src="images/capture_update.gif"/></a><br/>
						<s:textfield name="kaptcha" maxlength="20"  cssClass="ime_mode_n" title="画像認証" onblur="validate(this,'REQ,ALN');"/>
						<span class="explain">※ 画像認証コードを入力してください。</span>
						<span id="error_kaptcha" class="input_error"><s:fielderror><s:param>kaptcha</s:param></s:fielderror></span>
					</dd>

				</dl>
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