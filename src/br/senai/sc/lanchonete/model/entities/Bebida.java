package br.senai.sc.lanchonete.model.entities;

public class Bebida extends Pedido {
	private double volumeBebida;
	
	public Bebida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getVolumeBebida() {
		return volumeBebida;
	}

	public void setVolumeBebida(double volumeBebida) {
		this.volumeBebida = volumeBebida;
	}

	@Override
	public String toString() {
		return super.toString() + "\nVolume: " + volumeBebida + "\n";
	}
}
