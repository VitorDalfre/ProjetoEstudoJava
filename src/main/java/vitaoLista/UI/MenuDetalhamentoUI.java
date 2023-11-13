package vitaoLista.UI;

import vitaoLista.DAO.ListaDAO;
import vitaoLista.Modelos.DetalhesLista;
import vitaoLista.Service.AlteraListaService;
import vitaoLista.Service.DetalhamentoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDetalhamentoUI {

    private final ListaDAO listaDAO;
    private final DetalhamentoService detalhamentoService;
    private final AlteraListaService alteraListaService;

    public MenuDetalhamentoUI() {
        this.listaDAO = new ListaDAO();
        detalhamentoService = new DetalhamentoService(listaDAO);
        alteraListaService = new AlteraListaService(listaDAO);
    }

    public void selecionaOpcaoDeDetalhamento() {
        Scanner sc = new Scanner(System.in);
        int idLista;
        DetalhesLista opcaoDetalhe;

        System.out.println("Informe o ID da lista que deseja ver os detalhes: ");

        try {
            idLista = sc.nextInt();
            System.out.println("Agora escolha a opção de detalhamento:");
            System.out.println(menuDeOpcoesDetalhesLista());
            int idDetalhe = sc.nextInt();
            opcaoDetalhe = DetalhesLista.getById(idDetalhe);
            direcionadaOpcaoDetalhada(idLista, opcaoDetalhe);

        } catch (InputMismatchException | NullPointerException ex) {
            System.out.println("Escolha Invalida! Tente novamente");
            selecionaOpcaoDeDetalhamento();
        }
    }

    private void direcionadaOpcaoDetalhada(int idLista, DetalhesLista idDetalhe) {

        switch (idDetalhe) {
            case NUMEROS_PARES:
                System.out.println(detalhamentoService.numerosPares(idLista));
                break;
            case NUMEROS_IMPARES:
                System.out.println(detalhamentoService.numerosImpares(idLista));
                break;
            case MAIOR_NUMERO:
                System.out.println(detalhamentoService.maiorNumero(idLista));
                break;
            case MENOR_NUMERO:
                System.out.println(detalhamentoService.menorNumero(idLista));
                break;
            case ADICIONAR_OBSERVACAO:
                detalhamentoService.adicionaObservacaoLista(idLista);
                break;
            case ADICIONAR_NUMERO:
                adicionaNumeroLista(idLista);
            case VOLTAR_MENU_PRINCIPAL:
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }

    private String menuDeOpcoesDetalhesLista() {
        StringBuilder opcoes = new StringBuilder();

        for (DetalhesLista opcao : DetalhesLista.values()) {
            opcoes.append(opcao.getId()).append(" - ").append(opcao.getDescricao()).append("\n");
        }
        return opcoes.toString();
    }

    private void adicionaNumeroLista(int idLista){
        Scanner sc = new Scanner(System.in);
        int novoNumero;

        System.out.println("Digite qual numero deseja adicionar a está lista: ");
        novoNumero  = sc.nextInt();
        alteraListaService.adicionaNumeroLista(idLista, novoNumero);
    }
}
