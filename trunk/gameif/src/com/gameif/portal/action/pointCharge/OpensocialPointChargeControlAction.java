package com.gameif.portal.action.pointCharge;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gameif.portal.businesslogic.IOpensocialPointChargeBusinessLogic;
import com.gameif.portal.entity.MemSettlementTrns;
import com.gameif.portal.entity.OpensocialSettlementHist;
import com.gameif.portal.entity.SettlementMst;
import com.gameif.portal.util.ContextUtil;

public class OpensocialPointChargeControlAction extends PointChargeControlAction {

	private static final long serialVersionUID = -7492565950587701715L;

	private IOpensocialPointChargeBusinessLogic opensocialPointChargeBusinessLogic = null;
	
	@Override
	protected int getPlayHistCount() {
		
		return opensocialPointChargeBusinessLogic.countPlayHist(ContextUtil.getExternalMemberNo(), getModel().getTitleId(), getModel().getServerId());
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
		
		return opensocialPointChargeBusinessLogic.createSettlementTrns(settlementTrns);
	}

	@Override
	protected void createSettlementHist() throws Exception {
		
		OpensocialSettlementHist settlementHist = new OpensocialSettlementHist();
		
		BeanUtils.copyProperties(getModel(), settlementHist);
		settlementHist.setProviderId(ContextUtil.getProviderId());
		
		opensocialPointChargeBusinessLogic.createSettlementHist(settlementHist);
	}

	@Override
	protected List<SettlementMst> getSettlementMstList() {
		
		return opensocialPointChargeBusinessLogic.getSettlementListForCharge(ContextUtil.getMemberNoWithExt());
	}

	public void setOpensocialPointChargeBusinessLogic(IOpensocialPointChargeBusinessLogic opensocialPointChargeBusinessLogic) {
		
		this.opensocialPointChargeBusinessLogic = opensocialPointChargeBusinessLogic;
	}
}