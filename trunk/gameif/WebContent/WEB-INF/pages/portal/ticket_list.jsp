<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gameif.portal.constants.PortalConstants"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>サービスチケット</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/common.js" type="text/javascript"></script>
	<script type="text/javascript">
		window.onload = function(){   
			var point = document.getElementById("point").value;
			if (point != null && eval(point) > 0) {
				var msg = "";
				if (eval(point) > 100) {
					msg = "おめでとうございます。\n";
				}
				alert(msg + "サービスポイント" + point + "PTを獲得しました。");
				location = "inputListTicket.html";
			}
        };
	</script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>サービスチケット</strong><span><a href="inputListTicket.html">► チケット使用</a>　<a href="inputUseListTicket.html">► チケット使用履歴</a>　<a href="inputGiveListTicket.html">► チケット付与履歴</a></span></dt>
		<dd>
			<s:form name="frm_ticket_list" method="post" cssClass="entry" cssStyle="margin:0px;">
				<h3 style="color:#F60;margin:20px 0px 20px 0px;">サービスチケットを使ってサービスポイントを獲得しましょう！</h3>
				<div>
					<b>サービスチケットには「運のチケット」と「定のチケット」の二種類があります。</b><br/>
					<div style="margin:10px 0px;padding:7px 10px;font-size:10px;border:1px solid #EEE;background-color:#F6F6F6;line-height:18px;">
					運のチケット：
					獲得できるサービスポイントは運によります。運がよければ、最大でチケット画像に表示されている数字分のポイントが獲得できます。<br/>
					定のチケット：
					獲得できるサービスポイント数は固定です。チケット画像に表示されている数字分のポイントを獲得します。
					</div>
					サービスチケットを使うにはサービスポイントチケット一覧から「今すぐ使用」をクリックしてください。一回一枚ずつ使います。
				</div>
				<table class="tspace_y" align="center" cellspacing="0" cellpadding="3" border="0" width="100%">
					<tr align="center" bgcolor="#333333" style="color:#FFF;" height="28">
						<td>サービスチケット</td>
						<td>対象タイトル</td>
						<td>枚数</td>
						<td>使用可能日</td>
						<td>使用期限</td>
						<td width="100">&nbsp;</td>
					</tr>
					<s:iterator value="ticketList" id="ticketList" status="st">
						<tr align="center">
							<td><img src="<s:property value="iconUrl"/>" title="<s:property value="ticketName"/>"/></td>
							<td><s:property value="titleName"/></td>
							<td><s:property value="ticketCount"/></td>
							<td><s:date name="ticketStartDate" format="yyyy/MM/dd"/></td>
							<td><s:date name="ticketEndDate" format="yyyy/MM/dd"/></td>
							<td><a href="useTicket.html?ticketId=<s:property value="ticketId"/>&titleId=<s:property value="titleId"/>" >今すぐ使用</a></td>
						</tr>
					</s:iterator>
				</table><br/>
				<span class="logic_error" style="font-size:12px;"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span>
				<s:hidden id="point" name="point"></s:hidden>
				<table width="100%" align="center" cellspacing="1" cellpadding="5" border="0" style="background-color:#FFF;margin-top:30px;border:1px solid #DDD;">
					<tr align="center" bgcolor="#999" style="background-color:#EEE;">
						<td>サービスポイント残高</td>
						<td>タイトル</td>
						<td>有効期限</td>
					</tr>
					<s:iterator value="servicePointList" id="servicePointList">
						<tr align="center">
							<td>
								<s:if test="pointAmount != null">
									<s:text name="format.money">
										<s:param value="pointAmount" />
									</s:text>
								</s:if>
								<s:else>
									<span>0</span>
								</s:else> PT
							</td>
							<td>
								<s:if test="titleName != null">
									<s:property value="titleName"/>
								</s:if>
								<s:else>
									<span>-</span>
								</s:else>
							</td>
							<td>
								<s:if test="pointEndDate != null">
									<s:date name="pointEndDate" format="yyyy/MM/dd"/>
								</s:if>
								<s:else>
									<span>-</span>
								</s:else>
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:form>
		</dd>
	</dl>
</body>
</html>