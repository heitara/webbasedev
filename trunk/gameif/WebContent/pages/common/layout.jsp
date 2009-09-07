<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>   
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>  
<%@taglib prefix="s" uri="/struts-tags"%> 
  
<html>   
    <head>   
    	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
		<meta content="index, follow" name="robots"/>
		<meta content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" name="keywords"/>
		<meta content="ブラウザゲーム(WEBGAME)のポータルサイト" name="description"/>
		<link type="text/css" href="css/common/common.css" rel="stylesheet"></link>
		<link type="text/css" href="css/common/main.css" rel="stylesheet"></link>
		<title><decorator:title default="ゲームイフ | ブラウザゲームポータルサイト"/></title>
        <decorator:head />
    </head> 
    
    <body>
    	<div>
    		<jsp:include page="header.jsp" flush="true" />
    	</div>
    	<div>
    		<table width="100%">
    			<tr>
    				<td width="80%">
						<decorator:body />  
    				</td>
    				<td width="20%">
    					<jsp:include page="mainright.jsp" flush="true" />
    				</td>
    			</tr>
    		</table>
    	</div>
    	<div>
    		<jsp:include page="footer.jsp" flush="true" />
		</div>
    </body>

</html>  
