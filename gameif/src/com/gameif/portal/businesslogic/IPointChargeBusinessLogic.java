package com.gameif.portal.businesslogic;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.exception.LogicException;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MemSettlementTrns;

public interface IPointChargeBusinessLogic {

	/**
	 * 仮決済を登録する
	 * @param settlementTrns 仮決済情報（必要な項目が格納されていること）
	 */
	public int saveSettlementTrns(MemSettlementTrns settlementTrns) throws LogicException;
	
	public MemSettlementTrns getSettlementTrnsByKey(Long settleTrnsNum);

	/**
	 * 決済履歴を登録する
	 * @param settlementTrns 決済履歴情報（必要な項目が格納されていること）
	 */
	@Transactional
	public void createSettlementHist(MemSettlementHist settlementHist) throws Exception;
	
	/**
	 * 会員番号とタイトルIDより、ゲームのプレイ回数を取得する
	 * @param memNum 会員番号
	 * @param titleId タイトルID
	 * @return プレイ回数
	 */
	public Integer countPlayHist(Integer titleId);

}
