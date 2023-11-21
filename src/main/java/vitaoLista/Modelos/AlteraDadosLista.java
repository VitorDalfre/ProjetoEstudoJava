package vitaoLista.Modelos;

public enum AlteraDadosLista {

    ADICIONA_NUMERO(1, "ADICIONAR NUMERO"),
    REMOVE_NUMERO(2,"REMOVER NUMERO"),
    ADICIONA_OBSERVACAO(3,"ADICIONAR OBSERVACAO");

    private final int id;
    private final String descricao;


    AlteraDadosLista(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static AlteraDadosLista getById(int id) {
        for (AlteraDadosLista opcao : AlteraDadosLista.values()) {
            if (opcao.getId() == id) {
                return opcao;
            }
        }
        return null;
    }
}
