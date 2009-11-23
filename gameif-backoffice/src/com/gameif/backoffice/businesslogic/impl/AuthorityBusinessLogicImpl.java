package com.gameif.backoffice.businesslogic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.backoffice.bean.AuthorityInfo;
import com.gameif.backoffice.businesslogic.IAuthorityBusinessLogic;
import com.gameif.backoffice.dao.IAuthorityDetailMstDao;
import com.gameif.backoffice.dao.IAuthorityMstDao;
import com.gameif.backoffice.entity.AuthorityDetailMst;
import com.gameif.backoffice.entity.AuthorityMst;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;

public class AuthorityBusinessLogicImpl extends BaseBusinessLogic implements
IAuthorityBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3287778262136809319L;
	
	private IAuthorityMstDao authorityMstDao;
	private IAuthorityDetailMstDao authorityDetailMstDao;

	/**
	 * 権限コードの重複性をチェックする
	 */
	@Override
	public Integer countAuthorityByCode(String code) {

		return authorityMstDao.selectAuthorityByCode(code);
	}

	/**
	 * 権限情報を登録する
	 */
	@Transactional
	@Override
	public void createAuthorityInfo(AuthorityInfo authorityInfo) {

		Date now = new Date();
		
		AuthorityMst authority = authorityInfo.getAuthority();
		authority.setCreatedUser(ContextUtil.getUserId());
		authority.setCreatedDate(now);
		authority.setLastUpdateUser(ContextUtil.getUserId());
		authority.setLastUpdateDate(now);
		
		// 権限管理を登録する
		authorityMstDao.save(authority);
		
		for (AuthorityDetailMst authorityDetail : authorityInfo.getAuthorityDetails()) {
			
			authorityDetail.setAuthorityCode(authority.getAuthorityCode());
			authorityDetail.setCreatedUser(ContextUtil.getUserId());
			authorityDetail.setCreatedDate(now);
			authorityDetail.setLastUpdateUser(ContextUtil.getUserId());
			authorityDetail.setLastUpdateDate(now);
			
			// 権限明細を登録する
			authorityDetailMstDao.save(authorityDetail);
		 }
	}

	/**
	 * 
	 */
	@Override
	public AuthorityInfo getAuthorityinfoByCode(String code) throws LogicException {
		AuthorityInfo authorityInfo = new AuthorityInfo();
		
		AuthorityMst authority = new AuthorityMst();
		authority.setAuthorityCode(code);
		authority = authorityMstDao.selectByKey(authority);
		if (authority == null) {
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		authorityInfo.setAuthority(authority);
		
		// 権限明細を取得する
		List<AuthorityDetailMst> authorityDetails = authorityDetailMstDao.selectListByAuthorityCode(code);
		if (authorityDetails == null) {
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		authorityInfo.setAuthorityDetails(authorityDetails);
			
		
		return authorityInfo;
	}

	@Transactional
	@Override
	public void updateAuthorityInfo(AuthorityInfo authorityInfo) {

		Date now = new Date();
		
		AuthorityMst authority = authorityInfo.getAuthority();
		authority.setLastUpdateUser(ContextUtil.getUserId());
		authority.setLastUpdateDate(now);
		
		// 権限管理を登録する
		authorityMstDao.update(authority);
		// 権限明細を削除する
		authorityDetailMstDao.deleteByAuthorityCode(authority.getAuthorityCode());
		
		for (AuthorityDetailMst authorityDetail : authorityInfo.getAuthorityDetails()) {
			
			authorityDetail.setAuthorityCode(authority.getAuthorityCode());
			authorityDetail.setCreatedUser(ContextUtil.getUserId());
			authorityDetail.setCreatedDate(now);
			authorityDetail.setLastUpdateUser(ContextUtil.getUserId());
			authorityDetail.setLastUpdateDate(now);
			
			// 権限明細を登録する
			authorityDetailMstDao.save(authorityDetail);
		 }
	}

	/**
	 * 画面の検索条件により、権限一覧を検索する
	 */
	@Override
	public List<AuthorityMst> selectAuthorityList(AuthorityMst authorityMst) {
		return authorityMstDao.selectAuthorityList(authorityMst);
	}

	/**
	 * 権限情報を削除する
	 */
	@Transactional
	@Override
	public void deleteAuthorityMst(List<String> authorityCodes) {
		
		for (int i = 0; i < authorityCodes.size(); i++) {
			// 権限を削除する
			authorityMstDao.deleteByAuthorityCode(authorityCodes.get(i).toString());
			// 権限明細を削除する
			authorityDetailMstDao.deleteByAuthorityCode(authorityCodes.get(i).toString());
			
		}
		
	}

	/**
	 * @return the authorityMstDao
	 */
	public IAuthorityMstDao getAuthorityMstDao() {
		return authorityMstDao;
	}

	/**
	 * @param authorityMstDao the authorityMstDao to set
	 */
	public void setAuthorityMstDao(IAuthorityMstDao authorityMstDao) {
		this.authorityMstDao = authorityMstDao;
	}

	/**
	 * @return the authorityDetailMstDao
	 */
	public IAuthorityDetailMstDao getAuthorityDetailMstDao() {
		return authorityDetailMstDao;
	}

	/**
	 * @param authorityDetailMstDao the authorityDetailMstDao to set
	 */
	public void setAuthorityDetailMstDao(
			IAuthorityDetailMstDao authorityDetailMstDao) {
		this.authorityDetailMstDao = authorityDetailMstDao;
	}
}
