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
        String caminhoDesejado = sc.next();
        InputStreamReader caminhoTXT = new InputStreamReader(new FileInputStream(caminhoDesejado));
        ArrayList<Integer> lista = service.lerListaTXT(caminhoTXT);

        System.out.println("\n Aqui esta sua lista com 30 numeros aleatorios! \n" + lista);

        menu.menuDeEscolha(lista);

//        OutputStreamWriter caminhoParaEscrever = new OutputStreamWriter(new FileOutputStream("C:\\ProjetosEstudos\\VitaoLista\\Teste2.txt"));
//        service.escreverNoArquivoTXT(lista, caminhoParaEscrever);

    }
}
