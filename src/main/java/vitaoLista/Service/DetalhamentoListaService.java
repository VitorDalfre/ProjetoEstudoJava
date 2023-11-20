package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.util.Scanner;

public class DetalhamentoListaService {

    private final ListaDAO listaDAO;

    public DetalhamentoListaService(ListaDAO listaDAO) {
        this.listaDAO = listaDAO;
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

    public String numerosPares(int idLista){
        return listaDAO.consultaNumerosParesLista(idLista);
    }

    public String numerosImpares(int idLista){
        return listaDAO.consultaNumerosImparesLista(idLista);
    }

    public Integer maiorNumero(int idLista){
        return listaDAO.consultaMaiorNumero(idLista);
    }

    public Integer menorNumero(int idLista){
        return listaDAO.consultaMenorNumero(idLista);
    }
}
