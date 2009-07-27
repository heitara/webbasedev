<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="header">
<p>Welcome to GAME-IF</p>
<div>
	<ul>
		<li>
			<s:url id="create" action="createMenu" /> <s:a
				href="%{create}">
				<s:property value="%{getText('mem_new_tilte')}" />
				</s:a>
		</li>
		<li>
			<s:url id="inquiry" action="inquiryMenu" /> <s:a
				href="%{inquiry}">
				<s:property value="%{getText('inquiry_input_title')}" />
				</s:a>
		</li>
	</ul>
</div>
</div>