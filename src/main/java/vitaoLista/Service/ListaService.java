package vitaoLista.Service;

import vitaoLista.DAO.ListaDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ListaService {

    ListaDAO listaDAO;

    public ListaService(ListaDAO listaDAO) {
        this.listaDAO = listaDAO;
    }

    public ArrayList<Integer> geraListaDe30NumeroAleatorio() {
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            Integer numeroAleatorio = random.nextInt(1000);
            listaNumeros.add(numeroAleatorio);
        }
        return listaNumeros;
    }

    public void insereListaEmBanco(ArrayList<Integer> pListaNumeros) {

        String listaEmString = transformaListaEmString(pListaNumeros);
        String numerosPares = transformaListaEmString(apenasNumerosParesDaLista(pListaNumeros));
        String numerosImpares = transformaListaEmString(apenasNumerosImparesDaLista(pListaNumeros));
        Integer maiorNumero = maiorNumeroDaLista(pListaNumeros);
        Integer menorNumero = menorNumeroDaLista(pListaNumeros);

        listaDAO.insereListaEmBanco(listaEmString, numerosPares, numerosImpares, maiorNumero, menorNumero);
    }

    String transformaListaEmString(ArrayList<Integer> lista) {
        StringBuilder listaEmString = new StringBuilder();

        for (Integer inteiro : lista) {
            if (listaEmString.toString().isEmpty()) {
                listaEmString.append(inteiro);
            } else {
                listaEmString.append(", ").append(inteiro);
            }
        }
        return listaEmString.toString();
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
            int valorSemEspacos;
            try {
                valorSemEspacos = Integer.parseInt(numeroLista.trim());
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

    public void mostraLista() {
        Scanner sc = new Scanner(System.in);
        int id = 0;

        System.out.println("Digite o ID da lista que deseja consultar: ");
        try {
            id = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opção Inválida! ");
            mostraLista();
        }

        String lista = new ListaDAO().consultaLista(id);
        System.out.println(lista);
    }

    public void mostraTodasListas() {
        ArrayList<String> todasListas = new ListaDAO().consultaTodasListas();

        for (String lista : todasListas) {
            System.out.println(lista);
        }
    }
}
