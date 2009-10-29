<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
	<head>	
		<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
		<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
		<title>ゲーム</title>
	</head>
	<body>
	
<dl class="light_box tspace_n">
	<dt><strong>ゲーム</strong><span><a href="#">► マイゲーム</a></span></dt>
	<dd>
		<table class="games">
			<s:iterator value="titles" id="title" status="st">
			<tr>
				<td class="sidecell"><a href="<s:property value="siteUrl"/>" title="<s:property value="titleName"/>の公式サイトへ"><img src="<s:property value="bigIconUrl"/>"/></a></td>
				<td>
					<div class="g_menu">
						<a href="<s:property value="siteUrl"/>" title="公式サイト">公式サイト</a><a href="<s:property value="forumUrl"/>" title="掲示板">掲示板</a><a href="<s:property value="chargeUrl"/>" title="ポイントチャージ">ポイントチャージ</a><a href="inputInvite.html?titleId=<s:property value="titleId"/>" title="友達にこのゲームを紹介する">友達紹介</a>
					</div>
					<div class="g_title"><s:property value="titleName"/></div>
					<div class="g_about" style="overflow:hidden;"><s:property value="titleAbout"/></div>
					<div class="g_announce"><s:property value="announce"/></div>
				</td>
				<td class="sidecell">
					<dl class="warm_box">
						<dt><strong>ゲームプレイ</strong><span></span></dt>
						<dd>
							<div class="g_servers">
								<s:if test='"0".equals(serviceStatus)'>
									<div style="padding:5px;color:#666;">このタイトルは、ただいま<br/>メンテナンスしております。</div>
								</s:if>
								<!-- CBTチェック -->
								<s:elseif test='"5".equals(serviceStatus)'>
									<s:if test="0==cbtTester">
										<div style="padding:5px;color:#666;">CBTテスターではないため<br/>プレイできません。</div>
									</s:if>
									<s:else>
										<s:iterator value="serverMap.get(#title.titleId)" id="server" status="st">
											<s:if test='"0".equals(serviceStatus)'>
												<a href="<s:property value="playUrl"/>?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>" style="background-color:#666;color:#DDD;" title="このサーバはただいま、メンテナンスしております。" onclick="return false;">S0<s:property value="serverId"/>: <s:property value="serverName"/>(メンテ中)</a>
											</s:if>
											<s:else>
												<a href="<s:property value="playUrl"/>?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>" title="第<s:property value="serverId"/>サーバ「<s:property value="serverName"/>」で「<s:property value="titleName"/>」をプレイする。">S0<s:property value="serverId"/>: <s:property value="serverName"/></a>
											</s:else>									
										</s:iterator>
									</s:else>
								</s:elseif>
								<s:else>
									<s:iterator value="serverMap.get(#title.titleId)" id="server" status="st">
										<s:if test='"0".equals(serviceStatus)'>
											<a href="<s:property value="playUrl"/>?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>" style="background-color:#666;color:#DDD;" title="このサーバはただいま、メンテナンスしております。" onclick="return false;">S0<s:property value="serverId"/>: <s:property value="serverName"/>(メンテ中)</a>
										</s:if>
										<s:else>
											<a href="<s:property value="playUrl"/>?serverId=<s:property value="serverId"/>&titleId=<s:property value="titleId"/>" title="第<s:property value="serverId"/>サーバ「<s:property value="serverName"/>」で「<s:property value="titleName"/>」をプレイする。">S0<s:property value="serverId"/>: <s:property value="serverName"/></a>
										</s:else>									
									</s:iterator>								
								</s:else>
							</div>
						</dd>
					</dl>
				</td>
			</tr>
			<tr class="space"><td colspan="3"></td></tr>
			</s:iterator>
		</table>
	</dd>
</dl>
</body>
</html>