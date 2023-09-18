import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    public void menuDeEscolha(ArrayList<Integer> listaDeNumeros) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opção: ");
        System.out.println(mostraOpcoesEnum());
        int escolha = sc.nextInt();
        Escolha escolhaUser = Escolha.getById(escolha);

        direcionarEscolha(escolhaUser, listaDeNumeros);
    }

    private String mostraOpcoesEnum() {
        return Escolha.NUMEROS_PARES.getId() + " - " + Escolha.NUMEROS_PARES.getDescricao() + "\n" +
                Escolha.NUMEROS_IMPARES.getId() + " - " + Escolha.NUMEROS_IMPARES.getDescricao() + "\n" +
                Escolha.MAIOR_NUMERO.getId() + " - " + Escolha.MAIOR_NUMERO.getDescricao() + "\n" +
                Escolha.MENOR_NUMER0.getId() + " - " + Escolha.MENOR_NUMER0.getDescricao() + "\n" +
                Escolha.FINALIZA_PROGRAMA.getId() + " - " + Escolha.FINALIZA_PROGRAMA.getDescricao() + "\n";
    }

    public void direcionarEscolha(Escolha opcaoEscolhida, ArrayList<Integer> listaDeNumeros) {

        ListaService listaService = new ListaService();

        switch (opcaoEscolhida) {
            case NUMEROS_PARES:
                ArrayList pares = listaService.apenasNumerosParesDaLista(listaDeNumeros);
                System.out.println(opcaoEscolhida.getDescricao() + " - " + pares);
                menuDeEscolha(listaDeNumeros);
                break;
            case NUMEROS_IMPARES:
                ArrayList impares = listaService.apenasNumerosImparesDaLista(listaDeNumeros);
                System.out.println(opcaoEscolhida.getDescricao() + " - " + impares);
                menuDeEscolha(listaDeNumeros);
                break;
            case MAIOR_NUMERO:
                Integer maior = listaService.maiorNumeroDaLista(listaDeNumeros);
                System.out.println(opcaoEscolhida.getDescricao() + " - " + maior);
                menuDeEscolha(listaDeNumeros);
                break;
            case MENOR_NUMER0:
                Integer menor = listaService.menorNumeroDaLista(listaDeNumeros);
                System.out.println(opcaoEscolhida.getDescricao() + " - " + menor);
                menuDeEscolha(listaDeNumeros);
                break;
            case FINALIZA_PROGRAMA:
                System.out.println("Obrigado por utilizar o sistema!");
                System.exit(0);
                break;
            default:
                System.out.println("Escolha inválida!");
                menuDeEscolha(listaDeNumeros);
        }

    }
}
