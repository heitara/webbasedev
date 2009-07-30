<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><s:property value="%{getText('mem_new_tilte')}" /></title>
	<link rel="stylesheet" type="text/css" media="screen" href="css/common/screen.css" />
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/mem_login.js" type="text/javascript"></script>
	<s:include value="../common/header.jsp"></s:include>
</head>

<body>
	<div class="contents">
		<s:form name="frm_mem_edit" method="POST">
			<table>
				<tr>
					<td><s:property value="%{getText('mem_id')}" /></td>
					<td><s:property value="memId" /></td>
				</tr>
				<tr>
					<td><s:property value="%{getText('mail_address')}" /></td>
					<td><s:textfield name="mailPc" /></td>
				</tr>
				<tr>
					
				</tr>
				<tr>
					<td/>
					<td>
						<s:submit action="updateMember" formId="frm_mem_edit" value="%{getText('submit')}"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
</body>

<s:include value="../common/footer.jsp"></s:include>

</html>