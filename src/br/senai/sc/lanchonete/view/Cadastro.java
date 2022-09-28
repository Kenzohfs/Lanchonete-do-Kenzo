package br.senai.sc.lanchonete.view;

import javax.swing.*;

public class Cadastro {
    private JPanel cadastro;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel campoAdicional;

    public Cadastro(int tipoPedido) {
        criarComponentes(tipoPedido);
    }

    public void criarComponentes(int tipoPedido) {
            switch (tipoPedido) {
            case 0:
                campoAdicional.setText("Quantidade");
                break;
            case 1:
                campoAdicional.setText("Quantidade");
                break;
            case 2:
                campoAdicional.setText("Quantidade");
                break;
        } }
}
