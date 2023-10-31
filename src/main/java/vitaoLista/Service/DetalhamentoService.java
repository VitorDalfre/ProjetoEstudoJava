package vitaoLista.Service;

import vitaoLista.DAO.ContaDAO;

import java.util.Scanner;

public class DetalhamentoService {

    public void adicionaObservacaoLista(Integer idLista){
        Scanner sc = new Scanner(System.in);
        String observacao = null;

        System.out.println("Digite a observacao desejada:");

        try{
            observacao = sc.next();
        } catch (Exception e){
            System.out.println("Observação Inválida! Tente novamente!");
            adicionaObservacaoLista(idLista);
        }
        new ContaDAO().adicionaObservacao(idLista, observacao);
    }
}
