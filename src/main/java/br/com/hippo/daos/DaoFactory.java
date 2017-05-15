package br.com.hippo.daos;

import br.com.hippo.daos.jdbc.ProdutoDaoJdbc;
import br.com.hippo.daos.jdbc.CategoriaDaoJdbc;
import br.com.hippo.daos.jdbc.ClienteDaoJdbc;

public class DaoFactory {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://hippo-pi.database.windows.net:1433;databaseName=hippo;selectMethod=cursor";
    private static String user = "TSI";
    private static String pass = "SistemasInternet123";

    public static CategoriaDao getCategoriaDao() {
        return new CategoriaDaoJdbc(driver, url, user, pass);
    }

    public static ProdutoDao getProdutoDao() {
        return new ProdutoDaoJdbc(driver, url, user, pass);
    }

    public static ClienteDaoJdbc getClienteDao() { return new ClienteDaoJdbc(driver, url, user, pass);

    }

}
