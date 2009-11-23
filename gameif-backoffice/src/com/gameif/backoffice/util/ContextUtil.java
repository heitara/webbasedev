package com.gameif.backoffice.util;

import org.apache.struts2.ServletActionContext;

import com.gameif.backoffice.constants.BackofficeConstants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ContextUtil {
	
	/**
	 * ユーザIDセッションに保存する
	 * @param userId ユーザID
	 */
	@SuppressWarnings("unchecked")
	public final static void setUserId(String userId) {
		
		ActionContext.getContext().getSession().put(BackofficeConstants.SessionKey.USER_ID, userId);
	}
	
	/**
	 * セッションからユーザIDを取得する
	 * @return ユーザID
	 */
	public final static String getUserId() {
		Object userId = ActionContext.getContext().getSession().get(BackofficeConstants.SessionKey.USER_ID);
		if (userId == null) {
			return null;
		}
		return userId.toString();
	}
	
	/**
	 * ニックネームセッションに保存する
	 * @param userId ニックネーム
	 */
	@SuppressWarnings("unchecked")
	public final static void setNickName(String nickName) {
		
		ActionContext.getContext().getSession().put(BackofficeConstants.SessionKey.NICK_NAME, nickName);
		
	}
	
	/**
	 * セッションからニックネームを取得する
	 * @return ニックネーム
	 */
	public final static String getNickName() {
		Object nickName = ActionContext.getContext().getSession().get(BackofficeConstants.SessionKey.NICK_NAME);
		if (nickName == null) {
			return null;
		}
		return nickName.toString();
	}
	
	/**
	 * クライアントＩＰを取得する。
	 * @return　クライアントＩＰ
	 */
	public final static String getClientIP() {
		
		String clientIp = ServletActionContext.getRequest().getHeader("X-Real-IP");
		
		if (clientIp == null) {
			
			clientIp = ServletActionContext.getRequest().getRemoteAddr();
		}
		
		return clientIp;
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
		
		String userId = getUserId();
		
		info.append(getClientIP());
		info.append(" | ");
		info.append(userId == null ? "-" : userId);
		info.append(" | ");
		info.append(getRequestedURIQuery());
		
		return info.toString();
	}
}
