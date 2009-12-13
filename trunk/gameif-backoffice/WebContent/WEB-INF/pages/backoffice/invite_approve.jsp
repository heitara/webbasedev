<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>友達紹介承認</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script src="js/popcalendar.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			if (!confirm("送信します。よろしいですか？")) {
				return false;
			}
			var count = 0;
		    var checkboxs = document.getElementsByName("selectedInviteList");
		    for(var i=0;i<checkboxs.length;i++){
		    	if (!checkboxs[i].disabled) {
			    	if (checkboxs[i].checked) {
				    	count++;
			    	}
		    	}
		    }
		    if (count < 1) {
			    alert("紹介情報を選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>友達紹介承認</strong><span>&nbsp;</span></dt>
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
					<th><label for="inquiryList_entryDate">登録期間：</label></th>
					<td>
						<s:textfield name="entryStartDate" size="10" />
						<span class="explain">～</span>
						<s:textfield name="entryEndDate" size="10" />
					</td>
				</tr>
				<tr>
					<th><label for="inviteList_memId">紹介者ＩＤ：</label></th>
					<td>
						<s:textfield name="memId" maxlength="20" cssClass="ime_mode_n" title="紹介者ＩＤ" />
						<span class="explain">（部分一致）</span>
					</td>
				</tr>
				<tr>
					<th><label for="inviteList_childMemId">被紹介者ＩＤ：</label></th>
					<td>
						<s:textfield name="childMemId" maxlength="20" cssClass="ime_mode_n" title="被紹介者ＩＤ" />
						<span class="explain">（部分一致）</span>
					</td>
				</tr>
				<tr>
					<th><label for="inviteList_inviteType">紹介種別：</label></th>
					<td>
						<s:select name="inviteType" list="backOfficeProperties.inviteType" cssClass="big" />
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<th></th>
					<td>
						<s:submit value="検索" name="search" action="searchInviteList" />
						<s:submit value="クリア" name="clear" />
					</td>
				</tr>
				<tr>
					<td colspan="2" />
				</tr>
				<tr>
					<td colspan="2">
						<table class="friendhist tspace_y" align="center">
							<tr id="listTitle">
								<th rowspan="2">*</th>
								<th colspan="4" class="friend">紹介者</th>
								<th colspan="5" class="friend">被紹介者</th>
							</tr>
							<tr id="listTitle">
								<th class="status">ＩＤ</th>
								<th class="status">ニックネーム</th>
								<th class="mail">メールアドレス</th>
								<th class="entry_ymd">登録ＩＰ</th>
								<th class="status">ＩＤ</th>
								<th class="status">ニックネーム</th>
								<th class="mail">メールアドレス</th>
								<th class="entry_ymd">登録ＩＰ</th>
								<th class="entry_ymd">登録日</th>
							</tr>
							<s:iterator value="inviteList" id="inviteList" status="st">
								<tr <s:if test="#st.odd">class="odd" </s:if> >
									<td>
										<s:checkbox name="selectedInviteList" id="selectedInviteList" value="false" fieldValue="%{memNum},%{childMemNum}"></s:checkbox>
									</td>
									<td class="status"><s:property value="memId"/></td>
									<td class="status"><s:property value="nickName"/></td>
									<td class="mail"><s:property value="mailAdd"/></td>
									<td class="entry_ymd"><s:property value="entryIp"/></td>
									<td class="status"><s:property value="childMemId"/></td>
									<td class="status"><s:property value="childNickName"/></td>
									<td class="mail"><s:property value="childMailAdd"/></td>
									<td class="entry_ymd"><s:property value="childEntryIp"/></td>
									<td class="entry_ymd"><s:property value="entryDate"/></td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<s:if test="inviteList != null && inviteList.size() > 0">
							<s:submit value="一括承認" action="approveInviteList" cssClass="big" onclick="return checkCount();"/>
							<s:submit value="一括却下" action="rejectInviteList" cssClass="big" onclick="return checkCount();"/>
						</s:if>
					</td>
				</tr>
			</table>
		</s:form>
	</dd>
</dl>
</body>
</html>