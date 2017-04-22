package br.com.hippo.daos;

import br.com.hippo.entities.Categoria;
import java.util.List;

public interface CategoriaDao {

    public List<Categoria> findAll() throws DaoException;

    public Categoria findById(Long id) throws DaoException;
    
}
