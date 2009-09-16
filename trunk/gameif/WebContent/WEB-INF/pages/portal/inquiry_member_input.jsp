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
</head>

<body>
	<dl class="light_box tspace_n">
		<dt><strong>会員様のお問合せ</strong></dt>
		<dd>
			<s:form name="frm_inquiry_member_input" method="post" cssClass="entry">
				<dl class="friendhist tspace_b">
					<dt>
						<strong>受付時間  10:00 ～ 18:00</strong><br/>
						受付時間外の問合せは、後日対応を行う場合がございますので、あらかじめご了承ください。
					</dt>
					<dd></dd>
				</dl>
				<dl>
					<dt><label for="user_name">アカウント：</label></dt>
					<dd>
						<span class="item"><%=com.gameif.common.util.ContextUtil.getAccountId()%></span>
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
					
					<dt><label for="inquiry_kind">種類</label></dt>
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
					<dt></dt>
					<dd>&nbsp;</dd>

				</dl>
				<div class="submit">
					<s:submit action="createMemInquiry" value="送信" cssClass="submit"></s:submit>
					<s:reset value="クリア" cssClass="submit"></s:reset>
				</div>

			</s:form>
		</dd>
	</dl>
</body>

</html>