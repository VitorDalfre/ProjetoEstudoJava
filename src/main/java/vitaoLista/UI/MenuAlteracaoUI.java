package vitaoLista.UI;

import vitaoLista.DAO.ListaDAO;
import vitaoLista.Modelos.AlteraDadosLista;
import vitaoLista.Service.AdicionaNumeroListaService;
import vitaoLista.Service.AdicionaObservacaoListaService;
import vitaoLista.Service.RemoveNumeroListaService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAlteracaoUI {

    private final ListaDAO listaDAO;
    private final AdicionaNumeroListaService adicionaNumeroListaService;
    private final RemoveNumeroListaService removeNumeroListaService;
    private final AdicionaObservacaoListaService adicionaObservacaoListaService;

    public MenuAlteracaoUI() {
        this.listaDAO = new ListaDAO();
        this.adicionaObservacaoListaService = new AdicionaObservacaoListaService();
        this.adicionaNumeroListaService = new AdicionaNumeroListaService(listaDAO);
        this.removeNumeroListaService = new RemoveNumeroListaService(listaDAO);
    }

    public void selecionaOpcaoAlteracao(int idLista){
        Scanner sc = new Scanner(System.in);
        String menu = opcoesDoMenu();
        System.out.println(menu);
        System.out.println("Escolha o que deseja alterar na Lista: ");

        try{
            int opcaoAlteracao = sc.nextInt();
            AlteraDadosLista opcaoEnum = AlteraDadosLista.getById(opcaoAlteracao);
            direcionarOpcaoAlteracao(idLista, opcaoEnum);
        } catch (InputMismatchException | NullPointerException ex){
            System.out.println("Opção Inválida!");
        }
    }

    private void direcionarOpcaoAlteracao(int idLista, AlteraDadosLista opcaoEnum) {

        switch (opcaoEnum){
            case ADICIONA_NUMERO:
                adicionaNumeroLista(idLista);
                break;
            case REMOVE_NUMERO:
                removeNumerolista(idLista);
                break;
            case ADICIONA_OBSERVACAO:
                adicionaObservacaoListaService.adicionaObservacaoLista(idLista);
                break;
            default:
                break;
        }
    }

    private String opcoesDoMenu(){
        StringBuilder opcoesMenu = new StringBuilder();
        for(AlteraDadosLista opcoes : AlteraDadosLista.values()){
            opcoesMenu.append(opcoes.getId()).append(" - ").append(opcoes.getDescricao()).append("\n");
        }
        return opcoesMenu.toString();
    }

    private void adicionaNumeroLista(int idLista) {
        Scanner sc = new Scanner(System.in);
        int novoNumero;
        System.out.println("Digite qual numero deseja adicionar a está lista: ");

        try {
            novoNumero = sc.nextInt();
            adicionaNumeroListaService.adiciona(idLista, novoNumero);
        } catch (NullPointerException | InputMismatchException e){
            System.out.println("Por favor digitar numero válido!");
            adicionaNumeroLista(idLista);
        }
    }

    private void removeNumerolista(int idLista) {
        Scanner sc = new Scanner(System.in);
        int novoNumero;
        System.out.println("Qual numero você deseja remover da Lista: ");

        try {
            novoNumero = sc.nextInt();
            removeNumeroListaService.remove(idLista, novoNumero);
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println("Por favor digitar numero válido!");
            removeNumerolista(idLista);
        }
    }
}
