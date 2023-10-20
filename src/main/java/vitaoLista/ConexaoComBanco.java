package vitaoLista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoComBanco {

    public Connection recuperaConexao() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/BancoVitao?user=postgres&password=postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
