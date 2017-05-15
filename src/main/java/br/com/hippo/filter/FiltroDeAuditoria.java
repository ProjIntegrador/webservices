package br.com.hippo.filter;

import br.com.hippo.entities.Cliente;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession();
        Cliente clienteLogado = (Cliente) session.getAttribute("cliente.logado");

        String usuario = "<deslogado>";
        if (clienteLogado != null) {
            usuario = clienteLogado.getEmailCliente();
        }

        System.out.println("Cliente " + usuario + " acessando a URI " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}