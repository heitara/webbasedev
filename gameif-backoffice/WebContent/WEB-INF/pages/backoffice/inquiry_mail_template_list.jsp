<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>問合せ返信テンプレート管理</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			var count = 0;
		    var checkboxs = document.getElementsByName("selectedTemplateList");
		    for(var i=0;i<checkboxs.length;i++){
		    	if (!checkboxs[i].disabled) {
			    	if (checkboxs[i].checked) {
				    	count++;
			    	}
		    	}
		    }
		    if (count < 1) {
			    alert("テンプレートを選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>問合せ返信テンプレート一覧</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form name="frm_template_list" cssClass="entry" method="post">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><label for="inquirySendmailName">テンプレート名：</label></th>
					<td>
						<s:textfield name="inquirySendmailName" maxlength="50" cssClass="ime_mode_n" />
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th></th>
					<td>
						<s:submit value="検索" action="searchInquiryTemplate" />
						<s:submit value="新規追加" action="inputAddInquiryTemplate" />
						<s:reset value="クリア"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<td colspan="2">
						<table class="friendhist tspace_y" align="center">
							<tr id="listTitle">
								<th>*</th>
								<th>テンプレート名</th>
							</tr>
							<s:iterator value="inquiryTemplateList" id="inquirySendmailId" status="st">
								<tr <s:if test="#st.odd">class="odd" </s:if> >
									<td>
										<s:checkbox name="selectedTemplateList" id="selectedTemplateList" value="false" fieldValue="%{inquirySendmailId}"></s:checkbox>
									</td>
									<td>
										<a href="inputEditInquiryTemplate.html?inquirySendmailId=<s:property value="inquirySendmailId"/>" ><s:property value="inquirySendmailName"/></a>
									</td>
								</tr>
							</s:iterator>
							<s:if test="inquiryTemplateList != null && inquiryTemplateList.size() > 0">
								<tr>
									<td colspan="3">
										<s:submit value="削除" action="deleteInquiryTemplate" cssClass="big" onclick="return checkCount();"/>
									</td>
								</tr>
							</s:if>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</dd>
</dl>
</body>
</html>