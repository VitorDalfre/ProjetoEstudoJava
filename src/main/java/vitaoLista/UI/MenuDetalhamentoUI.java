package vitaoLista.UI;

import vitaoLista.DAO.ContaDAO;
import vitaoLista.Modelos.DetalhesLista;
import vitaoLista.Service.DetalhamentoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDetalhamentoUI {

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
        DetalhamentoService detalhamentoService = new DetalhamentoService();

        switch (idDetalhe) {
            case NUMEROS_PARES:
                System.out.println(new ContaDAO().consultaNumerosParesLista(idLista));
                break;
            case NUMEROS_IMPARES:
                System.out.println(new ContaDAO().consultaNumerosImparesLista(idLista));
                break;
            case MAIOR_NUMERO:
                System.out.println(new ContaDAO().consultaMaiorNumero(idLista));
                break;
            case MENOR_NUMERO:
                System.out.println(new ContaDAO().consultaMenorNumero(idLista));
                break;
            case ADICIONAR_OBSERVACAO:
                detalhamentoService.adicionaObservacaoLista(idLista);
                break;
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
}
