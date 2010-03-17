package org.jasig.cas.util;

public class AuthConsts {
	
	public class Key {
		
		public final static String SERVICE = "service";
		public final static String OP = "op";
		public final static String FROM = "from";
		public final static String TIME = "time";
		public final static String OPENID_SIGN = "openIdSign";
		public final static String OPENID_ID = "openIDIdentity";
		public final static String OPENID_ENTRY_PAGE = "openIDEntryPage";
		public final static String OPENID_SELECT_PAGE = "openIDSelectPage";
		public final static String OPENID_PROVIDER_PAGE = "openIDProviderPage";

		public class Result {

			public final static String SUCCESS = "success";
			public final static String INPUT = "input";
			public final static String FALSE = "false";
			public final static String CANCEL = "cancel";
			public final static String ERROR = "error";
		}
		
		public class Member {
			
			public final static String MEM_NUM = "memNum";
			public final static String MEM_ID = "memId";
			public final static String NICK_NAME = "nickName";
			public final static String MAIL = "mailPc";
		}
		
		public class OpenID {

			public final static String ATTR_MAC = "openid_mac";
			public final static String ATTR_ALIAS = "openid_alias";
			public final static String RESPONSE_NONCE = "openid.response_nonce";
			public final static String MODE = "openid.mode";
		}
		
	}
	
	public class Encode {

		public final static String UTF8 = "UTF-8";
	}
	
	public class Time {

		public final static long ONE_HOUR = 3600000L;
		public final static long TWO_HOUR = ONE_HOUR * 2L;
	}

}
