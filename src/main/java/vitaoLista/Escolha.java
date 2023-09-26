package vitaoLista;
public enum Escolha {

    NUMEROS_PARES(1, "NUMEROS PARES"),
    NUMEROS_IMPARES(2, "NUMEROS IMPARES"),
    MAIOR_NUMERO(3, "MAIOR NUMERO"),
    MENOR_NUMER0(4, "MENOR NUMERO"),
    FINALIZA_FUNCOES_LISTA(5, "FINALIZA FUNCOES LISTA");

    private final int id;
    private final String descricao;

    Escolha(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Escolha getById(int id) {
        for (Escolha escolha : Escolha.values()) {
            if (escolha.getId() == id) {
                return escolha;
            }
        }
        return null;
    }
}
