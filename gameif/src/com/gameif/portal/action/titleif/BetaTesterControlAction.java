package com.gameif.portal.action.titleif;

import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IBetaTesterBusinessLogic;
import com.gameif.portal.entity.BetaTester;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.util.ContextUtil;

public class BetaTesterControlAction  extends
ModelDrivenActionSupport<BetaTester> {

	private static final long serialVersionUID = 579242178680718814L;
	
	private IBetaTesterBusinessLogic betaTesterBusinessLogic;
	
	private List<MyTitle> betaTitleList;
	
	private Integer titleId;
	private String status;
		
	/**
	 * 該当登録したユーザをβテスターテーブルに登録する
	 * @return
	 */
	public String apply() {
		
		this.getModel().setMemNum(ContextUtil.getMemberNo());
		betaTesterBusinessLogic.saveBetaTester(this.getModel());
		
		return SUCCESS;
	}
	
	public String finishApply() {
		
		return "finish";
	}

	/**
	 * @return the betaTesterBusinessLogic
	 */
	public IBetaTesterBusinessLogic getBetaTesterBusinessLogic() {
		return betaTesterBusinessLogic;
	}

	/**
	 * @param betaTesterBusinessLogic the betaTesterBusinessLogic to set
	 */
	public void setBetaTesterBusinessLogic(
			IBetaTesterBusinessLogic betaTesterBusinessLogic) {
		this.betaTesterBusinessLogic = betaTesterBusinessLogic;
	}

	/**
	 * @return the betaTitleList
	 */
	public List<MyTitle> getBetaTitleList() {
		return betaTitleList;
	}

	/**
	 * @param betaTitleList the betaTitleList to set
	 */
	public void setBetaTitleList(List<MyTitle> betaTitleList) {
		this.betaTitleList = betaTitleList;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

