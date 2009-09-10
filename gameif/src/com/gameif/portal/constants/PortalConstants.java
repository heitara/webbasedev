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
}
