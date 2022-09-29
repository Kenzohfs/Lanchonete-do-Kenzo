package br.senai.sc.lanchonete.model.exceptions;

public class FalhaException extends RuntimeException {
    public FalhaException(String message) {
        super("Erro inesperado! \n" + message);
    }
}
