package com.gameif.payment.entity;

import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class MyTitle extends BaseEntity {
	
	private static final long serialVersionUID = 1495023899031741425L;

	private Integer titleId;
	private String titleName;
	private String titleAbout;
	private String serviceStatus;
	private String recruitStatus;
	private String siteUrl;
	private String newsUrl;
	private String forumUrl;
	private String paymentUrl;
	private String bigIconUrl;
	private String smallIconUrl;
	private Integer orderNum;
	private Integer playersNum;
	private String announce;
	private Date playDate;
	private Integer playCount;
	private String electStatus;
	
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getTitleAbout() {
		return titleAbout;
	}
	public void setTitleAbout(String titleAbout) {
		this.titleAbout = titleAbout;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
	/**
	 * @return the recruitStatus
	 */
	public String getRecruitStatus() {
		return recruitStatus;
	}
	/**
	 * @param recruitStatus the recruitStatus to set
	 */
	public void setRecruitStatus(String recruitStatus) {
		this.recruitStatus = recruitStatus;
	}
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	public String getNewsUrl() {
		return newsUrl;
	}
	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}
	public String getForumUrl() {
		return forumUrl;
	}
	public void setForumUrl(String forumUrl) {
		this.forumUrl = forumUrl;
	}
	public String getPaymentUrl() {
		return paymentUrl;
	}
	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}
	public String getBigIconUrl() {
		return bigIconUrl;
	}
	public void setBigIconUrl(String bigIconUrl) {
		this.bigIconUrl = bigIconUrl;
	}
	public String getSmallIconUrl() {
		return smallIconUrl;
	}
	public void setSmallIconUrl(String smallIconUrl) {
		this.smallIconUrl = smallIconUrl;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getPlayersNum() {
		return playersNum;
	}
	public void setPlayersNum(Integer playersNum) {
		this.playersNum = playersNum;
	}
	public String getAnnounce() {
		return announce;
	}
	public void setAnnounce(String announce) {
		this.announce = announce;
	}
	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}
	public Integer getPlayCount() {
		return playCount;
	}
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}
	/**
	 * @return the betaTester
	 */
	public String getElectStatus() {
		return electStatus;
	}
	/**
	 * @param electStatus the electStatus to set
	 */
	public void setElectStatus(String electStatus) {
		this.electStatus = electStatus;
	}
	
}
