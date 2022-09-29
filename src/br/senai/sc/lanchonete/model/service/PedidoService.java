package br.senai.sc.lanchonete.model.service;

import br.senai.sc.lanchonete.model.dao.PedidoDAO;
import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.entities.TipoPedido;

import java.util.ArrayList;

public class PedidoService {
    public void cadastrar(Pedido pedido) {
        new PedidoDAO().cadastrarPedido(pedido);
    }

    public ArrayList<Pedido> listar(int tipo) {
        return new PedidoDAO().listarPedidos(tipo);
    }

    public boolean buscarCodigoPedido(TipoPedido tipoPedido, int codigoPedido) {
        return new PedidoDAO().buscarCodigoPedido(tipoPedido, codigoPedido);
    }

    public Pedido buscarPedidoPorCodigo(int codigo, String tipopedido) {
        return new PedidoDAO().buscarPedidoPorCodigo(codigo, tipopedido);
    }

    public void removerPedido(int codigo, String tipoPedido) {
        new PedidoDAO().removerPedido(codigo, tipoPedido);
    }

    public void editarPedido(String tipoPedido, int codigo, double preco) {
        new PedidoDAO().editarPedido(tipoPedido, codigo, preco);
    }
}
