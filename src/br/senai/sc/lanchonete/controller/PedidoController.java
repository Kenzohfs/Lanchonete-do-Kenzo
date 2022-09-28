package br.senai.sc.lanchonete.controller;

import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.service.PedidoService;

import java.util.ArrayList;

public class PedidoController {
    public void cadastrarLanche(Pedido pedido) {
        new PedidoService().cadastrar(pedido);
    }

    public ArrayList<Pedido> listar(int tipo) {
        return new PedidoService().listar(tipo);
    }

    public boolean buscarCodigoPedido(int tipoPedido, int codigoPedido) {
        return new PedidoService().buscarCodigoPedido(tipoPedido, codigoPedido);
    }

    public Pedido buscarPedidoPorCodigo(int codigo, int tipoPedido) {
        String tipo = buscarTipoNome(tipoPedido);
        return new PedidoService().buscarPedidoPorCodigo(codigo, tipo);
    }

    public void removerPedido(int codigo, int tipo) {
        String tipoPedido = buscarTipoNome(tipo);
        new PedidoService().removerPedido(codigo, tipoPedido);
    }

    public String buscarTipoNome(int tipoPedido) {
        switch (tipoPedido) {
            case 1 -> {
                return "BEBIDA";
            }
            case 2 -> {
                return "LANCHE";
            }
            case 3 -> {
                return "OUTRO";
            }
        }
        return null;
    }

    public void editarPedido(int tipo, int codigo, double preco) {
        String tipoPedido = buscarTipoNome(tipo);
        new PedidoService().editarPedido(tipoPedido, codigo, preco);
    }
}
