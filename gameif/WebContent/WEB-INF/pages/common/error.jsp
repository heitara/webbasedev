<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%! static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("Error");%>
<%
if (exception != null) {
	
	logger.error(exception.getMessage(), exception);
}
%>
<div>
エラーが発生しました。<br />同じ現象が何度も繰り返す場合、サイト運営者に連絡してください。
</div>