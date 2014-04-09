<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>会員情報変更</title>
	<script src="js/portal/validate.js" type="text/javascript"></script>
</head>

<body>
<!-- 会員情報変更：開始 -->
<dl class="light_box tspace_n">
	<dt>
		<strong>会員情報変更</strong>
		<span><a href="editPassword.html">► パスワード変更</a></span>
	</dt>
	<dd>
		<s:form action="updateMemberInfo" cssClass="entry">
			<table class="form">
				<tr>
					<th><label for="giid">アカウントID：</label></th>
					<td><span class="item" id="memId" title="アカウントID"><%=com.gameif.payment.util.ContextUtil.getAccountId()%></span></td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><span class="required">*</span><label for="updateMemberInfo_model_nickName">ニックネーム：</label></th>
					<td>
						<s:textfield name="model.nickName" maxlength="20" title="ニックネーム" onblur="validate(this, 'REQ,KOT,SPNNEQ_memId,EXN');"/>
						<span class="explain">※ 記号とスペース以外の文字で入力してください。</span>
						<span id="error_nickName" class="input_error"><s:fielderror><s:param>nickName</s:param></s:fielderror></span>	
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="updateMemberInfo_model_mailPc">メールアドレス：</label></th>
					<td>
						<s:textfield name="model.mailPc" maxlength="100" cssClass="ime_mode_n" title="メールアドレス" onblur="validate(this, 'REQ,EML,EXM');"/>
						<span class="explain">※ メールアドレスを小文字で入力してください。</span>
						<span id="error_mailPc" class="input_error"><s:fielderror><s:param>mailPc</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><label for="updateMemberInfo_model_kanjiFname">氏名：</label></th>
					<td>
						<s:textfield name="model.kanjiFname" maxlength="10" cssClass="small ime_mode_y" title="姓" onblur="validate(this, 'KNJ');"/>
						<s:textfield name="model.kanjiLname" maxlength="10" cssClass="small ime_mode_y" title="名" onblur="validate(this, 'KNJ');"/>
						<span class="explain">※ 全角漢字で入力してください。</span>
						<span id="error_kanjiFname" class="input_error"><s:fielderror><s:param>kanjiNameForCheck</s:param></s:fielderror></span>
						<span id="error_kanjiLname" class="input_error"></span>	
					</td>
				</tr>
				<tr>
					<th><label for="updateMemberInfo_model_kanaFname">フリカナ：</label></th>
					<td>
						<s:textfield name="model.kanaFname" maxlength="10" cssClass="small ime_mode_y" title="姓のフリカナ" onblur="validate(this, 'KKN');"/>
						<s:textfield name="model.kanaLname" maxlength="10" cssClass="small ime_mode_y" title="名のフリカナ" onblur="validate(this, 'KKN');"/>
						<span class="explain">※ 全角仮名で入力してください。</span>
						<span id="error_kanaFname" class="input_error"><s:fielderror><s:param>kanaNameForCheck</s:param></s:fielderror></span>
						<span id="error_kanaLname" class="input_error"></span>						
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><span class="required">*</span><label for="updateMemberInfo_model_sexCd0">性別：</label></th>
					<td>
						<s:radio name="model.sexCd" list="paymentProperties.sexListMap" title="性別" onblur="validate(this, 'REQ');"/>
						<span id="error_sexCd" class="input_error"><s:fielderror><s:param>sexCd</s:param></s:fielderror></span>
					</td>
				</tr>				
				<tr>
					<th><span class="required">*</span><label for="updateMemberInfo_birthY">生年月日：</label></th>
					<td>
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td><s:textfield name="birthY" maxlength="4" cssClass="ime_mode_n min" title="生年月日の年" onblur="validate(this, 'REQ,NUM');"/>&nbsp;年 &nbsp;</td>
								<td><s:select name="birthM" list="paymentProperties.monthListMap" headerKey="" headerValue="" cssClass="min" title="生年月日の月" onblur="validate(this, 'REQ');"/>&nbsp;月&nbsp;</td>
								<td><s:select name="birthD" list="paymentProperties.dayListMap" headerKey="" headerValue="" cssClass="min" title="生年月日の日" onblur="validate(this, 'REQ');"/>&nbsp;日&nbsp;</td>
							</tr>
						</table>
						<span id="error_birthY" class="input_error"><s:fielderror><s:param>birthdayForCheck</s:param></s:fielderror></span>
						<span id="error_birthM" class="input_error"></span>
						<span id="error_birthD" class="input_error"></span>
					</td>
				</tr>
				<tr>
					<th><span class="required">*</span><label for="updateMemberInfo_model_occupCd">職業：</label></th>
					<td>
						<s:select name="model.occupCd" list="masterInfoBusinessLogic.allOccupationList" listKey="occupCode" listValue="occupName" headerKey="0" headerValue="" title="職業" onblur="validate(this, 'REQ');"/>
						<span id="error_occupCd" class="input_error"><s:fielderror><s:param>occupCd</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th><span class="required">*</span><label for="updateMemberInfo_model_divisCd">都道府県：</label></th>
					<td>
						<s:select name="model.divisCd" list="masterInfoBusinessLogic.allDivisionList" listKey="divisionCode" listValue="divisionName" headerKey="0" headerValue="" title="都道府県" onblur="validate(this, 'REQ');"/>
						<span id="error_divisCd" class="input_error"><s:fielderror><s:param>divisCd</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><label for="updateMemberInfo_model_cityName">市区町村：</label></th>
					<td>
						<s:textfield name="model.cityName" maxlength="50" cssClass="ime_mode_y" title="市区町村" onblur="validate(this, 'ZEN');"/>
						<span class="explain">※ 全角文字で入力してください。</span>
						<span id="error_cityName" class="input_error"><s:fielderror><s:param>cityName</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><label for="updateMemberInfo_model_buildingName">番地建物：</label></th>
					<td>
						<s:textfield name="model.buildingName" maxlength="50" cssClass="ime_mode_y" title="番地建物" onblur="validate(this, 'ZEN');"/>
						<span class="explain">※ 全角文字で入力してください。</span>
						<span id="error_buildingName" class="input_error"><s:fielderror><s:param>buildingName</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr>
					<th><label for="updateMemberInfo_model_telNum">電話番号：</label></th>
					<td>
						<s:textfield name="model.telNum" maxlength="15" cssClass="ime_mode_n" title="電話番号" onblur="validate(this, 'NUM,LEN_8_15');"/>
						<span class="explain">※ ハイフンなしの半角数字で入力してください。</span><br/>
						<span id="error_telNum" class="input_error"><s:fielderror><s:param>telNum</s:param></s:fielderror></span>
					</td>
				</tr>
				<tr class="space_row"><td colspan="2"></td></tr>
				<tr>
					<th></th>
					<td>
						<s:checkbox name="model.mailmagReqCd" value="%{mailmagReqCd == null ? true : (mailmagReqCd == 1 ? true : false)}" fieldValue="1"/>
						<label for="updateMemberInfo_model_mailmagReqCd">メルマガを受信する。</label>
					</td>
				</tr>
			</table>
			<div class="submit">
				<s:hidden name="model.memNum"/>
				<s:hidden name="model.memId"/>
				<s:hidden name="model.versionNo"/>
				<s:token/>
				<s:submit type="image" src="images/btn_c_submit.png"></s:submit>
				<s:submit type="image" src="images/btn_c_clear.png" onclick="this.form.reset();return false;"></s:submit>
			</div>
		</s:form>
	</dd>
</dl>
<!-- 会員情報変更：終了 -->
</body>
</html>