import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vitaoLista.DAO.ListaDAO;
import vitaoLista.Service.ListaService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListaServiceTest {

    private ListaService service;
    private ListaDAO listaDAO;

    @BeforeEach
    public void inicializar() {
        service = new ListaService(listaDAO);
    }

    @Test
    public void testeVerificaLista30Posicoes() {
        ArrayList<Integer> lista = service.geraListaDe30NumeroAleatorio();
        Integer contador = 0;
        for (Integer ignored : lista) {
            contador += 1;
        }
        assertEquals(30, contador);
    }

    @Test
    public void testaRetornoMaiorNumero() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int contador = 0; contador < 30; contador++) {
            lista.add(contador);
        }
        Integer maiorNumero = service.maiorNumeroDaLista(lista);
        assertEquals(29, maiorNumero);
    }

    @Test
    public void testaRetornoMenorNumero() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int contador = 30; contador > 0; contador--) {
            lista.add(contador);
        }
        Integer menorNumero = service.menorNumeroDaLista(lista);
        assertEquals(1, menorNumero);
    }

    @Test
    public void testaRetornoListaPares() {
        ArrayList<Integer> listaCorreta = new ArrayList<>();
        ArrayList<Integer> listaCompleta = new ArrayList<>();
        for (int contador = 1; contador < 31; contador++) {
            listaCompleta.add(contador);
            if (contador % 2 == 0) {
                listaCorreta.add(contador);
            }
        }
        ArrayList<Integer> listaPosMetodo = service.apenasNumerosParesDaLista(listaCompleta);
        assertEquals(listaCorreta, listaPosMetodo);
    }

    @Test
    public void testaRetornoListaImpares() {
        ArrayList<Integer> listaCorreta = new ArrayList<>();
        ArrayList<Integer> listaCompleta = new ArrayList<>();
        for (int contador = 1; contador < 31; contador++) {
            listaCompleta.add(contador);
            if (contador % 2 != 0) {
                listaCorreta.add(contador);
            }
        }
        ArrayList<Integer> listaPosMetodo = service.apenasNumerosImparesDaLista(listaCompleta);
        assertEquals(listaCorreta, listaPosMetodo);
    }
}