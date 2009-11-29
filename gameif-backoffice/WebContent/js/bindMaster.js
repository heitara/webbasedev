function importContents(obj, cName) {
	$.get("importMailContents.html", {inquirySendmailId: obj.value}, function(data) {
		var inquirySendmailContents = eval("(" + data + ")").inquirySendmailContents;
		document.getElementById(cName).value = inquirySendmailContents;
		}
	);
}