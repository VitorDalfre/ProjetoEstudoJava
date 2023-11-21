package vitaoLista.Modelos;

public enum DetalhesLista {

    NUMEROS_PARES(1, "NUMEROS PARES"),
    NUMEROS_IMPARES(2, "NUMEROS IMPARES"),
    MAIOR_NUMERO(3, "MAIOR NUMERO"),
    MENOR_NUMERO(4, "MENOR NUMERO"),
    ALTERA_LISTA(5,"ALTERAÇÕES LISTA"),
    VOLTAR_MENU_PRINCIPAL(6,"VOLTAR AO MENU PRINCIPAL");

    private final int id;
    private final  String descricao;

    DetalhesLista(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static DetalhesLista getById(int id) {
        for (DetalhesLista opcao : DetalhesLista.values()) {
            if (opcao.getId() == id) {
                return opcao;
            }
        }
        return null;
    }
}
