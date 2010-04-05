package com.gameif.portal.interceptor;

import com.gameif.portal.businesslogic.IOpensocialMemberBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.JointMember;

public class OpensocialPointChargeEntryInterceptor extends JointPointChargeEntryInterceptor {
	
	private static final long serialVersionUID = -9119576446431831491L;
	
	private IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic;

	
	protected JointMember getMemberByMemNum(Long memNum) {
		
		return opensocialMemberBusinessLogic.getMemberInfo(memNum);
	}
	
	@Override
	protected JointMember getMemberByMemIdAndProviderId(String memId, String providerId) {
		
		return opensocialMemberBusinessLogic.getMemberByMemIdAndProviderId(memId, providerId);
	}

	@Override
	protected void saveMemberInfo(String memId, String providerId) {
		
	}

	@Override
	protected String getProviderKind() {
		
		return PortalConstants.ProviderKind.OPENSOCIAL;
	}

	public void setOpensocialMemberBusinessLogic(IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic) {
		
		this.opensocialMemberBusinessLogic = opensocialMemberBusinessLogic;
	}
}