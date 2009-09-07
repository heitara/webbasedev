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
						<dt><s:property value="%{getText('mem_id')}" /></dt>
						<dd><span class="item">boxser</span></dd>
						<dt></dt>
						<dd>&nbsp;</dd>

						<dt>
							<span class="required">*</span><s:property value="%{getText('mem_name')}" />
						</dt>
						<dd>
							<s:textfield name="memName" maxlength="20" ></s:textfield>
							<img src="images/icn_check_ok.gif" class="input_check" alt="" align="top"/><br/>
							<span class="explain">全角文字で入力してください。</span>

						</dd>
						<dt>
							<span class="required">*</span><s:property value="%{getText('mail_pc')}" />
						</dt>
						<dd>
							<s:textfield name="mailPc" maxlength="100" cssClass="ime_mode_n"></s:textfield>
							<img src="images/icn_check_ng.gif" class="input_check" alt="" align="top" />
							<span class="check_ng">既に使われているメールアドレスです。</span><br/>
							<span class="explain">メールアドレスを小文字で入力してください。</span>

						</dd>
						
						<dt></dt>
						<dd>&nbsp;</dd>

						<dt><s:property value="%{getText('kanji_name')}" /></dt>
						<dd>
							<s:textfield name="kanji_fname" maxlength="10" cssClass="small"></s:textfield>
							<s:textfield name="kanji_lname" maxlength="10" cssClass="small"></s:textfield>
							<span class="explain">全角漢字で入力してください。</span>

						</dd>

						<dt><s:property value="%{getText('kana_name')}" /></dt>
						<dd>
							<s:textfield name="kana_fname" maxlength="10" cssClass="small"></s:textfield>
							<s:textfield name="kana_lname" maxlength="10" cssClass="small"></s:textfield>
							<span class="explain">全角仮名で入力してください。</span>
						</dd>

						
						<dt></dt>
						<dd>&nbsp;</dd>
						
						<dt><span class="required">*</span><s:property value="%{getText('sex_cd')}" /></dt>
						<dd>
							<s:radio name="sexCd" list="listSexCd" listKey="key" listValue="value" cssClass="big"/>
						</dd>
						
						<dt><span class="required">*</span><s:property value="%{getText('birth_ymd')}" /></dt>
						<dd>
							<s:textfield name="birth_year" maxlength="4" cssClass="ime_mode_n min"></s:textfield>
							<s:property value="%{getText('birth_year')}" />
							<s:select name="birth_month" 
								list="#{'1':'1','2':'2','3':'4','4':'4','5':'5','6':'6','7':'7',
										'8':'8','9':'9','10':'10','11':'11','12':'12'}"
								listKey="key" listValue="value" cssClass="min" />
							<s:property value="%{getText('birth_month')}" />
							<s:select name="birth_day" 
								list="#{'1':'1','2':'2','3':'4','4':'4','5':'5','6':'6','7':'7',
										'8':'8','9':'9','10':'10','11':'11','12':'12','13':'13',
										'14':'14','15':'15','16':'16','17':'17','18':'18','19':'19',
										'20':'20','21':'21','22':'22','23':'23','24':'24','25':'25',
										'26':'26','27':'27','28':'28','29':'29','30':'30','31':'31',}"
								listKey="key" listValue="value" cssClass="min" />
							<s:property value="%{getText('birth_day')}" />
						</dd>
						<dt><span class="required">*</span><s:property value="%{getText('occup_cd')}" /></dt>
						<dd>
							<s:radio name="occupCd" list="listOccupCd" listKey="key" listValue="value" cssClass="big"/>
						</dd>
						<dt></dt>
						<dd>&nbsp;</dd>
						
						<dt><span class="required">*</span> <label for="division">都道府県：</label></dt>
						<dd>
							<select id="division" name="division">

								<option value="01">北海道</option>
								<option value="02">青森県</option>
								<option value="03">岩手県</option>
								<option value="04">宮城県</option>
								<option value="05">秋田県</option>
								<option value="06">山形県</option>

								<option value="07">福島県</option>
								<option value="08">茨城県</option>
								<option value="09">栃木県</option>
								<option value="10">群馬県</option>
								<option value="11">埼玉県</option>
								<option value="12" selected="selected">千葉県</option>

								<option value="13">東京都</option>
								<option value="14">神奈川県</option>
								<option value="15">新潟県</option>
								<option value="16">富山県</option>
								<option value="17">石川県</option>
								<option value="18">福井県</option>

								<option value="19">山梨県</option>
								<option value="20">長野県</option>
								<option value="21">岐阜県</option>
								<option value="22">静岡県</option>
								<option value="23">愛知県</option>
								<option value="24">三重県</option>

								<option value="25">滋賀県</option>
								<option value="26">京都府</option>
								<option value="27">大阪府</option>
								<option value="28">兵庫県</option>
								<option value="29">奈良県</option>
								<option value="30">和歌山県</option>

								<option value="31">鳥取県</option>
								<option value="32">島根県</option>
								<option value="33">岡山県</option>
								<option value="34">広島県</option>
								<option value="35">山口県</option>
								<option value="36">徳島県</option>

								<option value="37">香川県</option>
								<option value="38">愛媛県</option>
								<option value="39">高知県</option>
								<option value="40">福岡県</option>
								<option value="41">佐賀県</option>
								<option value="42">長崎県</option>

								<option value="43">熊本県</option>
								<option value="44">大分県</option>
								<option value="45">宮崎県</option>
								<option value="46">鹿児島県</option>
								<option value="47">沖縄県</option>
								<option value="48">海外</option>

							</select>
						</dd>

						<dt><label for="city">市区町村：</label></dt>
						<dd>
							<input type="text" id="city" name="city" maxlength="50"/><br/>
							<span class="explain">全角文字で入力してください。</span>
						</dd>

						<dt><label for="house">番地建物：</label></dt>
						<dd>
							<input type="text" id="house" name="house" maxlength="50"/><br/>
							<span class="explain">全角文字で入力してください。</span>
						</dd>
						<dt><label for="tel">電話番号：</label></dt>
						<dd>

							<input type="text" id="tel" name="tel" maxlength="15" class="ime_mode_n"/><br/>
							<span class="explain">半角数字で入力してください。</span>
						</dd>
						<dt></dt>
						<dd>&nbsp;</dd>

						<dd><input type="checkbox" id="magazine" name="magazine" value="1"/> <label for="magazine">メルマガを受信する。</label></dd>

					</dl>
					<div class="submit">
						<input type="submit" value="更新" class="submit"/> <input type="reset" value="クリア" class="submit"/>
					</div>

				</s:form>
			</dd>
		</dl>
		<!-- 会員情報変更：終了 -->

	</div>
	<!-- ページメイン：終了 -->

</body>


</html>