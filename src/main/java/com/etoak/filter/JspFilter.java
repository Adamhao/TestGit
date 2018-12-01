package com.etoak.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Adam on 2018/11/8 21:36.
 */
public class JspFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String url = request.getRequestURL().toString();

        if(url.endsWith("login.jsp") || url.endsWith("query.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        response.sendRedirect(session.getServletContext().getContextPath() + "/");

    }

    @Override
    public void destroy() {

    }
}
