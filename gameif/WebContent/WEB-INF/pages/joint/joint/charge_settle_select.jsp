<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>決済方法選択 | ポイントチャージ</title>
<script src="js/portal/validate.js" type="text/javascript"></script>
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
<style>
form table tr th { text-align:left;padding-right:10px; }
div.subimit { width:100%;text-align:center; }
th.settle label { width:16px!important;font-weight:bold; }
</style>
</head>
<body>
<!-- ポイントチャージ：開始 -->
<s:form name="frm_nosubmit_settle_select" method="post" cssClass="entry">
<div style="margin-bottom:20px;text-align:center;">
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
クレジットカード決済の場合は、3Dセキュア認証が必要ですので、ご注意ください。<br/>
<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
<div style="background-color:#FFF;border:1px solid #CCC;width:50%;">
<table>
	<s:iterator value="settleList" id="settle" status="st">
		<tr valign="middle" >
			<th class="settle">
				<s:radio name="settlementCode" list="#{'settlementCode':'settlementName'} " listKey="settlementCode" listValue="settlementName" value=""></s:radio>
			</th>
			<td>
				<img src="<s:property value="iconUrl"/>" alt="<s:property value="settlementName"/>"/>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
<div class="submit" style="margin-top:30px;">
	<s:hidden name="titleId" ></s:hidden>
	<s:hidden name="serverId" ></s:hidden>
	<s:hidden name="pointId" ></s:hidden>
	<s:token />
	<s:submit value="戻る" action="chargePointSelect" cssClass="submit" />
	<s:submit value="次へ" action="chargeSettleSubmit" cssClass="submit" onclick="return checkCount();"/>
</div>
</center>
</s:form>
<!-- ポイントチャージ：終了 -->


</body>
</html>