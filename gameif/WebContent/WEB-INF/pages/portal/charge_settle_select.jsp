<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<title>ポイントチャージ | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/bindMaster.js" type="text/javascript"></script>
</head>

<body>
<!-- ポイントチャージ：開始 -->
<dl class="light_box tspace_n">
	<dt><strong>ポイントチャージ</strong><span><a href="#">► サービスポイント使用</a>　<a href="#">► チャージ履歴</a></span></dt>
	<dd>
		<s:form name="frm_settle_select" method="post" cssClass="entry">
			<div style="margin-bottom:30px;text-align:center;">
					<img src="images/point_flow_10.gif"/>
					<img src="images/point_flow_00.gif"/>
	
					<img src="images/point_flow_21.gif"/>
					<img src="images/point_flow_00.gif"/>
					<img src="images/point_flow_30.gif"/>
					<img src="images/point_flow_00.gif"/>
					<img src="images/point_flow_40.gif"/>0
					<img src="images/point_flow_00.gif"/>
					<img src="images/point_flow_50.gif"/>
			</div>
			
			<table align="center">
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
				<s:submit value="次へ" action="chargeSaveSettleTrns" cssClass="submit" />
				<s:submit value="戻る" action="chargePointSelect" cssClass="submit" />
			</div>
		</s:form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>