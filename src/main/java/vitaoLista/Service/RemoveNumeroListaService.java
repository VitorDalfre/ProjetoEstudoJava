package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.util.ArrayList;

public class RemoveNumeroListaService {

    private final AtualizaListaService atualizaListaService;
    private final VerificaDadosListaService verificaDadosListaService;

    public RemoveNumeroListaService(ListaDAO listaDAO) {
        this.atualizaListaService = new AtualizaListaService(listaDAO);
        this.verificaDadosListaService = new VerificaDadosListaService();
    }

    public void remove (int idLista, Integer numeroNovo){
        ArrayList<Integer> listaDoBanco = new ArrayList<>(atualizaListaService.transformaListaStringEmArray(idLista));
        boolean existeNaLista = verificaDadosListaService.existeNaLista(numeroNovo, listaDoBanco);

        if(existeNaLista){
            listaDoBanco.remove(numeroNovo);
            atualizaListaService.atualiza(idLista, listaDoBanco);
        } else {
            System.out.println("Numero não existente na lista! ");
        }
    }
}
