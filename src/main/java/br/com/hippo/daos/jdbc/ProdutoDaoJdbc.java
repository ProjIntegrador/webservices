package br.com.hippo.daos.jdbc;

import br.com.hippo.daos.DaoException;
import br.com.hippo.daos.ProdutoDao;
import br.com.hippo.entities.Categoria;
import br.com.hippo.entities.Produto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDaoJdbc implements ProdutoDao {

    private String driver;
    private String url;
    private String user;
    private String pass;

    public ProdutoDaoJdbc(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public List<Produto> findByCategoria(Categoria categoria) throws DaoException {
        List<Produto> produtos = new ArrayList<Produto>();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql =    "SELECT prod.idCategoria, prod.idProduto, prod.nomeProduto, prod.precProduto, cat.nomeCategoria " +
                            "FROM Produto prod INNER JOIN Categoria cat ON prod.idCategoria = cat.idCategoria " +
                            "WHERE prod.idCategoria = ? AND ativoProduto = 1 order by nomeProduto;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, categoria.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("idProduto");
                String nome = rs.getString("nomeProduto");
                BigDecimal preco = rs.getBigDecimal("precProduto");
                Categoria nomecategoria = new Categoria(categoria.getId(), rs.getString("nomeCategoria"));
                Produto produto = new Produto(id, nome, preco, categoria, nomecategoria);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return produtos;
    }
}