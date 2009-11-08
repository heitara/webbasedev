<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>会員情報仮登録完了</title>
<style>
dl.finish dd div p {font-weight:bold; color:#833;}
dl.finish dd div a {color:#833; }
dl.finish dd div a:hover {color:#F90; text-decoration:underline;}
</style>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>会員情報仮登録完了</strong><span>&nbsp;</span></dt>
	<dd>
		<dl class="finish">
			<dt>会員登録していただき、ありがとうございました。</dt>
			<dd>
				<div>
					<p>お客様のアカウントは現時点でまだ仮登録状態ですので、有効化手続きを完了させる必要がございます。</p>
					ご登録されたメールアドレスへご本人様確認のメールをお送りしましたので、そちらのメールを確認して、会員情報を有効化してください。<br/>
					<s:if test="mailLoginUrl != null && mailLoginUrl != 'null'">
						下記のリンクをクリックしていただきますと、ご利用中のメールのログイン画面へ移動できます。
						
						<hr/>
						<a href="<s:property value="mailLoginUrl" escape="true"/>"><s:property value="mailLoginUrl" escape="true"/></a> &nbsp;
						| &nbsp; <a href="<s:property value="mailLoginUrl" escape="true"/>" target="_blank">別ウィンドウで開く</a>
						<hr/>
					</s:if>
				</div>
				<a href="inputInquiry.html" title="お問合せ"><img src="images/btn_s_inquiry.gif" title="お問合せ"/></a>
				<a href="<%=getServletContext().getInitParameter("communityTopUrl")%>" title="コミュニティサイト"><img src="images/btn_s_community.gif" title="コミュニティサイト"/></a>
			<dd>
		</dl>
	</dd>
</dl>
</body>
</html>