package br.senai.sc.lanchonete.model.exceptions;

public class FalhaPreparacaoSQLException extends RuntimeException {
    public FalhaPreparacaoSQLException() {
        super("Erro na prepara��o do comando SQL");
    }
}
