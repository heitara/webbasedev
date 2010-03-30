<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja-jp" lang="ja-jp" >
<head><title>処理中断</title></head>
<body>
<center>
<div class="alert">
<dl class="warning">
	<dt>お客様から要求された処理が継続できませんでした。</dt>
	<dd>
		<div class="msg">原因としては下記のようなものが考えられます。</div>
		<ul>
			<li>存在しないデータへのアクセスを要求している。</li>
			<li>期限切れデータへのアクセスを要求している。</li>
			<li>サーバ側の処理が終わっていないうちに、繰り返して同じリクエストを重複送信している。</li>
			<li>複数人が同じデータを処理している。</li>
			<li>ハッキング目的でサイト攻撃している。</li>
		</ul><br/>
		正常に使っているにもかかわらず何度もこの画面が表示される場合は、お問合せフォームより、サイト管理者にご連絡ください。<br/><br/>
		<input type="button" value="画面を閉じる" onclick="window.close();"/>
	</dd>
</dl>
</div>
</center>
</body>
</html>