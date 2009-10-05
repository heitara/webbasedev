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

function checkAll(obj, cName)
{
    var checkboxs = document.getElementsByName(cName);
    for(var i=0;i<checkboxs.length;i++){
    	checkboxs[i].checked = obj.checked;
    }
}
