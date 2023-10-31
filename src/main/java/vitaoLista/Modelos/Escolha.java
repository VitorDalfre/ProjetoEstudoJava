package vitaoLista.Modelos;
public enum Escolha {

    CRIAR_LISTA(1,"CRIAR LISTA ALEATORIA"),
    VER_LISTA(2,"VER LISTA"),
    VER_TODAS_LISTAS(3,"VER TODAS LISTAS"),
    DETALHES_LISTA(4, "DETALHES LISTA"),
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
