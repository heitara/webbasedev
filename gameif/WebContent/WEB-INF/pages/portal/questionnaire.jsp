<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>お客様アンケート</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>お客様アンケート</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form method="post" action="createQuestionnaireAnswer">
			<s:hidden name="questionNo"></s:hidden>
			<h4>
			ゲームイフではよりよいサービスのために、皆様からのご意見をうかがっております。<br/>このアンケートにご記入いただけますでしょうか。
			</h4>
			<p style="border-top:1px dashed #CCC;padding-top:15px;line-height:18px;margin-top:10px">
			</p>
			<div>
				<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
			</div>
			<s:property value="htmlContents" escape="false"/>
			<div class="submit">
				<s:submit type="submit" value="送信" cssClass="an_btn" onclick="return checkFormInput();"/>
			</div>
		</s:form>
	</dd>
</dl>
</body>
</html>