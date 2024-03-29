package com.gameif.portal.action.pointCharge;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gameif.portal.businesslogic.IJointPointChargeBusinessLogic;
import com.gameif.portal.entity.JointSettlementHist;
import com.gameif.portal.entity.MemSettlementTrns;
import com.gameif.portal.entity.PointMst;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.entity.SettlementMst;
import com.gameif.portal.util.ContextUtil;

public class JointPointChargeControlAction extends PointChargeControlAction {

	private static final long serialVersionUID = -7492565950587701715L;

	private IJointPointChargeBusinessLogic jointPointChargeBusinessLogic = null;
	
	private String titleName;
	private String serverName;
	private List<PointMst> pointList;
	
	private String decorator;
	
	public String chargeEntry() {
		
		return "entry";
	}
	
	/**
	 * ポイントチャージ（ポイント選択）画面に案内する
	 * @return
	 */
	public String chargePointSelect() {
		
		ServerMst serverMst = new ServerMst();
		
		serverMst.setServerId(getModel().getServerId());
		serverMst.setTitleId(getModel().getTitleId());
		serverMst.setProviderId(ContextUtil.getProviderId());
		
		serverName = getMasterInfoBusinessLogic().getServer(serverMst).getServerName();
		titleName = getMasterInfoBusinessLogic().getValidTitle(getModel().getTitleId()).getTitleName();
		pointList = getMasterInfoBusinessLogic().getAllValidPointListByTitle(getModel().getTitleId());
		
		return "pointSelect";
	}
	
	@Override
	protected int getPlayHistCount() {
		
		return jointPointChargeBusinessLogic.countPlayHist(ContextUtil.getExternalMemberNo(), getModel().getTitleId(), getModel().getServerId());
	}

	@Override
	protected void setMemberNum(MemSettlementTrns settlementTrns) {
		
		settlementTrns.setMemNum(ContextUtil.getExternalMemberNo());
	}

	@Override
	protected void setProviderId(MemSettlementTrns settlementTrns) {
		
		settlementTrns.setProviderId(ContextUtil.getProviderId());
	}

	@Override
	protected int createSettlementTrns(MemSettlementTrns settlementTrns) {
		
		return jointPointChargeBusinessLogic.createSettlementTrns(settlementTrns);
	}

	@Override
	protected void createSettlementHist() throws Exception {
		
		JointSettlementHist settlementHist = new JointSettlementHist();
		
		BeanUtils.copyProperties(getModel(), settlementHist);
		
		jointPointChargeBusinessLogic.createSettlementHist(settlementHist);
	}

	@Override
	protected List<SettlementMst> getSettlementMstList() {
		
		return jointPointChargeBusinessLogic.getSettlementListForCharge(ContextUtil.getExternalMemberNo());
	}
	
	/**
	 * チャージ履歴画面に案内する
	 * @return チャージ履歴画面
	 */
	public String chargeSettlementHist() {
		
		setSettleHistList(jointPointChargeBusinessLogic.getSettlementHistListByMemNum(ContextUtil.getExternalMemberNo()));
		
		return "settlementHist";
	}

	public void setJointPointChargeBusinessLogic(
			IJointPointChargeBusinessLogic jointPointChargeBusinessLogic) {
		this.jointPointChargeBusinessLogic = jointPointChargeBusinessLogic;
	}

	public String getTitleName() {
		return titleName;
	}

	public String getServerName() {
		return serverName;
	}

	public List<PointMst> getPointList() {
		return pointList;
	}

	public String getDecorator() {
		return decorator;
	}

	public void setDecorator(String decorator) {
		this.decorator = decorator;
	}
}
