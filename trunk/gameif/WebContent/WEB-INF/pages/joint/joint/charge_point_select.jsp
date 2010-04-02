<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>ポイント選択 | ポイントチャージ </title>
<script src="js/portal/validate.js" type="text/javascript"></script>
<style>
form table tr th { text-align:right;padding-right:10px; }
div.subimit { width:100%;text-align:center; }
select { width:270px; height:24px; font-size:13px; }
td.oname { font-size:14px; font-weight:bold; color:#F30; }
</style>
</head>
<body>
<!-- ポイントチャージ：開始 -->
<s:form name="frm_nosubmit_point_select" method="post" cssClass="entry">
<div style="margin-bottom:20px;text-align:center;">
	<img src="images/point_flow_11.gif"/>
	<img src="images/point_flow_00.gif"/>
	<img src="images/point_flow_20.gif"/>
	<img src="images/point_flow_00.gif"/>
	<img src="images/point_flow_30.gif"/>
	<img src="images/point_flow_00.gif"/>
	<img src="images/point_flow_40.gif"/>
	<img src="images/point_flow_00.gif"/>
	<img src="images/point_flow_50.gif"/>
</div>
<table align="center" style="margin-bottom:100px;">
	<tr>
		<th width="120px;"></th>
		<td>
			<span class="input_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
		</td>
	</tr>
	<tr height="36">
		<th><label for="point_titleId">ゲーム：</label></th>
		<td class="oname"><s:property value="titleName"/></td>
	</tr>
	<tr height="36">
		<th><label for="point_serverId">サーバ：</label></th>
		<td class="oname"><s:property value="serverName"/></td>
	</tr>
	<tr height="40">
		<th><label for="point_pointId">チャージポイント：</label></th>
		<td>
			<s:select id="pointId" name="pointId" list="pointList" listKey="pointId" listValue="pointName" emptyOption="true" title="チャージポイント" onblur="validate(this,'REQ');"/>
			<span id="error_pointId" class="input_error"><s:fielderror><s:param>pointId</s:param></s:fielderror></span><br/>
		</td>
	</tr>
	<tr height="70">
		<th></th>
		<td>
			<s:hidden name="titleId" />
			<s:hidden name="serverId" />
			<s:token />
			<s:submit action="chargePointSubmit" value="次へ"/>
		</td>
	</tr>
</table>
</s:form>
<!-- ポイントチャージ：終了 -->
</body>
</html>