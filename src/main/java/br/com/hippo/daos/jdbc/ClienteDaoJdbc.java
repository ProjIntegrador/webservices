package br.com.hippo.daos.jdbc;

import br.com.hippo.daos.ClienteDao;
import br.com.hippo.daos.DaoException;
import br.com.hippo.entities.Cliente;

import java.sql.*;

public class ClienteDaoJdbc implements ClienteDao {

    private String driver;
    private String url;
    private String user;
    private String pass;

    public ClienteDaoJdbc(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public Cliente autenticacao(String emailCliente, String senhaCliente) throws DaoException {

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            Cliente cliente = null;
            String sql = "SELECT * FROM dbo.Cliente WHERE emailCliente='" + emailCliente + "' AND senhaCliente='" + senhaCliente + "'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente( rs.getLong("idCliente") );
                cliente.setNomeCompletoCliente( rs.getString("nomeCompletoCliente") );
                cliente.setEmailCliente(emailCliente);
            }
            return cliente;
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

    }
}