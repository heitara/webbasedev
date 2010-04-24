<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ゲーム</title>
	<script type="text/javascript">
		function getServerList() {
			jQuery.ajax({   
                url : "selectServerList.html",   
                type : "post",   
                cache : false,   
                dataType : "text",   
                success:function(d){
                	document.getElementById("canvas_view").innerHTML=d;
                }
                });
		}
	</script>
</head>
<body>	
<div id="canvas_view">this is test page!</div>
<input type="button" onclick="getServerList();">
</body>
</html>