package br.senai.sc.lanchonete.view;

import br.senai.sc.lanchonete.model.dao.PedidoDAO;
import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;

public class Teste {
    public static void main(String[] args) {
        Lanche bebida = new Lanche();
        bebida.setPesoLanche(1000);
        bebida.setDescricaoPedido("Guaraná");
        bebida.setCodigoPedido(2);
        bebida.setPrecoPedido(5.00);

        PedidoDAO dao = new PedidoDAO();

        dao.cadastrarPedido(bebida);
        //String descricaoPedido, int codigoPedido, double precoPedido
    }
}
