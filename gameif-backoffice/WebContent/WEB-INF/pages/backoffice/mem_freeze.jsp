<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>会員凍結</title>
	<script src="js/validate.js" type="text/javascript"></script>
	<script src="js/common.js" type="text/javascript"></script>
</head>
<body>
	<dl class="light_box tspace_n">
		<dt><strong>会員凍結</strong></dt>
		<dd>
		<s:form name="frm_mem_freeze" method="post" cssClass="entry">
			<table class="form">
				<tr>
					<th></th>
					<td>
						<span class="logic_error"><s:fielderror><s:param>errMessage</s:param></s:fielderror></span><br/>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="give_memId">アカウントID：</label></th>
					<td>
						<s:textarea name="memId" cssClass="ime_mode_y" title="アカウントID" cssStyle="width:300px;height:200px" onblur="validate(this, 'REQ');"/><br/>
						<span class="explain">(複数のアカウントIDを入力する場合、コンマで区切ってください。)</span>
						<span id="error_memId" class="input_error"><s:fielderror><s:param>memId</s:param></s:fielderror></span>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:token/>
				<s:submit value="一括凍結" action="freezeMemberInfo"/>
			</div>
		</s:form>
		</dd>
	</dl>
</body>
</html>