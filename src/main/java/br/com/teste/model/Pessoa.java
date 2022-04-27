package br.com.teste.model;

import java.io.Serializable;

public class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8620139082267394220L;

	public Pessoa() {
		super();
	}

	public Pessoa(int id, String nome, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	private int id;
	private String nome;
	private int idade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
