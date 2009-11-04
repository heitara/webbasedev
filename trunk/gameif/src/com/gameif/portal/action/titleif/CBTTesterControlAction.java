package com.gameif.portal.action.titleif;

import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.ICbtTesterBusinessLogic;
import com.gameif.portal.entity.CbtTester;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.util.ContextUtil;

public class CBTTesterControlAction  extends
ModelDrivenActionSupport<CbtTester> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 579242178680718814L;
	
	private ICbtTesterBusinessLogic cbtTesterBusinessLogic;
	
	private List<MyTitle> cbtTitleList;
	
	/**
	 * CBT募集画面へ案内する
	 * return CBT募集画面
	 */
	public String input() {
		
		// 募集中のタイトルを取得する
		setCbtTitleList(cbtTesterBusinessLogic.getCbtTitleList(ContextUtil.getMemberNo()));
		
		return INPUT;
	}
	
	/**
	 * 該当登録したユーザをCBTテスターテーブルに登録する
	 * @return
	 */
	public String create() {
		cbtTesterBusinessLogic.saveCbtTester(this.getModel());
		return SUCCESS;
	}

	/**
	 * @return the cbtTesterBusinessLogic
	 */
	public ICbtTesterBusinessLogic getCbtTesterBusinessLogic() {
		return cbtTesterBusinessLogic;
	}

	/**
	 * @param cbtTesterBusinessLogic the cbtTesterBusinessLogic to set
	 */
	public void setCbtTesterBusinessLogic(
			ICbtTesterBusinessLogic cbtTesterBusinessLogic) {
		this.cbtTesterBusinessLogic = cbtTesterBusinessLogic;
	}

	/**
	 * @return the cbtTitleList
	 */
	public List<MyTitle> getCbtTitleList() {
		return cbtTitleList;
	}

	/**
	 * @param cbtTitleList the cbtTitleList to set
	 */
	public void setCbtTitleList(List<MyTitle> cbtTitleList) {
		this.cbtTitleList = cbtTitleList;
	}

}

