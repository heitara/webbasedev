package com.gameif.payment.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gameif.payment.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.payment.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class RepetitionRegInterceptor extends MethodFilterInterceptor {

    private static final long serialVersionUID = 4500488131766995696L;
    private final static Log logger = LogFactory.getLog(RepetitionRegInterceptor.class);
    
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
    public String doIntercept(ActionInvocation ai) throws Exception {
            
		String clientIp = ContextUtil.getClientIP();
		
		//①memberInfoBusinessLogic.countMembersByIPInTime()メソッド要実装
		//②repetion_errorに該当するresult要定義、エラー画面要作成
		int memberNum = memberInfoBusinessLogic.countMembersByIPInTime(clientIp, checkTime);
		
		if (memberNum >= repetitionMax) {
		        
		logger.warn(getRequestInfo(ai) + " | 会員登録連続して行いました。");
		return "warning";
		}
		
		return ai.invoke();
    }
	
	private String getRequestInfo(ActionInvocation ai) {

		StringBuffer msgBuff = new StringBuffer();
		
		msgBuff.append(ContextUtil.getRequestBaseInfo());

		msgBuff.append(" | ");
		msgBuff.append(ai.getAction().getClass().getSimpleName());
		msgBuff.append(".");
		msgBuff.append(ai.getProxy().getMethod());
		msgBuff.append("()");
		
		return msgBuff.toString();
	}
}
