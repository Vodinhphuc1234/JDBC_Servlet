package com.example.demo1.Filter;

import com.example.demo1.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginFilter implements Filter {
    private ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;

        String url = httpServletRequest.getRequestURI();

        if (url.startsWith("/me")){
            if (SessionUtil.getInstance().getValue(httpServletRequest, "USERMODEL")!=null) {
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            } else {
                httpServletResponse.sendRedirect("/login?action=login");
            }
        } else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
