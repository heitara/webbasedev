package com.gameif.common.util;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import edu.yale.its.tp.cas.client.filter.CASFilter;

public class ContextUtil {

	/**
	 * セッションから会員番号を取得する。
	 * @return　アカウントＩＤ
	 */
	public final static Long getMemberNo() {
		
		Long memberNo = null;
		String memberNoStr = getLoginSessionInfo()[0];
		
		if (memberNoStr != null && !"".equals(memberNoStr.trim())) {
			
			memberNo = new Long(memberNoStr.trim());
		}
		
		return memberNo;
	}
	
	/**
	 * セッションからアカウントＩＤを取得する。
	 * @return　アカウントＩＤ
	 */
	public final static String getAccountId() {
		
		return getLoginSessionInfo()[1];
	}

	/**
	 * セッションからニックネームを取得する。
	 * @return　ニックネーム
	 */
	public final static String getNickName() {
		
		return getLoginSessionInfo()[2];
	}

	/**
	 * セッションからアカウント関連情報（会員番号、アカウントＩＤ、ニックネーム）を取得する。
	 * @return　セッションからアカウント関連情報（会員番号、アカウントＩＤ、ニックネーム）
	 */
	private final static String[] getLoginSessionInfo() {
		
		String[] loginSessionInfo = null;
		String sessionInfo = (String)ActionContext.getContext().getSession().get(CASFilter.CAS_FILTER_USER);
		
		if (sessionInfo != null) {
			
			loginSessionInfo = sessionInfo.split(",");
			
		} else {
			
			loginSessionInfo = new String[] {null, null, null};
		}

		return loginSessionInfo;
	}
	
	/**
	 * ログイン状態を判断する。
	 * @return　true:ログイン; false:未ログイン
	 */
	public final static boolean userIsLogin() {
		
		return getAccountId() == null ? false : true;
	}

	/**
	 * クライアントＩＰを取得する。
	 * @return　クライアントＩＰ
	 */
	public final static String getClientIP() {
		
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	/**
	 * リクエストしたＵＲＩ（ＧＥＴパラメータつき）を取得する。
	 * @return ＵＲＩ
	 */
	public final static String getRequestedURIQuery() {

		StringBuffer uriq = new StringBuffer();
		
		uriq.append(ServletActionContext.getRequest().getRequestURI());
		
		if (ServletActionContext.getRequest().getQueryString() != null) {
			uriq.append("?");
			uriq.append(ServletActionContext.getRequest().getQueryString());
		}
		
		return uriq.toString();
	}
	
	/**
	 * クライアントＩＰとアカウントＩＤ、ＵＲＩを含むリクエスト情報を取得する。
	 * <br/>主にログ出力に使う。
	 * @return　リクエスト情報
	 */
	public final static String getRequestBaseInfo() {
		
		StringBuffer info = new StringBuffer();
		
		String account = getAccountId();
		
		info.append(getClientIP());
		info.append(" | ");
		info.append(account == null ? "-" : account);
		info.append(" | ");
		info.append(getRequestedURIQuery());
		
		return info.toString();
	}
}
