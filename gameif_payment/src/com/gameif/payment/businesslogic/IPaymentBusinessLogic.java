package com.gameif.payment.businesslogic;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.exception.LogicException;
import com.gameif.payment.entity.Settlement;
import com.gameif.payment.entity.MemSettlementTrns;
import com.gameif.payment.entity.MySettlementHist;
import com.gameif.payment.entity.SettlementMst;

public interface IPaymentBusinessLogic {

	/**
	 * 仮決済を登録する
	 * @param settlementTrns 仮決済情報（必要な項目が格納されていること）
	 */
	public int createSettlementTrns(MemSettlementTrns settlementTrns);
	
	public MemSettlementTrns getSettlementTrnsByKey(Long settleTrnsNum);

	/**
	 * 決済履歴を登録する
	 * @param settlementTrns 決済履歴情報（必要な項目が格納されていること）
	 */
	@Transactional
	public void createSettlementHist(Settlement settlementHist) throws Exception;
	
	/**
	 * 会員番号とタイトルIDより、ゲームのプレイ回数を取得する
	 * @param memNum 会員番号
	 * @param titleId タイトルID
	 * @param serverId サーバID
	 * @return プレイ回数
	 */
	public Integer countPlayHist(Long memNum, Integer titleId, Integer serverId);
	
	public List<MySettlementHist> getSettlementHistListByMemNum(Long memNum);

	public List<SettlementMst> getSettlementListForCharge(Long memNum);

}
