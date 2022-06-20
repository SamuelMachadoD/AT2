package br.com.prova.Questao9;

import java.util.Date;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private double desconto;
	private double preco;
	private String data_inicio;
	
	public Produto(String nome, String descricao, double dp, double p, String data) {
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = dp;
		this.preco = p;
		this.data_inicio = data;
	}
	public Produto(String nome, String descricao, double dp, double p) {
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = dp;
		this.preco = p;
	}
	public Produto(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Produto(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	public int getId() {
		return id;
	}
	public double getDesconto() {
		return desconto;
	}
	public double getPreco() {
		return preco;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	@Override
	public String toString() {
		return " "+ id +" - "+ nome;
	}
	
	
}
