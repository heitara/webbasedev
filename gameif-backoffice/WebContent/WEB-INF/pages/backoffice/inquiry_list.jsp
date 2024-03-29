<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>お問合せ管理</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script src="js/popcalendar.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			if (!confirm("送信します。よろしいですか？")) {
				return false;
			}
			var count = 0;
		    var checkboxs = document.getElementsByName("selectedInquiryList");
		    for(var i=0;i<checkboxs.length;i++){
		    	if (!checkboxs[i].disabled) {
			    	if (checkboxs[i].checked) {
				    	count++;
			    	}
		    	}
		    }
		    if (count < 1) {
			    alert("問合せ情報を選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>お問合せ一覧</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form name="frm_nosubmit_inquirylist" cssClass="entry" method="post">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><label for="inquiryList_inquiryDate">お問合せ期間：</label></th>
					<td>
						<s:textfield id="inquiryStartDate" name="inquiryStartDate" size="10" />
						<span class="explain">～</span>
						<s:textfield id="inquiryEndDate" name="inquiryEndDate" size="10" />
					</td>
				</tr>
				<tr>
					<th><label for="inquiryList_inquiryDate">お問合せ種別：</label></th>
					<td>
						<s:checkboxlist name="inquiryType" list="backOfficeProperties.inquiryTypes" cssClass="big"/>
					</td>
					
					
				</tr>
				<tr>
					<th><label for="inquiryList_authorityCode">お問合せ種類：</label></th>
					<td>
						<s:checkboxlist name="inquiryKindCode" list="masterInfoBusinessLogic.allInquiryKindList" cssClass="big" listKey="inquiryKindCode" listValue="inquiryKindName"/>
					</td>
				</tr>
				<tr>
					<th><label for="inquiryList_correspondStatus">対応状態：</label></th>
					<td>
						<s:select name="correspondStatus" list="backOfficeProperties.correspondStatus" cssClass="big" headerKey="9999" headerValue="全て" />
					</td>
				</tr>
				<tr>
					<th><label for="inquiryList_userMailadd">メールアドレス：</label></th>
					<td>
						<s:textfield name="userMailadd" maxlength="30" cssClass="ime_mode_n" />
						<span class="explain">（部分一致）</span>
					</td>
				</tr>
				<tr>
					<th><label for="inquiryList_inquiryObject">お問合せ件名：</label></th>
					<td>
						<s:textfield name="inquiryObject" maxlength="100" cssClass="ime_mode_y" cssStyle="width:360px;" />
						<span class="explain">（部分一致）</span>
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th></th>
					<td>
						<s:submit value="検索" name="search" action="searchInquriyList" method="search" />
						<s:submit value="クリア" name="clear" action="clearInquriyList" method="clear" />
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
								<th class="friend">お問合せ件名</th>
								<th class="friend">お問合せ種別</th>
								<th class="mail">お問合せ日時</th>
								<th class="mail">メールアドレス</th>
								<th class="entry_ymd">対応状態</th>
								<th class="mail">対応日時</th>
							</tr>
							<s:iterator value="inquiryList" id="inquiryList" status="st">
								<tr <s:if test="#st.odd">class="odd" </s:if> >
									<td>
										<s:checkbox name="selectedInquiryList" id="selectedInquiryList" value="false" fieldValue="%{inquiryNum}"></s:checkbox>
									</td>
									<td>
										<a href="inputEditInquriy.html?inquiryNum=<s:property value="inquiryNum"/>" ><s:property value="inquiryObject"/></a>
									</td>
									<td class="friend"><s:property value="backOfficeProperties.inquiryTypes[inquiryType]"/></td>
									<td class="entry_ymd"><s:date name="inquiryDate" format="yyyy/MM/dd HH:mm:ss"/></td>
									<td class="entry_ymd"><s:property value="userMailadd"/></td>
									<s:if test="correspondStatus == null">
										<td class="mail"></td>
									</s:if>
									<s:else>
										<td class="mail"><s:property value="backOfficeProperties.correspondStatus[correspondStatus]"/></td>
									</s:else>
									<td class="mail"><s:date name="responseDate" format="yyyy/MM/dd HH:mm:ss"/></td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<s:if test="inquiryList != null && inquiryList.size() > 0">
							<s:submit value="削除" action="deleteInquriyList" cssClass="big" onclick="return checkCount();"/>
						</s:if>
					</td>
				</tr>
			</table>
		</s:form>
	</dd>
</dl>
</body>
</html>