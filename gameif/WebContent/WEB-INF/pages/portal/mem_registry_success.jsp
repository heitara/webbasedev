<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>会員情報登録完了</title></head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>会員情報登録完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt style="height:40px;">会員情報登録が完了しました。<br/>サービスを利用する前に、アカウントを有効化する必要がございます。</dt>
			<dd>
				<div>ご登録されたメールアドレスへご本人様確認のメールをお送りしましたので、<br/>そちらのメールを確認して、会員情報を有効化してください。</div>
				<!--<span></span><s:property value="memNum"/></span>-->
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>