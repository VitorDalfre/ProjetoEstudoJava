package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.util.ArrayList;

public class AdicionaNumeroListaService {

    private final VerificaListaService verificaListaService;
    private final AtualizaListaService atualizaListaService;

    public AdicionaNumeroListaService(ListaDAO listaDAO) {
        verificaListaService = new VerificaListaService();
        atualizaListaService = new AtualizaListaService(listaDAO);
    }

    public void adiciona(int idLista, Integer numeroNovo){
        ArrayList<Integer> listaDoBanco = new ArrayList<>(atualizaListaService.transformaListaStringEmArray(idLista));
        boolean existeNaLista = verificaListaService.existeNaLista(numeroNovo, listaDoBanco);

        if(!existeNaLista){
            listaDoBanco.add(numeroNovo);
            atualizaListaService.atualiza(idLista, listaDoBanco);
        } else {
            System.out.println("Numero ja existente na lista! ");
        }
    }


}
