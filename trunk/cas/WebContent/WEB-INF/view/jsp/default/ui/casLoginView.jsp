<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:directive.include file="includes/top.jsp" />
	<form:form method="post" id="loginForm" cssClass="fm-v clearfix" commandName="${commandName}" htmlEscape="true" cssStyle="padding:0px;margin:20px 0px;">
		<form:errors path="*" cssClass="errors" element="div" cssStyle="padding:8px;line-height:20px;color:#C00;border:1px solid #CCC;margin:5px 5px 10px 0px;background-color:#FFF6E6;"/><br/>
		<table width="980" cellpadding="0" cellspacing="10" border="0" align="center">
			<tr valign="top">
				<td width="380">
					<div class="login_area" style="margin-bottom:15px;height:225px;background:url('images/bg_login_auth.jpg');">
						<div style="height:26px;line-height:28px;text-align:right;margin-right:10px;">
							<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/inputPwdReget.html" style="font-size:11px;color:#FFF;">パスワードを忘れた方はこちら ►</a>
						</div>
						<form:input cssClass="required ime_mode_n" cssErrorClass="error ime_mode_n" id="username" maxlength="20" path="username" autocomplete="false" htmlEscape="true" cssStyle="margin-top:50px;margin-left:145px;width:185px;height:20px;"/><br/>
						<form:password cssClass="required ime_mode_n" cssErrorClass="error ime_mode_n" id="password" maxlength="20" path="password"  htmlEscape="true" autocomplete="off" cssStyle="margin-top:22px;margin-left:145px;width:185px;height:20px;"/><br/>
						<input type="image" src="images/btn_c_login.gif" style="margin-top:15px;margin-left:145px;"/>
						<a href="javascript:document.getElementById('loginForm').reset();"><img src="images/btn_c_clear.gif" style="margin-top:10px;margin-left:3px;border:0px;"/></a>
						<input type="hidden" name="lt" value="${flowExecutionKey}" />
						<input type="hidden" name="_eventId" value="submit" />
					</div>
					<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/registryMember.html"><img src="images/btn_c_registry.gif"/></a>
					<a href="<%=getServletContext().getInitParameter("portalTopUrl")%>/inputInquiry.html"><img src="images/btn_c_inquiry.gif" style="margin-left:5px;"/></a>
				</td>
				<td>
					<a href="openIDSelect?_eventId=submit&op=Yahoo&<%if(request.getQueryString() != null) { out.print(request.getQueryString()); }%>" title="Yahoo! JAPAN IDでログイン">
						<img src="images/btn_c_openid_yahoo.gif" width="150" height="30" alt="Yahoo! JAPAN IDでログイン" border="0"/>
					</a><br/>
					<a href="openIDSelect?_eventId=submit&op=Mixi&<%if(request.getQueryString() != null) { out.print(request.getQueryString()); }%>" title="Mixi　IDでログイン">
						<img src="images/btn_c_openid_mixi.gif" width="150" alt="Mixi　IDでログイン" border="0"/>
					</a><br/>
					<a href="openIDSelect?_eventId=submit&op=Google&<%if(request.getQueryString() != null) { out.print(request.getQueryString()); }%>" title="Google　IDでログイン">
						<img src="images/btn_c_openid_google.gif" width="150" alt="Google　IDでログイン" border="0"/>
					</a><br/>
					<a href="openIDSelect?_eventId=submit&op=Excite&<%if(request.getQueryString() != null) { out.print(request.getQueryString()); }%>" title="Excite　IDでログイン">
						<img src="images/btn_c_openid_excite.gif" width="150" alt="Excite　IDでログイン" border="0"/>
					</a><br/>
					<a href="openIDSelect?_eventId=submit&op=Biglobe&<%if(request.getQueryString() != null) { out.print(request.getQueryString()); }%>" title="Biglobe　IDでログイン">
						<img src="images/btn_c_openid_biglobe.gif" width="150" alt="Biglobe　IDでログイン" border="0"/>
					</a>
				</td>
				<td>
					<div style="padding:12px;margin:0px;height:260px;border:1px solid #CCC;font-family:'Arial','Courier','ＭＳ Ｐゴシック',monospace;">
						<div style="font-size:13px;font-weight:bold;color:#900;">
							ゲームイフにはOpenIDでログインすることができます。
						</div>
						<div style="margin:10px 24px 15px 24px;">
							Yahoo、Mixi、Google、ExciteのIDをお持ちの方は会員登録をする必要がなく、そちらのIDでゲームイフにログインして、
							ゲームイフの全てのサービスを利用することができます。
						</div>
						<div style="font-size:13px;font-weight:bold;color:#900;">
							ゲームイフのアカウントとパスワードでログインできない場合は、<br/>下記の原因が考えられます。
						</div>
						<ul style="line-height:18px;">
							<li>アカウントIDとパスワードを間違えている。</li>
							<li>アカウントが有効化されていない。</li>
							<li>パスワードの誤入力回数がシステム制限回数を超えている。</li>
							<li>不正行為と疑われる履歴が見つかり、凍結された。</li>
							<li>アカウントが盗難された。</li>
						</ul>
						詳しくは「<a href="<%=getServletContext().getInitParameter("portalNewsTopUrl")%>/component/content/article/11-faq" title="よくある質問">よくある質問</a>」をご確認ください。
					</div>
				
				</td>
			</tr>
		</table><br/><br/><br/><br/><br/>
	</form:form>
<jsp:directive.include file="includes/bottom.jsp" />
