function importContents(obj, cName) {
	$.get("importMailContents.html", {inquirySendmailId: obj.value}, function(data) {
		var inquirySendmailContents = eval("(" + data + ")").inquirySendmailContents;
		document.getElementById(cName).value = inquirySendmailContents;
		}
	);
}

function bindTicket(obj, cName) {
	$.get("bindTicketMst.html", {titleId: obj.value}, function(data) {
		var ticketList = eval("(" + data + ")").ticketList;
		$(cName).empty();
		if (ticketList.length > 1) {
			$(cName).get(0).options.length = ticketList.length + 1;	
		} else {
			$(cName).get(0).options.length = ticketList.length;	
		}
		try {
			$.each(ticketList,function(i){
				if (ticketList.length == 1) {
					$(cName).get(0).options[i].value = ticketList[i].ticketId;
					$(cName).get(0).options[i].text = ticketList[i].ticketName;
				}
				else {
					$(cName).get(0).options[i + 1].value = ticketList[i].ticketId;
					$(cName).get(0).options[i + 1].text = ticketList[i].ticketName;
				}
			});
			
		} catch (ex) {}
		}
	);
}