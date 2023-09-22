import java.io.*;
import java.util.ArrayList;

public class MainGerandoListaRandom {

    public static void main(String[] args) throws IOException {

        MenuService menuService = new MenuService();
        ListaService listaService = new ListaService();

        ArrayList<Integer> lista = listaService.geraListaDe30NumeroAleatorio();
        System.out.println(lista);

        menuService.menuDeEscolha(lista);
    }
}