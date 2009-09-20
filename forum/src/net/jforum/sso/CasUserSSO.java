/*
 * Copyright (c) JForum Team
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, 
 * with or without modification, are permitted provided 
 * that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above 
 * copyright notice, this list of conditions and the 
 * following  disclaimer.
 * 2)  Redistributions in binary form must reproduce the 
 * above copyright notice, this list of conditions and 
 * the following disclaimer in the documentation and/or 
 * other materials provided with the distribution.
 * 3) Neither the name of "Rafael Steil" nor 
 * the names of its contributors may be used to endorse 
 * or promote products derived from this software without 
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT 
 * HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, 
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL 
 * THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE 
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE
 * 
 * Created on Mar 28, 2005 7:36:00 PM
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum.sso;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

import net.jforum.context.RequestContext;
import net.jforum.entities.UserSession;
import net.jforum.util.preferences.ConfigKeys;
import net.jforum.util.preferences.SystemGlobals;
import edu.yale.its.tp.cas.client.ServiceTicketValidator;
import edu.yale.its.tp.cas.client.filter.CASFilter;

public class CasUserSSO implements SSO {
	
    private final static Log logger = LogFactory.getLog(CasUserSSO.class);

	public String authenticateUser(RequestContext request) {
		
		String userName = getNickName(request);
		
		logger.info("Login User:" + userName);
		
        return userName;
	}
	
	public boolean isSessionValid(UserSession userSession, RequestContext request) {
		
		//ServiceTicketValidator sv = new ServiceTicketValidator();
		String remoteUser = getNickName(request);
//		userSession.setUsername(remoteUser);
//		userSession.setUserId(getUserId(request));
		//String remoteUser = sv.getUser();
        
		if (remoteUser == null && userSession.getUserId() != SystemGlobals.getIntValue(ConfigKeys.ANONYMOUS_USER_ID)) {
			
			return false;
			
		} else if (remoteUser != null && userSession.getUserId() == SystemGlobals.getIntValue(ConfigKeys.ANONYMOUS_USER_ID)) {
			
			return false;
			
		} else if (remoteUser != null && !remoteUser.equals(userSession.getUsername())) {
			
			return false;
		}
		
		return true;
	}
	
//	private String getUserName(RequestContext request) {
//		
//		return getUserInfoFromCAS(request)[1];
//	}
	private String getNickName(RequestContext request) {
		
		String nickName = getUserInfoFromCAS(request)[2];
		
		return nickName == null ? null : ByteUtil.stringFromHexString(nickName);
	}
	
	private int getUserId(RequestContext request) {
		
		String userIdStr = getUserInfoFromCAS(request)[0];
		
		return userIdStr == null ? SystemGlobals.getIntValue(ConfigKeys.ANONYMOUS_USER_ID) : Integer.valueOf(userIdStr).intValue();
	}
	
	private String[] getUserInfoFromCAS(RequestContext request) {

		String[] userInfo = null;
		
		String userInfoStr = (String)request.getSessionContext().getAttribute(CASFilter.CAS_FILTER_USER);
		
		if (userInfoStr != null) {

			userInfo = userInfoStr.split(",");
			
		} else {
			
			userInfo = new String[]{null, null, null};
		}
		
		return userInfo;
	}
}
