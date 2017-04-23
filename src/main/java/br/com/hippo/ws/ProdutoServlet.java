package br.com.hippo.ws;

import br.com.hippo.daos.CategoriaDao;
import br.com.hippo.daos.DaoException;
import br.com.hippo.daos.DaoFactory;
import br.com.hippo.daos.ProdutoDao;
import br.com.hippo.entities.Categoria;
import br.com.hippo.entities.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/produto")
//  A classe herda da
public class ProdutoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Prepara variavel da saída de dados
        PrintWriter out = response.getWriter();
        String idcategoria = request.getParameter("idCategoria");
        Categoria categoria = new Categoria(new Long(idcategoria), "");


        try {
            ProdutoDao produtoDao = DaoFactory.getProdutoDao();
            List<Produto> produtos = produtoDao.findByCategoria(categoria);
                    System.out.println("Produtos:" );
            for (Produto p : produtos) {
                System.out.println(p.getId() + "-" + p.getNome());
            }

            //  Integração com o gerador Json com a dependencias no pom.xml sendo o jackson-databind
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(produtos);
            out.println(jsonInString);

        } catch (DaoException ex) {
            System.out.println(ex);
        }


    }
}