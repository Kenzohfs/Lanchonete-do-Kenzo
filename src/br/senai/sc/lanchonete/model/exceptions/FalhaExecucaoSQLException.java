package br.senai.sc.lanchonete.model.exceptions;

public class FalhaExecucaoSQLException extends RuntimeException{
    public FalhaExecucaoSQLException() {
        super("Erro na execu��o do comando SQL");
    }
}
