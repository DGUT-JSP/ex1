package com.dgut.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgut.bean.User;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter("/*")
public class PermissionFilter implements Filter {

    public PermissionFilter() {
    }

	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//
		String path = req.getServletPath();
		//
		if(path.startsWith("/user")){
			HttpSession session = req.getSession();
			//不存在session即返回
			if(session == null){
				//System.out.println("flag");
				res.sendRedirect(req.getContextPath() + "/login.jsp");
			}else{
				
				if(session.getAttribute("user") == null){
					res.sendRedirect(req.getContextPath() + "/login.jsp");
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
