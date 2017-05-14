package br.com.hippo.ws;

import br.com.hippo.daos.DaoException;
import br.com.hippo.daos.DaoFactory;
import br.com.hippo.daos.UsuarioAuthDao;
import br.com.hippo.entities.UsuarioAuth;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/usuario/auth")
public class UsuarioAuthServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String loginUsuario = request.getParameter("loginUsuario");
        String senhaUsuario = request.getParameter("senhaUsuario");
        PrintWriter out = response.getWriter();

        try {
            UsuarioAuthDao userAuthDao = DaoFactory.getUsuarioAuth();

            boolean autenticado = userAuthDao.autenticaUsuario(loginUsuario, senhaUsuario);

            if (autenticado == false) {
                System.out.println(autenticado);
            } else {
                System.out.println(autenticado);
                HttpSession session = request.getSession();
                session.setAttribute("usuario.logado" , loginUsuario);

                session.setMaxInactiveInterval(1440*60);
                Cookie usuarioLogado = new Cookie("usuario.logado", loginUsuario);
                usuarioLogado.setMaxAge(1440*60);
                response.addCookie(usuarioLogado);

                //Usuario usuario = new Usuario(int autemticado.)
                //session.setAttribute();
            }

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(autenticado);
            out.println(jsonInString);

        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}