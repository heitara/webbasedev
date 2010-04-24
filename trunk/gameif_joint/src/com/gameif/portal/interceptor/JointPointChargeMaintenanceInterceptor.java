package com.gameif.portal.interceptor;

import com.gameif.portal.businesslogic.IJointMemberBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.JointMember;
import com.gameif.portal.util.ContextUtil;

public class JointPointChargeMaintenanceInterceptor extends PointChargeMaintenanceInterceptor {

	private static final long serialVersionUID = -4908757732007241733L;

	private IJointMemberBusinessLogic jointMemberBusinessLogic;

    @Override
    protected boolean isTestUser() {
        
    	boolean isTestUser = false;
		
		if (ContextUtil.getExternalMemberNo() != null) {

			JointMember member = jointMemberBusinessLogic.getMemberInfo(ContextUtil.getExternalMemberNo());
		
			if (member != null && member.getMemAtbtCd().equals(PortalConstants.MemberAtbtCd.TEST)) {
				
				isTestUser = true;
			}
		}
		
		return isTestUser;
    }

	public void setJointMemberBusinessLogic(IJointMemberBusinessLogic jointMemberBusinessLogic) {
		
		this.jointMemberBusinessLogic = jointMemberBusinessLogic;
	}
}