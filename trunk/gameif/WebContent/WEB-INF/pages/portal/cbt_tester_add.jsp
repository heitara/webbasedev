<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>クローズドβテスター募集</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
		<script src="js/portal/common.js" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>クローズドβテスター募集</strong></dt>
			<dd>
				<s:form name="frm_cbt_tester_add" method="post" cssClass="entry">
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
								<span class="explain">ただいま、クローズドβテスター募集が開催されています。<br/>応募したい方は下のゲームを選択してから、「応募」をクリックしてください。</span><br/>
							</td>
						</tr>	
						<tr>
							<th><span class="required">*</span><label for="game">ゲーム：</label></th>
							<td>
								<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.cbtTitleList" listKey="titleId" listValue="titleName" title="ゲーム" onblur="validate(this,'REQ');" />
								<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span><br/>
							</td>
						</tr>	
						<tr>
							<th></th>
							<td>
								<s:submit value="応募" cssClass="submit" action="createCBTTester"></s:submit>
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