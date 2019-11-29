package com.esdras.upload.model;

public class Produto {

	private int idprodutos;
	private String nome;
	private Double valor;

	public Produto(int idprodutos, String nome, Double valor) {
		super();
		this.idprodutos = idprodutos;
		this.nome = nome;
		this.valor = valor;
	}

	public int getIdprodutos() {
		return idprodutos;
	}

	public void setIdprodutos(int idprodutos) {
		this.idprodutos = idprodutos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
