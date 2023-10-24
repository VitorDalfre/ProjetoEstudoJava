package vitaoLista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDetalhamentoService {

    public void selecionaOpcaoDeDetalhamento() {
        Scanner sc = new Scanner(System.in);
        int idLista;
        DetalhesLista opcaoDetalhe;

        System.out.println("Informe o ID da lista que deseja ver os detalhes: ");

        try {
            idLista = sc.nextInt();
            System.out.println("Agora escolha a opção de detalhamento: \n");
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
                //chama pares no banco
                break;
            case NUMEROS_IMPARES:
                //chama impares no banco
                break;
            case MAIOR_NUMERO:
                //chama maior no banco
                break;
            case MENOR_NUMERO:
                //chama menor no banco
                break;
            default:
                break;
        }
    }

    private String menuDeOpcoesDetalhesLista() {
        StringBuilder opcoes = new StringBuilder();

        for (DetalhesLista opcao : DetalhesLista.values()) {
            opcoes.append(opcao.getId()).append(" - ").append(opcao.getDescricao());
        }
        return opcoes.toString();
    }
}
