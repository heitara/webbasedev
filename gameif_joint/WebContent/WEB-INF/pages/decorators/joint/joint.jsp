<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<title><decorator:title default="遊びから生まれる可能性"/> | ゲームイフ | ブラウザゲームポータルサイト</title>
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<base href="<%=getServletContext().getInitParameter("portalTopUrl")%>/"/>
	<link type="text/css" href="css/joint/joint.css" rel="stylesheet"></link>
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<decorator:head />
</head>
<body>
<div class="page_main_box">
	<decorator:body />
</div>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-11566933-1");
pageTracker._setDomainName(".game-if.com");
pageTracker._trackPageview();
} catch(err) {}
</script>
</body>
</html>