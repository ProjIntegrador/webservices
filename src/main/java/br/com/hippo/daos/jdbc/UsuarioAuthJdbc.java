package br.com.hippo.daos.jdbc;

public class UsuarioAuthJdbc {


    String sql = "SELECT * FROM dbo.Usuario WHERE loginUsuario="+loginUsuario+" AND " +
            "senhaUsuario='"+senhaUsuario+"'";


}
