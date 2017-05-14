package br.com.hippo.daos.jdbc;

import br.com.hippo.daos.DaoException;
import br.com.hippo.daos.UsuarioAuthDao;

import java.sql.*;

public class UsuarioAuthJdbc implements UsuarioAuthDao {

    private String driver;
    private String url;
    private String user;
    private String pass;

    public UsuarioAuthJdbc(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public boolean autenticaUsuario(String loginUsuario, String senhaUsuario) throws DaoException {

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {

            String sql = "SELECT * FROM dbo.Usuario WHERE loginUsuario='" + loginUsuario + "' AND senhaUsuario='" + senhaUsuario + "'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if ( !rs.next() ) /* || ( rs  ))*/ {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

    }
}