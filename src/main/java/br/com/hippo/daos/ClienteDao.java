package br.com.hippo.daos;

import br.com.hippo.entities.Cliente;

public interface ClienteDao {

    public Cliente autenticacao(String loginUsuario, String senhaUsuario) throws DaoException;


}
