<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta name="robots" content="index, follow" />
	<meta name="keywords" content="ゲームイフ,ブラウザゲーム,webgame,大人数同時プレイブラウザゲーム,オンラインゲーム,パブリッシング,プラットフォーム" />
	<meta name="description" content="ブラウザゲーム(WEBGAME)のポータルサイト" />
	<title><s:property value="%{getText('change_mem_tilte')}" /></title>
	<link rel="stylesheet" href="css/common/common.css" type="text/css" />
	<link rel="stylesheet" href="css/common/main.css" type="text/css" />
	<script src="js/jquery/jquery.js" type="text/javascript"></script>
	<script src="js/portal/mem_login.js" type="text/javascript"></script>
</head>

<body>
	<!-- ページメイン：開始 -->
	<div id="page_main_main">
		<!-- 会員情報変更：開始 -->

		<dl class="light_box tspace_n">
			<dt>
				<strong>会員情報変更</strong>
				<span><a href="chpass.html">► パスワード変更</a></span>
			</dt>
			<dd>
				<s:form name="frm_change_mem" method="POST" action="updateMember" cssClass="entry">
					<dl>
						<dt><label for="giid">アカウントID(GI-ID)：</label></dt>
						<dd><span class="item">boxser</span></dd>
						<dt></dt>
						<dd>&nbsp;</dd>

						<dt>
							<span class="required">*</span><label for="nickname">ニックネーム：</label>
						</dt>
						<dd>
							<s:textfield name="memName" maxlength="20" ></s:textfield>
							<img src="images/icn_check_ok.gif" class="input_check" alt="" align="top"/><br/>
							<span class="explain">全角文字で入力してください。</span>

						</dd>
						<dt>
							<span class="required">*</span><label for="mail">メールアドレス：</label>
						</dt>
						<dd>
							<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n"></s:textfield>
							<img src="images/icn_check_ng.gif" class="input_check" alt="" align="top" />
							<span class="check_ng">既に使われているメールアドレスです。</span><br/>
							<span class="explain">メールアドレスを小文字で入力してください。</span>

						</dd>
						
						<dt></dt>
						<dd>&nbsp;</dd>

						<dt><label for="fname">氏名：</label></dt>
						<dd>
							<s:textfield name="kanjiFname" maxlength="10" cssClass="small"></s:textfield>
							<s:textfield name="kanjiLname" maxlength="10" cssClass="small"></s:textfield>
							<span class="explain">全角漢字で入力してください。</span>

						</dd>

						<dt><label for="fname">フリカナ：</label></dt>
						<dd>
							<s:textfield name="kanaFname" maxlength="10" cssClass="small"></s:textfield>
							<s:textfield name="kanaLname" maxlength="10" cssClass="small"></s:textfield>
							<span class="explain">全角仮名で入力してください。</span>
						</dd>

						
						<dt></dt>
						<dd>&nbsp;</dd>
						
						<dt><span class="required">*</span><label for="mail">性別：</label></dt>
						<dd>
							<s:radio name="sexCd" list="listSexCd" listKey="key" listValue="value" cssClass="big"/>
						</dd>
						
						<dt><span class="required">*</span><label for="birth_y">生年月日：</label></dt>
						<dd>
							<s:textfield name="birthYear" maxlength="4" cssClass="ime_mode_n min"></s:textfield>年
							<s:select name="birthMonth" 
								list="#{'1':'1','2':'2','3':'4','4':'4','5':'5','6':'6','7':'7',
										'8':'8','9':'9','10':'10','11':'11','12':'12'}"
								listKey="key" listValue="value" cssClass="min" />月
							<s:select name="birthDay" 
								list="#{'1':'1','2':'2','3':'4','4':'4','5':'5','6':'6','7':'7',
										'8':'8','9':'9','10':'10','11':'11','12':'12','13':'13',
										'14':'14','15':'15','16':'16','17':'17','18':'18','19':'19',
										'20':'20','21':'21','22':'22','23':'23','24':'24','25':'25',
										'26':'26','27':'27','28':'28','29':'29','30':'30','31':'31',}"
								listKey="key" listValue="value" cssClass="min" />日
						</dd>
						<dt><span class="required">*</span><label for="occupation">職業：</label></dt>
						<dd>
							<s:radio name="occupCd" list="listOccupCd" listKey="key" listValue="value" cssClass="big"/>
						</dd>
						<dt></dt>
						<dd>&nbsp;</dd>
						
						<dt><span class="required">*</span><label for="division">都道府県：</label></dt>
						<dd>
							<s:select name="divisCd" list="listDivision" listKey="key" listValue="value"/>
						</dd>

						<dt><label for="city">市区町村：</label></dt>
						<dd>
							<s:textfield name="cityName" maxlength="50"></s:textfield><br/>
							<span class="explain">全角文字で入力してください。</span>
						</dd>

						<dt><label for="house">番地建物：</label></dt>
						<dd>
							<s:textfield name="buildingName" maxlength="50"></s:textfield><br/>
							<span class="explain">全角文字で入力してください。</span>
						</dd>
						<dt><label for="tel">電話番号：</label></dt>
						<dd>
							<s:textfield name="telNum" maxlength="15" cssClass="ime_mode_n"></s:textfield><br/>
							<span class="explain">半角数字で入力してください。</span>
						</dd>
						<dt></dt>
						<dd>&nbsp;</dd>

						<dd>
							<s:checkbox name="mailmagReqCd" value="false"/>
							<label for="magazine">メルマガを受信する。</label>
						</dd>

					</dl>
					<div class="submit">
						<s:submit value="更新" cssClass="submit"></s:submit>
						<s:submit value="クリア" cssClass="submit"></s:submit>
					</div>

				</s:form>
			</dd>
		</dl>
		<!-- 会員情報変更：終了 -->

	</div>
	<!-- ページメイン：終了 -->

</body>


</html>