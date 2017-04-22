package br.com.hippo.ws;

import br.com.hippo.daos.CategoriaDao;
import br.com.hippo.daos.DaoException;
import br.com.hippo.daos.DaoFactory;
import br.com.hippo.entities.Categoria;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/categoria")
            //  A classe herda da
public class CategoriaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        try {
            CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();
            List<Categoria> categorias = categoriaDao.findAll();
            System.out.println("Categorias:");
            for (Categoria c : categorias) {
                System.out.println(c.getId() + "-" + c.getNome());
            }

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(categorias);
            out.println(jsonInString);

        } catch (DaoException ex) {
            System.out.println(ex);
        }



    }

}
