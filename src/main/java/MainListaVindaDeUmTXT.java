import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainListaVindaDeUmTXT {

    public static void main(String[] args) throws IOException {

        ListaService service = new ListaService();
        MenuService menu = new MenuService();

        InputStreamReader caminho = new InputStreamReader(new FileInputStream("C:\\ProjetosEstudos\\VitaoLista\\Teste.txt"));
        ArrayList<Integer> lista = service.lerListaTXT(caminho);
        System.out.println(lista);

        menu.menuDeEscolha(lista);
    }

}