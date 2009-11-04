<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>クローズドβテスター応募</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
		<script src="js/portal/common.js" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>クローズドβテスター応募</strong></dt>
			<dd>
				<s:form name="frm_cbt_tester_add" method="post" cssClass="entry">
					<table class="games">
						<s:iterator value="cbtTitleList" id="title" status="st">
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
									<div>
										<s:if test="0==cbtTester">
											<a href="createCBTTester.html?titleId=<s:property value="titleId"/>" title="クローズドβテスター応募"><img src="images/btn_c_cbt.gif" title="クローズドβテスター応募" style="margin-bottom:2px;margin-right:2px;"/></a>
										</s:if>
										<s:else>
											<div style="padding:5px;color:#666;">応募済み</div>
										</s:else>
									</div>
								</td>
							</tr>
							<tr class="space"><td colspan="3"></td></tr>
						</s:iterator>
					</table>
				</s:form>
			</dd>
		</dl>
	</body>
</html>