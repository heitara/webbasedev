<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>サービスポイント受取</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
		<script src="js/portal/bindMaster.js" type="text/javascript"></script>
		<script src="js/portal/common.js" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>サービスポイント受取</strong><span><a href="">► サービスポイント受取履歴</a></span></dt>
			<dd>
				<s:form name="frm_service_point" method="post" cssClass="entry">
					<table>
						<tr>
							<th></th>
							<td>
								<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
							</td>
						</tr>
						<tr>
							<th></th>
							<td>
								<span class="explain">連続してゲームにログインした場合、サービスポイントがもらえる。</span><br/>
							</td>
						</tr>	
						<tr>
							<th><span class="required">*</span><label for="game">ゲーム：</label></th>
							<td>
								<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName"  headerKey="0" headerValue="" title="ゲーム" onblur="validate(this,'REQ');" />
								<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span><br/>
							</td>
						</tr>	
						<tr>
							<th></th>
							<td>
								<s:submit value="ポイント受取" cssClass="submit" action="getGameLoginServicePoint"></s:submit>
							</td>
						</tr>	
						<tr class="space_row">
							<td colspan="2"></td>
						</tr>
					</table>
				</s:form>
			</dd>
		</dl>
	</body>
</html>