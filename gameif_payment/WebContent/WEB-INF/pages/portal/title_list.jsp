<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>ゲーム</title>
<style type="text/css">
div.game_play {
	padding-top:2px;
	width:180px;
	height:20px;
	background:url(images/btn_c_play.gif) no-repeat;
}
div.game_play a {
	display:block;
	margin:0px 10px;
	color:#FFF;
	font-weight:bold;
}
div.game_play a.new {
	color:#FC3;
}
div.game_play a:hover {
	margin-left:15px;
}
div.game_maintenance {
	padding-top:2px;
	width:180px;
	height:20px;
}
div.game_maintenance a {
	display:block;
	margin:0px 10px;
	color:#666;
}
div.start_ymd {
	margin:0px 0px 10px 10px;
}
</style>
</head>
<body>	
<dl class="light_box tspace_n">
	<dt><strong>ゲーム</strong><span><!-- <a href="#">► マイゲーム</a> -->&nbsp;</span></dt>
	<dd>
		<table class="games">
			<s:iterator value="titles" id="title" status="st">
			<tr>
				<td class="sidecell"><a href="<s:property value="siteUrl"/>" title="<s:property value="titleName"/>の公式サイトへ"><img src="<s:property value="bigIconUrl"/>"/></a></td>
				<td>
					<div class="g_menu">
						<a href="<s:property value="siteUrl"/>" title="公式サイト">公式サイト</a><a href="<s:property value="forumUrl"/>" title="掲示板">掲示板</a><a href="<s:property value="paymentUrl"/>" title="ポイントチャージ">ポイントチャージ</a><a href="inputInvite.html?titleId=<s:property value="titleId"/>" title="友達にこのゲームを紹介する">友達に紹介</a>
					</div>
					<div class="g_title"><s:property value="titleName"/>
					<s:if test='"0".equals(serviceStatus)'>
						<span>
						（ メンテナンス中 ）
						</span>				
					</s:if>
					<s:if test='"2".equals(serviceStatus)'>
						<span>
						（ クローズβテスト
							<s:if test='"1".equals(recruitStatus)'>
								募集中
							</s:if>
							<s:elseif test='("0".equals(recruitStatus) || "2".equals(recruitStatus) || "3".equals(recruitStatus))'>
								実施中
							</s:elseif>
							）
						</span>				
					</s:if>
					<s:elseif test='"3".equals(serviceStatus)'>
						<span>
						（オープンβテスト
							<s:if test='"1".equals(recruitStatus)'>
								募集中
							</s:if>
							<s:elseif test='("0".equals(recruitStatus) || "2".equals(recruitStatus) || "3".equals(recruitStatus))'>
								実施中
							</s:elseif>
							）
						</span>
					</s:elseif>
					</div>
					<div class="g_about" style="overflow:hidden;"><s:property value="titleAbout"/></div>
					<div class="g_announce"><s:property value="announce"/></div>
				</td>
				<td class="sidecell">					
					<s:if test='"0".equals(serviceStatus)'>
						<div class="play_info">ただいまメンテナンス中です。</div>
					</s:if>
					<s:elseif test='"2".equals(serviceStatus) || "3".equals(serviceStatus)'>								
						<s:if test='"0".equals(recruitStatus) || (("2".equals(recruitStatus) || "3".equals(recruitStatus)) && "1".equals(electStatus))'>
							<s:iterator value="serverMap.get(#title.titleId)" id="server" status="st">
								<s:if test='"0".equals(serviceStatus)'>
									<div class="game_maintenance">
										<a href="<s:property value="playUrl"/>?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>" title="このサーバはただいま、メンテナンスしております。" onclick="return false;"><s:property value="serverName"/>(メンテ中)</a>
									</div>
								</s:if>
								<s:else>
									<div class="game_play">
										<a href="playGame.html?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>" title="サーバ「<s:property value="serverName"/>」でプレイ！" class="<s:if test='"1".equals(recommend)'>new</s:if>" ><s:property value="serverName" escape="false"/></a>
									</div>
								</s:else>
								<div class="start_ymd"><s:property value="serviceStartYmd"/> ～</div>
							</s:iterator>
						</s:if>
						<s:if test='"1".equals(recruitStatus)'>
							<s:if test='electStatus == null'>
								<a href="applyBetaTester.html?titleId=<s:property value="titleId"/>&status=<s:property value="serviceStatus"/>" title="テスターに応募"><img src="images/btn_c_apply_tester.gif" alt="テスターに応募"/></a>
							</s:if>
							<s:elseif test='"1".equals(electStatus)'>
								<div class="play_info">テスターに当選されました。</div>
								<p>ご協力宜しくお願いします。</p>
							</s:elseif>
							<s:else>
								<div class="play_info">テスターに応募済です。</div>
								<p>承認されるまで、<br/>しばらくお待ちください。</p>
							</s:else>
						</s:if>
						<s:if test='"2".equals(recruitStatus)'>
							<s:if test='electStatus == null'>
								<a href="applyBetaTester.html?titleId=<s:property value="titleId"/>&status=<s:property value="serviceStatus"/>" title="テスターに応募"><img src="images/btn_c_apply_tester.gif" alt="テスターに応募"/></a>
							</s:if>
							<s:elseif test='"0".equals(electStatus)'>
								<div class="play_info">テスターに応募済です。</div>
								<p>まだ承認されていません。<br/>しばらくお待ちください。</p>
							</s:elseif>
						</s:if>
						<s:if test='"3".equals(recruitStatus)'>
							<s:if test='electStatus == null'>
								<div class="play_info">テスター募集が終了しました。</div>
							</s:if>
							<s:if test='"0".equals(electStatus)'>
								<p>残念ながら、あなたは<br/>テスター当選に至りませんでした。</p><p>ご協力ありがとうございました。</p>
							</s:if>
						</s:if>
					</s:elseif>
					<s:else>
						<s:iterator value="serverMap.get(#title.titleId)" id="server" status="st">
							<s:if test='"0".equals(serviceStatus)'>
								<div class="game_maintenance">
									<a href="<s:property value="playUrl"/>?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>" title="このサーバはただいま、メンテナンスしております。" onclick="return false;"><s:property value="serverName"/>(メンテ中)</a>
								</div>
							</s:if>
							<s:else>
								<div class="game_play">
									<a href="playGame.html?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>" title="サーバ「<s:property value="serverName"/>」でプレイ！" class="<s:if test='"1".equals(recommend)'>new</s:if>" ><s:property value="serverName" escape="false"/></a>
								</div>
							</s:else>
							<div class="start_ymd"><s:property value="serviceStartYmd"/> ～</div>
						</s:iterator>
					</s:else>
					<s:if test="testUser">
						<select style="width:180px;margin:10px 0px; font-size:12px;" onchange="if(this.selectedIndex > 0) location = this.options[this.selectedIndex].value;">
							<option value="">テストプレイ（サーバ選択）</option>
							<s:iterator value="serverMap.get(#title.titleId)" id="server" status="st">
								<option value="playGame.html?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>"><s:property value="serverName"/></option>
							</s:iterator>
						</select>
					</s:if>
				</td>
			</tr>
			<tr class="space"><td colspan="3"></td></tr>
			</s:iterator>
		</table>
	</dd>
</dl>
</body>
</html>