<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
<html>
<head>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title><s:property value="%{getText('inquiry_input_title')}" /></title>
	<script charset="UTF-8" src="js/portal/common.js" language="JavaScript" type="text/javascript"></script>
</head>

<body>
	<div id="page_main_box">
		<div id="page_main_main">
			<dl class="light_box tspace_n">
				<dt><strong>問合せ</strong></dt>
				<dd>
					<s:form name="frm_inquiry_input" method="post" cssClass="entry">
						<dl>
							<dt><span class="required">*</span><label for="user_name">お名前：</label></dt>
							<dd>
								<s:textfield name="userName" maxlength="20" cssClass="big ime_mode_n"/>
							</dd>
				
							<dt><span class="required">*</span><label for="mail">メールアドレス：</label></dt>
							<dd>
								<s:textfield name="userMailadd" maxlength="100" cssClass="ime_mode_n" />
								<span class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span><br/>
								<span class="explain">メールアドレスを小文字で入力してください。</span>
							</dd>
							
							<dt><span class="required">*</span><label for="game">対象タイトル：</label></dt>
							<dd>
								<s:select name="titleId" list="listValidTitle" listKey="titleId" listValue="titleName" cssClass="big"/>
							</dd>
							
							<dt><label for="inquiry_kind">種類</label></dt>
							<dd>
								<s:select name="inquiryKindCode" list="listInquiryKind" listKey="inquiryKindCode" listValue="inquiryKindName" cssClass="big"/>
							</dd>
							
							<dt><span class="required">*</span><label for="object">お問合せ件名：</label></dt>
							<dd>
								<s:textfield name="inquiryObject" maxlength="100" cssClass="big ime_mode_n"/>
							</dd>
							
							<dt><span class="required">*</span><label for="contents">内容：</label></dt>
							<dd>
								<s:textarea name="inquiryContents" rows="8" cssClass="big ime_mode_n f_left"/>
							</dd>
							<dt></dt>
							<dd>&nbsp;</dd>
	
						</dl>
						<div class="submit">
							<s:submit action="createInquiry" value="送信" cssClass="submit"></s:submit>
							<s:reset value="クリア" cssClass="submit"></s:reset>
						</div>
	
					</s:form>
				</dd>
			</dl>
		</div>
		<div class="clearbox"></div>	
	</div>
</body>

</html>
</s:i18n>