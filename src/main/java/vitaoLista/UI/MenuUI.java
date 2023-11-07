package vitaoLista.UI;

import vitaoLista.DAO.ListaDAO;
import vitaoLista.Modelos.Escolha;
import vitaoLista.Service.ListaService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUI {

    private ListaDAO listaDAO;
    public void menuDeEscolha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opcao: ");
        System.out.println(mostraOpcoesEscolha());
        Escolha escolhaUser;

        try {
            int escolha = sc.nextInt();
            escolhaUser = Escolha.getById(escolha);
            direcionarEscolha(escolhaUser);
        } catch (InputMismatchException | NullPointerException ex) {
            System.out.println("Escolha Invalida! Tente novamente");
            menuDeEscolha();
        }
    }

    private String mostraOpcoesEscolha() {
        StringBuilder opcoes = new StringBuilder();

        for (Escolha escolha : Escolha.values()) {
            opcoes.append(escolha.getId()).append(" - ").append(escolha.getDescricao()).append("\n");
        }
        return opcoes.toString();
    }

    public void direcionarEscolha(Escolha opcaoEscolhida) {

        ListaService listaService = new ListaService(listaDAO);
        MenuDetalhamentoUI menuDetalhamento = new MenuDetalhamentoUI();

        switch (opcaoEscolhida) {
            case CRIAR_LISTA:
                ArrayList<Integer> listaAleatoria = listaService.geraListaDe30NumeroAleatorio();
                salvarLista(listaAleatoria);
                menuDeEscolha();
                break;
            case VER_LISTA:
                listaService.mostraLista();
                menuDeEscolha();
                break;
            case VER_TODAS_LISTAS:
                listaService.mostraTodasListas();
                menuDeEscolha();
                break;
            case DETALHES_LISTA:
                menuDetalhamento.selecionaOpcaoDeDetalhamento();
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

    private void salvarLista(ArrayList<Integer> pLista){
        if(pLista.isEmpty()){
           return;
        }
        new ListaService(listaDAO).insereListaEmBanco(pLista);
    }

}
