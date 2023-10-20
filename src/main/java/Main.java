import vitaoLista.ConexaoComBanco;
import vitaoLista.CriarTabelasDAO;
import vitaoLista.ListaService;
import vitaoLista.MenuService;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        menuService.menuDeEscolha();

    }

}
