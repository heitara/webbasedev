function bindTemplate(obj, cName) {
	$.get("bindInviteTemplate.html", {titleId: obj.value}, function(data) {
			var tempList = eval("(" + data + ")").tempList;
			$(cName).empty();   
			
			if (tempList.length > 1) {
				$(cName).get(0).options.length = tempList.length + 1;	
			} else {
				$(cName).get(0).options.length = tempList.length;	
			}
			try {
				$.each(tempList,function(i){
					if (tempList.length == 1) {
						$(cName).get(0).options[i].value = tempList[i].inviteTemplateId;
						$(cName).get(0).options[i].text = tempList[i].inviteTemplateSubject;
					}
					else {
						$(cName).get(0).options[i + 1].value = tempList[i].inviteTemplateId;
						$(cName).get(0).options[i + 1].text = tempList[i].inviteTemplateSubject;
					}
				});
				
			} catch (ex) {}
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

function bindServerAndPoint(obj, cServer, cPoint) { 
	$.get("bindServerAndPointForCharge.html", {titleId: obj.value}, function(data) {
			// サーバをバインドする
			var serverList = eval("(" + data + ")").serverList;
			$(cServer).empty();
			if (serverList.length > 1) {
				$(cServer).get(0).options.length = serverList.length + 1;	
			} else {
				$(cServer).get(0).options.length = serverList.length;	
			}
			try {
				$.each(serverList,function(i){
					if (serverList.length == 1) {
						$(cServer).get(0).options[i].value = serverList[i].serverId;
						$(cServer).get(0).options[i].text = serverList[i].serverName;
					}
					else {
						$(cServer).get(0).options[i + 1].value = serverList[i].serverId;
						$(cServer).get(0).options[i + 1].text = serverList[i].serverName;
					}
				});
				
			} catch (ex) {}

			// ポイントをバインドする
			var pointList = eval("(" + data + ")").pointList;
			$(cPoint).empty();
			if (pointList.length > 1) {
				$(cPoint).get(0).options.length = pointList.length + 1;	
			} else {
				$(cPoint).get(0).options.length = pointList.length;	
			}
			try {
				$.each(pointList,function(i){
					if (pointList.length == 1) {
						$(cPoint).get(0).options[i].value = pointList[i].pointId;
						$(cPoint).get(0).options[i].text = pointList[i].pointName;
					}
					else {
						$(cPoint).get(0).options[i + 1].value = pointList[i].pointId;
						$(cPoint).get(0).options[i + 1].text = pointList[i].pointName;
					}
				});
				
			} catch (ex) {}
		}
	);
}	

function bindServerAndBalance(obj, cServer) { 
	$.get("bindServerAndBalanceForCharge.html", {titleId: obj.value}, function(data) {
			// サーバをバインドする
			var serverList = eval("(" + data + ")").serverList;
			$(cServer).empty();
			if (serverList.length > 1) {
				$(cServer).get(0).options.length = serverList.length + 1;	
			} else {
				$(cServer).get(0).options.length = serverList.length;	
			}
			try {
				$.each(serverList,function(i){
					if (serverList.length == 1) {
						$(cServer).get(0).options[i].value = serverList[i].serverId;
						$(cServer).get(0).options[i].text = serverList[i].serverName;
					}
					else {
						$(cServer).get(0).options[i + 1].value = serverList[i].serverId;
						$(cServer).get(0).options[i + 1].text = serverList[i].serverName;
					}
				});
				
			} catch (ex) {}
			// ポイントをバインドする
			var balance = eval("(" + data + ")").balance;
			document.getElementById("balance").innerHTML = balance;
		}
	);
}