package com.gameif.portal.businesslogic.titleif.charge;

public class ChargeConstants {
	
	public class Result {

		/** チャージ成功 */
		public final static int SUCCESS = 0;
		
		/** <strong>重複チャージで、他のトランザクションにて既にポイントが反映されている。</strong><br/>
		 * <p>この結果が出た場合は、後でポイントを補足付与してはいけない。</p>
		 */
		public final static int OUT_TRADE_NO_EXIST = -1;
		
		/** <strong>アカウントが存在しない原因で、ポイントが反映されていない。</strong><br/>
		 * <p>よくあるケースとしては、ユーザが一回もゲームに入ったことがないのに、先にポイントをチャージしてしまった場合。<br/>
		 * この結果が出た場合は、履歴を残し、未反映のポイントを後で補足付与する必要がある。<br/>
		 * 親切な対応としては、完了画面でユーザにその旨を伝え、
		 * 後でユーザが自分でボタンを押して反映させることができるようにする方法等が考えられる。</p>
		 */
		public final static int ACCOUNT_NOT_EXIST = 1;

		/** <strong>パラメータ不正が原因で、ポイントが反映されていない。</strong><br/>
		 * <p>パラメータ仕様がポータルと合わなくて発生するエラーだが、
		 * 予告なく一方的に仕様を変更しない限り、このエラーが発生する可能性がほとんどない。<br/>
		 * 発生した場合は、履歴を残し、後で補足付与する必要がある。</p>
		 */
		public final static int ILLEGAL_ARGUMENT = 2;

		/** <strong>セキュリティキーが不正で、ポイントが反映されていない。</strong><br/>
		 * <p>サーバ間通信パスワードを一方的に変更しない限り、このエラーが発生する可能性がほとんどない。<br/>
		 * 発生した場合は、履歴を残し、後で補足付与する必要がある。</p>
		 */
		public final static int ILLEGAL_SIGN = 3;

		/** <strong>通信障害等のシステムエラーで、ポイントが反映されたか、されていないのかは調査しなければ判断できない。</strong><br/>
		 * <p>サーバの高負荷、ダウン、ネットワーク障害等で、正常に処理が終わらなかった場合や、システム環境等の問題で発生する。<br/>
		 * 発生した場合は、履歴を残して調査する必要がある。<br/>
		 * ゲームサーバにはリクエストが届いたが、帰ってくるのが遅くてタイムアウトしてしまった場合は、補足付与してはいけない。
		 * （遅くてもポイントは付与されるため）
		 */
		public final static int SYSTEM_ERROR = 9;
	}
}
