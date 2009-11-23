package com.gameif.backoffice.helper;

import java.util.Map;

public class BackOfficeProperties {
			
		/** 権限レベルマップ */
		private Map<String, String> authorityLevels;
		/** 問合せ種別マップ */
		private Map<String, String> inquiryTypes;
		/** 問合せの対応状況マップ */
		private Map<Integer, String> correspondStatus;

		/**
		 * @return the authorityLevels
		 */
		public Map<String, String> getAuthorityLevels() {
			return authorityLevels;
		}

		/**
		 * @param authorityLevels the authorityLevels to set
		 */
		public void setAuthorityLevels(Map<String, String> authorityLevels) {
			this.authorityLevels = authorityLevels;
		}

		/**
		 * @return the inquiryTypes
		 */
		public Map<String, String> getInquiryTypes() {
			return inquiryTypes;
		}

		/**
		 * @param inquiryTypes the inquiryTypes to set
		 */
		public void setInquiryTypes(Map<String, String> inquiryTypes) {
			this.inquiryTypes = inquiryTypes;
		}

		/**
		 * @return the correspondStatus
		 */
		public Map<Integer, String> getCorrespondStatus() {
			return correspondStatus;
		}

		/**
		 * @param correspondStatus the correspondStatus to set
		 */
		public void setCorrespondStatus(Map<Integer, String> correspondStatus) {
			this.correspondStatus = correspondStatus;
		}
}
