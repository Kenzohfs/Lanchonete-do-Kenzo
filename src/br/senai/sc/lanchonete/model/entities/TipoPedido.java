package br.senai.sc.lanchonete.model.entities;

public enum TipoPedido {
    BEBIDA("BEBIDA"),
    LANCHE("LANCHE"),
    SOBREMESA("SOBREMESA");

    private String tipo;

    TipoPedido(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
