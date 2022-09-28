package br.senai.sc.lanchonete.model.entities;

public class Pedido {
	private String descricaoPedido;
	private int codigoPedido;
	private double precoPedido;

	public Pedido(String descricaoPedido, int codigoPedido, double precoPedido) {
		super();
		this.descricaoPedido = descricaoPedido;
		this.codigoPedido = codigoPedido;
		this.precoPedido = precoPedido;
	}
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricaoPedido() {
		return descricaoPedido;
	}
	public void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
	}
	public int getCodigo() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public double getPrecoPedido() {
		return precoPedido;
	}
	public void setPrecoPedido(double precoPedido) {
		this.precoPedido = precoPedido;
	}

	@Override
	public String toString() {
		return "\nDADOS DO PRODUTO\n-----------------\nCodigo: " + codigoPedido + "\nDescricao: " + descricaoPedido +  "\nPreco: " + precoPedido;
	}
}
