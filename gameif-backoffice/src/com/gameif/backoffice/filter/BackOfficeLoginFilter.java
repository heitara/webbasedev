package com.gameif.backoffice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gameif.backoffice.constants.BackofficeConstants;
import com.gameif.backoffice.util.ContextUtil;

public class BackOfficeLoginFilter implements Filter {

	protected FilterConfig config;

	@Override
	public void destroy() {
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest)request).getSession();
		Object userId = session.getAttribute(BackofficeConstants.SessionKey.USER_ID);
		if (userId == null || userId.toString().trim().length() == 0)
		{
			HttpServletResponse res = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			res.sendRedirect(req.getContextPath() + "/inputUserLogin.html");
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
