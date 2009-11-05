package com.gameif.portal.constants;

public class PortalConstants {
	
	public final static String YES = "1";
	public final static String NO = "0";
	
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
		/** アフィリエイト */
		public final static String AFFILIATE = "1";
		/** チャネリング */
		public final static String CHANNELING= "2";

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
		/** 募集完了「募集不可、当選者プレー可」 */
		public final static String COMPLETE = "0";
		/** 募集中「募集可、誰でもプレー不可」 */
		public final static String RECRUITING = "1";
		/** テスト状態「募集可、当選者プレイ可」 */
		public final static String TEST = "2";
		/** 稼動状態「募集不可、誰でもプレー可」 */
		public final static String RUNNING = "3";
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
		public final static String GAME_LOGIN = "1";
		/** 最近一ヶ月の累計課金金額が一定金額を超えた場合 */
		public final static String CHARGE = "2";
	}
	
	/** ポイント区別 */
	public class ChargeSpType {
		/** サービスポイント */
		public final static String SERVICE_POINT = "1";
		/** 課金ポイント */
		public final static String ACCOUNT_POINT = "0";
		
	}
}
