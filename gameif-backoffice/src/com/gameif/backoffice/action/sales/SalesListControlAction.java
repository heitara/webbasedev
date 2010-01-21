package com.gameif.backoffice.action.sales;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.backoffice.bean.SalesSearchCondition;
import com.gameif.backoffice.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.backoffice.businesslogic.ISalesBusinessLogic;
import com.gameif.backoffice.entity.MySettlementList;
import com.gameif.backoffice.helper.BackOfficeProperties;
import com.gameif.common.action.ModelDrivenActionSupport;

public class SalesListControlAction extends
		ModelDrivenActionSupport<SalesSearchCondition> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5319950443622777499L;

	private BackOfficeProperties backOfficeProperties;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private ISalesBusinessLogic salesBusinessLogic;

	private List<MySettlementList> personDayList;
	private List<MySettlementList> personMonthList;
	private List<MySettlementList> titleDayList;
	private List<MySettlementList> titleMonthList;
	
	private BigDecimal totalPointAmount;
	
	public String input() {
		return INPUT;
	}
	
	public String search() {
		if (this.getModel().getSalesType().equals("1")) {
			searchPersonDayList();
			getPersonDayTotal();
		} else if (this.getModel().getSalesType().equals("2")) {
			searchPersonMonthList();
			getPersonMonthTotal();
		} else if (this.getModel().getSalesType().equals("3")) {
			searchTitleDayList();
			getTitleDayTotal();
		} else if (this.getModel().getSalesType().equals("4")) {
			searchTitleMonthList();
			getTitleMonthTotal();
		}
		
		return INPUT;
	}
	
	private void searchPersonDayList() {
		setPersonDayList(salesBusinessLogic.getPersonDayList(this.getModel()));
	}
	
	private void getPersonDayTotal() {
		setTotalPointAmount(salesBusinessLogic.getPersonDayTotal(this.getModel()));
	}
	
	private void searchPersonMonthList() {
		setPersonMonthList(salesBusinessLogic.getPersonMonthList(this.getModel()));
	}
	
	private void getPersonMonthTotal() {
		setTotalPointAmount(salesBusinessLogic.getPersonMonthTotal(this.getModel()));
	}
	
	private void searchTitleDayList() {
		setTitleDayList(salesBusinessLogic.getTitleDayList(this.getModel()));
	}
	
	private void getTitleDayTotal() {
		setTotalPointAmount(salesBusinessLogic.getTitleDayTotal(this.getModel()));
	}
	
	private void searchTitleMonthList() {
		setTitleMonthList(salesBusinessLogic.getTitleMonthList(this.getModel()));
	}
	
	private void getTitleMonthTotal() {
		setTotalPointAmount(salesBusinessLogic.getTitleMonthTotal(this.getModel()));
	}

	/**
	 * @return the backOfficeProperties
	 */
	public BackOfficeProperties getBackOfficeProperties() {
		return backOfficeProperties;
	}

	/**
	 * @param backOfficeProperties
	 *            the backOfficeProperties to set
	 */
	public void setBackOfficeProperties(
			BackOfficeProperties backOfficeProperties) {
		this.backOfficeProperties = backOfficeProperties;
	}

	/**
	 * @return the masterInfoBusinessLogic
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
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
	 * @return the personDayList
	 */
	public List<MySettlementList> getPersonDayList() {
		return personDayList;
	}

	/**
	 * @param personDayList
	 *            the personDayList to set
	 */
	public void setPersonDayList(List<MySettlementList> personDayList) {
		this.personDayList = personDayList;
	}

	/**
	 * @return the personMonthList
	 */
	public List<MySettlementList> getPersonMonthList() {
		return personMonthList;
	}

	/**
	 * @param personMonthList
	 *            the personMonthList to set
	 */
	public void setPersonMonthList(List<MySettlementList> personMonthList) {
		this.personMonthList = personMonthList;
	}

	/**
	 * @return the titleDayList
	 */
	public List<MySettlementList> getTitleDayList() {
		return titleDayList;
	}

	/**
	 * @param titleDayList
	 *            the titleDayList to set
	 */
	public void setTitleDayList(List<MySettlementList> titleDayList) {
		this.titleDayList = titleDayList;
	}

	/**
	 * @return the titleMonthList
	 */
	public List<MySettlementList> getTitleMonthList() {
		return titleMonthList;
	}

	/**
	 * @param titleMonthList
	 *            the titleMonthList to set
	 */
	public void setTitleMonthList(List<MySettlementList> titleMonthList) {
		this.titleMonthList = titleMonthList;
	}

	/**
	 * @param salesBusinessLogic the salesBusinessLogic to set
	 */
	public void setSalesBusinessLogic(ISalesBusinessLogic salesBusinessLogic) {
		this.salesBusinessLogic = salesBusinessLogic;
	}

	/**
	 * @return the totalPointAmount
	 */
	public BigDecimal getTotalPointAmount() {
		return totalPointAmount;
	}

	/**
	 * @param totalPointAmount the totalPointAmount to set
	 */
	public void setTotalPointAmount(BigDecimal totalPointAmount) {
		this.totalPointAmount = totalPointAmount;
	}

}
