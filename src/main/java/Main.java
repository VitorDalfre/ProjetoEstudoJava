import vitaoLista.DAO.CriarTabelasDAO;
import vitaoLista.UI.MenuUI;

public class Main {

    public static void main(String[] args) {

        CriarTabelasDAO att = new CriarTabelasDAO();
        att.criaTabelaLista();

        MenuUI menuService = new MenuUI();
        menuService.menuDeEscolha();


    }

}
