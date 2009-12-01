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
			<div style="padding:0px 10px 30px 0px;font-size:12px;color:#555;">
				退会される前に、下記の注意事項をよくお読みください。<br/><br/>
				<p style="color:#600;line-height:20px;margin:15px">
				こちらで退会されたアカウントは、復旧することはできませんので、ご注意ください。<br/>
				掲示板なとの書き込みにつきましては、退会されましても削除されずに残りますので、ご注意ください。<br/>
				 退会されますと、ご利用されていた各ゲームのデータ（残高、キャラクターやアイテム等）の復旧等につきましてはいかなる場合においても対応いたしかねますので、ご注意ください。<br/><br/>
				</p>
				上記の事項にご同意頂けます場合には、アンケートにご回答いただき、退会ボタンを押してください。<br/>
			</div>
			<div style="color:#666;border-top:1px dashed #CCC;">
                <s:checkboxlist name="withdrawReason" list="portalProperties.withdrawReason" ></s:checkboxlist>
				<span id="error_withdrawReason" class="input_error"><s:fielderror><s:param>withdrawReason</s:param></s:fielderror></span>
			</div>
			<div style="color:#666;">
				<p>
				※ご意見、ご要望があれば、お書きください。
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