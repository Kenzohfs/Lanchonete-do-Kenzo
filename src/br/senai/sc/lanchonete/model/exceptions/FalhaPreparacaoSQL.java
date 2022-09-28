package br.senai.sc.lanchonete.model.exceptions;

public class FalhaPreparacaoSQL extends RuntimeException {
    public FalhaPreparacaoSQL() {
        super("Erro na preparação do comando SQL");
    }
}
