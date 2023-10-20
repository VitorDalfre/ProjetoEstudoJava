package vitaoLista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContaDAO {

    private final Connection con;

    ContaDAO(Connection connection) {
        this.con = connection;
    }

    public void salvaListaEmBanco(String lista) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO listas (listacompleta) ").append("VALUES ('").append(lista).append("')");

        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql.toString());
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir tabela em banco!");
        }
    }

    public String consultaLista(Integer idLista) {
        String lista = null;
        Statement stm;
        ResultSet rst;

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM listas WHERE id = ").append(idLista);

        try {
            stm = con.createStatement();
            rst = stm.executeQuery(sql.toString());

            if (rst.next()) {
                lista = rst.getString(2);
            }
            con.close();
            rst.close();
            stm.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar tabela!");
        }
        return lista;
    }

}
