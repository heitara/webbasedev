package com.gameif.portal.interceptor;

import com.gameif.portal.businesslogic.IOpensocialMemberBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.JointMember;
import com.gameif.portal.util.ContextUtil;

public class OpensocialPointChargeTitleMaintenanceInterceptor extends PointChargeTitleMaintenanceInterceptor {
    
	private static final long serialVersionUID = -4908757732007241733L;

	private IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic;

    @Override
    protected boolean isTestUser() {
        
		boolean isTestUser = false;
		
		if (ContextUtil.getExternalMemberNo() != null) {

			JointMember member = opensocialMemberBusinessLogic.getMemberInfo(ContextUtil.getExternalMemberNo());
			
			if (member != null && member.getMemAtbtCd().equals(PortalConstants.MemberAtbtCd.TEST)) {
				
				isTestUser = true;
			}
		}
		
		return isTestUser;
    }

	public void setOpensocialMemberBusinessLogic(IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic) {
		
		this.opensocialMemberBusinessLogic = opensocialMemberBusinessLogic;
	}
}