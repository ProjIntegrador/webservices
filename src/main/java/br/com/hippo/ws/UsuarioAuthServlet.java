package br.com.hippo.ws;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import br.com.hippo.entities.UsuarioAuth;

public class UsuarioAuthServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginUsuario = "";
        String senhaUsuario = "";

        if (loginUsuario != null) {
            loginUsuario = response.;
        }

        if (senhaUsuario != null) {
            senhaUsuario = request.;
        }

        if (username.equals("Manisha") && password.equals("password")) {
            return "Hello " + username + " to world of Jax WS - Valid User!";
        } else {
            return " User No Valid!";
        }
    }

}
