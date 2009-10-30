/**
 *  Copyright 2007 Rutgers, the State University of New Jersey
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *      
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.inspektr.common.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Creates a ClientInfo object and passes it to the {@link ClientInfoHolder}
 * 
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 1.0
 *
 */
public class ClientInfoThreadLocalFilter implements Filter {

	public void destroy() {
		// nothing to do here
	}
	
	public void doFilter(final ServletRequest request, final ServletResponse response,
			final FilterChain filterChain) throws IOException, ServletException {
		try {
			final ClientInfo clientInfo = new ClientInfo((HttpServletRequest) request);
			ClientInfoHolder.setClientInfo(clientInfo);
			filterChain.doFilter(request, response);
		} finally {
			ClientInfoHolder.clear();
		}
	}



	public void init(final FilterConfig filterConfig) throws ServletException {
		// nothing to do
	}
}
