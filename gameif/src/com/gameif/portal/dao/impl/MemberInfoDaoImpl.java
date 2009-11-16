package com.gameif.portal.dao.impl;

import com.gameif.common.bean.ComSearchCondition;
import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.entity.MemberInfo;

public class MemberInfoDaoImpl extends AbstractBaseDao<MemberInfo, MemberInfo>
		implements IMemberInfoDao {

	/**
	 * 会員番号でロック状態で会員情報を取得する。
	 * 
	 * @param memNum
	 *            会員番号
	 * @return　会員情報
	 */
	@Override
	public MemberInfo selectForUpdate(Long memNum) {

		return (MemberInfo) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectForUpdate", memNum));
	}

	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する。
	 * 
	 * @param clientIP
	 *            クライアントＩＰ
	 * @param checkTime
	 *            チェックする時間
	 * @return 件数
	 */
	@Override
	public int selectCountByIPAndTime(String clientIP, Integer checkTime) {

		ComSearchCondition cond = new ComSearchCondition();

		cond.setClientIp(clientIP);
		cond.setCheckTime(checkTime);

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectCountByIPAndTime", cond));
	}

	/**
	 * アカウントＩＤで会員情報を検索する。
	 * 
	 * @param memId
	 * @return MemberInfo
	 */
	@Override
	public MemberInfo selectByMemId(String memId) {

		return (MemberInfo) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectByMemId", memId));
	}

	/**
	 * 指定したアカウントＩＤの件数を検索する。
	 * 
	 * @param memId
	 *            アカウントＩＤ
	 * @return 件数
	 */
	@Override
	public int selectCountByMemId(String memId) {

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectCountByMemId", memId));
	}

	/**
	 * 指定したアカウントＩＤの件数を検索する。 <br/>
	 * 会員番号を指定した場合、その会員は対象外とする。
	 * 
	 * @param memId
	 *            アカウントＩＤ
	 * @param memNum
	 *            会員番号
	 * @return 件数
	 */
	@Override
	public int selectCountByMemId(String memId, Long memNum) {

		ComSearchCondition cond = new ComSearchCondition();

		cond.setMemNum(memNum);
		cond.setMemId(memId);

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectCountByMemIdForOther", cond));
	}

	/**
	 * 指定したニックネームの件数を検索する。
	 * 
	 * @param nickName
	 *            ニックネーム
	 * @return 件数
	 */
	@Override
	public int selectCountByNickName(String nickName) {

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectCountByNickName", nickName));
	}

	/**
	 * 指定したニックネームの件数を検索する。 <br/>
	 * 会員番号を指定した場合、その会員は対象外とする。
	 * 
	 * @param nickName
	 *            ニックネーム
	 * @param memNum
	 *            会員番号
	 * @return 件数
	 */
	@Override
	public int selectCountByNickName(String nickName, Long memNum) {

		ComSearchCondition cond = new ComSearchCondition();

		cond.setMemNum(memNum);
		cond.setNickName(nickName);

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectCountByNickNameForOther", cond));
	}

	/**
	 * 指定したパソコンメールの件数を検索する。
	 * 
	 * @param mailPc
	 *            メールアドレス
	 * @return 件数
	 */
	@Override
	public int selectCountByMailPc(String mailPc) {

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectCountByMailPc", mailPc));
	}

	/**
	 * 指定したパソコンメールの件数を検索する。 <br/>
	 * 会員番号を指定した場合、その会員は対象外とする。
	 * 
	 * @param mailPc
	 *            メールアドレス
	 * @param memNum
	 *            会員番号
	 * @return 件数
	 */
	@Override
	public int selectCountByMailPc(String mailPc, Long memNum) {

		ComSearchCondition cond = new ComSearchCondition();

		cond.setMemNum(memNum);
		cond.setMailPc(mailPc);

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectCountByMailPcForOther", cond));
	}

	/**
	 * メールアドレースと質問と答えにより、会員情報を検索する 。
	 * 
	 * @param memberinfo
	 *            会員情報
	 * @return 会員情報
	 */
	@Override
	public MemberInfo selectForPwdReget(MemberInfo memberinfo) {
		return (MemberInfo) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectForPwdReget", memberinfo));
	}

	/**
	 * 会員番号とIDにより、会員情報を検索する
	 * @param memberInfo
	 * @return 会員情報 
	 */
	@Override
	public MemberInfo selectByNumAndIDForUpdate(MemberInfo memberInfo) {
		return (MemberInfo) (getSqlMapClientTemplate().queryForObject(namespace + ".selectByNumAndIDForUpdate", memberInfo));
	}

}
