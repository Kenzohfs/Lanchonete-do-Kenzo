package br.senai.sc.lanchonete.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements Runnable {
    private JPanel menu;
    private JButton cadastrarButton;
    private JButton listarButton;
    private JButton editarButton;
    private JButton removerButton;
    private JButton encerrarButton;

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    public Menu() {
        criarComponentes();

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String options[] = {"Bebida", "Lanche", "Outro"};
                int indiceEscolhido = JOptionPane.showOptionDialog(
                        null,
                        "Selecione o tipo de pedido a ser cadastrado",
                        "Tipo de pedido",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                dispose();
                new Cadastro(indiceEscolhido);
            }
        });
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        encerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void criarComponentes() {
        setContentPane(menu);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        run();
        pack();
    }

    @Override
    public void run() {
        if (!isVisible()) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela ja está aberta!");
        }
    }
}
