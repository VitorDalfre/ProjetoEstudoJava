package vitaoLista.UI;

import vitaoLista.DAO.ListaDAO;
import vitaoLista.Modelos.EscolhaLista;
import vitaoLista.Service.ListaService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUI {

    private final ListaDAO listaDAO;

    public MenuUI() {
        this.listaDAO = new ListaDAO();
    }

    public void menuDeEscolha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opcao: ");
        System.out.println(mostraOpcoesEscolha());
        EscolhaLista escolhaListaUser;

        try {
            int escolha = sc.nextInt();
            escolhaListaUser = EscolhaLista.getById(escolha);
            direcionarEscolha(escolhaListaUser);
        } catch (InputMismatchException | NullPointerException ex) {
            System.out.println("Escolha Invalida! Tente novamente");
            menuDeEscolha();
        }
    }

    private String mostraOpcoesEscolha() {
        StringBuilder opcoes = new StringBuilder();

        for (EscolhaLista escolhaLista : EscolhaLista.values()) {
            opcoes.append(escolhaLista.getId()).append(" - ").append(escolhaLista.getDescricao()).append("\n");
        }
        return opcoes.toString();
    }

    public void direcionarEscolha(EscolhaLista opcaoEscolhida) {

        ListaService listaService = new ListaService(listaDAO);
        MenuDetalhamentoUI menuDetalhamento = new MenuDetalhamentoUI();

        switch (opcaoEscolhida) {
            case CRIAR_LISTA:
                ArrayList<Integer> listaAleatoria = listaService.geraListaDe30NumeroAleatorio();
                listaService.salvarLista(listaAleatoria);
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

}
