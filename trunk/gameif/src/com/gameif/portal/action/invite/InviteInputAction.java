package com.gameif.portal.action.invite;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import octazen.addressbook.AddressBookAuthenticationException;
import octazen.addressbook.AddressBookException;
import octazen.addressbook.Contact;
import octazen.addressbook.SimpleAddressBookImporter;
import octazen.addressbook.UnexpectedFormatException;
import octazen.addressbook.UnsupportedAddressBookException;
import octazen.captcha.CaptchaChallengeException;
import octazen.http.HttpException;
import octazen.http.UserInputRequiredException;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.OutOfMaxCountException;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.InviteTemplateMst;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.TitleMst;

public class InviteInputAction extends ModelDrivenActionSupport<InviteInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2224587269669764464L;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	
	private Map<Integer, List<InviteTemplateMst>> inviteTemplateList;
	private List<TitleMst> titleList;

	private String mailAdd;
	private String domain;
	private String memPwd;
	
	private List<Contact> friendList;
	
//	private List<String> selectedFriends;

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
	 * @return the inviteTemplateList
	 */
	public Map<Integer, List<InviteTemplateMst>> getInviteTemplateList() {
		return inviteTemplateList;
	}

	/**
	 * @param inviteTemplateList the inviteTemplateList to set
	 */
	public void setInviteTemplateList(
			Map<Integer, List<InviteTemplateMst>> inviteTemplateList) {
		this.inviteTemplateList = inviteTemplateList;
	}

	/**
	 * @return the titleList
	 */
	public List<TitleMst> getTitleList() {
		return titleList;
	}

	/**
	 * @param titleList the titleList to set
	 */
	public void setTitleList(List<TitleMst> titleList) {
		this.titleList = titleList;
	}

	/**
	 * @return the mailAdd
	 */
	public String getMailAdd() {
		return mailAdd;
	}

	/**
	 * @param mailAdd the mailAdd to set
	 */
	public void setMailAdd(String mailAdd) {
		this.mailAdd = mailAdd;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the memPwd
	 */
	public String getMemPwd() {
		return memPwd;
	}

	/**
	 * @param memPwd the memPwd to set
	 */
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	/**
	 * @return the friendList
	 */
	public List<Contact> getFriendList() {
		return friendList;
	}

	/**
	 * @param friendList the friendList to set
	 */
	public void setFriendList(List<Contact> friendList) {
		this.friendList = friendList;
	}

//	/**
//	 * @return the selectedFriends
//	 */
//	public List<String> getSelectedFriends() {
//		return selectedFriends;
//	}
//
//	/**
//	 * @param selectedFriends the selectedFriends to set
//	 */
//	public void setSelectedFriends(List<String> selectedFriends) {
//		this.selectedFriends = selectedFriends;
//	}

	/**
	 * 画面初期化
	 */
	private void initPage() {
		
		setTitleList( masterInfoBusinessLogic.getValidTitleList());

		Map<Integer, List<InviteTemplateMst>> inviteTemp = new LinkedHashMap<Integer, List<InviteTemplateMst>>();
		
		List<InviteTemplateMst> tempList = null;
		for (int i = 0; i < getTitleList().size(); i++) {
			tempList = masterInfoBusinessLogic.getInviteTemplateByTitleId(getTitleList().get(i).getTitleId());
			inviteTemp.put(getTitleList().get(i).getTitleId(), tempList);
		}
		this.setInviteTemplateList(inviteTemp);
	}
	
	/**
	 * 友達紹介画面に案内する。
	 * 
	 * @return 友達紹介入力画面
	 */
	public String input() {
		
		initPage();
		
		// 紹介者の会員番号
		getModel().setMemNum(ContextUtil.getMemberNo());
		
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMemNum(getModel().getMemNum());
		// 会員番号により、会員情報を取得する
		memberInfo = memberInfoBusinessLogic.getMemberInfo(memberInfo);
		if (memberInfo != null) {
			// メールアドレスを紹介者のメールアドレスに設定する
			getModel().setInviteMailFrom(memberInfo.getMailPc());
			
//			if (selectedFriends != null){
//				getModel().setInviteMailTo(selectedFriends.toString());
//			}
		}
		
		return INPUT;
	}

	/**
	 * データを友達紹介テーブルに登録する
	 * 
	 * @return　登録完了画面
	 */
	public String create() {
		/** 複数友達の場合、メールアドレースを「,」で分割 */
		String[] mailToList = getModel().getInviteMailTo().trim().replace("\r\n", "\n").split("\n");
//		String[] mailToList = getModel().getInviteMailTo().split(",");
		if (mailToList.length > 10) {
			addFieldError("inviteMailTo", getText("inviteMailTo.maxLength"));
			return INPUT;
		}
		
		try {
			
			inviteInfoBusinessLogic.saveInviteInfo(this.getModel());
			
		} catch (OutOfMaxCountException ex) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ex.getMessage());
			addFieldError("inviteMailTo", getText("inviteMailTo.maxLength"));
			return INPUT;
			
		} catch (LogicException lgex) {
	
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());
			return "warning";
		}
		return SUCCESS;
	}

	/**
	 * ＷＥＢメールアドレス入力画面に案内する。
	 * 
	 * @return ＷＥＢメールアドレス入力画面
	 */
	public String inputMailSel() {
		return "inputMailSel";
	}
	
	public String loginMailSel() {
		String email = mailAdd + domain;
		try {
			List<Contact> list = SimpleAddressBookImporter.fetchContacts(email, memPwd);
			setFriendList(list);
//			Iterator it = list.iterator();
//			while (it.hasNext()) {
//				Contact contact = (Contact) it.next();
//				System.out.println(contact.getName() + " <"
//						+ contact.getEmail() + ">");
//			}

		} catch (AddressBookAuthenticationException e) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ e.getMessage());
			// bad user name or password
			addFieldError("loginError", getText("loginError.invalidMailadd"));
			return "inputMailSel";
		} catch (UnexpectedFormatException e) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ e.getMessage());
			// Server error. Received unexpected content
			addFieldError("loginError", getText("loginError.unexpectedContent"));
			return "inputMailSel";
		} catch (UnsupportedAddressBookException e) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ e.getMessage());
			// Unsupported webmail
			addFieldError("loginError", getText("loginError.UnsupportedWebmail"));
			return "inputMailSel";
		} catch (CaptchaChallengeException e) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ e.getMessage());
			// A captcha challenge was raised
			addFieldError("loginError", getText("loginError.unexpectedError"));
			return "inputMailSel";
		} catch (UserInputRequiredException e) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ e.getMessage());
			// Need to answer some questions in the webmail service
			addFieldError("loginError", getText("loginError.unexpectedError"));
			return "inputMailSel";
		} catch (AddressBookException e) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ e.getMessage());
			// Unsupported webmail / internal error
			addFieldError("loginError", getText("loginError.unexpectedError"));
			return "inputMailSel";
		} catch (IOException e) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ e.getMessage());
			// IO exception
			addFieldError("loginError", getText("loginError.unexpectedError"));
			return "inputMailSel";
		} catch (HttpException e) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ e.getMessage());
			// General http request exception
			addFieldError("loginError", getText("loginError.unexpectedError"));
			return "inputMailSel";
		}
		return "friendImport";
	}
}
