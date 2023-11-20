package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.util.Scanner;

public class DetalhamentoListaService {

    private final ListaDAO listaDAO;

    public DetalhamentoListaService(ListaDAO listaDAO) {
        this.listaDAO = listaDAO;
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
