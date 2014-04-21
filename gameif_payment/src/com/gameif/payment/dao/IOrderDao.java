package com.gameif.payment.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.Order;

public interface IOrderDao extends IBaseDao<Order, Order> {

	/**
	 * 仮決済番号でロック状態で仮決済情報を取得する
	 * 
	 * @param id 仮決済番号
	 * @return　仮決済情報
	 */
	public Order selectForUpdate(Long id);
	
	/**
	 * 仮決済情報を削除する
	 * @param id 仮決済番号
	 * @return
	 */
	public int deleteByKey(Long id);

}
