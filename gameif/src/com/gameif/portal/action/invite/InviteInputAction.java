package com.gameif.portal.action.invite;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import octazen.addressbook.AddressBookAuthenticationException;
import octazen.addressbook.AddressBookException;
import octazen.addressbook.Contact;
import octazen.addressbook.SimpleAddressBookImporter;
import octazen.addressbook.UnexpectedFormatException;
import octazen.addressbook.UnsupportedAddressBookException;
import octazen.http.HttpException;
import octazen.http.UserInputRequiredException;
import octazen.captcha.CaptchaChallengeException;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.OutOfMaxCountException;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.helper.PortalProperties;

public class InviteInputAction extends ModelDrivenActionSupport<InviteInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2224587269669764464L;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private PortalProperties portalProperties;

	private String mailAdd;
	private String domain;
	private String memPwd;
	
	private List<Contact> friendList;
	
	private List<String> selectedFriends;

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
	 * @return the portalProperties
	 */
	public PortalProperties getPortalProperties() {
		return portalProperties;
	}

	/**
	 * @param portalProperties the portalProperties to set
	 */
	public void setPortalProperties(PortalProperties portalProperties) {
		this.portalProperties = portalProperties;
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

	/**
	 * @return the selectedFriends
	 */
	public List<String> getSelectedFriends() {
		return selectedFriends;
	}

	/**
	 * @param selectedFriends the selectedFriends to set
	 */
	public void setSelectedFriends(List<String> selectedFriends) {
		this.selectedFriends = selectedFriends;
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
			if (selectedFriends != null){
				getModel().setInviteMailTo(selectedFriends.toString());
			}
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
//		String[] mailToList = getModel().getInviteMailTo()
//				.replace("\r\n", "\n").split("\n");
		String[] mailToList = getModel().getInviteMailTo().split(",");
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
			System.err.println("Sorry, bad user name or password");
		} catch (UnexpectedFormatException e) {
			System.err.println("Server error. Received unexpected content");
		} catch (UnsupportedAddressBookException e) {
			System.err.println("Unsupported webmail");
		} catch (CaptchaChallengeException e) {
			System.err.println("A captcha challenge was raised");
		} catch (UserInputRequiredException e) {
			System.err.println("Need to answer some questions in the webmail service");
		} catch (AddressBookException e) {
			System.err.println("Unsupported webmail / internal error");
		} catch (IOException e) {
			System.err.println("IO exception:" + e.getMessage());
		} catch (HttpException e) {
			System.err.println("General http request exception: "
					+ e.getMessage());
		}
		return "friendImport";
	}
	
	public String importFriends(){
		return "importFriends";
	}
}
