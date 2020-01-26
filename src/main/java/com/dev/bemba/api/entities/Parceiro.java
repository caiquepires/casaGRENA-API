package com.dev.bemba.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.dev.bemba.api.enums.PerfilEnum;

@Entity
@Table(name = "parceiro")
public class Parceiro implements Serializable{

	private static final long serialVersionUID = 1577068373656109030L;
	
	private Long idParceiro;
	private Date dataCriacao;
	private String nomeParceiro;
	private String nomeFantasia;
	private String cpfParceiro;
	private String telefone;
	private String email;
	private List<Produto> produtos;
	private PerfilEnum perfil;
	
	public Parceiro() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdParceiro() {
		return idParceiro;
	}
	public void setIdParceiro(Long idParceiro) {
		this.idParceiro = idParceiro;
	}
	
	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "nome_parceiro", nullable = false)
	public String getNomeParceiro() {
		return nomeParceiro;
	}
	public void setNomeParceiro(String nomeParceiro) {
		this.nomeParceiro = nomeParceiro;
	}

	@Column(name = "nome_fantasia", nullable = false)
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Column(name = "cpf_parceiro", nullable = false)
	public String getCpfParceiro() {
		return cpfParceiro;
	}
	public void setCpfParceiro(String cpfParceiro) {
		this.cpfParceiro = cpfParceiro;
	}

	@Column(name = "telefone", nullable = false)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "parceiro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	@PrePersist
	public void prePersist(){
		final Date atual = new Date();
		this.dataCriacao = atual;
	}
	
	
	
	

}
