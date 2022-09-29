package br.senai.sc.lanchonete.model.exceptions;

public class FalhaExecucaoSQLException extends RuntimeException{
    public FalhaExecucaoSQLException() {
        super("Erro na execução do comando SQL");
    }
}
