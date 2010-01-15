<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>友達紹介</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
	<style>
		a.invite_hist_link { color:#855; }
		a.invite_hist_link:hover { color:#F90; text-decoration:underline; }
	</style>
</head>
<body>
<dl class="light_box tspace_n">
	<dt><strong>友達紹介</strong><span>&nbsp;</span></dt>
	<dd>
		<h3 style="color:#F60;margin:20px 0px;">友達を誘ってゲーム世界を広げましょう！</h3>
		
		<h4>
		友達紹介は、「リンクで紹介」と「メールで紹介」の二つの方法があります。
		</h4>
		<blockquote>
			<table width="100%" border="0" cellpadding="0" cellspacing="">
				<tr>
					<td><a href="inputLinkInvite.html" title="リンクで友達を招待する"><img src="images/btn_c_invite_link.png" alt="リンクで友達を招待する" /></a></td>
					<td align="right"><a href="showLinkInviteHist.html" class="invite_hist_link">リンク紹介履歴参照・報酬申請 ►</a></td>
				</tr>
			</table>
			<p>
				あなたに専用の紹介用リンクを発行します。このリンクをＭＳＮ、Ｓｋｙｐｅ、メール、ブログ、掲示板等で友達に伝えてください。
			</p>
			<table width="100%" border="0" cellpadding="0" cellspacing="">
				<tr>
					<td><a href="inputMailInvite.html" title="メールで友達を招待する"><img src="images/btn_c_invite_mail.png" alt="メールで友達を招待する" /></a></td>
					<td align="right"><a href="showMailInviteHist.html" class="invite_hist_link">メール紹介履歴参照・報酬申請 ►</a></td>
				</tr>
			</table>
			<p>
				既に友達のメールアドレスがご存知の場合、友達にゲーム紹介メールを送信します。<br/>
				Hotmail、Gmail、Yahooメールのお持ちの方は、そちらの連絡帳から直接友達のメールアドレスをインポートして使うことも可能です。
			</p>
		</blockquote>
		<p style="border-top:1px dashed #CCC;padding-top:15px;line-height:18px;margin-top:20px">
			<div style="font-size:13px;font-weight:bold;">友達紹介の流れ</div>
			<ol>
				<li>ゲームイフポータルサイトの友達紹介機能(リンク紹介或いはメール紹介)を利用して、友達に「レジオン-創世伝説-」を紹介します。</li>
				<li>被紹介者がゲームイフポータルサイトで会員登録を行い、「レジオン-創世伝説-」をプレイします。（プレイした日数が3日以上）</li>
				<li>紹介者が友達紹介履歴画面より、友達の会員登録を確認して、成果褒美を申請します。</li>
				<li>ゲームイフは、紹介者と被紹介者の正当性と被紹介者のゲームプレイ履歴をチェックして有効な紹介だった場合、承認処理を行います。</li>
				<li>毎週金曜日20時、ゲームイフはその一週間の友達紹介成果(承認済)に対して、サービスポイントを付与します。</li>
			</ol>
			<div style="font-size:13px;font-weight:bold;">友達紹介成果のプレゼント</div>
			<ul>
				<li>紹介一名の成果に対してサービスポイント100PTをプレゼントします。</li>
				<li>紹介人数が5名を超えた場合は、5名が増える度に「運のチケット10000」サービスチケット(10PT～10,000PTのサービスポイントが獲得できる運によるサービスチケット)をボーナスとしてプレゼントします。</li>
				<li style="list-style:none;">※紹介者と被紹介者が同じパソコンまたは同じネットワーク(IP)を使っている場合は承認されません。</li>
				<li style="list-style:none;">※以前紹介した友達と同じパソコンまたはネットワーク(IP)を使っている友達を紹介した場合は承認されません。</li>
			</ul>
		</p>
		<div class="rbox_side" style="margin-top:20px;"></div><div class="rbox_round"></div><div class="rbox_main">
			<div style="overflow:hidden;">
				<div style="margin:10px;color:#666;">
					<h4 style="color:#F60;">注意事項：</h4>
					<p>
					ゲームイフでは皆様に、安全且つ公平な環境が提供できるよう、友達紹介機能について下記の制限を設けております。<br/>
					違反が発覚されば場合、余儀なく違反者のアカウントを凍結させていただきますので、予めご了承ください。
					</p>
					<ol>
						<li>成果プレゼント獲得を狙って、紹介者本人が紹介リンクでアカウントを複数作成する。</li>
						<li>存在しないメールアドレスに紹介メールを送信している。</li>
						<li>同じメールアドレスに紹介メールを大量に送信して、相手に迷惑をかけている。</li>
					</ol>
				</div>
			</div>
		</div><div class="rbox_round"></div><div class="rbox_side"></div>
	</dd>
</dl>
</body>
</html>