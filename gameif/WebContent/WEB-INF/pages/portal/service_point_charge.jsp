<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>サービスポイント利用 </title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/bindMaster.js" type="text/javascript"></script>	
	<script type="text/javascript">
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
	<dt><strong>サービスポイント利用</strong><span><a href="inputChargeServicePoint.html">► サービスポイント利用</a>　<a href="inputUseListServicePoint.html">► サービスポイント利用履歴</a>　<a href="inputGiveListServicePoint.html">► サービスポイント獲得履歴</a></span></dt>
	<dd>
		<h3 style="color:#F60;margin:20px 0px 10px 0px;">サービスポイントを使ってゲーム内GPを購入しましょう！</h3>
		<div style="margin:10px 0px;padding:7px 10px;font-size:10px;border:1px solid #EEE;background-color:#F6F6F6;line-height:18px;">
			購入前に対象タイトルのサービスポイント残高を確認してください。<br/>
			サービスポイントで購入したゲーム内GPでは、ゲーム内取引を行うことができませんのでご注意ください。
		</div>
		<table width="100%" align="center" cellspacing="1" cellpadding="5" border="0" style="background-color:#FFF;margin-top:10px;border:1px solid #DDD;">
			<tr align="center" bgcolor="#999" style="background-color:#666;color:#FFF;">
				<td>対象タイトル</td>
				<td>サービスポイント残高</td>
				<td>有効期限</td>
			</tr>
			<s:iterator value="servicePointList" id="servicePointList">
				<tr align="center">
					<td>
						<s:if test="titleName != null">
							<s:property value="titleName"/>
						</s:if>
						<s:else>
							<span>-</span>
						</s:else>
					</td>
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
		<s:form name="frm_sp_use" action="useServicePoint" method="post" cssClass="entry" cssStyle="margin:0px;">
			<table>
				<tr>
					<th></th>
					<td>
						<span class="logic_error" style="font-size:12px;"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
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
						<s:textfield name="pointAmount" maxlength="6" cssClass="ime_mode_n big" title="チャージポイント" onblur="validate(this, 'REQ,NUM');"></s:textfield>
						<span id="error_pointAmount" class="input_error"><s:fielderror><s:param>pointAmount</s:param></s:fielderror></span><br/>
						<span class="explain">チャージするポイントを入力してください。</span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token />
				<s:submit value="ゲーム内ポイント購入" cssClass="submit" cssStyle="width:180px;"/>
			</div>
		</s:form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>