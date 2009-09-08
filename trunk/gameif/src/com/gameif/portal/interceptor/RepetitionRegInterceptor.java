package com.gameif.portal.interceptor;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.gameif.common.interceptor.CommonInterceptor;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.opensymphony.xwork2.ActionInvocation;

public class RepetitionRegInterceptor extends CommonInterceptor {

	private static final long serialVersionUID = 4500488131766995696L;
	private final static Logger logger = Logger.getLogger(RepetitionRegInterceptor.class);
	
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private int repetitionMax;
	private int checkTime;

	public IMemberInfoBusinessLogic getMemberInfoBusinessLogic() {
		return memberInfoBusinessLogic;
	}

	public void setMemberInfoBusinessLogic(IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}
	
	public int getRepetitionMax() {
		return repetitionMax;
	}

	public void setRepetitionMax(int repetitionMax) {
		this.repetitionMax = repetitionMax;
	}

	public int getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(int checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * 同じＩＰで「checkTime」時間以内に、会員登録を連続して「repetitionMax」回行った場合、エラー
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		
		String clientIp = ServletActionContext.getRequest().getRemoteAddr();
		
		//TODO: ①memberInfoBusinessLogic.countMembersByIPInTime()メソッド要実装
		//TODO: ②repetion_errorに該当するresult要定義、エラー画面要作成
		int memberNum = 0;
		//int memberNum = memberInfoBusinessLogic.countMembersByIPInTime(clientIp, checkTime);
		
		if (memberNum >= repetitionMax) {
			
			logger.warn(getRequestInfo(ai) + " | 会員登録連続して行いました。");
			return "repetion_error";
		}
		
		return ai.invoke();
	}
}
