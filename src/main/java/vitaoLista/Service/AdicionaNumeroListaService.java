package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.util.ArrayList;

public class AdicionaNumeroListaService {

    private final VerificaDadosListaService verificaDadosListaService;
    private final AtualizaListaService atualizaListaService;

    public AdicionaNumeroListaService(ListaDAO listaDAO) {
        verificaDadosListaService = new VerificaDadosListaService();
        atualizaListaService = new AtualizaListaService(listaDAO);
    }

    public void adiciona(int idLista, Integer numeroNovo){
        ArrayList<Integer> listaDoBanco = new ArrayList<>(atualizaListaService.transformaListaStringEmArray(idLista));
        boolean existeNaLista = verificaDadosListaService.existeNaLista(numeroNovo, listaDoBanco);

        if(!existeNaLista){
            listaDoBanco.add(numeroNovo);
            atualizaListaService.atualiza(idLista, listaDoBanco);
        } else {
            System.out.println("Numero ja existente na lista! ");
        }
    }


}
