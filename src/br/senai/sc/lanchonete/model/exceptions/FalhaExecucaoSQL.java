package br.senai.sc.lanchonete.model.exceptions;

public class FalhaExecucaoSQL extends RuntimeException{
    public FalhaExecucaoSQL() {
        super("Erro na execu��o do comando SQL");
    }
}
