<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:directive.include file="includes/top.jsp" />
	<form:form method="post" id="loginForm" cssClass="fm-v clearfix" commandName="${commandName}" htmlEscape="true" cssStyle="padding:0px;margin:20px 0px;">
		<form:errors path="*" cssClass="errors" element="div" cssStyle="padding:8px;line-height:20px;color:#C00;border:1px solid #CCC;margin:5px 5px 10px 0px;background-color:#FFF6E6;"/><br/>
		<div class="page_main_main">
				<div class="login_area" style="margin-bottom:15px;height:225px;background:url('images/bg_login_auth.jpg');">
					<div style="height:26px;line-height:28px;text-align:right;margin-right:10px;">
						<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/inputPwdReget.html" style="font-size:11px;color:#FFF;">パスワードを忘れた方はこちら ►</a>
					</div>
					<form:input cssClass="required" cssErrorClass="error" id="username" maxlength="20" path="username" autocomplete="false" htmlEscape="true" cssStyle="margin-top:50px;margin-left:145px;width:185px;height:20px;"/><br/>
					<form:password cssClass="required" cssErrorClass="error" id="password" maxlength="20" path="password"  htmlEscape="true" autocomplete="off" cssStyle="margin-top:22px;margin-left:145px;width:185px;height:20px;"/><br/>
					<input type="image" src="images/btn_c_login.gif" style="margin-top:15px;margin-left:145px;"/>
					<a href="javascript:document.getElementById('loginForm').reset();"><img src="images/btn_c_clear.gif" style="margin-top:10px;margin-left:3px;border:0px;"/></a>
					<input type="hidden" name="lt" value="${flowExecutionKey}" />
					<input type="hidden" name="_eventId" value="submit" />
				</div>
				<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/registryMember.html"><img src="images/btn_c_registry.gif"/></a>
				<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/inputInquiry.html"><img src="images/btn_c_inquiry.gif" style="margin-left:5px;"/></a>
			</div>
		<div class="page_main_right">
			<div style="height:5px;background:url('images/bg_bd_t_login_about.gif');"></div>
			<div style="width:573px;height:275px;padding:0px;border-left:1px solid #AAA;border-right:1px solid #AAA;">
				<br/>
				<div style="margin:0px 20px;height:200px;">
					<h3 style="margin:0px;margin-bottom:20px;color:#900;font-size:16px;">ログイン注意事項</h3>
					<p>
					パスワードの入力が一定回数以上を間違えると、アカウントがブロックされますので、ご注意ください。
					</p>
					<p style="line-height:18px;">
					正確なアカウントとパスワードを入力してもログインできない場合は、<br/>
					下記の原因が考えられますので <a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/inputInquiry.html" title="お問合せ">問合せーフォーム</a> により、速やかにご連絡ください。<br/>
					</p>
					<ul style="line-height:18px;">
						<li>パスワードの誤入力回数がシステム制限回数を超えた。</li>
						<li>不正行為と疑われる履歴が見つかり、アカウントを凍結した。</li>
						<li>アカウントが盗難された。</li>
					</ul>
				</div>
			</div>
			<div style="height:5px;background:url('images/bg_bd_b_login_about.gif');"></div>
		</div>
		<div class="clearbox"></div>
	</form:form>
<jsp:directive.include file="includes/bottom.jsp" />
