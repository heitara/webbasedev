<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>サービスポイント利用 </title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/bindMaster.js" type="text/javascript"></script>	<script type="text/javascript">
		window.onload = function(){   
			var titleId = document.getElementById("titleId");
			var serverId = $("#serverId");
			bindServerAndBalance(titleId, serverId);
        };
	</script>
</head>

<body>
<!-- ポイントチャージ：開始 -->
<dl class="light_box tspace_n">
	<dt><strong>サービスポイント利用</strong><span><a href="inputServicePoint.html">► サービスポイント残高照会</a>　<a href="inputUseListServicePoint.html">► サービスポイント利用履歴</a>　<a href="inputGiveListServicePoint.html">► サービスポイント付与履歴</a></span></dt>
	<dd>
		<s:form name="frm_sp_use" action="chargeServicePoint" method="post" cssClass="entry">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="input_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="point_titleId">ゲーム選択：</label></th>
					<td>
						<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName" title="ゲーム"  onchange="bindServerAndBalance(this, serverId);" onblur="validate(this,'REQ');" />
						<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span><br/>
						<span class="explain">ポイントをチャージするゲームを選択してください。</span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="point_serverId">サーバ選択：</label></th>
					<td>
						<select id="serverId" name="serverId" title="サーバ" class="big" onblur="validate(this,'REQ');"></select>
						<span id="error_serverId" class="input_error"><s:fielderror><s:param>serverId</s:param></s:fielderror></span><br/>
						<span class="explain">ポイントをチャージするサーバを選択してください。</span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="point_pointId">チャージポイント：</label></th>
					<td>
						<s:textfield name="pointAmount" maxlength="4" cssClass="ime_mode_n min" title="チャージポイント" onblur="validate(this, 'REQ,NUM');"></s:textfield>
						<span class="explain">※利用可ポイント：  </span><span id="balance" ></span><span class="explain"> PT</span>
						<span id="error_pointAmount" class="input_error"><s:fielderror><s:param>pointAmount</s:param></s:fielderror></span><br/>
						<span class="explain">チャージするポイントを入力してください。</span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token />
				<s:submit value="チャージ" cssClass="submit" />
			</div>
		</s:form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>