import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        ListaService listaService = new ListaService();
        ArrayList<Integer> lista = listaService.geraListaDe30NumeroAleatorio();
        System.out.println(lista);

        menuService.menuDeEscolha(lista);
    }

}