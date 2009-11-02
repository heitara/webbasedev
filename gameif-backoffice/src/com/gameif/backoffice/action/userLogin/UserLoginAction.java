package com.gameif.backoffice.action.userLogin;

import com.gameif.backoffice.businesslogic.IUserLoginBusinessLogic;
import com.gameif.backoffice.entity.LoginUser;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;

public class UserLoginAction extends ModelDrivenActionSupport<LoginUser> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4311140827329987591L;
	
	private IUserLoginBusinessLogic userLoginBusinessLogic;

	public String input(){
		return INPUT;
	}
	/**
	 * ログインを行う
	 * @return 
	 */
	public String check() {
		try {
			
			userLoginBusinessLogic.checkUserLogin(this.getModel());
			
		} catch (DataNotExistsException ahex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ahex.getMessage());

			addFieldError("errMessage", getText("loginError.invalidUser"));

			return INPUT;

		} catch (LogicException lgex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());

			return "warning";
		}

		return SUCCESS;
	}

	/**
	 * @return the userLoginBusinessLogic
	 */
	public IUserLoginBusinessLogic getUserLoginBusinessLogic() {
		return userLoginBusinessLogic;
	}

	/**
	 * @param userLoginBusinessLogic the userLoginBusinessLogic to set
	 */
	public void setUserLoginBusinessLogic(
			IUserLoginBusinessLogic userLoginBusinessLogic) {
		this.userLoginBusinessLogic = userLoginBusinessLogic;
	}
}
