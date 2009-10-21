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
	
	// 友達紹介に指定した日時前のデータ（ロジック削除）を削除する
	public final static Integer DELE_DAYS = 2;
	// 毎日に送信の最大個数
	public final static Integer MAIL_COUNT = 10;
}
