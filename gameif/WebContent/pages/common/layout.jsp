<%@ page contentType="text/html; CHARSET=utf8" pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>   
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>  
<%@taglib prefix="s" uri="/struts-tags"%> 
  
<html>   
    <head>   
    	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
		<meta content="index, follow" name="robots"/>
		<link type="text/css" href="<%=request.getContextPath()%>/css/common/common.css" rel="stylesheet"></link>
		<link type="text/css" href="<%=request.getContextPath()%>/css/common/main.css" rel="stylesheet"></link>
		<title><decorator:title default="ゲームイフ | ブラウザゲームポータルサイト"/></title>
        <decorator:head />
    </head> 
    
    <body>
   			<jsp:include page="header.jsp" flush="true" />
    	<div id="page_main_box">
    		<div id="page_main_main">
				<decorator:body />  
			</div>
			<div id="page_main_right">
				<dl class="quickstart tspace_n">
					<dt>
						<a title="ログイン" href="mypage.html">
							<img alt="ログイン" src="<%=request.getContextPath()%>/images/btn_b_login.gif"/>
						</a>
					</dt>
					<dd/>
				</dl>
				<dl class="quickstart tspace_s">
					<dt>
						<s:url id="new" action="createCommon" includeParams="none"/>
						<s:a href="%{new}" title="会員登録">
							<img src="<%=request.getContextPath()%>/images/btn_b_entry.gif" alt="会員登録"/>
						</s:a>
					</dt>
					<dd>
						<s:url id="invite" action="inputeInvite" includeParams="none"/>
						<s:a href="%{invite}" title="友達招待">
							<img src="<%=request.getContextPath()%>/images/btn_b_friend.gif" alt="友達招待"/>
						</s:a>
					</dd>
				</dl>
				<dl class="title_box tspace_b">
					<dt>
						<strong>初めての方へ</strong>
					</dt>
					<dd class="guide">
						<a title="会員登録方法" href="#">会員登録方法</a>
						<a title="ＧＩポイントについて" href="#">ＧＩポイントについて</a>
						<a title="ご利用上の注意" href="#">ご利用上の注意</a>
						<a title="ＦＡＱ" href="#">ＦＡＱ</a>
						<a title="お問合せ" href="#">お問合せ</a>
					</dd>
				</dl>
			</div>
			<div class="clearbox"></div>
    	</div>
    	<div>
    		<dl class="page_bottom">
				<dt>
					<a title="会社概要" href="http://www.game-if.com">会社概要</a>|
					<a title="利用規約" href="agreement.html">利用規約</a>|
					<a title="免責事項" href="immunity.html">免責事項</a>|
					<a title="プライバシーポリシー" href="privacy.html">プライバシーポリシー</a>|
					<a title="特定商取引法に基づく表示内容" href="shop_info.html">特定商取引法に基づく表示内容</a>
				</dt>
				<dd>Copyright © 2009 Game-IF Co.,Ltd. All Rights Reserved.</dd>
			</dl>
		</div>
    </body>

</html>  
