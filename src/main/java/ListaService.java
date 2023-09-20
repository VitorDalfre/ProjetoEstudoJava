import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ListaService {

    public ArrayList<Integer> geraListaDe30NumeroAleatorio() {
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Random random = new Random();
            Integer numeroAleatorio = random.nextInt(1000);
            listaNumeros.add(numeroAleatorio);
        }
        return listaNumeros;
    }

    public void lerListaTXT(){
        Path path;
    }

    public ArrayList<Integer> apenasNumerosParesDaLista(ArrayList<Integer> listaCompleta) {
        ArrayList<Integer> listaPares = new ArrayList<>();

        for (Integer x : listaCompleta) {
            if (x % 2 == 0) {
                listaPares.add(x);
            }
        }
        return listaPares;
    }

    public ArrayList<Integer> apenasNumerosImparesDaLista(ArrayList<Integer> listaCompleta) {
        ArrayList<Integer> listaImpares = new ArrayList<>();

        for (Integer x : listaCompleta) {
            if (x % 2 != 0) {
                listaImpares.add(x);
            }
        }
        return listaImpares;
    }

    public Integer maiorNumeroDaLista(ArrayList<Integer> listaCompleta) {
        Integer maiorNumero = 0;
        for (Integer x : listaCompleta) {
            if (x > maiorNumero) {
                maiorNumero = x;
            }
        }
        return maiorNumero;
    }

    public Integer menorNumeroDaLista(ArrayList<Integer> listaCompleta) {
        Integer menorNumero = listaCompleta.get(0);
        for (Integer x : listaCompleta) {
            if (x < menorNumero) {
                menorNumero = x;
            }
        }
        return menorNumero;
    }
}
