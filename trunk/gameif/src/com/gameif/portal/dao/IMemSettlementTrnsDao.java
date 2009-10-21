package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemSettlementTrns;

public interface IMemSettlementTrnsDao extends IBaseDao<MemSettlementTrns, MemSettlementTrns> {

	/**
	 * 仮決済番号でロック状態で仮決済情報を取得する
	 * 
	 * @param settleTrnsNum
	 *            仮決済番号
	 * @return　仮決済情報
	 */
	public MemSettlementTrns selectForUpdate(Long settleTrnsNum);
	
	/**
	 * 仮決済情報を削除する
	 * @param settleTrnsNum 仮決済番号
	 * @return
	 */
	public int deleteByKey(Long settleTrnsNum);

}
