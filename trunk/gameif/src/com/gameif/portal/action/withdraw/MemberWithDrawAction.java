package com.gameif.portal.action.withdraw;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.LogicException;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.MemberWithdrawInfo;
import com.gameif.portal.helper.PortalProperties;
import com.gameif.portal.util.ContextUtil;

public class MemberWithDrawAction extends ModelDrivenActionSupport<MemberWithdrawInfo> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7944357306283942528L;
	
	public IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private PortalProperties portalProperties;

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
	 * @param portalProperties the portalProperties to set
	 */
	public void setPortalProperties(PortalProperties portalProperties) {
		this.portalProperties = portalProperties;
	}

	/**
	 * @return the portalProperties
	 */
	public PortalProperties getPortalProperties() {
		return portalProperties;
	}

}
