package com.gameif.portal.constants;

public class PortalConstants {
	
	public final static String YES = "1";
	public final static String NO = "0";
	public final static String INVITE_COOKIE_VALUE = "K849ojrEaMhdaAC";
	
	public class Key {
		
		public final static String SEURE_PARAM_KEY = "enc";
		public final static String ENTRY_PARAM_TITLE_KEY = "title";
		public final static String ENTRY_PARAM_APPLY_KEY = "apply";
		public final static String INVITE_COOKIE_KEY = "inviteCookie";
	}
	
	/** ユーザ属性コード */
	public class MemberAtbtCd {
		
		/** 通常ユーザ */
		public final static String NORMAL = "1";
		/** 課金ユーザ */
		public final static String CHARGE = "2";
		/** テストユーザ */
		public final static String TEST = "3";
		/** メディアユーザ */
		public final static String MEDIA = "4";
	}
	
	/** ユーザ種別コード */
	public class MemberKindCd {
		
		/** ゲームイフユーザ */
		public final static String GAMEIF = "0";
		/** 代理店なし */
		public final static String NO_AGENCY = "1";
		/** チャネリング */
		public final static String CHANNELING= "2";
		/** アフィリエイト */
		public final static String AFFILIATE = "3";

	}
	
	/** ユーザ有効区別コード */
	public class MemberValidYNCd {
		
		/** 有効 */
		public final static String VALID = "1";
		/** 退会 */
		public final static String WITHDRAW  = "2";
		/** 凍結 */
		public final static String FREEZE = "3";
	}
	
	/** 友達登録ステータス */
	public class InviteStatus {
		/** 応答なし */
		public final static String NO_RESPONSE = "0";
		/** 会員登録済 */
		public final static String REGISTERED  = "1";
	}

	/** 問合せ種別 */
	public class InquiryType {
		/** 会員 */ 
		public final static int MEMBER = 0;
		/** メディア */ 
		public final static int MEDIA = 1;
		/** その他 */ 
		public final static int OTHER = 2;
	}
	
	/** 問合せの対応状況 */
	public class CorrespondStatus {
		/** 未対応  */
		public final static int NO_CORRESPOND = 0;
		/** 対応済 */
		public final static int CORRESPONDED = 1;
		/** 対応中 */
		public final static int IN_CORRESPOND = 2;
	}
	
	/** サーバ稼動状態 */
	public class ServerStatus {
		/** サーバメンテナンス中 */
		public final static String MAINTENANCE = "0";
		/** サーバ稼動中 */
		public final static String RUNNING = "1";
		/** CBT中 */
		public final static String CBT = "2";
		/** OBT中 */
		public final static String OBT = "3";
	}
	
	/** 募集ステータス */
	public class RecruitStatus {
		/** 稼動状態「募集無し、誰でもプレイ可」 */
		public final static String RUNNING = "0";
		/** 募集中「募集中、誰でもプレイ不可」 */
		public final static String RECRUITING = "1";
		/** テスト状態「募集中、当選者プレイ可」 */
		public final static String TEST = "2";
		/** 募集完了「募集終了、当選者プレイ可」 */
		public final static String COMPLETE = "3";
	}
	
	/** 募集者の当選ステータス */
	public class ElectStatus {
		/** 未当選 */
		public final static String NOT_ELECTED = "0";
		/** 当選 */
		public final static String ELECTED = "1";
	}

	/** 削除フラグ */
	public class DeleteFlag {
		/** 正常データ */ 
		public final static String NORMAL = "0";
		/** 削除されたデータ */ 
		public final static String DELETEED = "1";
	}

	/** パスワード再発行用パラメータ名 */
	public class PwdRegetParams {
		/** 会員番号 */ 
		public final static String MEMBER_NUM = "memNum";
		/** 臨時キー（仮パスワード） */ 
		public final static String TEMP_KEY = "tempKey";
	}
	
	/** サービスポイント贈与タイプ */
	public class ServicePointTypeCd {
		/** 連続してゲームにログインした場合 */
		public final static int GAME_LOGIN = 1;
		/** チャージに対して、指定期間内の累計課金金額が一定金額を超えた場合、今回決済金額の幾つパーセントのサービスポイントを付与する */
		public final static int CHARGE_PERCENT = 2;
		/** チャージに対して、今回決済金額によって、固定額のサービスポイントを付与する*/
		public final static int CHARGE_FIX = 3;
		/** 友達紹介 */
		public final static int INVITE = 4;
		/** アンケット */
		public final static int QUESTIONNAIRE = 5;
		/** チケット */
		public final static int TICKET = 10;
	}
	
	/** 各機能の有効状態 */
	public class FunctionServiceStatus {
		/** 該当機能が利用できない */
		public final static String OFF = "0";
		/** 該当機能が利用できる */
		/** チャージの場合は「指定期間内の累計課金金額が一定金額を超えたら、決済金額の幾つパーセントのサービスポイントを付与する」機能を使う */
		public final static String ON = "1";
		/** チャージの場合使うだけ、「今回決済金額によって、固定額のサービスポイントを付与する」機能を使う */
		public final static String CHARGE_FIX = "2";
	}
	
	/** ポイント区別 */
	public class ChargeSpType {
		/** サービスポイント */
		public final static String SERVICE_POINT = "1";
		/** 課金ポイント */
		public final static String ACCOUNT_POINT = "0";
		
	}
	
	/** 機能コード */
	public class FunctionCode {
		/** ポイントチャージ */
		public final static String CHARGE = "20";
		/** サービスポイント */
		public final static String SERVICE_POINT = "30";
		/** メールで友達招待 */
		public final static String INVITE_MAIL = "40";
		/** リンクで友達招待 */
		public final static String INVITE_LINK = "43";
		/** チケット */
		public final static String TICKET = "50";
	}
	
	/** サーバ稼動状態 */
	public class MaintenanceStatus {
		/** サーバ稼動中 */
		public final static String RUNNING = "0";
		/** サーバメンテナンス中 */
		public final static String MAINTENANCE = "1";
		/** テストユーザ使用可 */
		public final static String TEST = "2";
	}
	
	/** 決済方法 */
	public class SettlementCode {
		public final static String BITCASH = "bitcash";
		public final static String CREDIT = "credit3d";
		public final static String CYBEREDY = "cyberedy";
		public final static String MOBILEEDY = "mobileedy";
		public final static String NETCASH = "netcash";
		public final static String WEBMONEY = "webmoney";
		
	}
	
	/** 友達の承認ステータス */
	public class ApproveStatus {
		/** 未承認 */
		public final static String NO_APPROVE = "1";
		/** IP重複 */
		public final static String IP_REPEAT = "2";
		/** 申請中 */
		public final static String APPROVING = "3";
		/** 承認済 */
		public final static String APPROVED = "4";
		/** 褒美済 */
		public final static String REWARDED = "5";
		/** ボーナス褒美済 */
		public final static String BONUS_REWARDED = "6";
		/** 却下 */
		public final static String REJECTED = "7";
	}
}
