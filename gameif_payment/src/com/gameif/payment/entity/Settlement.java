package com.gameif.payment.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gameif.common.entity.BaseEntity;

public class Settlement extends BaseEntity {

	private static final long serialVersionUID = 4187902858833042314L;


	/**
	 * 決済番号
	 */
	private Long id;
	/**
	 * ユーザーID：  [clientId]-[clCatId]-[<clUserId]
	 */
	private String userId;
	/**
	 * 商品ID： [clientId]-[clCatId]-[clItemId]
	 */
	private String itemId;
	/**
	 * 商品名： [clItemName]
	 */
	private String itemName;
	/**
	 * 商品名： [clPrice]
	 */
	private BigDecimal price;
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
	 * 決済成約日時
	 */
	private Date settlementDate;

	private String clientId;
	private String clCatId;
	private String clOrderId;
	private String clUserId;
	private String clItemId;
	/**
	 * 決済通知受付URL
	 */
	private String clCallback;
	
	private Long settlementNum;

	private String settlementLog;
	private String settlementRemarks;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
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
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
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
	public String getClCallback() {
		return clCallback;
	}
	public void setClCallback(String clCallback) {
		this.clCallback = clCallback;
	}
	public Long getSettlementNum() {
		return settlementNum;
	}
	public void setSettlementNum(Long settlementNum) {
		this.settlementNum = settlementNum;
	}
	public String getSettlementLog() {
		return settlementLog;
	}
	public void setSettlementLog(String settlementLog) {
		this.settlementLog = settlementLog;
	}
	public String getSettlementRemarks() {
		return settlementRemarks;
	}
	public void setSettlementRemarks(String settlementRemarks) {
		this.settlementRemarks = settlementRemarks;
	}
}
