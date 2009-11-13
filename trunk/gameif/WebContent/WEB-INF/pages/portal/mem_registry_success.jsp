<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>会員情報仮登録完了</title>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>会員情報仮登録完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>会員登録していただき、ありがとうございました。</dt>
			<dd>
				<div class="msg">
					<p>お客様のアカウントは現時点でまだ仮登録状態ですので、有効化手続きを完了させる必要がございます。</p>
					ご登録されたメールアドレスへご本人様確認のメールをお送りしましたので、<br/>そちらのメールを確認して、アカウントを有効化してください。<br/>
					<s:if test="mailLoginUrl != null && mailLoginUrl != 'null'">
						<br/><br/>
						下のボタンをクリックしていただきますと、ご利用中のメールのログイン画面が開かれます。<br/>
						※開かれる画面のURL：　<span style="color:#900"><s:property value="mailLoginUrl" escape="true"/></span>
						<br/><br/>
						<a href="<s:property value="mailLoginUrl" escape="true"/>" title="メールログイン画面を開く" target="_blank"><img src="images/btn_c_mail_login.png" alt="ウェブメールにログイン"/></a>
					</s:if>
				</div>
				<div class="rbox_side" style="margin-top:30px;"></div><div class="rbox_round"></div><div class="rbox_main">
					<div style="overflow:hidden;margin:10px;">
						<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
						<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
					</div>
				</div><div class="rbox_round"></div><div class="rbox_side"></div>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>