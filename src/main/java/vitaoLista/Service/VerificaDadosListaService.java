package vitaoLista.Service;

import java.util.ArrayList;

public class VerificaDadosListaService {

    public boolean existeNaLista(Integer numeroNovo, ArrayList<Integer> listaValidacao) {
        return listaValidacao.contains(numeroNovo);
    }
}
