package com.gameif.payment.interceptor;

import com.gameif.payment.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.payment.entity.MemAdvertActualInfo;
import com.gameif.payment.util.ContextUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BiglobePaymentInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -4908757732007241733L;
	
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	
	private Integer advertNum;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {

    	String result = null;
    	
		MemAdvertActualInfo memAdvertActInfo = memberInfoBusinessLogic.getMemAdvertActualInfoByMemNum(ContextUtil.getMemberNo());
		
		if (memAdvertActInfo != null && advertNum.equals(memAdvertActInfo.getAdvertNum())) {
			
			result = "biglobeCharge";
			
		} else {
			
			result = ai.invoke();
		}
		
		return result;
    }

	public void setMemberInfoBusinessLogic(IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}

	public void setAdvertNum(Integer advertNum) {
		this.advertNum = advertNum;
	}
}
