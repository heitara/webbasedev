<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>退会手続き</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
		function checkCount() {
			var count = 0;
		    var sttlCodes = document.getElementsByName("withdrawReason");
		    for (var i = 0; i < sttlCodes.length; i++) { 
		    	if (sttlCodes[i].checked) {
			    	count++;
		    	}
		    } 
		    if (count < 1) {
			    alert("退会理由を選択してください。");
			    return false;
		    } else {
			    return true;
		    }
		}
	</script>
</head>

<body>
<dl class="light_box tspace_n">
	<dt>
		<strong>退会手続き</strong>
	</dt>
	<dd>
		<s:form name="frm_withdraw" method="post" cssClass="entry">
			<div style="font-size:14px;color:#500;font-weight:bold;">退会される前に、下記の注意事項をご確認ください。</div>
			<ul>
				<li>退会したアカウント及関連データはいかなる場合においても復旧することはできません。</li>
				<li>掲示板の書き込みは、退会されても削除されず、そのまま残ります。</li>
			</ul>
			上記の事項に同意する場合には、アンケートにご回答頂き、、退会ボタンを押してください。<br/>
			<div style="color:#333;border-top:1px dashed #CCC;padding-top:10px;margin-top:10px;">
                <s:checkboxlist name="withdrawReason" list="portalProperties.withdrawReason" ></s:checkboxlist>
				<span id="error_withdrawReason" class="input_error"><s:fielderror><s:param>withdrawReason</s:param></s:fielderror></span>
			</div>
			<div style="color:#666;">
				<p>
				※ご意見、ご要望があれば、書いてください。
				</p>
				<s:textarea name="remarks" rows="15" cssStyle="height:180px;width:500px;" title="内容" onblur="validate(this, 'LEN_0_1000');" />
				<span id="error_remarks" class="input_error"><s:fielderror><s:param>remarks</s:param></s:fielderror></span>
			</div>
			<div class="submit">
				<s:token/>
				<s:submit value="退会" action="createWithDrawInfo" cssClass="submit" onclick="return checkCount();"></s:submit>
			</div>

		</s:form>
	</dd>
</dl>

</body>
</html>