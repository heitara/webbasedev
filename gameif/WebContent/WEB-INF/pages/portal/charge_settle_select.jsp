<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>決済方法選択 | ポイントチャージ</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/bindMaster.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			var count = 0;
		    var sttlCodes = document.getElementsByName("settlementCode");
		    for (var i = 0; i < sttlCodes.length; i++) { 
		    	if (sttlCodes[i].checked) {
			    	count++;
		    	}
		    } 
		    if (count != 1) {
			    alert("決済方法を選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>

<body>
<!-- ポイントチャージ：開始 -->
<dl class="light_box tspace_n">
	<dt><strong>ポイントチャージ</strong><span><a href="#">► サービスポイント使用</a>　<a href="chargeSettlementHist.html">► チャージ履歴</a></span></dt>
	<dd>
		<s:form name="frm_nosubmit_settle_select" method="post" cssClass="entry">
			<div style="margin-bottom:30px;text-align:center;">
					<img src="images/point_flow_10.gif"/>
					<img src="images/point_flow_00.gif"/>
					<img src="images/point_flow_21.gif"/>
					<img src="images/point_flow_00.gif"/>
					<img src="images/point_flow_30.gif"/>
					<img src="images/point_flow_00.gif"/>
					<img src="images/point_flow_40.gif"/>
					<img src="images/point_flow_00.gif"/>
					<img src="images/point_flow_50.gif"/>
			</div>
			<center>
				<div style="width:92%;text-align:left;padding:10px;border:1px solid #CCC;background-color:#F6F6F6;">
					クレジットカード決済の場合は、3Dセキュア認証が必須となっておりますので、ご注意ください。<br/>
					詳しくは <a href="http://info.game-if.com/component/content/article/21-3d" target="_blank">こちら</a> をご参照ください。				
				</div>
			</center>
			<table align="center">
				<tr>
					<td colspan="2">
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<s:iterator value="settleList" id="settle" status="st">
					<tr valign="middle" >
						<td>
							<s:radio name="settlementCode" list="#{'settlementCode':'settlementName'} " listKey="settlementCode" listValue="settlementName" value=""></s:radio>
						</td>
						<td>
							<img src="<s:property value="iconUrl"/>" alt="<s:property value="settlementName"/>"/>
						</td>
					</tr>
				</s:iterator>
			</table>
			<div class="submit">
				<s:hidden name="titleId" ></s:hidden>
				<s:hidden name="serverId" ></s:hidden>
				<s:hidden name="pointId" ></s:hidden>
				<s:token />
				<s:submit value="次へ" action="chargeSaveSettleTrns" cssClass="submit" onclick="return checkCount();"/>
				<s:submit value="戻る" action="chargePointSelect" cssClass="submit" />
			</div>
		</s:form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>