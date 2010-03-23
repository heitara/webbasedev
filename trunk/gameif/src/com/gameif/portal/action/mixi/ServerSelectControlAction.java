package com.gameif.portal.action.mixi;

import java.util.Date;
import java.util.List;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.portal.businesslogic.IMemberInfoForMixiBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.MemberInfoForMixi;
import com.gameif.portal.entity.ServerMst;

public class ServerSelectControlAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 467375535561559776L;

	private String memId;
	private String nickName;
	private String address;
	private Integer age;
	private Date birthYmd;
	private String sexCd;
	private String bloodType;
	private Boolean fromMixi;

	private IMemberInfoForMixiBusinessLogic memberInfoForMixiBusinessLogic;
	private List<ServerMst> servers;
	private boolean testUser;

	@Override
	public String input() {

		if (!getFromMixi() || getMemId() == null || getNickName() == null) {
			return "error";
		}
		
		MemberInfoForMixi memberForMixi = new MemberInfoForMixi();
		memberForMixi.setMemId(getMemId());
		memberForMixi.setNickName(getNickName());
		memberForMixi.setAddress(getAddress());
		memberForMixi.setAge(getAge());
		memberForMixi.setBirthYmd(getBirthYmd());
		memberForMixi.setSexCd(getSexCd());
		memberForMixi.setBloodType(getBloodType());
		
		String memAtbtCd = memberInfoForMixiBusinessLogic.checkMemberinfoForMixi(memberForMixi);
		if (memAtbtCd.length() == 0) {
			return "error";
		}
		
		servers = memberInfoForMixiBusinessLogic.getServersListForMixi(1);

		if (PortalConstants.MemberAtbtCd.TEST.equals(memAtbtCd)) {

			testUser = true;
		}
		
		return SUCCESS;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
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
	 * @return the sexCd
	 */
	public String getSexCd() {
		return sexCd;
	}

	/**
	 * @param sexCd
	 *            the sexCd to set
	 */
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}

	/**
	 * @return the bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}

	/**
	 * @param bloodType
	 *            the bloodType to set
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * @return the testUser
	 */
	public boolean isTestUser() {
		return testUser;
	}

	/**
	 * @param testUser
	 *            the testUser to set
	 */
	public void setTestUser(boolean testUser) {
		this.testUser = testUser;
	}

	/**
	 * @return the fromMixi
	 */
	public Boolean getFromMixi() {
		return fromMixi;
	}

	/**
	 * @param fromMixi
	 *            the fromMixi to set
	 */
	public void setFromMixi(Boolean fromMixi) {
		this.fromMixi = fromMixi;
	}

	/**
	 * @return the servers
	 */
	public List<ServerMst> getServers() {
		return servers;
	}

	/**
	 * @param servers
	 *            the servers to set
	 */
	public void setServers(List<ServerMst> servers) {
		this.servers = servers;
	}

	/**
	 * @param memberInfoForMixiBusinessLogic
	 *            the memberInfoForMixiBusinessLogic to set
	 */
	public void setMemberInfoForMixiBusinessLogic(
			IMemberInfoForMixiBusinessLogic memberInfoForMixiBusinessLogic) {
		this.memberInfoForMixiBusinessLogic = memberInfoForMixiBusinessLogic;
	}

	/**
	 * @return the memberInfoForMixiBusinessLogic
	 */
	public IMemberInfoForMixiBusinessLogic getMemberInfoForMixiBusinessLogic() {
		return memberInfoForMixiBusinessLogic;
	}

}
