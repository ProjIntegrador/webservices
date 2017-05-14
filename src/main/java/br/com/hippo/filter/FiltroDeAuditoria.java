package br.com.hippo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Usuario acessando a URI " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}