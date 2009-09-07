package com.gameif.portal.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MemberInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 300326522772761034L;

	private Integer memNum;
	private String memId;
	private String nickName;
	private String memPwd;
	private String memKindCd;
	private String memAtbtCd;
	private Integer questionCd;
	private String answer;
	private String mailPc;
	private String mailMobile;
	private String kanjiFname;
	private String kanjiLname;
	private String kanaFname;
	private String kanaLname;
	private Integer sexCd;
	private Date birthYmd;
	private Integer divisCd;
	private Integer occupCd;
	private String area;
	private String telNum;
	private String mailmagReqCd;
	private String mailmagObjCd;
	private String note;
	private String entryIp;
	private Date entryYmd;
	private String loginYmdIp;
	private Date loginYmd;
	private String loginFailIp;
	private Date loginFailYmd;
	private Integer loginFailCnt;
	private String lastUpdateIp;
	private Date lastUpdateYmd;
	private Integer versionNo;

	private String newPwd;
	private String confirmPwd;
	private String capture;
	private String magazine;
	private String agreement;

	/**
	 * @return the memNum
	 */
	public Integer getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum
	 *            the memNum to set
	 */
	public void setMemNum(Integer memNum) {
		this.memNum = memNum;
	}

	/**
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}

	/**
	 * @param memId
	 *            the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the memPwd
	 */
	public String getMemPwd() {
		return memPwd;
	}

	/**
	 * @param memPwd
	 *            the memPwd to set
	 */
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	/**
	 * @return the memKindCd
	 */
	public String getMemKindCd() {
		return memKindCd;
	}

	/**
	 * @param memKindCd
	 *            the memKindCd to set
	 */
	public void setMemKindCd(String memKindCd) {
		this.memKindCd = memKindCd;
	}

	/**
	 * @return the memAtbtCd
	 */
	public String getMemAtbtCd() {
		return memAtbtCd;
	}

	/**
	 * @param memAtbtCd
	 *            the memAtbtCd to set
	 */
	public void setMemAtbtCd(String memAtbtCd) {
		this.memAtbtCd = memAtbtCd;
	}

	/**
	 * @return the questionCd
	 */
	public Integer getQuestionCd() {
		return questionCd;
	}

	/**
	 * @param questionCd
	 *            the questionCd to set
	 */
	public void setQuestionCd(Integer questionCd) {
		this.questionCd = questionCd;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the mailPc
	 */
	public String getMailPc() {
		return mailPc;
	}

	/**
	 * @param mailPc
	 *            the mailPc to set
	 */
	public void setMailPc(String mailPc) {
		this.mailPc = mailPc;
	}

	/**
	 * @return the mailMobile
	 */
	public String getMailMobile() {
		return mailMobile;
	}

	/**
	 * @param mailMobile
	 *            the mailMobile to set
	 */
	public void setMailMobile(String mailMobile) {
		this.mailMobile = mailMobile;
	}

	/**
	 * @return the kanjiFname
	 */
	public String getKanjiFname() {
		return kanjiFname;
	}

	/**
	 * @param kanjiFname
	 *            the kanjiFname to set
	 */
	public void setKanjiFname(String kanjiFname) {
		this.kanjiFname = kanjiFname;
	}

	/**
	 * @return the kanjiLname
	 */
	public String getKanjiLname() {
		return kanjiLname;
	}

	/**
	 * @param kanjiLname
	 *            the kanjiLname to set
	 */
	public void setKanjiLname(String kanjiLname) {
		this.kanjiLname = kanjiLname;
	}

	/**
	 * @return the kanaFname
	 */
	public String getKanaFname() {
		return kanaFname;
	}

	/**
	 * @param kanaFname
	 *            the kanaFname to set
	 */
	public void setKanaFname(String kanaFname) {
		this.kanaFname = kanaFname;
	}

	/**
	 * @return the kanaLname
	 */
	public String getKanaLname() {
		return kanaLname;
	}

	/**
	 * @param kanaLname
	 *            the kanaLname to set
	 */
	public void setKanaLname(String kanaLname) {
		this.kanaLname = kanaLname;
	}

	/**
	 * @return the sexCd
	 */
	public Integer getSexCd() {
		return sexCd;
	}

	/**
	 * @param sexCd
	 *            the sexCd to set
	 */
	public void setSexCd(Integer sexCd) {
		this.sexCd = sexCd;
	}

	/**
	 * @return the birthYmd
	 */
	public Date getBirthYmd() {
		return birthYmd;
	}

	/**
	 * @param birthYmd
	 *            the birthYmd to set
	 */
	public void setBirthYmd(Date birthYmd) {
		this.birthYmd = birthYmd;
	}

	/**
	 * @return the divisCd
	 */
	public Integer getDivisCd() {
		return divisCd;
	}

	/**
	 * @param divisCd
	 *            the divisCd to set
	 */
	public void setDivisCd(Integer divisCd) {
		this.divisCd = divisCd;
	}

	/**
	 * @return the occupCd
	 */
	public Integer getOccupCd() {
		return occupCd;
	}

	/**
	 * @param occupCd
	 *            the occupCd to set
	 */
	public void setOccupCd(Integer occupCd) {
		this.occupCd = occupCd;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the telNum
	 */
	public String getTelNum() {
		return telNum;
	}

	/**
	 * @param telNum
	 *            the telNum to set
	 */
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	/**
	 * @return the mailmagReqCd
	 */
	public String getMailmagReqCd() {
		return mailmagReqCd;
	}

	/**
	 * @param mailmagReqCd
	 *            the mailmagReqCd to set
	 */
	public void setMailmagReqCd(String mailmagReqCd) {
		this.mailmagReqCd = mailmagReqCd;
	}

	/**
	 * @return the mailmagObjCd
	 */
	public String getMailmagObjCd() {
		return mailmagObjCd;
	}

	/**
	 * @param mailmagObjCd
	 *            the mailmagObjCd to set
	 */
	public void setMailmagObjCd(String mailmagObjCd) {
		this.mailmagObjCd = mailmagObjCd;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the entryIp
	 */
	public String getEntryIp() {
		return entryIp;
	}

	/**
	 * @param entryIp
	 *            the entryIp to set
	 */
	public void setEntryIp(String entryIp) {
		this.entryIp = entryIp;
	}

	/**
	 * @return the entryYmd
	 */
	public Date getEntryYmd() {
		return entryYmd;
	}

	/**
	 * @param entryYmd
	 *            the entryYmd to set
	 */
	public void setEntryYmd(Date entryYmd) {
		this.entryYmd = entryYmd;
	}

	/**
	 * @return the loginYmdIp
	 */
	public String getLoginYmdIp() {
		return loginYmdIp;
	}

	/**
	 * @param loginYmdIp
	 *            the loginYmdIp to set
	 */
	public void setLoginYmdIp(String loginYmdIp) {
		this.loginYmdIp = loginYmdIp;
	}

	/**
	 * @return the loginYmd
	 */
	public Date getLoginYmd() {
		return loginYmd;
	}

	/**
	 * @param loginYmd
	 *            the loginYmd to set
	 */
	public void setLoginYmd(Date loginYmd) {
		this.loginYmd = loginYmd;
	}

	/**
	 * @return the loginFailIp
	 */
	public String getLoginFailIp() {
		return loginFailIp;
	}

	/**
	 * @param loginFailIp
	 *            the loginFailIp to set
	 */
	public void setLoginFailIp(String loginFailIp) {
		this.loginFailIp = loginFailIp;
	}

	/**
	 * @return the loginFailYmd
	 */
	public Date getLoginFailYmd() {
		return loginFailYmd;
	}

	/**
	 * @param loginFailYmd
	 *            the loginFailYmd to set
	 */
	public void setLoginFailYmd(Date loginFailYmd) {
		this.loginFailYmd = loginFailYmd;
	}

	/**
	 * @return the loginFailCnt
	 */
	public Integer getLoginFailCnt() {
		return loginFailCnt;
	}

	/**
	 * @param loginFailCnt
	 *            the loginFailCnt to set
	 */
	public void setLoginFailCnt(Integer loginFailCnt) {
		this.loginFailCnt = loginFailCnt;
	}

	/**
	 * @return the lastUpdateIp
	 */
	public String getLastUpdateIp() {
		return lastUpdateIp;
	}

	/**
	 * @param lastUpdateIp
	 *            the lastUpdateIp to set
	 */
	public void setLastUpdateIp(String lastUpdateIp) {
		this.lastUpdateIp = lastUpdateIp;
	}

	/**
	 * @return the lastUpdateYmd
	 */
	public Date getLastUpdateYmd() {
		return lastUpdateYmd;
	}

	/**
	 * @param lastUpdateYmd
	 *            the lastUpdateYmd to set
	 */
	public void setLastUpdateYmd(Date lastUpdateYmd) {
		this.lastUpdateYmd = lastUpdateYmd;
	}

	/**
	 * @return the versionNo
	 */
	public Integer getVersionNo() {
		return versionNo;
	}

	/**
	 * @param versionNo
	 *            the versionNo to set
	 */
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * @return the newPwd
	 */
	public String getNewPwd() {
		return newPwd;
	}

	/**
	 * @param newPwd
	 *            the newPwd to set
	 */
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	/**
	 * @return the confirmPwd
	 */
	public String getConfirmPwd() {
		return confirmPwd;
	}

	/**
	 * @param confirmPwd
	 *            the confirmPwd to set
	 */
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	/**
	 * @return the capture
	 */
	public String getCapture() {
		return capture;
	}

	/**
	 * @param capture
	 *            the capture to set
	 */
	public void setCapture(String capture) {
		this.capture = capture;
	}

	/**
	 * @return the magazine
	 */
	public String getMagazine() {
		return magazine;
	}

	/**
	 * @param magazine
	 *            the magazine to set
	 */
	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

	/**
	 * @return the agreement
	 */
	public String getAgreement() {
		return agreement;
	}

	/**
	 * @param agreement
	 *            the agreement to set
	 */
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

}
