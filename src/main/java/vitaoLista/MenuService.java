package vitaoLista;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    public void menuDeEscolha(ArrayList<Integer> listaDeNumeros) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opcao: ");
        System.out.println(mostraOpcoesEnum());
        int escolha = sc.nextInt();
        Escolha escolhaUser = Escolha.getById(escolha);

        try {
            direcionarEscolha(escolhaUser, listaDeNumeros);
        } catch (NullPointerException ex){
            System.out.println("Escolha Invalida! Tente novamente");
            menuDeEscolha(listaDeNumeros);
        }
    }

    private String mostraOpcoesEnum() {
        StringBuilder opcoes = new StringBuilder();

        for (Escolha escolha : Escolha.values()) {
            opcoes.append(escolha.getId()).append(" - ").append(escolha.getDescricao()).append("\n");
        }
        return opcoes.toString();
    }

    public void direcionarEscolha(Escolha opcaoEscolhida, ArrayList<Integer> listaDeNumeros) {

        ListaService listaService = new ListaService();

        switch (opcaoEscolhida) {
            case NUMEROS_PARES:
                ArrayList<Integer> pares = listaService.apenasNumerosParesDaLista(listaDeNumeros);
                System.out.println(opcaoEscolhida.getDescricao() + " - " + pares);
                menuDeEscolha(listaDeNumeros);
                break;
            case NUMEROS_IMPARES:
                ArrayList<Integer> impares = listaService.apenasNumerosImparesDaLista(listaDeNumeros);
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
            case FINALIZA_FUNCOES_LISTA:
                System.out.println("Fim das Operações!");
                break;
            default:
                System.out.println("Escolha inválida!");
                menuDeEscolha(listaDeNumeros);
                break;
        }

    }
}
