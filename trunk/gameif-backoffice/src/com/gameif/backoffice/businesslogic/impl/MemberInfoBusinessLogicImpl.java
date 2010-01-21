package com.gameif.backoffice.businesslogic.impl;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gameif.backoffice.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.backoffice.constants.BackofficeConstants;
import com.gameif.backoffice.dao.IMemberInfoDao;
import com.gameif.backoffice.dao.IMemberLoginInfoDao;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.backoffice.entity.MemberLoginInfo;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.helper.TemplateMailer;

public class MemberInfoBusinessLogicImpl extends BaseBusinessLogic implements IMemberInfoBusinessLogic {

	private static final long serialVersionUID = -1903255586967518866L;
	
	private final static Log logger = LogFactory.getLog(MemberInfoBusinessLogicImpl.class);

	private IMemberInfoDao memberInfoDao;
	private IMemberLoginInfoDao memberLoginInfoDao;
	private TemplateMailer templateMailer;

	@Override
	public MemberInfo getMemberInfoByMemNum(Long memNum) {
		MemberInfo key = new MemberInfo();
		key.setMemNum(memNum);
		
		return memberInfoDao.selectByKey(key);
	}

	@Transactional
	@Override
	public void freezeMemberInfo(String memId) {
		String[] memberList = memId.split(",");

		MemberInfo member = null;
		Date now = new Date();
		
		for (int i = 0; i < memberList.length; i++) {
			member = memberInfoDao.selectByMemIdForUpdate(memberList[i]);
			if (member == null) {
				continue;
			}
			
			member.setMemValidYNCd(BackofficeConstants.MemberValidYNCd.FREEZE);
			member.setLastUpdateDate(now);
			member.setLastUpdateUser(ContextUtil.getUserId());
			
			memberInfoDao.update(member);
			
			MemberLoginInfo memberLoginInfo = new MemberLoginInfo();
			
			memberLoginInfo.setMemNum(member.getMemNum());
			memberLoginInfo.setMemId(member.getMemId());
			memberLoginInfo.setMemPwd(member.getMemPwd());
			memberLoginInfo.setNickName(member.getNickName());
			memberLoginInfo.setMemValidYNCd(member.getMemValidYNCd());
			
			memberLoginInfoDao.update(memberLoginInfo);
			
			try {
				// お知らせメールを送信する。
				HashMap<String, String> props = new HashMap<String, String>();
				props.put("nickName", member.getNickName());			
				props.put("memId", member.getMemId());	
				templateMailer.sendAsyncMail(member.getMailPc(), "freezeMember", props);
			} catch (Exception ex) {
				logger.error("error has occurred in sending withdraw mail. ", ex);
			}
		}
		
	}
	
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		
		this.memberInfoDao = memberInfoDao;
	}

	/**
	 * @param memberLoginInfoDao the memberLoginInfoDao to set
	 */
	public void setMemberLoginInfoDao(IMemberLoginInfoDao memberLoginInfoDao) {
		this.memberLoginInfoDao = memberLoginInfoDao;
	}

	/**
	 * @param templateMailer the templateMailer to set
	 */
	public void setTemplateMailer(TemplateMailer templateMailer) {
		this.templateMailer = templateMailer;
	}
	
}