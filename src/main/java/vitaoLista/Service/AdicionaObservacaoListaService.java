package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.util.Scanner;

public class AdicionaObservacaoListaService {

    private ListaDAO listaDAO;

    public void AdicionaNumeroListaService(){
        this.listaDAO = new ListaDAO();
    }

    public void adicionaObservacaoLista(Integer idLista) {
        Scanner sc = new Scanner(System.in);
        String observacao = "";

        System.out.println("Digite a observacao desejada:");

        try {
            observacao += sc.nextLine();
        } catch (Exception e) {
            System.out.println("Observação Inválida! Tente novamente!");
            adicionaObservacaoLista(idLista);
        }
        this.listaDAO.adicionaObservacao(idLista, observacao);
    }
}
