<%@ page language="java" contentType="text/csv; charset=Shift-JIS" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head>
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<title>ポイントチャージ | ゲームイフ | ブラウザゲームのポータルサイト</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<script src="js/portal/bindMaster.js" type="text/javascript"></script>
</head>

<body onload="document.form1.submit();return;">
<!-- ポイントチャージ：開始 -->
<dl>
	<dd>
		<form name="form1" action="https://stbfep.sps-system.com/Extra/BuyRequestAction.do" method="post">
			<s:property value="result" /><s:property value=","/><s:property value="errMsg"/>
			
			<div>
				<s:submit value="次へ" cssClass="submit" />
			</div>
		</form>
	</dd>
</dl>
<!-- ポイントチャージ：終了 -->


</body>
</html>