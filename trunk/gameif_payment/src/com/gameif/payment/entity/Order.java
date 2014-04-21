package com.gameif.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gameif.common.entity.BaseEntity;
import com.gameif.common.exception.SystemException;

public class Order extends BaseEntity {
	
	private static final long serialVersionUID = 3484982922743471565L;

	/**
	 * オーダー番号
	 */
	private Long id;
	private String clientId;
	private String clCatId;
	private String clOrderId;
	private String clUserId;
	private String clItemId;
	private String clItemName;
	private BigDecimal clPrice;
	private Date clOrderDate;
	
	/**
	 * 支払い方法： credit3d | webmoney | bitcash | netcash
	 */
	private String paymentMethod;
	/**
	 * 決済処理状態<br/>
	 * 0:決済受付, 1:決済代行依頼, 2:決済エラー, 9:決済成約
	 */
	private String status;
	/**
	 * 決済代行依頼日時
	 */
	private Date orderDate;

	/**
	 * 決済通知受付URL
	 */
	private String clCallback;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClCatId() {
		return clCatId;
	}
	public void setClCatId(String clCatId) {
		this.clCatId = clCatId;
	}
	public String getClOrderId() {
		return clOrderId;
	}
	public void setClOrderId(String clOrderId) {
		this.clOrderId = clOrderId;
	}
	public String getClUserId() {
		return clUserId;
	}
	public void setClUserId(String clUserId) {
		this.clUserId = clUserId;
	}
	public String getClItemId() {
		return clItemId;
	}
	public void setClItemId(String clItemId) {
		this.clItemId = clItemId;
	}
	public Date getClOrderDate() {
		return clOrderDate;
	}
	public void setClOrderDate(Date clOrderDate) {
		this.clOrderDate = clOrderDate;
	}
	public String getClCallback() {
		return clCallback;
	}
	public void setClCallback(String clCallback) {
		this.clCallback = clCallback;
	}
	public String getClItemName() {
		return clItemName;
	}
	public void setClItemName(String clItemName) {
		this.clItemName = clItemName;
	}
	public BigDecimal getClPrice() {
		return clPrice;
	}
	public void setClPrice(BigDecimal clPrice) {
		this.clPrice = clPrice;
	}
	public String getUserId() {
		if(StringUtils.isEmpty(this.clientId) || StringUtils.isEmpty(this.clCatId) || StringUtils.isEmpty(this.clUserId)) {
			return null;
		}
		return new StringBuffer()
				.append(this.clientId)
				.append("-")
				.append(this.clCatId)
				.append("-")
				.append(this.clUserId)
				.toString();
	}
	public void setUserId(String userId) {
		String[] v = userId.split("-");
		if(v != null && v.length == 3) {
			if(StringUtils.isEmpty(this.clientId)) {
				this.clientId = v[0];
			} else if(this.clientId != v[0]) {
				throw new SystemException("ClientId is not match.");
			}
			if(StringUtils.isEmpty(this.clCatId)) {
				this.clCatId = v[1];
			} else if(this.clCatId != v[1]) {
				throw new SystemException("ClCatId is not match.");
			}
			this.clUserId = v[2];
		}
	}
	public String getItemId() {
		if(StringUtils.isEmpty(this.clientId) || StringUtils.isEmpty(this.clCatId) || StringUtils.isEmpty(this.clItemId)) {
			return null;
		}
		return new StringBuffer()
				.append(this.clientId)
				.append("-")
				.append(this.clCatId)
				.append("-")
				.append(this.clItemId)
				.toString();
	}
	public void setItemId(String itemId) {
		String[] v = itemId.split("-");
		if(v != null && v.length == 3) {
			if(StringUtils.isEmpty(this.clientId)) {
				this.clientId = v[0];
			} else if(this.clientId != v[0]) {
				throw new SystemException("ClientId is not match.");
			}
			if(StringUtils.isEmpty(this.clCatId)) {
				this.clCatId = v[1];
			} else if(this.clCatId != v[1]) {
				throw new SystemException("ClCatId is not match.");
			}
			this.clItemId = v[2];
		}
	}
	public BigDecimal getPrice() {
		return this.getClPrice();
	}
	public void setPrice(BigDecimal price) {
		this.setClPrice(price);
	}
}