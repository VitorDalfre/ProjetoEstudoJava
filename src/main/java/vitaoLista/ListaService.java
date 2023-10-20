package vitaoLista;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ListaService {

    private final ConexaoComBanco conexao;

    public ListaService() {
        this.conexao = new ConexaoComBanco();
    }

    public void geraListaDe30NumeroAleatorio() {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        StringBuilder listaEmString = new StringBuilder();

            Random random = new Random();

        for (int i = 0; i < 30; i++) {
            Integer numeroAleatorio = random.nextInt(1000);
            listaNumeros.add(numeroAleatorio);
        }

        for (Integer inteiro : listaNumeros) {
            if(listaEmString.toString().isEmpty()) {
                listaEmString.append(inteiro);
            } else {
                listaEmString.append(", ").append(inteiro);
            }
        }

        Connection con = conexao.recuperaConexao();
        new ContaDAO(con).salvaListaEmBanco(listaEmString.toString());
    }

    public ArrayList<Integer> lerListaTXT(InputStreamReader caminhoArquivo) throws IOException {
        BufferedReader lerLista = new BufferedReader(caminhoArquivo);
        StringBuilder arquivoLido = new StringBuilder();
        String linha;

        while ((linha = lerLista.readLine()) != null) {
            arquivoLido.append(linha);
        }

        ArrayList<Integer> listaTXTFinal = new ArrayList<>();
        ArrayList<String> diferentesDeInteger = new ArrayList<>();

        for (String numeroLista : arquivoLido.toString().split(",")) {
            Integer valorSemEspacos;
            try {
                valorSemEspacos = Integer.valueOf(numeroLista.trim());
                listaTXTFinal.add(valorSemEspacos);
            } catch (NumberFormatException ex) {
                diferentesDeInteger.add(numeroLista);
                System.out.println("Diferente de Integer: " + numeroLista);
            }
        }
        return listaTXTFinal;
    }

    public void escreverNoArquivoTXT(ArrayList<Integer> lista, OutputStreamWriter caminhoArquivo) throws IOException {
        BufferedWriter escreveNoArquivo = new BufferedWriter(caminhoArquivo);
        StringBuilder criaConteudoTexto = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            criaConteudoTexto.append(lista.get(i));
            if (i != lista.size() - 1) {
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

    public void mostraLista(){
        Scanner sc = new Scanner(System.in);
        int id = 0;

        System.out.println("Digite o ID da lista que deseja consultar: ");
        try {
            id = sc.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Opção Inválida! ");
            mostraLista();
        }

        String lista = new ContaDAO(conexao.recuperaConexao()).consultaLista(id);
        System.out.println(lista);
    }
}
