package br.com.hippo.ws;

import br.com.hippo.daos.DaoException;
import br.com.hippo.daos.DaoFactory;
import br.com.hippo.daos.jdbc.ClienteDaoJdbc;
import br.com.hippo.entities.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class ClienteLoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Cliente clienteLogado = (Cliente) session.getAttribute("cliente.logado");

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(clienteLogado);
        out.println(jsonInString);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String emailCliente = request.getParameter("emailCliente");
        String senhaCliente = request.getParameter("senhaCliente");
        PrintWriter out = response.getWriter();

        try {
            ClienteDaoJdbc clienteDAO = DaoFactory.getClienteDao();

            Cliente cliente = clienteDAO.autenticacao(emailCliente, senhaCliente);

            if (cliente != null) {
                HttpSession session = request.getSession();
                session.setAttribute("cliente.logado" , cliente);
            }else{
                response.setStatus(401);
                return;
            }

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(cliente);
            out.println(jsonInString);

        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}