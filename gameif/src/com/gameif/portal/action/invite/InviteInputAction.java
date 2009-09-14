package com.gameif.portal.action.invite;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.MemberInfo;

public class InviteInputAction extends ModelDrivenActionSupport<InviteInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2224587269669764464L;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;

	/**
	 * @param inviteInfoBusinessLogic
	 *            the inviteInfoBusinessLogic to set
	 */
	public void setInviteInfoBusinessLogic(
			IInviteInfoBusinessLogic inviteInfoBusinessLogic) {
		this.inviteInfoBusinessLogic = inviteInfoBusinessLogic;
	}

	/**
	 * 
	 * @return
	 */
	public IInviteInfoBusinessLogic getInviteInfoBusinessLogic() {
		return inviteInfoBusinessLogic;
	}

	/**
	 * @param masterInfoBusinessLogic
	 *            the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	/**
	 * 
	 * @return
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	/**
	 * 
	 * @return
	 */
	public IMemberInfoBusinessLogic getMemberInfoBusinessLogic() {
		return memberInfoBusinessLogic;
	}

	/**
	 * 
	 * @param memberInfoBusinessLogic
	 */
	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}

	/**
	 * 友達紹介画面に案内する。
	 * 
	 * @return 友達紹介入力画面
	 */
	public String input() {
		// 紹介者の会員番号
		getModel().setMemNum(ContextUtil.getMemberNo());
		
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMemNum(getModel().getMemNum());
		// 会員番号により、会員情報を取得する
		memberInfo = memberInfoBusinessLogic.getMemberInfo(memberInfo);
		if (memberInfo != null) {
			// メールアドレスを紹介者のメールアドレスに設定する
			getModel().setInviteMailFrom(memberInfo.getMailPc());
		}
		
		return INPUT;
	}

	/**
	 * データを友達紹介テーブルに登録する
	 * 
	 * @return　登録完了画面
	 */
	public String create() {
		inviteInfoBusinessLogic.saveInviteInfo(this.getModel());
		return SUCCESS;
	}
}
