package com.fcfadmin.fcf.model.enuns;

public enum TipoMovimentoCaixa {

    ENTRADA(1, "Entrada"),
    SAIDA(2, "Saída");

    private final int id;
    private final String descricao;

    TipoMovimentoCaixa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
