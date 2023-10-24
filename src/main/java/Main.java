import vitaoLista.*;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        ConexaoComBanco con = new ConexaoComBanco();
        Connection conn = con.recuperaConexao();

        CriarTabelasDAO att = new CriarTabelasDAO(conn);
        att.criaTabelaLista();

//        MenuService menuService = new MenuService();
//        menuService.menuDeEscolha();


    }

}
