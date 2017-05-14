package br.com.hippo.daos;

public interface UsuarioAuthDao {

    public boolean autenticaUsuario(String loginUsuario, String senhaUsuario) throws DaoException;


}
