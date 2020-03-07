package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Eduardo Alves
 *
 */
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tb_endereco" )
	@SequenceGenerator(name="seq_tb_endereco", sequenceName = "seq_tb_endereco", allocationSize = 20)
	@Column(name = "CO_SEQ_ENDERECO")
	private Long id;
 
	@ManyToOne
	@JoinColumn(name = "CO_SEQ_PESSOA")
	private Pessoa id_pessoa;
	
	@NotNull
	@Column(name = "DS_LOGRADOURO")
	private String logradouro;

	@Column(name = "DS_COMPLEMENTO")
	private String complemento;
 
	@NotNull
	@Column(name = "DS_BAIRRO")
	private String bairro;

	@NotNull
	@Column(name = "DS_CIDADE")
	private String cidade;
	
	@NotNull
	@Column(name = "CO_UF")
	private String uf;
	
	@NotNull
	@Column(name = "DS_CEP")
	private String cep;

	/**
	 * Metodo construtor da classe
	 */
	public Endereco() {
	}

	/**
	 * Construtor da Classe, Obrigando receber todos os parametros
	 * @param perfil
	 * @param descricao
	 * @param dataInclusao
	 * @param dataAlteracao <- NÃO É OBRIGATÓRIA
	 */



	public Endereco(Pessoa id_pessoa, @NotNull String logradouro, String complemento,
			@NotNull String bairro, @NotNull String cidade, @NotNull String uf, @NotNull String cep) {
		super();
		this.id_pessoa = id_pessoa;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Pessoa id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
