package vitaoLista.Service;

import java.util.ArrayList;

public class VerificaListaService {

    public boolean existeNaLista(Integer numeroNovo, ArrayList<Integer> listaValidacao) {
        return listaValidacao.contains(numeroNovo);
    }
}
