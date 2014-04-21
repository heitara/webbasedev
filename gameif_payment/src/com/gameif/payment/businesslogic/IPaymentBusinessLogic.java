package com.gameif.payment.businesslogic;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.exception.LogicException;
import com.gameif.payment.entity.Order;

public interface IPaymentBusinessLogic {

	/**
	 * 仮決済を登録する
	 * @param settlementTrns 仮決済情報（必要な項目が格納されていること）
	 */
	public void createOrder(Order order);

	/**
	 * 決済履歴を登録する
	 * @param settlementTrns 決済履歴情報（必要な項目が格納されていること）
	 */
	@Transactional
	public void createSettlement(Long orderId, String sbpsTrackingId) throws LogicException;

}
