<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>チケット付与</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script src="js/common.js" type="text/javascript"></script>
	<script src="js/bindMaster.js" type="text/javascript"></script><script type="text/javascript">
		window.onload = function(){   
			var titleId = document.getElementById("titleId");
			var ticketId = $("#ticketId");
			bindTicket(titleId, ticketId);
        };

        function changeGiveType(obj) {
            if (obj.value == "1") {
                document.getElementById("trMemNum").style.visibility="";
                document.getElementById("trMemId").style.visibility="hidden";
            } else if (obj.value == "2") {
                document.getElementById("trMemNum").style.visibility="hidden";
                document.getElementById("trMemId").style.visibility="";
            }
        }
	</script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>チケット付与</strong></dt>
		<dd>
		<s:form  name="frm_give_ticket" action="giveTicket" cssClass="entry">
			<table class="form">
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="give_titleId">ゲーム選択：</label></th>
					<td>
						<s:select name="titleId" id="titleId" cssClass="big" list="masterInfoBusinessLogic.validTitleList" listKey="titleId" listValue="titleName" title="ゲーム"  onchange="bindTicket(this, ticketId);" onblur="validate(this,'REQ');" />
						<span id="error_titleId" class="input_error"><s:fielderror><s:param>titleId</s:param></s:fielderror></span><br/>
						<span class="explain">付与するゲームを選択してください。</span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="give_ticketId">チケット選択：</label></th>
					<td>
						<select id="ticketId" name="ticketId" title="チケット" class="big" onblur="validate(this,'REQ');"></select>
						<span id="error_ticketId" class="input_error"><s:fielderror><s:param>ticketId</s:param></s:fielderror></span><br/>
						<span class="explain">付与するチケットを選択してください。</span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="give_ticketTypeCd">チケット種別：</label></th>
					<td>
						<s:select name="ticketTypeCd" cssClass="big" list="backOfficeProperties.ticketTypeCd" headerKey="0" headerValue="" title="チケット種別" onblur="validate(this,'REQ');" />
						<span id="error_ticketTypeCd" class="input_error"><s:fielderror><s:param>ticketTypeCd</s:param></s:fielderror></span><br/>
						<span class="explain">チケット種別を選択してください。</span>
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><span class="required">*</span><label for="give_ticketCount">枚数：</label></th>
					<td>
						<s:textfield name="ticketCount" maxlength="2" cssClass="ime_mode_n min" title="枚数" onblur="validate(this, 'REQ,NUM');"/><label>枚</label>
						<span class="explain">※ 半角数字で入力してください。</span>
						<span id="error_ticketCount" class="input_error"><s:fielderror><s:param>ticketCount</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><span class="required">*</span><label for="give_giveType">区別：</label></th>
					<td>
						<select name="giveType" id="giveType" onchange="changeGiveType(this)">
							<option value=1 selected="selected">会員番号でチケットを付与</option>
							<option value=2 >アカウントIDでチケットを付与</option>
						</select>
					</td>
				</tr>
				<tr id="trMemNum">
					<th><span class="required">*</span><label for="give_memNumList">会員番号：</label></th>
					<td>
						<s:textarea name="memNumList" cssClass="ime_mode_y" title="会員番号" cssStyle="width:350px;height:300px" onblur="validate(this, 'REQ');"/><br/>
						<span class="explain">(複数の会員番号を入力する場合、コンマで区切ってください。)</span>
						<span id="error_memNumList" class="input_error"><s:fielderror><s:param>memNumList</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr id="trMemId" style="visibility:hidden">
					<th><span class="required">*</span><label for="give_memId">アカウントID：</label></th>
					<td>
						<s:textarea name="memId" cssClass="ime_mode_y" title="アカウントID" cssStyle="width:350px;height:300px" onblur="validate(this, 'REQ');"/><br/>
						<span class="explain">(複数のアカウントIDを入力する場合、コンマで区切ってください。)</span>
						<span id="error_memId" class="input_error"><s:fielderror><s:param>memId</s:param></s:fielderror></span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token/>
				<s:submit value="付与"/>
				<s:submit value="クリア" onclick="this.form.reset();return false;"/>
			</div>
		</s:form>
		</dd>
	</dl>
</body>
</html>