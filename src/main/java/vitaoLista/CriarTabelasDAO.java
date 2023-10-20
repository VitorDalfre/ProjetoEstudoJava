package vitaoLista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelasDAO {

    private final Connection con;

    public CriarTabelasDAO(Connection connection) {
        this.con = connection;
    }

    private boolean verificaTabelaListasExiste() {
        Statement stm;
        ResultSet rst;

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT EXISTS (SELECT FROM pg_tables WHERE tablename = 'listas');");

        try {
            stm = con.createStatement();
            rst = stm.executeQuery(sql.toString());

            if (rst.next()) {
                return rst.getBoolean(1);
            }
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void criaTabelaLista() {
        boolean tabelaExiste = verificaTabelaListasExiste();

        if (!tabelaExiste) {
            StringBuilder sql = new StringBuilder();

            sql.append("CREATE TABLE listas")
                    .append("(id SERIAL PRIMARY KEY,")
                    .append("listacompleta VARCHAR(255),")
                    .append("numerospares VARCHAR(255),")
                    .append("numeroimpares VARCHAR(255),")
                    .append("maiornumero INT,")
                    .append("menornumero INT)");

            try {
                Statement stm = con.createStatement();
                stm.executeUpdate(sql.toString());
                stm.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
