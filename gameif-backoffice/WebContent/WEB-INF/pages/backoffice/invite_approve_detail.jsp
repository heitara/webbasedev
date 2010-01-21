<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>友達招待承認（個人）</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			if (!confirm("送信します。よろしいですか？")) {
				return false;
			}
			var count = 0;
		    var inviteList = document.getElementsByName("selectedInviteList");
		    for(var i=0;i<inviteList.length;i++){
		    	if (inviteList[i].checked) {
			    	count++;
		    	}
		    }
		    var inviteLink = document.getElementsByName("selectedInviteLink");
		    for(var i=0;i<inviteLink.length;i++){
		    	if (inviteLink[i].checked) {
			    	count++;
		    	}
		    }
		    if (count < 1) {
			    alert("承認する被紹介者を選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>

<body>
	<dl >
		<dt><strong>友達招待承認（個人）</strong></dt>
		<dd>
			<s:form name="frm_nosubmit_inviteDetail" method="post" >
				<table>
					<s:hidden name="memNum"></s:hidden>
					<tr>
						<th><label for="account_id">アカウントID：</label></th>
						<td>
							<s:property value="model.memId"/>
						</td>
					</tr>
					<tr>
						<th><label for="nick_name">ニックネーム：</label></th>
						<td>
							<s:property value="model.nickName"/>
						</td>
					</tr>
					<tr>
						<th><label for="mail_pc">メールアドレス</label></th>
						<td>
							<s:property value="model.mailPc"/>
						</td>
					</tr>
					<tr>
						<th><label for="entry_ip">登録IP：</label></th>
						<td>
							<s:property value="model.entryIp"/>
						</td>
					</tr>
					<tr>
						<th><label for="entry_date">登録日：</label></th>
						<td>
							<s:date name="model.entryDate" format="yyyy/MM/dd HH:mm:ss"/>
						</td>
					</tr>
					<tr>
						<td colspan="2"><label for="entry_date">メールで紹介履歴</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<table class="friendhist tspace_y" align="center">
								<tr id="listTitle">
									<th>*</th>
									<th class="friend">アカウントID</th>
									<th class="friend">ニックネーム</th>
									<th class="mail">メールアドレス</th>
									<th class="mail">登録IP</th>
									<th class="entry_ymd">登録日時</th>
									<th class="friend">会員有効状態</th>
									<th class="friend">紹介者申請クッキー</th>
									<th class="friend">紹介者クッキー</th>
									<th class="friend">クッキー</th>
									<th class="friend">ゲームプレー回数</th>
									<th class="entry_ymd">最初プレー日時</th>
									<th class="entry_ymd">最終プレー日時</th>
									<th class="friend">承認状態</th>
								</tr>
								<s:iterator value="inviteHistList" id="inviteHistList" status="st">
									<tr>
										<td>
											<s:checkbox name="selectedInviteList" id="selectedInviteList" value="false" fieldValue="%{memNum}"></s:checkbox>
										</td>
										<td　class="friend"><s:property value="memId"/></td>
										<td class="friend"><s:property value="nickName"/></td>
										<td　class="mail"><s:property value="mailAdd"/></td>
										<td class="mail"><s:property value="entryIp"/></td>
										<td class="entry_ymd"><s:date name="entryDate" format="yyyy/MM/dd HH:mm:ss"/></td>
										<td　class="friend"><s:property value="backOfficeProperties.memberValidYNCd[memValidYnCd]"/></td>
										<td　class="friend"><s:property value="parentApproveCookie"/></td>
										<td　class="friend"><s:property value="parentCookie"/></td>
										<td　class="friend"><s:property value="childCookie"/></td>
										<td　class="friend"><s:property value="playCount"/></td>
										<td class="entry_ymd"><s:date name="playStartDate" format="yyyy/MM/dd HH:mm:ss"/></td>
										<td class="entry_ymd"><s:date name="playEndDate" format="yyyy/MM/dd HH:mm:ss"/></td>
										<td class="friend"><s:property value="backOfficeProperties.approveStatus[approveStatus]"/></td>
									</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2"><label for="entry_date">リンクで紹介履歴</label></td>
					</tr>
					<tr>
						<td colspan="2" >
							<table class="friendhist tspace_y" align="center">
								<tr id="listTitle">
									<th>*</th>
									<th class="friend">アカウントID</th>
									<th class="friend">ニックネーム</th>
									<th class="mail">メールアドレス</th>
									<th class="mail">登録IP</th>
									<th class="entry_ymd">登録日時</th>
									<th class="friend">会員有効状態</th>
									<th class="friend">紹介者申請クッキー</th>
									<th class="friend">クッキー</th>
									<th class="friend">ゲームプレー回数</th>
									<th class="entry_ymd">最初プレー日時</th>
									<th class="entry_ymd">最終プレー日時</th>
									<th class="friend">承認状態</th>
								</tr>
								<s:iterator value="inviteLinkHistList" id="inviteLinkHistList" status="st">
									<tr >
										<td>
											<s:checkbox name="selectedInviteLink" id="selectedInviteLink" value="false" fieldValue="%{memNum}"></s:checkbox>
										</td>
										<td　class="friend"><s:property value="memId"/></td>
										<td class="friend"><s:property value="nickName"/></td>
										<td　class="mail"><s:property value="mailAdd"/></td>
										<td class="mail"><s:property value="entryIp"/></td>
										<td class="entry_ymd"><s:date name="entryDate" format="yyyy/MM/dd HH:mm:ss"/></td>
										<td　class="friend"><s:property value="backOfficeProperties.memberValidYNCd[memValidYnCd]"/></td>
										<td　class="friend"><s:property value="parentApproveCookie"/></td>
										<td　class="friend"><s:property value="childCookie"/></td>
										<td　class="friend"><s:property value="playCount"/></td>
										<td class="entry_ymd"><s:date name="playStartDate" format="yyyy/MM/dd HH:mm:ss"/></td>
										<td class="entry_ymd"><s:date name="playEndDate" format="yyyy/MM/dd HH:mm:ss"/></td>
										<td class="friend"><s:property value="backOfficeProperties.approveStatus[approveStatus]"/></td>
									</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
				</table>
				<div class="submit">
					<s:token />
					<s:submit value="一括承認" action="approveInviteDetail" cssClass="big" onclick="return checkCount();"/>
					<s:submit value="一括却下" action="rejectInviteDetail" cssClass="big" onclick="return checkCount();"/>
					<s:submit value="一括保留" action="reserveInviteDetail" cssClass="big" onclick="return checkCount();"/>
					<a href="inputInviteList.html" title="戻る">戻る</a>
				</div>

			</s:form>
		</dd>
	</dl>
</body>
</html>