<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="characters">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta content="index, follow" name="robots"/>
	<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
	<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
	<title><s:property value="%{getText('new_mem_tilte')}" /></title>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/mem_login.js" type="text/javascript"></script>
	<SCRIPT type="text/javascript">
		function RefreshImg(){
		}
	</SCRIPT>
</head>

<body>
	<div id="page_main_box">
		<div id="page_main_main">
			<dl class="light_box tspace_n">
				<dt><strong><s:property value="%{getText('new_mem_tilte')}" /></strong><span></span></dt>
				<dd>
					<s:form name="frm_mem_edit" method="POST" cssClass="entry">
						<dl>
							<dt><span class="required">*</span><s:property value="%{getText('mem_id')}" /></dt>
							<dd>
								<s:textfield name="memId" maxlength="20" cssClass="ime_mode_n" />
								<img src="images/icn_check_ok.gif" class="input_check" align="top"/>
								<br/>
								<span class="explain">6～20桁の半角英数字で入力してください。</span>
							</dd>
							
							<dt><span class="required">*</span><s:property value="%{getText('passwd')}" /></dt>
							<dd>
	
								<s:password name="memPwd" maxlength="20" cssClass="ime_mode_n" />
								<img src="images/icn_check_ok.gif" class="input_check" align="top"/>
								<br/>
								<span class="explain">6～20桁の半角英数字で入力してください。</span>
							</dd>
							
							<dt><span class="required">*</span><s:property value="%{getText('confirm_passwd')}" /></dt>
							<dd>
								<s:password name="confirmPwd" maxlength="20" cssClass="ime_mode_n" />
								<img src="images/icn_check_ok.gif" class="input_check" align="top"/>
								<br/>
								<span class="explain">確認のためパスワードを再入力してください。</span>
							</dd>
							
							<dt></dt>
							<dd>&nbsp;</dd>
	
							<dt><span class="required">*</span><s:property value="%{getText('nick_name')}" /></dt>
							<dd>
								<s:textfield name="nickName" maxlength="20" />
								<img src="images/icn_check_ok.gif" class="input_check" align="top"/><br/>
								<span class="explain">全角文字で入力してください。</span>
							</dd>
							
							<dt><span class="required">*</span><s:property value="%{getText('mailPc')}" /></dt>
							<dd>
								<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n" />
								<img src="images/icn_check_ng.gif" class="input_check" align="top"/>
								<span class="check_ng">既に使われているメールアドレスです。</span><br/>
								<span class="explain">メールアドレスを小文字で入力してください。</span>
							</dd>
							
							<dt></dt>
							<dd>&nbsp;</dd>
							
							<dt><span class="required">*</span><s:property value="%{getText('question')}" /></dt>
							<dd>
								<s:select name="questionCd" list="listQuestion" listKey="key" listValue="value" />
							</dd>
							
							<dt><span class="required">*</span><s:property value="%{getText('answer')}" /></dt>
							<dd>
								<s:textfield name="answer" maxlength="20" />
								<span class="explain">2～10桁の全角文字で入力してください。</span>
							</dd>
							
							<dt></dt>
							<dd>&nbsp;</dd>
	
							<dt><span class="required">*</span><s:property value="%{getText('capture')}" /></dt>
							<dd>
								<img src="images/capture.gif"/>
								<img src="images/kaptcha.jpg" onclick="RefreshImg()"/><br/>
								<s:textfield name="kaptcha" maxlength="6"  cssClass="ime_mode_n" />
								<br/>
								<span class="explain">画像認証コードを入力してください。</span>
							</dd>
							
							<dt></dt>
							<dd>&nbsp;</dd>
	
							<dt></dt>
							<dd>
								<s:checkbox name="magazine" value="0"/>
								<s:property value="%{getText('magazine1')}" />
							</dd>
								
							<dt></dt>
							<dd>
								<s:checkbox name="agreement" value="0"/>
								<s:property value="%{getText('magazine2')}" />
								(<a href="#" class="agreement">利用規約</a> )
							</dd>
							<dt></dt>
							<dd></dd>
						</dl>
						<div class="submit">
							<s:submit action="createMember" formId="frm_mem_edit" value="%{getText('submit')}"></s:submit>
							<s:reset action="createMember" value="%{getText('clear')}"></s:reset>
						</div>
					</s:form>
				</dd>
			</dl>
		</div>
	</div>
</body>

</html>
</s:i18n>