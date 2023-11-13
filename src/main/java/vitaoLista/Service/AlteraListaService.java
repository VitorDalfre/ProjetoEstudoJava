package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.util.ArrayList;

public class AlteraListaService {

    private final ListaDAO listaDAO;

    public AlteraListaService(ListaDAO listaDAO) {
        this.listaDAO = listaDAO;
    }

    public void adicionaNumeroLista(int idLista, Integer numeroNovo){
        ArrayList<Integer> listaDoBanco = new ArrayList<>(transformaListaStringEmArray(idLista));
        boolean existeNaLista = verificaListaPossuiNumero(numeroNovo, listaDoBanco);

        if(!existeNaLista){
            listaDoBanco.add(numeroNovo);
            atualizaListaEmBanco(idLista, listaDoBanco);
        } else {
            System.out.println("Numero ja existente na lista! ");
        }
    }

    private ArrayList<Integer> transformaListaStringEmArray(int idLista) {
        String listaBanco = listaDAO.consultaLista(idLista);
        ArrayList<Integer> listaConvertida = new ArrayList<>();

        for (String numerosLista : listaBanco.split(", ")) {
            listaConvertida.add(Integer.valueOf(numerosLista));
        }
        return listaConvertida;
    }

    private boolean verificaListaPossuiNumero(Integer numeroNovo, ArrayList<Integer> listaValidacao) {
        return listaValidacao.contains(numeroNovo);
    }

    private void atualizaListaEmBanco(int idLista, ArrayList<Integer> pListaNumeros) {
        ListaService service = new ListaService(listaDAO);

        String listaEmString = service.transformaListaEmString(pListaNumeros);
        String numerosPares = service.transformaListaEmString(service.apenasNumerosParesDaLista(pListaNumeros));
        String numerosImpares = service.transformaListaEmString(service.apenasNumerosImparesDaLista(pListaNumeros));
        Integer maiorNumero = service.maiorNumeroDaLista(pListaNumeros);
        Integer menorNumero = service.menorNumeroDaLista(pListaNumeros);

        listaDAO.atualizaListaEmBanco(idLista, listaEmString, numerosPares, numerosImpares, maiorNumero, menorNumero);
    }
}
