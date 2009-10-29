<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:directive.include file="includes/top.jsp" />
	<div style="height:450px;">
		<div class="errors">
			<h2><spring:message code="screen.service.sso.error.header" /></h2>
			<p><spring:message code="screen.service.sso.error.message"  arguments="${fn:escapeXml(request.requestURI)}" /></p>
		</div>
	</div>
<jsp:directive.include file="includes/bottom.jsp" />