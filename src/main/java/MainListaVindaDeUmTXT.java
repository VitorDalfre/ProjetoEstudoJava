import java.io.*;
import java.util.ArrayList;

public class MainListaVindaDeUmTXT {

    public static void main(String[] args) throws IOException {

        ListaService service = new ListaService();
        MenuService menu = new MenuService();

        InputStreamReader caminho = new InputStreamReader(new FileInputStream("C:\\ProjetosEstudos\\VitaoLista\\Teste.txt"));
        ArrayList<Integer> lista = service.lerListaTXT(caminho);
        System.out.println(lista);

        //menu.menuDeEscolha(lista);

        OutputStreamWriter caminhoParaEscrever = new OutputStreamWriter(new FileOutputStream("C:\\ProjetosEstudos\\VitaoLista\\Teste2.txt"));
        service.escreverNoArquivoTXT(lista, caminhoParaEscrever);
    }

}