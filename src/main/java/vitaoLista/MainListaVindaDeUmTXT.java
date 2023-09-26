package vitaoLista;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainListaVindaDeUmTXT {

    public static void main(String[] args) throws IOException {

        ListaService service = new ListaService();
        MenuService menu = new MenuService();
        Scanner sc = new Scanner(System.in);

        System.out.println("Coloque o caminho do seu TXT: ");
        String caminhoListaInicial = sc.next();
        InputStreamReader caminhoTXT = new InputStreamReader(new FileInputStream(caminhoListaInicial));
        ArrayList<Integer> lista = service.lerListaTXT(caminhoTXT);

        menu.menuDeEscolha(lista);

        System.out.println("Coloque o TXT para salvarmos a lista formatada: ");
        String caminhoSalvarLista = sc.next();
        OutputStreamWriter caminhoParaEscrever = new OutputStreamWriter(new FileOutputStream(caminhoSalvarLista));
        service.escreverNoArquivoTXT(lista, caminhoParaEscrever);
    }
}
