package com.dev.bemba.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {


	private static final long serialVersionUID = -613314988343517693L;

	private Long idProduto;
	private Parceiro parceiro;
	private String descricao;
	private Date dataCriacao;
	
	
	public Produto() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Parceiro getParceiro() {
		return parceiro;
	}
	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	@Column(name = "descricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@PrePersist
	public void prePersist(){
		final Date atual = new Date();
		this.dataCriacao = atual;
	}
	
	
	
	
	
}
