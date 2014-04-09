package com.gameif.payment.action.withdraw;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.LogicException;
import com.gameif.payment.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.payment.entity.MemberInfo;
import com.gameif.payment.entity.MemberWithdrawInfo;
import com.gameif.payment.helper.PaymentProperties;
import com.gameif.payment.util.ContextUtil;

public class MemberWithDrawAction extends ModelDrivenActionSupport<MemberWithdrawInfo> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7944357306283942528L;
	
	public IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private PaymentProperties paymentProperties;
	private String logoutUrl;

	/**
	 * 会員退会画面へ案内する
	 * @return 会員退会画面
	 */
	public String inputWithDrawInfo() {
		return INPUT;
	}
	
	/**
	 * 会員退会を行う
	 * @return
	 */
	public String createWithDrawInfo() {
		
		MemberInfo member = new MemberInfo();
		member.setMemNum(ContextUtil.getMemberNo());
		member.setMemId(ContextUtil.getAccountId());
		
		try {
			memberInfoBusinessLogic.withdraw(member, this.getModel());

		} catch (LogicException ex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ex.getMessage());

			return "warning";
		}
		
		// セッションをクリアする
		ServletActionContext.getRequest().getSession().invalidate();
		logoutUrl = ServletActionContext.getServletContext().getInitParameter("portalAuthTopUrl") + "/logout";
		
		return SUCCESS;
	}
	
	/**
	 * 退会完了画面へ案内する
	 * @return 退会完了画面
	 */
	public String finishedWithDrawInfo() {
		return "finished";
	}

	/**
	 * @param memberInfoBusinessLogic the memberInfoBusinessLogic to set
	 */
	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}

	/**
	 * @param paymentProperties the paymentProperties to set
	 */
	public void setPaymentProperties(PaymentProperties paymentProperties) {
		this.paymentProperties = paymentProperties;
	}

	/**
	 * @return the paymentProperties
	 */
	public PaymentProperties getPaymentProperties() {
		return paymentProperties;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

}
