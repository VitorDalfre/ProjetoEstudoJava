package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.util.ArrayList;

public class AtualizaListaService {

    private final ListaDAO listaDAO;

    public AtualizaListaService(ListaDAO listaDAO) {
        this.listaDAO = listaDAO;
    }

    public void atualiza(int idLista, ArrayList<Integer> pListaNumeros) {
        ListaService service = new ListaService(listaDAO);

        String listaEmString = service.transformaListaEmString(pListaNumeros);
        String numerosPares = service.transformaListaEmString(service.apenasNumerosParesDaLista(pListaNumeros));
        String numerosImpares = service.transformaListaEmString(service.apenasNumerosImparesDaLista(pListaNumeros));
        Integer maiorNumero = service.maiorNumeroDaLista(pListaNumeros);
        Integer menorNumero = service.menorNumeroDaLista(pListaNumeros);

        listaDAO.atualizaListaEmBanco(idLista, listaEmString, numerosPares, numerosImpares, maiorNumero, menorNumero);
    }

    public ArrayList<Integer> transformaListaStringEmArray(int idLista) {
        String listaBanco = listaDAO.consultaLista(idLista);
        ArrayList<Integer> listaConvertida = new ArrayList<>();

        for (String numerosLista : listaBanco.split(", ")) {
            listaConvertida.add(Integer.valueOf(numerosLista));
        }
        return listaConvertida;
    }
}
