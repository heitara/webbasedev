<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>「レジオン-創世伝説-」クローズドβテスト参加者アンケート</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>「レジオン-創世伝説-」クローズドβテスト参加者アンケート</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form method="post" action="createQuestionnaireAnswer">
			<s:hidden name="questionNo"></s:hidden>
			<div style="color:#F60;font-weight:bold;font-size:14px;line-height:22px;">
			「レジオン-創世伝説-」のクローズドβテストに参加された方は、こちらのアンケートにもぜひご参加ください。</div>
			<div style="color:#600;font-size:12px;line-height:20px;margin:15px">
			クローズドβテストに参加された方で、こちらのアンケートにも参加された場合、<br/>
			「レジオン-創世伝説-」正式サービス開始する時に、サービスポイント300PTをプレゼントします。
			</div>
			<div style="border:1px solid #CCC;background-color:#F3F3F3;padding:15px;">
				<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span>
				<s:property value="htmlContents" escape="false"/>
			</div>
			<s:if test="hasDblError == false">
			<div style="margin:20px 60px;">
				<input type="button" value="送信" style="width:180px;" onclick="if(checkFormInput()) { this.form.submit(); }"/>
			</div>
			</s:if>
		</s:form>
	</dd>
</dl>
</body>
</html>