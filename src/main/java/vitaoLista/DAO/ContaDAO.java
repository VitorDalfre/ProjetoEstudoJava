package vitaoLista.DAO;

import vitaoLista.ConexaoComBanco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContaDAO {

    public void salvaListaEmBanco(String listaCompleta, String pares, String impares, Integer maior, Integer menor) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO listas (listacompleta, numerospares, numerosimpares, maiornumero, menornumero) ")
                .append("VALUES ('")
                .append(listaCompleta).append("','")
                .append(pares).append("','")
                .append(impares).append("',")
                .append(maior).append(",")
                .append(menor).append(")");


        try {
            Statement stm = ConexaoComBanco.getConexao().createStatement();
            stm.executeUpdate(sql.toString());
            stm.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir tabela em banco!");
        }
    }

    public String consultaLista(Integer idLista) {
        String lista = null;
        Statement stm;
        ResultSet rst;

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT listacompleta FROM listas WHERE id = ").append(idLista);

        try {
            stm = ConexaoComBanco.getConexao().createStatement();
            rst = stm.executeQuery(sql.toString());

            if (rst.next()) {
                lista = rst.getString(1);
            }
            rst.close();
            stm.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar tabela!");
        }
        return lista;
    }

    public ArrayList<String> consultaTodasListas(){
        ArrayList<String> todasListas = new ArrayList<>();
        Statement stm;
        ResultSet rst;

        StringBuilder sql = new StringBuilder("SELECT listacompleta FROM listas");

        try {
            stm = ConexaoComBanco.getConexao().createStatement();
            rst = stm.executeQuery(sql.toString());

            while(rst.next()){
                todasListas.add(rst.getString(1));
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro na consulta de listas!");
        }
        return todasListas;
    }

    public String consultaNumerosParesLista(int idLista) {
        String listaPares = null;
        Statement stm;
        ResultSet rst;

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT numerospares FROM listas WHERE id = ").append(idLista);

        try {
            stm = ConexaoComBanco.getConexao().createStatement();
            rst = stm.executeQuery(sql.toString());

            if (rst.next()) {
                listaPares = rst.getString(1);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query! ");
        }
        return listaPares;
    }

    public String consultaNumerosImparesLista(int idLista) {
        String listaImpares = null;
        Statement stm;
        ResultSet rst;

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT numerosimpares FROM listas WHERE id = ").append(idLista);

        try {
            stm = ConexaoComBanco.getConexao().createStatement();
            rst = stm.executeQuery(sql.toString());

            if (rst.next()) {
                listaImpares = rst.getString(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar query!");
        }
        return listaImpares;
    }

    public Integer consultaMaiorNumero(Integer idLista){
        Integer maiorNumero = null;
        Statement stm;
        ResultSet rst;

        StringBuilder sql;
        sql = new StringBuilder("SELECT maiornumero FROM listas WHERE id =").append(idLista);

        try{
            stm = ConexaoComBanco.getConexao().createStatement();
            rst = stm.executeQuery(sql.toString());

            if(rst.next()){
                maiorNumero = rst.getInt(1);
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao executar query!");
        }
        return maiorNumero;
    }

    public Integer consultaMenorNumero(Integer idLista){
        Integer menorNumero = null;
        Statement stm;
        ResultSet rst;

        StringBuilder sql;
        sql = new StringBuilder("SELECT menornumero FROM listas WHERE id =").append(idLista);

        try{
            stm = ConexaoComBanco.getConexao().createStatement();
            rst = stm.executeQuery(sql.toString());

            if(rst.next()){
                menorNumero = rst.getInt(1);
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao executar query!");
        }
        return menorNumero;
    }

}
