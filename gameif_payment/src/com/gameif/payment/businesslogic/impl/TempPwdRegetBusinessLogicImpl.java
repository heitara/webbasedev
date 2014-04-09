package com.gameif.payment.businesslogic.impl;

import java.util.Date;
import java.util.HashMap;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.common.util.SecurityUtil;
import com.gameif.payment.businesslogic.ITempPwdRegetBusinessLogic;
import com.gameif.payment.constants.PortalConstants;
import com.gameif.payment.dao.IMemberInfoDao;
import com.gameif.payment.dao.ITempPwdInfoDao;
import com.gameif.payment.entity.MemberInfo;
import com.gameif.payment.entity.TempPwdInfo;

public class TempPwdRegetBusinessLogicImpl extends BaseBusinessLogic implements
		ITempPwdRegetBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5764703108289976473L;

	private ITempPwdInfoDao tempPwdInfoDao;
	private IMemberInfoDao memberInfoDao;
	private TemplateMailer templateMailer;

	/**
	 * @return the tempPwdInfoDao
	 */
	public ITempPwdInfoDao getTempPwdInfoDao() {
		return tempPwdInfoDao;
	}

	/**
	 * @param tempPwdInfoDao
	 *            the tempPwdInfoDao to set
	 */
	public void setTempPwdInfoDao(ITempPwdInfoDao tempPwdInfoDao) {
		this.tempPwdInfoDao = tempPwdInfoDao;
	}

	/**
	 * @return the memberInfoDao
	 */
	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	/**
	 * @param memberInfoDao
	 *            the memberInfoDao to set
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	/**
	 * @return the templateMailer
	 */
	public TemplateMailer getTemplateMailer() {
		return templateMailer;
	}

	/**
	 * @param templateMailer the templateMailer to set
	 */
	public void setTemplateMailer(TemplateMailer templateMailer) {
		this.templateMailer = templateMailer;
	}

	/**
	 * 仮パスワードを発行する
	 */
	@Override
	public void saveTempPwdInfo(TempPwdInfo tempPwdInfo, MemberInfo memberInfo)  throws LogicException {
		
		// 画面で入力したメールアドレースと質問と答えにより、会員情報を検索する
		MemberInfo member = memberInfoDao.selectForPwdReget(memberInfo);
		
		if (member == null) {
			
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		// 該当会員に対して、残っているレコードを削除する。
		tempPwdInfoDao.deleteByMemNum(member.getMemNum());
		
		// データを登録する。
		tempPwdInfo.setCreatedDate(new Date());
		tempPwdInfo.setMemNum(member.getMemNum());
		// 臨時認証キーを設定する
		tempPwdInfo.setTempKey(SecurityUtil.getRandomAuthKey(10));
	
		tempPwdInfoDao.save(tempPwdInfo);

		// お知らせメールを送信する。
		HashMap<String, String> props = new HashMap<String, String>();
		props.put("nickName", member.getNickName());
//		props.put("tempKey", tempPwdInfo.getTempKey());
//		props.put("memNum",member.getMemNum().toString());
		props.put(PortalConstants.Key.SEURE_PARAM_KEY, SecurityUtil.encodeParam(new StringBuffer()
			.append("memNum=")
			.append(member.getMemNum().toString())
			.append("&tempKey=")
			.append(tempPwdInfo.getTempKey())
			.toString()));
		
		templateMailer.sendAsyncMail(memberInfo.getMailPc(), "createPwdReget", props);
	}
}
