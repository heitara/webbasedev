$("document").ready(
	function() {
		$("input[@type='text'],input[@type='password'],textarea").focus(
			function() {
				$(this).addClass("focuscolor").blur(
					function() {
						$(this).removeClass("focuscolor");
					}
				);
			}
		);
	}
);

$("document").ready(
	function() {
		$("form").submit(
			function() {				
				var submitOk = false;
				var errs = "";
				$("input,textarea,select").trigger("blur");				
				$("span.input_error").each(
					function() {
						errs += $(this).html();
					}
				);
				if (errs.length < 1) {					
					if (!window.isSubmited && confirm("送信します。よろしいですか？")) {
						window.isSubmited = true;
						submitOk = true;
					}
				}
				return submitOk;
			}
		);
	}
);

function getErrorMsbBox(field) {

	var fns = field.name.split(".");
	var fname = fns[fns.length - 1];
	
	return $("#error_" + fname);
}

function addFieldError(field, message) {
	
	getErrorMsbBox(field).empty()
		.css("display","block")
		.css("padding-top","2px");
	getErrorMsbBox(field).append(message);
}

function clearFieldError(field) {
	
	getErrorMsbBox(field).empty().css("display","inline");
}

function validate_required(field) {

	var result = false;
	switch (field.type) {
		case "text":
		case "textarea":
		case "password":
			result = field.value != null && (field.value == "" || field.value.replace(/^\s+|\s+$/g,"").length == 0);
			break;
		case "checkbox":
			result = !field.checked;
			break;
		case "radio":
			var selected = false;
			var objarr = document.getElementsByName(field.name);
			for(var i = 0; i < objarr.length; i++) {
				if (objarr[i].checked) {
					selected = true;
					break;
				}
			}
			result = !selected;
			break;
		case "select-one":
			result = field.selectedIndex == 0;
			break;
	}

	return result;
}
function validate_length(field, minLenth, maxLength) {

	return (field.value != null && field.value.length > 0 && !field.value.match("(.{" + minLenth + "," + maxLength + "})"));
}
function validate_numeric(field) {

	return (field.value != null && field.value.length > 0 && !field.value.match("(^[0-9]+$)"));
}
function validate_alphaNumeric(field) {

	return (field.value != null && field.value.length > 0 && !field.value.match("(^[a-zA-Z0-9]+$)"));
}

function validate_email(field) {

	return (field.value != null && field.value.length > 0 && field.value.match(/\b(^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/gi)==null);
}

function validate_zenkaku(field) {

	return (field.value != null && field.value.length > 0 && !field.value.match("(^[^ -~｡-ﾟ]+$)"));
}

function validate_kanji(field) {

	return (field.value != null && field.value.length > 0 && !field.value.match("(^[一-龠]+$)"));
}

function validate_katakana(field) {

	return (field.value != null && field.value.length > 0 && !field.value.match("(^[ァ-ヶ]+$)"));
}

function validate_kigouigai(field) {

	return (field.value != null && field.value.length > 0 && !field.value.match("(^[a-zA-Z0-9｡-ﾟぁ-ゞァ-ヶ一-龠Ａ-Ｚａ-ｚ]+$)"));
}

function validate_exist_id(field) {
	$.get("checkAccountExist.html", {target: field.value}, function(data) {
			var result = eval("(" + data + ")").result;
			if(result > 0) {
				addFieldError(field, "入力された" + field.title + "は既に使われています。 ");
			} else {
				clearFieldError(field); 
			}
		}
	);
}

function validate_exist_nickname(field) {
	$.get("checkNickNameExist.html", {target: field.value}, function(data) {
		var result = eval("(" + data + ")").result;
		if(result > 0) {
				addFieldError(field, "入力された" + field.title + "は既に使われています。 ");
			} else {
				clearFieldError(field); 
			}
		}
	);
}

function validate_exist_email(field) {
	$.get("checkEmailExist.html", {target: field.value}, function(data) {
			var result = eval("(" + data + ")").result;
			if(result > 0) {
				addFieldError(field, "入力された" + field.title + "は既に使われています。 ");
			} else {
				clearFieldError(field); 
			}
		}
	);
}

function validate(field, patterns) {

	var ptrnarr = patterns.split(",");
	var hasError = false;

	for (var i = 0; i < ptrnarr.length; i++) {

		var pt = ptrnarr[i].split("_");

		switch(jQuery.trim(pt[0])) {
		case "REQ":
			//必須チェック
			if (!hasError && validate_required(field)) {
				var optName = null;
				if (field.type == "text" || field.type == "textarea" || field.type == "password") {
					optName = "入力";
				} else {
					optName = "選択";
				}
				addFieldError(field, field.title + "を" + optName + "してください。");
				hasError = true;
			};
			break;
		case "LEN":
			//桁数チェック（最小桁数と最大桁数指定が必須）
			if (!hasError && validate_length(field, pt[1], pt[2])) {
				addFieldError(field, field.title + "は" + pt[1] + "～" + pt[2] + "桁で入力してください。");
				hasError = true;
			}
			break;
		case "NUM":
			//半角数字チェック
			if (!hasError && validate_numeric(field)) {
				addFieldError(field, field.title + "は数字で入力してください。");
				hasError = true;
			}
			break;
		case "ALN":
			//半角英数字
			if (!hasError && validate_alphaNumeric(field)) {
				addFieldError(field, field.title + "は英数字で入力してください。");
				hasError = true;
			}
			break;
		case "ZEN":
			//全角文字チェック
			if (!hasError && validate_zenkaku(field)) {
				addFieldError(field, field.title + "は全角文字で入力してください。");
				hasError = true;
			}
			break;
		case "KNJ":
			//漢字チェック
			if (!hasError && validate_kanji(field)) {
				addFieldError(field, field.title + "は漢字で入力してください。");
				hasError = true;
			}
			break;
		case "KKN":
			//全角カタカナチェック
			if (!hasError && validate_katakana(field)) {
				addFieldError(field, field.title + "は全角カタカナで入力してください。");
				hasError = true;
			}
			break;
		case "KOT":
			//記号とスペース以外の文字チェック
			if (!hasError && validate_kigouigai(field)) {
				addFieldError(field, field.title + "は記号とスペース以外の文字で入力してください。");
				hasError = true;
			}
			break;
		case "EML":
			//メールアドレスチェック
			if (!hasError && validate_email(field)) {
				addFieldError(field, field.title + "は不正です。");
				hasError = true;
			}
			break;
		case "EQU":
			//同ＦＯＲＭ内のほかの項目と一致するかチェック（比較対象項目のＮＡＭＥ指定が必須）
			if (!hasError && field.value != eval("field.form." + pt[1] + ".value")) {
				addFieldError(field, field.title + "は" + eval("field.form." + pt[1] + ".title") + "と一致しません。");
				hasError = true;
			}
			break;
		case "EXI":
			//アカウントＩＤ重複チェック
			if (!hasError) {
				validate_exist_id(field);
				hasError = true;
			}
			break;
		case "EXN":
			//ニックネーム重複チェック
			if (!hasError) {
				validate_exist_nickname(field);
				hasError = true;
			}
			break;
		case "EXM":
			//メールアドレス重複チェック
			if (!hasError) {
				validate_exist_email(field);
				hasError = true;
			}
			break;
		}
		if (!hasError) {
			clearFieldError(field);
		}
	}
}

function bindTemplate(obj, cName) {
	$.get("bindInviteTemplate.html", {titleId: obj.value}, function(data) {
			var tempList = eval("(" + data + ")").tempList;
			$(cName).empty();   
			$(cName).append(new Option("","0"));
		    $.each(tempList,function(i){
		    	$(cName).append(new Option(tempList[i].inviteTemplateSubject,tempList[i].inviteTemplateId));
		    }) 
		}
	);
}

function changeMessage(obj, cName) {
	$.get("changeInviteMsg.html", {inviteTemplateId: obj.value}, function(data) {
		var inviteMsg = eval("(" + data + ")").inviteMsg;
		$(cName).val(inviteMsg);  
	}
);
	
}
