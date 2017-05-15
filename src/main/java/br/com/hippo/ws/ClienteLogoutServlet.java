package br.com.hippo.ws;

import br.com.hippo.daos.DaoException;
import br.com.hippo.daos.DaoFactory;
import br.com.hippo.daos.jdbc.ClienteDaoJdbc;
import br.com.hippo.entities.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class ClienteLogoutServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("cliente.logado");
        return;

    }

}