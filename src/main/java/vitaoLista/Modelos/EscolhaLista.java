package vitaoLista.Modelos;
public enum EscolhaLista {

    CRIAR_LISTA(1,"CRIAR LISTA ALEATORIA"),
    VER_LISTA(2,"VER LISTA"),
    VER_TODAS_LISTAS(3,"VER TODAS LISTAS"),
    DETALHES_LISTA(4, "DETALHES LISTA"),
    FINALIZA_FUNCOES_LISTA(5, "FINALIZA FUNCOES LISTA");

    private final int id;
    private final String descricao;

    EscolhaLista(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EscolhaLista getById(int id) {
        for (EscolhaLista escolhaLista : EscolhaLista.values()) {
            if (escolhaLista.getId() == id) {
                return escolhaLista;
            }
        }
        return null;
    }
}
