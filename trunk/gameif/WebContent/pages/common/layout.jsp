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
		<title><decorator:title default="ゲームイフ | ブラウザゲームポータルサイト" /></title>
        <decorator:head />   
    </head> 
    <body>
    	<div>
    		this is header!!!
    	</div>
    	<div>
    		<table>
    			<tr>
    				<td>
    					<decorator:body />  
    				</td>
    				<td>
						this is right menu!!
    				</td>
    			</tr>
    		</table>
    	</div>
    	<div>this is footer!!!</div>
    </body>

</html>  
