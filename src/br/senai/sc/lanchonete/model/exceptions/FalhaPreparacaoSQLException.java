package br.senai.sc.lanchonete.model.exceptions;

public class FalhaPreparacaoSQLException extends RuntimeException {
    public FalhaPreparacaoSQLException() {
        super("Erro na preparação do comando SQL");
    }
}
