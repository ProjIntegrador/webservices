package br.com.hippo.daos;

import br.com.hippo.entities.Categoria;
import br.com.hippo.entities.Produto;
import java.util.List;

public interface ProdutoDao {

    public List<Produto> findByCategoria(Categoria categoria) throws DaoException;

}
