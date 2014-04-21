package com.gameif.payment.businesslogic.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.SystemException;
import com.gameif.payment.businesslogic.IPaymentBusinessLogic;
import com.gameif.payment.dao.IOrderDao;
import com.gameif.payment.dao.ISettlementDao;
import com.gameif.payment.entity.Order;
import com.gameif.payment.entity.Settlement;

public class PaymentBusinessLogicImpl extends BaseBusinessLogic implements IPaymentBusinessLogic {

	private static final long serialVersionUID = 5064320624553235706L;
	
	//private final static Log logger = LogFactory.getLog(PaymentBusinessLogicImpl.class);

	private IOrderDao orderDao;
	private ISettlementDao settlementDao;
	

	/**
	 * 仮決済を登録する
	 * @param order　仮決済情報
	 */
	@Transactional
	@Override
	public void createOrder(Order order) {
		
		orderDao.save(order);
	}
	
	/**
	 * 本決済を登録する
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Transactional
	@Override
	public void createSettlement(Long orderId, String sbpsTrackingId) throws LogicException {
		
		// 仮決済情報を取得する
		Order order = orderDao.selectForUpdate(orderId);
		
		if(order == null) {
			throw new LogicException("The order[id=" + orderId + "] not exists.");
		}
		
		Settlement settlement = new Settlement();
		
		try {
			
			BeanUtils.copyProperties(settlement, order);
			
		} catch(Exception ex) {
			
			throw new SystemException(ex);
		}
		
		settlement.setSettlementDate(new Date());
		settlement.setSbpsTrackingId(sbpsTrackingId);
		settlementDao.save(settlement);
		orderDao.deleteByKey(orderId);
		
		doCallback(settlement);
	}
	
	private void doCallback(Settlement settlement) {

		//TODO: do callback.
	}
}