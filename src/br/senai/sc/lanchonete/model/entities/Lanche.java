package br.senai.sc.lanchonete.model.entities;

public class Lanche extends Pedido {
	private double pesoLanche;

	public Lanche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lanche(String descricao, int codigo, double preco, double pesoLanche) {
		super(descricao, codigo, preco);
		this.pesoLanche = pesoLanche;
	}

	public double getPesoLanche() {
		return pesoLanche;
	}

	public void setPesoLanche(double pesoLanche) {
		this.pesoLanche = pesoLanche;
	}

	@Override
	public String toString() {
		return super.toString() + "\nPeso: " + pesoLanche + "\n";
	}
}
