package vitaoLista;
public enum Escolha {

    CRIAR_LISTA(1,"CRIAR LISTA ALEATORIA"),
    VER_LISTA(2,"VER LISTA"),
    NUMEROS_PARES(3, "NUMEROS PARES"),
    NUMEROS_IMPARES(4, "NUMEROS IMPARES"),
    MAIOR_NUMERO(5, "MAIOR NUMERO"),
    MENOR_NUMER0(6, "MENOR NUMERO"),
    FINALIZA_FUNCOES_LISTA(7, "FINALIZA FUNCOES LISTA");

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
