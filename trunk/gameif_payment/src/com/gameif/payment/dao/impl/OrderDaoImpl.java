package com.gameif.payment.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IOrderDao;
import com.gameif.payment.entity.Order;

public class OrderDaoImpl extends AbstractBaseDao<Order, Order>
		implements IOrderDao {
	
	/**
	 * 会員番号でロック状態で会員情報を取得する。
	 * @param id
	 * @return　Order
	 */
	@Override
	public Order selectForUpdate(Long id) {

		return (Order) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectForUpdate", id));
	}

	@Override
	public int deleteByKey(Long id) {

		return getSqlMapClientTemplate().delete(namespace + ".deleteByKey", id);
	}
}
