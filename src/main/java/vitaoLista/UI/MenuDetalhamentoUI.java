package vitaoLista.UI;

import vitaoLista.DAO.ListaDAO;
import vitaoLista.Modelos.DetalhesLista;
import vitaoLista.Service.AdicionaNumeroListaService;
import vitaoLista.Service.DetalhamentoListaService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDetalhamentoUI {

    private final ListaDAO listaDAO;
    private final DetalhamentoListaService detalhamentoListaService;
    private final AdicionaNumeroListaService adicionaNumeroListaService;

    public MenuDetalhamentoUI() {
        this.listaDAO = new ListaDAO();
        detalhamentoListaService = new DetalhamentoListaService(listaDAO);
        adicionaNumeroListaService = new AdicionaNumeroListaService(listaDAO);
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
                System.out.println(detalhamentoListaService.numerosPares(idLista));
                break;
            case NUMEROS_IMPARES:
                System.out.println(detalhamentoListaService.numerosImpares(idLista));
                break;
            case MAIOR_NUMERO:
                System.out.println(detalhamentoListaService.maiorNumero(idLista));
                break;
            case MENOR_NUMERO:
                System.out.println(detalhamentoListaService.menorNumero(idLista));
                break;
            case ADICIONAR_OBSERVACAO:
                detalhamentoListaService.adicionaObservacaoLista(idLista);
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
        adicionaNumeroListaService.adiciona(idLista, novoNumero);
    }
}
