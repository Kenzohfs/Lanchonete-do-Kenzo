package br.senai.sc.lanchonete.model.entities;

public class Outro extends Pedido {
	private String tamanhoOutro;
	
	public Outro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTamanhoOutro() {
		return tamanhoOutro;
	}

	public void setTamanhoOutro(String tamanhoOutro) {
		this.tamanhoOutro = tamanhoOutro;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTamanho: " + tamanhoOutro + "\n";
	}
}
