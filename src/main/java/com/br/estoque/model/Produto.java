package com.br.estoque.model;

import jakarta.persistence.*;


@Entity
@Table(name= "produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	
	private String descricao;
	
	
	private Double preco;
	
	
	private Integer quantidade;
	
	
	public Produto() {
}
	
	//Getters
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	
	//Setters OI
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public void setQuantidade (Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
	
