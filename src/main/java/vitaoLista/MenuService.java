package vitaoLista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {
    public void menuDeEscolha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opcao: ");
        System.out.println(mostraOpcoesEnum());
        Escolha escolhaUser;

        try {
            int escolha = sc.nextInt();
            escolhaUser = Escolha.getById(escolha);
            direcionarEscolha(escolhaUser);
        }catch (InputMismatchException | NullPointerException ex){
            System.out.println("Escolha Invalida! Tente novamente");
            menuDeEscolha();
        }
    }

    private String mostraOpcoesEnum() {
        StringBuilder opcoes = new StringBuilder();

        for (Escolha escolha : Escolha.values()) {
            opcoes.append(escolha.getId()).append(" - ").append(escolha.getDescricao()).append("\n");
        }
        return opcoes.toString();
    }

    public void direcionarEscolha(Escolha opcaoEscolhida) {

        ListaService listaService = new ListaService();

        switch (opcaoEscolhida) {
            case CRIAR_LISTA:
                listaService.geraListaDe30NumeroAleatorio();
                menuDeEscolha();
                break;
            case VER_LISTA:
                listaService.mostraLista();
                menuDeEscolha();
                break;
            case NUMEROS_PARES:
                menuDeEscolha();
                break;
            case NUMEROS_IMPARES:
                menuDeEscolha();
                break;
            case MAIOR_NUMERO:
                menuDeEscolha();
                break;
            case MENOR_NUMER0:
                menuDeEscolha();
                break;
            case FINALIZA_FUNCOES_LISTA:
                System.out.println("Fim das Operações!");
                break;
            default:
                System.out.println("Escolha inválida!");
                menuDeEscolha();
                break;
        }

    }
}
