<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ポイント選択 | ポイントチャージ </title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/bindMaster.js" type="text/javascript"></script>
	<script type="text/javascript">
		window.onload = function(){   
			var titleId = document.getElementById("titleId");
			var serverId = $("#serverId");
			var pointId = $("#pointId");
			bindServerAndPoint(titleId, serverId, pointId, "bindOpensocialServerAndPointForCharge");
        };
	</script>
</head>

<body>
<!-- ポイントチャージ：開始 -->
<dl class="light_box tspace_n">
	<dt><strong>ポイントチャージ</strong></dt>
	<dd>
		<s:form name="frm_nosubmit_point_select" action="chargeSettleSelect" method="post" cssClass="entry">
			<div style="margin-bottom:30px;text-align:center;">
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
			<table width="95%" align="center">
				<tr>
					<th></th>
					<td>
						<span class="input_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="point_titleId">ゲーム選択：</label></th>
					<td>
						<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName" title="ゲーム"  onchange="bindServerAndPoint(this, serverId, pointId,'bindOpensocialServerAndPointForCharge');" onblur="validate(this,'REQ');" />
						<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span><br/>
						<span class="explain">ポイントをチャージするゲームを選択してください。</span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="point_serverId">サーバ選択：</label></th>
					<td>
						<select id="serverId" name="serverId" title="サーバ" class="big"　style="font-family:'ＭＳ ゴシック';" onblur="validate(this,'REQ');"></select>
						<span id="error_serverId" class="input_error"><s:fielderror><s:param>serverId</s:param></s:fielderror></span><br/>
						<span class="explain">ポイントをチャージするサーバを選択してください。</span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="point_pointId">チャージポイント：</label></th>
					<td>
						<select id="pointId" name="pointId" title="チャージポイント" class="big" onblur="validate(this,'REQ');"></select>
						<span id="error_pointId" class="input_error"><s:fielderror><s:param>pointId</s:param></s:fielderror></span><br/>
						<span class="explain">チャージするポイントを選択してください。</span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token />
				<s:submit value="次へ" cssClass="submit" />
			</div>
		</s:form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->
</body>
</html>