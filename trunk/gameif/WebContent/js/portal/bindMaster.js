

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

function bindServer(obj, cName) { 
	$.get("bindServerForCharge.html", {titleId: obj.value}, function(data) {
		var serverList = eval("(" + data + ")").serverList;
		$(cName).empty();   
		$(cName).append(new Option("","0"));
	    $.each(serverList,function(i){
	    	$(cName).append(new Option(serverList[i].serverName,serverList[i].serverId));
	    }) 
	}
	);
}	

function bindPoint(obj, cName) {
	$.get("bindPointForCharge.html", {serverId: obj.value}, function(data) {
		var pointList = eval("(" + data + ")").pointList;
		$(cName).empty();   
		$(cName).append(new Option("","0"));
	    $.each(pointList,function(i){
	    	$(cName).append(new Option(pointList[i].pointName,pointList[i].pointId));
	    }) 
	}
	);
}