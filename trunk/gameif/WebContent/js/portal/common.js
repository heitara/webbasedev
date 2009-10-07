function openPopup(url, weight, height) {
	var top = (window.screen.height - height) / 2;
	var left = (window.screen.width - weight) / 2;
	var winname = "gipopup";
	var option = "width=" + weight
				+ ", height=" + height
				+ ", top=" + top
				+ ", left=" + left
				+ "toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no";
	window.open(url, winname, option);
}

/**
 * 
 * @param obj　チェックボックス(全選択/全不選択)
 * @param cName チェックボックスのName
 * @return
 */
function checkAll(obj, cName) {
    var checkboxs = document.getElementsByName(cName);
    for(var i=0;i<checkboxs.length;i++){
    	if (!checkboxs[i].disabled) {
    		checkboxs[i].checked = obj.checked;
    	}
    }
}

/**
 * 友達を紹介状に追加してから、友達選択画面を閉じる
 */ 
function importFriends(cName) {
	var mailToList = "";
    var checkboxs = document.getElementsByName(cName);
    for(var i=0;i<checkboxs.length;i++){
    	if (checkboxs[i].checked) {
    		mailToList = mailToList + checkboxs[i].value + "\r\n";
    	}
    }
    
    var parent = window.opener;
    if(parent) {
        var mailTo = parent.document.getElementById("inviteMailTo").value;
    	parent.document.getElementById("inviteMailTo").value = mailTo + mailToList;
    }
    
    window.close();
}

function selectInvitedHist(obj, cName){
	var status = obj.value;
    var select = document.getElementsByTagName("tr");
    for(var i=0;i<select.length;i++){
    	if (select[i].id.indexOf(cName) < 0 || status == "9999") {
    		select[i].style.display = "";
    	} else {
        	if (select[i].id == cName + status) {
        		select[i].style.display = "";
        	} else {
        		select[i].style.display = "none";
        	}
    	}
    }
    
    
    var checkboxs = document.getElementsByName("selectedInvites");
    for(var j=0;j<checkboxs.length;j++){
    	checkboxs[j].checked = false;
    }
    
    document.getElementById("selAll").checked = false;
}

function bindTemplate(srcName) {
	alert("sss");
	var title = document.getElementById(srcName).options[obj.selectedIndex].value;
	alert(title);
	
}
