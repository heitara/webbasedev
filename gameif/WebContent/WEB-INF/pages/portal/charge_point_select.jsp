<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<title>ポイントチャージ | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/bindMaster.js" type="text/javascript"></script>	<script type="text/javascript">
		window.onload = function(){   
			var titleId = document.getElementById("titleId");
			var serverId = $("#serverId");
			var pointId = $("#pointId");
			bindServerAndPoint(titleId, serverId, pointId);
        };
	</script>
</head>

<body>
<!-- ポイントチャージ：開始 -->
<dl class="light_box tspace_n">
	<dt><strong>ポイントチャージ</strong><span><a href="inputGetServicePoint.html">► サービスポイント受取</a>　<a href="#">► サービスポイント使用</a>　<a href="#">► チャージ履歴</a></span></dt>
	<dd>
		<s:form name="frm_nosubmit_point_select" action="chargeSettleSelectInit" method="post" cssClass="entry">
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
						<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName" title="ゲーム"  onchange="bindServerAndPoint(this, serverId, pointId);" onblur="validate(this,'REQ');" />
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