package com.gameif.backoffice.action.user;

import java.util.List;

import com.gameif.backoffice.bean.UserSearchCondition;
import com.gameif.backoffice.businesslogic.IAuthorityBusinessLogic;
import com.gameif.backoffice.businesslogic.IUserLoginBusinessLogic;
import com.gameif.backoffice.entity.LoginUser;
import com.gameif.common.action.ModelDrivenActionSupport;

public class UserInfoListAction extends
		ModelDrivenActionSupport<UserSearchCondition> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6990901291577291384L;

	/**
	 * 権限によって、新規、変更と削除ボタン表示かどうかフラグ
	 * <p>
	 * 【true:表示する、false:表示しない】
	 */
	private Boolean editFlag = true;

	/**
	 * 画面で選択したユーザIDリスト
	 */
	private String[] userIds;

	/**
	 * 画面表示リスト
	 */
	private List<LoginUser> userList;

	/**
	 * ユーザ情報処理ロジック
	 */
	private IUserLoginBusinessLogic userLoginBusinessLogic;

	/**
	 * 権限マスタ処理ロジック
	 */
	private IAuthorityBusinessLogic authorityBusinessLogic;

	/**
	 * 画面初期表示
	 */
	public String input() {
		return INPUT;
	}

	/**
	 * 画面で入力した検索条件でサーチを行う
	 */
	public String execute() {
		// 権限チェックを行う
		checkLoginUserAuthority();
		// ユーザ情報リストを取得
		userList = userLoginBusinessLogic.getLoginUserList(this.getModel());

		// 検査結果がない場合
		if (userList == null || userList.size() == 0) {

			addActionError(getText("common.dataNotExist"));

			return INPUT;
		}

		return SUCCESS;
	}

	/**
	 * 権限チェックを行う
	 */
	private void checkLoginUserAuthority() {
		// TODO editFlagのセット
	}

	/**
	 * @return the editFlag
	 */
	public Boolean getEditFlag() {
		return editFlag;
	}

	/**
	 * @param editFlag
	 *            the editFlag to set
	 */
	public void setEditFlag(Boolean editFlag) {
		this.editFlag = editFlag;
	}

	/**
	 * @return the userIds
	 */
	public String[] getUserIds() {
		return userIds;
	}

	/**
	 * @param userIds
	 *            the userIds to set
	 */
	public void setUserIds(String[] userIds) {
		this.userIds = userIds;
	}

	/**
	 * @return the userList
	 */
	public List<LoginUser> getUserList() {
		return userList;
	}

	/**
	 * @param userLoginBusinessLogic
	 *            the userLoginBusinessLogic to set
	 */
	public void setUserLoginBusinessLogic(
			IUserLoginBusinessLogic userLoginBusinessLogic) {
		this.userLoginBusinessLogic = userLoginBusinessLogic;
	}

	/**
	 * @return the authorityBusinessLogic
	 */
	public IAuthorityBusinessLogic getAuthorityBusinessLogic() {
		return authorityBusinessLogic;
	}

	/**
	 * @param authorityBusinessLogic
	 *            the authorityBusinessLogic to set
	 */
	public void setAuthorityBusinessLogic(
			IAuthorityBusinessLogic authorityBusinessLogic) {
		this.authorityBusinessLogic = authorityBusinessLogic;
	}

}
