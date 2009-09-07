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
		<link type="text/css" href="<%=request.getContextPath()%>/css/common/common.css" rel="stylesheet"></link>
		<link type="text/css" href="<%=request.getContextPath()%>/css/common/main.css" rel="stylesheet"></link>
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
    					<div id="page_main_right">
							<dl class="quickstart tspace_n">
								<dt>
									<a title="ログイン" href="mypage.html">
										<img alt="ログイン" src="images/btn_b_login.gif"/>
									</a>
								</dt>
								<dd/>
							</dl>
							<dl class="quickstart tspace_s">
								<dt>
									<a title="会員登録" href="entry.html">
										<img alt="会員登録" src="<%=request.getContextPath()%>/images/btn_b_entry.gif"/>
									</a>
								</dt>
								<dd>
									<a title="友達招待" href="friend.html">
										<img alt="友達招待" src="<%=request.getContextPath()%>/images/btn_b_friend.gif"/>
									</a>
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
    				</td>
    			</tr>
    		</table>
    	</div>
    	<div>
    		<dl class="page_bottom">
					<dt>
					<a title="会社概要" href="http://www.game-if.com">会社概要</a>
					|
					<a title="利用規約" href="agreement.html">利用規約</a>
					|
					<a title="免責事項" href="immunity.html">免責事項</a>
					|
					<a title="プライバシーポリシー" href="privacy.html">プライバシーポリシー</a>
					|
					<a title="特定商取引法に基づく表示内容" href="shop_info.html">特定商取引法に基づく表示内容</a>
					</dt>
			<dd>Copyright © 2009 Game-IF Co.,Ltd. All Rights Reserved.</dd>
			</dl>
		</div>
    </body>

</html>  
