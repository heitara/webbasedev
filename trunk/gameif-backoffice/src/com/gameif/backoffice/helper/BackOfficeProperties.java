package com.gameif.backoffice.helper;

import java.util.Map;

public class BackOfficeProperties {
			
		/** 権限レベルマップ */
		private Map<String, String> authorityLevels;

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
}
