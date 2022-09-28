package br.senai.sc.lanchonete.model.factory;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.entities.Outro;
import br.senai.sc.lanchonete.model.entities.Pedido;

public class PedidoFactory {
    public Pedido getPedido(int codigoPedido, String descricaoPedido, Double precoPedido, Double volumeBebida, Double pesoLanche, String tamanhoOutro, String tipoPedido) {
        Pedido pedido = null;
        switch (tipoPedido) {
            case "BEBIDA":
                pedido = new Bebida();
                ((Bebida) pedido).setVolumeBebida(volumeBebida);
                break;
            case "LANCHE":
                pedido = new Lanche();
                ((Lanche) pedido).setPesoLanche(pesoLanche);
                break;
            case "OUTRO":
                pedido = new Outro();
                ((Outro) pedido).setTamanhoOutro(tamanhoOutro);
                break;
        }
        pedido.setCodigoPedido(codigoPedido);
        pedido.setDescricaoPedido(descricaoPedido);
        pedido.setPrecoPedido(precoPedido);

        return pedido;
    }
}
