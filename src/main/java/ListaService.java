import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


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

    public ArrayList<Integer> lerListaTXT(InputStreamReader caminhoArquivo) throws IOException {
        BufferedReader lerLista = new BufferedReader(caminhoArquivo);
        StringBuilder arquivoLido = new StringBuilder();
        String linha;

        while ((linha = lerLista.readLine()) != null) {
            arquivoLido.append(linha);
        }

        String[] separandoString = arquivoLido.toString().split(",");
        ArrayList<Integer> listaTXTFinal = new ArrayList<>();

        for (String s : separandoString) {
            s = s.trim();
            if (!s.isEmpty()) {
                Integer adicionaLista = Integer.valueOf(s);
                listaTXTFinal.add(adicionaLista);
            }
        }
        return listaTXTFinal;
    }

    public void escreverNoArquivoTXT(ArrayList<Integer> lista, OutputStreamWriter caminhoArquivo) throws IOException {
        BufferedWriter escreveNoArquivo = new BufferedWriter(caminhoArquivo);
        StringBuilder criaConteudoTexto = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            criaConteudoTexto.append(lista.get(i));
            if(i != lista.size() - 1){
                criaConteudoTexto.append(",");
            }
        }
        escreveNoArquivo.write(criaConteudoTexto.toString());
        escreveNoArquivo.close();
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
