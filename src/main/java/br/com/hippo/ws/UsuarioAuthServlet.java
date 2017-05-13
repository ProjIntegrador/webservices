package br.com.hippo.ws;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import br.com.hippo.entities.UsuarioAuth;

@WebServlet("/usuario/auth")
public class UsuarioAuthServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginUsuario = request.getParameter("loginUsuario");
        String senhaUsuario = request.getParameter("senhaUsuario");

        if (loginUsuario.equals("admin") && senhaUsuario.equals("pipoca")) {
            System.out.println("XYZ " + loginUsuario);
        } else {
            System.out.println("ERRO");
        }
    }
}