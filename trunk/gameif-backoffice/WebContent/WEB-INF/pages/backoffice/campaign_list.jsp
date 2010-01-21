<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>キャンペーン管理</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			var count = 0;
		    var checkboxs = document.getElementsByName("selectedCampaignList");
		    for(var i=0;i<checkboxs.length;i++){
		    	if (!checkboxs[i].disabled) {
			    	if (checkboxs[i].checked) {
				    	count++;
			    	}
		    	}
		    }
		    if (count < 1) {
			    alert("キャンペーンを選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>キャンペーン一覧</strong><span>&nbsp;</span></dt>
	<dd>
		<s:form cssClass="entry">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><label for="campaignList_inquiryDate">キャンペーン期間：</label></th>
					<td>
						<s:textfield id="campaignStartDate" name="campaignStartDate" size="10" />
						<span class="explain">～</span>
						<s:textfield id="campaignEndDate" name="campaignEndDate" size="10" />
					</td>
				</tr>
				<tr>
					<th><label for="campaignList_campaignSubject">キャンペーン名：</label></th>
					<td>
						<s:textfield name="campaignSubject" maxlength="100" />
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th></th>
					<td>
						<s:submit value="検索" action="searchCampaign" />
						<s:submit value="新規追加" action="inputAddCampaign" />
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
								<th>権限コード</th>
								<th>開始日期</th>
								<th>終了日期</th>
							</tr>
							<s:iterator value="campaignList" id="campaignList" status="st">
								<tr <s:if test="#st.odd">class="odd" </s:if> >
									<td>
										<s:checkbox name="selectedCampaignList" id="selectedCampaignList" value="false" fieldValue="%{campaignId}"></s:checkbox>
									</td>
									<td>
										<a href="inputEditCampaign.html?campaignId=<s:property value="campaignId"/>" ><s:property value="campaignSubject"/></a>
									</td>
									<td>
										<s:date name="campaignStartDate" format="yyyy/MM/dd"/>
									</td>
									<td>
										<s:date name="campaignEndDate" format="yyyy/MM/dd"/>
									</td>
								</tr>
							</s:iterator>
							<s:if test="campaignList != null && campaignList.size() > 0">
								<tr>
									<td colspan="4">
										<s:submit value="削除" action="deleteCampaign" cssClass="big" onclick="return checkCount();"/>
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