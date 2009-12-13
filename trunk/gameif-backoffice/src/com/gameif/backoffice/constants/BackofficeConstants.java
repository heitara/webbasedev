package com.gameif.backoffice.constants;

public class BackofficeConstants {
	
	/** セッションキー */
	public class SessionKey {
		/** ユーザID */
		public final static String USER_ID = "userId";
		/** ニックネーム */
		public final static String NICK_NAME = "nickName";
	}
	
	/** 機能コード */
	public class FunctionCode {
		/** 会員管理 */
		public final static String MEMBER = "100";
		/** 問合せ管理  */
		public final static String INQUIRY = "200";
		/** 友達紹介管理  */
		public final static String INVITE = "300";
		/** キャンペーン管理 */
		public final static String CAMPAIGN = "400";
		/** サービスポイント管理 */
		public final static String SERVICE_POINT = "500";
		/** 売上げ集計  */
		public final static String SALES = "600";
		/** 権限管理  */
		public final static String Authority = "700";
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

	/** 問合せ種別 */
	public class InquiryType {
		/** 会員 */ 
		public final static int MEMBER = 0;
		/** メディア */ 
		public final static int MEDIA = 1;
		/** その他 */ 
		public final static int OTHER = 2;
	}
	
	/** 友達紹介の種別 */
	public class InviteType {
		/** メールで紹介 */
		public final static String MAIL = "1";
		/** リンクで紹介 */
		public final static String LINK = "2";
	}
	
	/** 友達の承認ステータス */
	public class ApproveStatus {
		/** 未承認 */
		public final static String NO_APPROVE = "1";
		/** 承認済 */
		public final static String APPROVED = "2";
		/** 却下 */
		public final static String REJECTED = "3";
	}
}
