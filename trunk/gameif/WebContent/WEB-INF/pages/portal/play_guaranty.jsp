<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>複数アカウントの警告</title>
		<script src="js/portal/validate.js" type="text/javascript"></script>
	</head>
	<body>
		<dl class="light_box tspace_n">
			<dt><strong>複数アカウントの警告</strong></dt>
			<dd>
				<div style="margin:30px 0px;line-height:20px;">
				<div style="font-size:16px;color:#F60;font-weight:bold;margin:10px 0px;">お客様ご利用のIPアドレスから、複数アカウントが作成されていることが確認されました。</div>
				<div style="line-height:18px;margin:20px 0px;">
					複数の会員アカウントを取得し、同一ゲームサーバー内に複数のプレイヤーデータを作成する行為は利用規約違反となります。<br/>
					同じIPからのゲームプレイは、下記の場合のみ可能となりますので、事前にご確認ください。
				</div>
				<ul style="border:1px solid #CCC;background-color:#F6F6F6;padding:10px 10px 10px 24px;">
					<li>光ファイバー、ADSL等インターネット接続サービスのプロバイダーから、動的に変更されるIPが提供されている場合。</li>
					<li>ネットカフェ、学校、会社等共通IPを使っている場所からゲームをプレイする場合。</li>
					<li>兄弟や家族、友達とともにそれぞれ別のアカウントを作り、同じ場所からゲームをプレイする場合。</li>
				</ul>
				<div style="line-height:18px;margin-top:20px;">
					上記の場合においても、ゲーム内で同じIPを使っている別アカウントとの取引、対人戦、攻城戦は一切禁止しております。（ギルド戦の場合は対象外）<br/>
					こちらのページからゲームを起動したアカウントは、複数アカウント防止対策として、監視リストに登録させていただきますので、ご了承ください。
				</div>
				</div>
				<s:form name="frm_nosubmit_play_link" method="post" cssClass="entry">

				<s:hidden name="serverId"></s:hidden>
				<s:hidden name="titleId"></s:hidden>
				<s:hidden name="server"></s:hidden>
				<s:submit value="上記の条項を了承してゲームをプレイする" action="createPlayGuaranty" cssStyle="width:300px;"></s:submit>

				</s:form>
			</dd>
		</dl>
	</body>
</html>