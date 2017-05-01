package br.com.hippo.ws;

import br.com.hippo.daos.DaoException;
import br.com.hippo.daos.DaoFactory;
import br.com.hippo.daos.ProdutoDao;
import br.com.hippo.entities.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/produto/detalhe")
public class DetalheProdutoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  Prepara variavel da saída de dados
        PrintWriter out = response.getWriter();
        String idproduto = request.getParameter("idProduto");

        try {
            ProdutoDao produtoDao = DaoFactory.getProdutoDao();
            Produto produto = produtoDao.findProductById(Integer.parseInt(idproduto));
           //System.out.println(produto.getId(), produto.getNome(), produto.getDescproduto());

            //  Integração com o gerador Json com a dependencias no pom.xml sendo o jackson-databind
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(produto);
            out.println(jsonInString);

        } catch (DaoException ex) {
            System.out.println(ex);
        }

    }
}
